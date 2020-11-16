Feature: Convocar

  Scenario Outline: cancelar
  
  When organizador es <organizador>
  Then cancelo la reunion con token <token>
  Then la respuesta sera <codigo>
  
  
  Examples:
  | organizador | codigo  | token |
  | "admin"  | 200 | "Admin123" |
  | "admin" | 400 | "Admin123" |