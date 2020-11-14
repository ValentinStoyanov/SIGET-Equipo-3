Feature: Convocar

  #Background:
  #  Given baseUri is http://localhost:8080
    
  Scenario Outline: cancelar
  Given el organizador quiere cancelar una reunion
  When cancelo la reunion <id> con token <token>
  And organizador es <organizador>
  Then la respuesta sera <codigo>
  
  Examples:
  | id  | organizador | codigo  | token
  | 4 | "admin"  | 200 | "Admin123" 
  | 5 | "admin" | 400 | "Admin123" 