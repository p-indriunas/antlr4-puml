grammar Puml;

diagram:
    startuml NL+
    (statements=statement)*
    enduml NL?
    EOF;

startuml: '@startuml' WS? ID?;
enduml: '@enduml';

statement: (entity|relation);
entity: 'entity' WS entityId=ID NL;
relation: (idLeft=ID) (commentLeft=R_COMM|WS)? L_REL '--' R_REL (commentRight=R_COMM|WS)? (idRight=ID) NL;

R_COMM: WS? STR WS?;

L_REL: (L_M | L_M1 | L_M0 | L_01 | L_E1);

L_M: '}';
L_M1: '}|';
L_M0: '}o';
L_01: '|o';

L_E1: '||' WS? {_input.LA(1) == '-'}?;

R_REL: (R_M | R_M1 | R_M0 | R_01 | R_E1);

R_M: '{';
R_M1: '|{';
R_M0: 'o{';
R_01: 'o|';

R_E1: {_input.LA(-1) == '-'}? WS? '||';

ID: ('A'..'Z' | 'a'..'z' | '0'..'9')+;
STR: '"' ('A'..'Z' | 'a'..'z' | '1'..'9' | ' ')+ '"';

NL:  ('\r'? '\n')+;
WS
:
	[ \r\n\t]+ -> skip
;


