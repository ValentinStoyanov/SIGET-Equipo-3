Feature: Convocar

	#Background:
  #  Given baseUri is http://localhost:8080
    
  Scenario Outline: convocar
  Given el organizador quiere convocar una reunion
  When convoco la reunion <id> con token <token>
  And organizador es <organizador>
  And titulo es <titulo>
  And estado es <estado>
  And dia es <dia>
  And mes es <mes>
  And ano es <ano>
  And hora es <String>
  And asistentes son <asistentes>
  Then la respuesta sera <codigo>
  
  Examples:
  |	id	|	organizador	|	titulo	|	estado	|	dia	|	mes	|	ano	|	hora	|	asistentes	|	codigo	| token
  |	4	|	"admin"	|	"Reunion 1"	|	"pendiente"	|	20	|	11	|	2020	|	"22:00"	|	"Fatima:pendiente,Victor:pendiente"	|	200	| "Admin123" |
  |	5	|	"admin"	|	"Reunion 2"	|	"pendiente"	|	51	|	11	|	2020	|	"16:00"	|	"Fatima:pendiente,Victor:pendiente"	|	400	| "Admin123" |
  