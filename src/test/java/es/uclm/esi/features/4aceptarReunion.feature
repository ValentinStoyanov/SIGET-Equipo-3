Feature: Aceptar

  Scenario Outline: aceptar
  
  When acepto la reunion 
  Then la respuesta debe ser <codigo>
 
  
  Examples:
	| codigo | 
  | 200 | 