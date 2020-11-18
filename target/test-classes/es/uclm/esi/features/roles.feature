Feature: Roles patrón RBAC

  Scenario Outline: Roles de los usuarios de la aplicacion
    When accedo con el token de usuario <token>
    And a recursos del rol <rol>
    Then muestro el codigo <codigo>

    Examples: 
      |	rol	|	codigo	|	token	|
      | "USER" | 200 | "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYwNTYzNTQ1MSwiZXhwIjoxNjA1NzIxODUxfQ.o10ETSsrHmdxDOpvTgbwjS8SuTW6NOK04e9KPah5pLxsFhZ75l6VOrgg7pDAJdv3qDzo8a2YkAsyDG1oQSVtOQ" |
      | "ADMIN" | 200 | "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYwNTY5NzMzNiwiZXhwIjoxNjA1NzgzNzM2fQ.pZVcn6TOzZXsGF5ooGnjy6p7bPlEGYeEdRVzX81J2rORJfZMChtW1fDIp_udthFdmpoj2hCDDhBZh_ZH68pZqA" |
			| "ADMIN" | 403 | "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0cmFiYWphZG9yMSIsImlhdCI6MTYwNTcwMTEyMCwiZXhwIjoxNjA1Nzg3NTIwfQ.mezskTWmEmR9LguIVC0iaQZzrQyvTE4r5S_VEJDdjjpWyBnVWXoSrrK-oVCti1Vck8UI5n8W-6xj74321LEleQ" |
			| "USER" | 401 | "?" |