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
    And los nuevos asistentes seran <asistentes>
    

 