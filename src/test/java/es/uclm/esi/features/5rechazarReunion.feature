Feature: Rechazar

  Scenario Outline: rechazar
  
  When rechazo la reunion 
  Then el codigo de rechazar debera ser <codigo>
 
  
  Examples:
	| codigo | 
  | 200 | 