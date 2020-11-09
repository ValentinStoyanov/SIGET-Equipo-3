Feature: Modificar Reunion

  Scenario Outline: modificar
    When Modifico la reunion <id> con el token de usuario <token> 
    And cambio el titulo a <titulo>
    And cambio la fecha a <fecha>
    And cambio la hora a <hora>
    Then la repuesta sera <codigo>
    

 