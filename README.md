#### По умолчанию используется интегрированная база данных hsqldb в spring boot
#### Для использования Postgresql:
#### -создать базу данных
#### -в каталоге clientregister\src\main\resources настроить подключения к базе данных в файле application.properties и выпольнить скрипт для создания таблиц initDB.sql
#### -раскоментировать зависимость postgresql и закоментировать hsqldb
#### Для запуска приложения:
#### -создать jar файл с помощью mvn -package
#### -запустить jar файл

### curl samples (application deployed in application context `request`).
> For windows use `Git Bash`

#### create User | result 0
`curl -s -X POST -d '{"type": "create", "login": "user123", "password": "user123"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/request`

#### create duplicate User | result 1
`curl -s -X POST -d '{"type": "create", "login": "user123", "password": "user123"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/request`

#### get balance User | result 0
`curl -s -X POST -d '{"type": "get-balance", "login": "user123", "password": "user123"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/request`

#### get balance User not found | result 3
`curl -s -X POST -d '{"type": "get-balance", "login": "user1234", "password": "user123"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/request`

#### get balance User password not valid | result 4
`curl -s -X POST -d '{"type": "get-balance", "login": "user123", "password": "user1234"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/request`

#### get balance User technical error | result 2
`curl -s -X POST -d '{"type": "get-balance", "login": "", "password": "user123"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/request`

#### get balance User technical error | result 2
`curl -s -X POST -d '{"type": "balance", "login": "user123", "password": "user123"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/request`