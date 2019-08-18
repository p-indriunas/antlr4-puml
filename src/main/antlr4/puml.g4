grammar puml;

start: '@startuml';
end: '@enduml';

r   : 'hello' ID;
ID  : [a-z]+ ;

WS
   : [ \r\n\t] + -> skip
   ;
