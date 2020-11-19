Feature: Cancelar

  Scenario Outline: cancelar
  
  When selecciono la reunion con id <id>
  Then cancelo la reunion 
  Then la respuesta debe ser <codigo>
  
  
  Examples:
  |	id	| codigo | 
  |	9	| 400 | 