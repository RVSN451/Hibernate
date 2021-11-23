В системе 2 пользователя:
KOST password: 2222 role “All”
RVSN password: 2222 role “READ”

localhost:8080/hello – доступен всем!!!
localhost:8080/goodbye – доступен всем авторизованным пользователям
http://localhost:8080/persons/LessTheSpecifiedAge?age=30 доступен имеющим роль “ALL”
localhost:8080/persons/by-city?city=Moscow & /persons/TheSpecifiedNameAndSurname** - доступен всем, у кого есть роли “All” или “READ”
