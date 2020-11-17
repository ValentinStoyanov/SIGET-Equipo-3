Feature: Convocar

    
  Scenario Outline: convocar
  	When titulo es <titulo>
  	And estado es <estado>
  	And dia es <dia>
  	And mes es <mes>
  	And ano es <ano>
  	And hora es <hora>
  	And descripcion es <descripcion>
  	And asistentes son <asistentes>
  	Then convoco la reunion con token <token>
  	Then la respuesta sera <codigo>
  
  Examples:
  |	titulo	|	estado	|	dia	|	mes	|	ano	|	hora	| descripcion |	asistentes	|	codigo	| token |
  |	"Reunion 1"	|	"pendiente"	|	20	|	11	|	2020	|	"22:00"	| "Prueba" |	"Fatima:pendiente,Victor:pendiente"	|	200	| "token" |
  |	"Reunion 2"	|	"pendiente"	|	51	|	11	|	2020	|	"16:00"	|	"Prueba" |	"Fatima:pendiente,Victor:pendiente"	|	400	| "token" |
  