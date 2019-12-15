grammar Pack;

diagram:
    startuml
    body
    enduml
    EOF;

startuml: '@startuml' name=VARIABLE?;
enduml: '@enduml';

body:
	elements=element*;

element:
    statement |
    packageDecl;

packageDecl: PACKAGE name=VARIABLE? '{' body '}';

statement:
    entity |
    relation
;

entity: ENTITY name=VARIABLE;
relation: (entityLeft=VARIABLE) (commentLeft=STR)? relationLeft=L_REL '--' relationRight=R_REL (commentRight=STR)? (entityRight=VARIABLE);

PACKAGE: 'package';
ENTITY: 'entity';

VARIABLE
:
	VALID_ID_START VALID_ID_CHAR*
;

fragment VALID_ID_START:
	(
		'a' .. 'z'
	)
	|
	(
		'A' .. 'Z'
	)
	| '_'
;

fragment VALID_ID_CHAR:
	VALID_ID_START
	|
	(
		'0' .. '9'
	)
;

CURL_OPENED: '{';
CURL_CLOSED: '}';

L_REL: (L_M | L_M1 | L_M0 | L_01 | L_E1);

L_M: '}' WS? {_input.LA(1) == '-'}?;
L_M1: '}|';
L_M0: '}o';
L_01: '|o';

L_E1: '||' WS? {_input.LA(1) == '-'}?;

R_REL: (R_M | R_M1 | R_M0 | R_01 | R_E1);

R_M: {_input.LA(-1) == '-'}? WS? '{';
R_M1: '|{';
R_M0: 'o{';
R_01: 'o|';

R_E1: {_input.LA(-1) == '-'}? WS? '||';

ID: ('A'..'Z' | 'a'..'z' | '0'..'9')+;
STR: '"' ('A'..'Z' | 'a'..'z' | '1'..'9' | ' ')+ '"';

WS:	[ \r\n\t]+ -> skip;
