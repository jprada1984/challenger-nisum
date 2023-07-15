# Evaluación JAVA

El desarrollo de la aplicación trata de creación de usuarios.

## Para su ejecución 

Internamente ya carga el esquema de la base de datos y datos de prueba para eso se ejecuta lo siguiente:

```
mvn spring-boot:run
```

Para poder acceder a la base de datos h2 lo puedes buscar en el navegador

```
http://localhost:8080/h2-ui
```

Para probar las funcionalidades usando swaggerui puedes acceder en el navegador

```
http://localhost:8080/swagger-ui/index.html
```


### Se ha realizado los siguientes métodos:

1. Crear un registro

```
curl --location 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"Anita",
    "email":"anitaperez@dominio.cl",
    "password":"12345678",
    "phones":[{
        "number":"927199509",
        "cityCode":"1",
        "countrCode":"57"
    }]
}'
```

2. Listar todo los usuarios

```
curl --location 'http://localhost:8080/api/user'
```

3. Buscar por su identificador

```
curl --location 'http://localhost:8080/api/user/37c7dcca-6260-4190-8792-7f1e41d756cb'
```

