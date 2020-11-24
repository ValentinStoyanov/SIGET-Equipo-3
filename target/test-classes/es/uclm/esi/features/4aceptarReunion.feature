Feature: Aceptar

  Scenario Outline: aceptar
  
  When acepto la reunion 
  Then el codigo de aceptar debera ser <codigo>
 
  
  Examples:
	| codigo | 
  | 200 | 