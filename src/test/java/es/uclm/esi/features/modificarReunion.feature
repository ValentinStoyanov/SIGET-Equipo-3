Feature: Modificar Reunion

  Scenario Outline: modificar
    When Modifico la reunion <id> con el token de usuario <token> 
    And cambio el titulo a <titulo>
    And cambio la fecha a <fecha>
    And cambio la hora a <hora>
    And cambio los asistentes a <asistentes>
    Then la repuesta sera <codigo>
    And el nuevo titulo sera <nuevotitulo>
    And la nueva fecha sera <nuevafecha>
    And la nueva hora sera <nuevahora>
    And los nuevos asistentes seran <asistentesnuevos>
    
    
    Examples:
  | titulo | nuevotitulo | fecha      | nuevafecha | hora  | nuevahora | asistentes                | asistentesnuevos          | codigo | id   | token |
	| test   | test        | 11-11-2020 | 11-11-2020 | 23:32 |     23:32 | juan,luis                 | juan,luis                 | 200    | 1    | awed  |
 