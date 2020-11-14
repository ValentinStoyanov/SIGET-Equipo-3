Feature: consultar reuniones dia

	#Background:
  #  Given baseUri is http://localhost:8080
  
  Scenario Outline: Mostrar lista reuniones del dia
  Given el usuario quiere ver las reuniones de un dia
  When Muestro la lista de reuniones del dia <dia>
  Then Muestro el codigo <codigo>
  And Muestro las reuniones con su <titulo> y <hora>
  
  Examples:
 	| 	dia 	|	codigo	|	titulo |	hora |
 	| 	10 		|	200		|	"reunion 1, reunion 2, reunion 3"	|	"14:30"	|
 	| 	"ee" 	|	400		|	
 	| 	-1 		|	400		|	
 	| 	"" 		|	400		|	