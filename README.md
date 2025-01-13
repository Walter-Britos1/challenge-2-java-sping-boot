# 📚 Challenge Literatura - Sistema de Gestión de Libros y Autores

## Descripción

Este proyecto es una aplicación de consola desarrollada en Java que permite gestionar libros y autores, así como realizar consultas específicas en una base de datos. La aplicación utiliza Spring Boot, JPA, y una API externa para buscar y registrar libros.

## ✨ Funcionalidades

1. Buscar libros por título 🔍

- Permite realizar una búsqueda de libros utilizando una API externa.

- Si se encuentra el libro, se almacena en la base de datos junto con su autor.

2. Listar libros registrados 📖

- Muestra todos los libros guardados en la base de datos.

- Incluye información como título, idiomas disponibles y número de descargas.

3. Listar autores registrados ✒️

- Muestra todos los autores almacenados junto con sus respectivos libros.

4. Listar autores vivos en un año específico 🗓️

- Permite ingresar un año y muestra los autores que estaban vivos en ese momento.

- Incluye información sobre el nombre del autor, su año de nacimiento y fallecimiento (si aplica), y los libros asociados.

5. Listar libros por idioma 🌍

- Filtra y muestra los libros que están disponibles en un idioma específico.

- Ejemplos de idiomas soportados: es (Español), en (Inglés), fr (Francés), pt (Portugués).

## ⚙️ Requisitos

- Java 17 o superior

- Maven

- Base de datos PostgreSQL 

## 🛠️ Tecnologías utilizadas

- Spring Boot: Framework principal para el desarrollo de la aplicación.

- Spring Data JPA: Para la interacción con la base de datos.

- PostgreSQL.

- Jakarta Persistence (JPA): Manejo de entidades y relaciones.

- API Externa: GutenDex para buscar libros.

## 🚀 Cómo ejecutar la aplicación

1. Clona este repositorio:

```sh
git clone https://github.com/Walter-Britos1/challenge-2-java-sping-boot.git
```

2. Accede al directorio del proyecto:

```sh
cd challenge-2-java-sping-boot
```

3. Ejecuta el proyecto con Maven:

```sh
mvn spring-boot:run
```

4. Sigue las instrucciones en la consola para interactuar con el sistema.

## 📂 Estructura del proyecto

- Main: Contiene el menú principal y el flujo de interacción con el usuario.

- Models: Clases que representan las entidades del sistema, como Author y Book.

- Repository: Interfaces para interactuar con la base de datos.

- Services: Servicios auxiliares, como la conexión con la API externa y conversión de datos.

## 📋 Ejemplos de uso
 
### 🔍 Buscar un libro

- Selecciona la opción "Buscar libro" en el menú.

- Ingresa el título del libro que deseas buscar.

- Si el libro es encontrado, se guarda en la base de datos junto con su autor.

### 🗓️ Listar autores vivos en un año

- Selecciona la opción "Listar autores vivos en un año".

- Ingresa un año (por ejemplo, 1800).

- Obtendrás una lista de autores vivos en ese año, con sus libros asociados.

## 👨‍💻 Autor

Desarrollado por [Walter-Britos1](https://github.com/Walter-Britos1).
