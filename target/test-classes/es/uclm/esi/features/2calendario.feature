Feature: Calendario

    
  Scenario Outline: Calendario mes
  	When consulto con el usuario <token>
  	And el calendario mes con mes <mes> y anio <anio>
  	Then obtengo el codigo <codigo>
  	And obtengo los dias <dias>
  
  Examples:
  |	mes	|	anio  |	dias	  |	codigo	| token   |
  |	11	|	2020	|	"6,23"	|	200     | "admin" |
  
  Scenario Outline: Calendario dia
  	When consulto con el usuario <token>
  	And el calendario dia con dia <dia> y mes <mes> y anio <anio>
  	Then obtengo el codigo <codigo>
  	And obtengo las reuniones <reuniones>
  	
  	Examples:
 |	dia | mes	|	anio  |	reuniones	        			|	codigo	| token   |
 |	6		|	11  |	2020	|	"Frontend"	    				|	200     | "admin" |

 
  