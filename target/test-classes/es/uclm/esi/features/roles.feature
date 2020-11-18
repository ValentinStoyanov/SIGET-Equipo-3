Feature: Roles patrón RBAC


  Scenario Outline: Roles de los usuarios de la aplicacion
    Given mostrar el rol que tiene el usuario dentro de la aplicacion
    When accedo al calendario personal con el token de usuario <token>
    And muestro el tipo de <rol> que posee dicho usuario
    Then muestro el codigo <codigo>

    Examples: 
      |	token	|	rol	|	codigo	|
      | "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYwNTYzNTQ1MSwiZXhwIjoxNjA1NzIxODUxfQ.o10ETSsrHmdxDOpvTgbwjS8SuTW6NOK04e9KPah5pLxsFhZ75l6VOrgg7pDAJdv3qDzo8a2YkAsyDG1oQSVtOQ" | "USER" | 200 |
      | "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYwNTY5NzMzNiwiZXhwIjoxNjA1NzgzNzM2fQ.pZVcn6TOzZXsGF5ooGnjy6p7bPlEGYeEdRVzX81J2rORJfZMChtW1fDIp_udthFdmpoj2hCDDhBZh_ZH68pZqA" | "ADMIN" | 200 |
			| "?" | "?" | 400 |