Feature: Cancelar

  Scenario Outline: cancelar
  
  When id cancelar es <id>
  Then cancelo la reunion con token <token>
  Then la respuesta sera <codigo>
  
  
  Examples:
  |	id	| codigo | token |
  |	7	| 200 | "Admin123" |
  |	8	| 400 | "Admin123" |