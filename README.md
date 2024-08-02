# Proyecto de Prueba Técnica

Este proyecto está diseñado por Gabriel Sosa y es parte de un desafio.

## Requisitos

- Instalado Docker.
- Instalado java 17 o 21
- Instalado maven 3.3 o superior

## Instrucciones para Ejecutar el Proyecto

### Usando Docker Compose

1. **Clonar el repositorio** (si aplica):
    ```sh
    git clone https://github.com/GabrielSosa/DesafioJava.git
    cd DesafioJava
    ```

2. **Ejecutar el proyecto**:
   En la raíz del proyecto, ejecuta:
    ```sh
    docker-compose up --build
    ```
   Este comando construirá las imágenes Docker necesarias y levantará los servicios definidos en el archivo `docker-compose.yml`.

## Apis expuestas en AWS

Actualmente las Apis estan expuestas en un servidor aws
1. Crear usuario (POST): http://3.21.187.29:8080/user
2. Consultar producto por id (GET): http://3.21.187.29:8080/product/1
3. Consultar todos los productos (GET): http://3.21.187.29:8080/product
4. Consultar producto por nombre (GET): http://3.21.187.29:8080/product/search
5. Estadisticas (GET): http://3.21.187.29:8080/statistics/Computadoras
6. Crear producto (POST): http://3.21.187.29:8080/product
7. Modificar producto (PUT): http://3.21.187.29:8080/product/1
8. Eliminar produto (DELETE): http://3.21.187.29:8080/product/1


Se comparte el enlace con la colección POSTMAN:
https://drive.google.com/drive/folders/1qRz8ZlHp8oVL0Aa0hUQDfF2PGJ4TDQh1?usp=sharing

## Tecnologías Utilizadas

- <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="Java Spring Boot" width="20"/> Java Spring Boot: Utilizado para desarrollar las aplicaciones `cliente-persona` y `cuenta-movimiento`.
- <img src="https://www.vectorlogo.zone/logos/mysql/mysql-icon.svg" alt="MySQL" width="20"/> MySQL: Base de datos utilizada para almacenar la información de las aplicaciones.

## Estructura del Proyecto

El proyecto está estructurado en varios servicios definidos en el archivo `docker-compose.yml`:

- **MySQL**: Servicio de base de datos.
- **api-productos**: Servicio de aplicación Spring Boot corriendo en el puerto API donde se crea un CRUD `8080`.

## Configuración de variables de entorno

Estas son las variables de entorno que se deben configurar.

- `SPRING_DATASOURCE_URL`: Conexion para la base de datos.
- `SPRING_DATASOURCE_USERNAME`: Usuario de la base de datos..
- `SPRING_DATASOURCE_PASSWORD`: Contraseña del usuario de la base de datos.

Estos datos se encuentran en el archivo docker-compose.yml por lo que no es necesario configurar.

## Redes de Docker

Los servicios están conectados a una red de Docker llamada `spring-net` para permitir la comunicación interna entre ellos.

## Notas Adicionales

- Asegúrate de tener Docker y Docker Compose instalados en tu sistema antes de ejecutar el proyecto.

## Comando para ejecutar pruebas

Se debe ubicar en la carpeta api-productos que es donde esta el proyecto
``` maven
mvn test
```

## Autor

Gabriel Sosa

Este proyecto es parte de una prueba técnica y demuestra el uso de Docker, Docker Compose, CI/CD y despliegue en aws y Spring Boot en un entorno integrado.

