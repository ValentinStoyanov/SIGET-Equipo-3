Feature: consultar info reunion

	#Background:
  #  Given baseUri is http://localhost:8080
  
  Scenario Outline: Mostrar la información de la reunion
  Given el usuario quiere ver la información de la reunion seleccionada
  When el titulo de la reunion es <titulo>
  And la hora de la reunion es <hora>
  And los asistentes son <asistentes>
  Then Muestro el codigo <codigo>
  
  Examples:
 	| 	titulo |	hora	|	asistentes	|	codigo	|
 	| 	"esto es una reunion buena" 	|	"16:00"		|	"Jesus:aceptado, German:pendiente"	|	200	|
 	| 	"esto es una reunion mala" 	|	""		|	""	|	400	|
 	
 	
 