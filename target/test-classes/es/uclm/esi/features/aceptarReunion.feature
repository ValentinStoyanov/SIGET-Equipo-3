Feature: Aceptar

	Scenario Outline: aceptar
		When id es <id>
		Then acepto la reunion con token <token>
		Then la respuesta a aceptar sera <codigo>
		
		Examples:
		|	id |	token	|	codigo |
		|	1	|	"token"	|	200	|