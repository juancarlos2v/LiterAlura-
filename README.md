# LiterAlura Challenge

Este proyecto es parte del **reto LiterAlura**, desarrollado para consolidar los conocimientos adquiridos en el curso de Spring Boot. El objetivo es consumir datos de una API externa, mapear los resultados en clases de Java y almacenarlos en una base de datos PostgreSQL usando JPA (Java Persistence API).

## 🚀 Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.0**
- **Maven** (Gestor de dependencias)
- **PostgreSQL** (Base de datos relacional)
- **JPA / Hibernate** (Para la persistencia de datos)
- **Jackson** (Para el mapeo de JSON a objetos de Java)
- **HttpClient** (Para consumir la API externa)

---

## 📋 Descripción del Proyecto

El proyecto consiste en consumir datos de la API de **Gutendex** (una API pública para libros), procesar estos datos y almacenarlos en una base de datos PostgreSQL. Además, se ofrecen funcionalidades para consultar libros y autores, así como buscar libros por título.

### Funcionalidades Principales:
1. **Consumo de API Externa**:
    - Realiza peticiones HTTP a la API de Gutendex.
    - Filtra y obtiene datos clave de los resultados (`title`, `author`, `languages`, etc.).

2. **Mapeo de Resultados**:
    - Los datos JSON obtenidos se mapean en una estructura de clases en Java para facilitar su manipulación.

3. **Persistencia con JPA**:
    - Los datos de los libros se almacenan en una base de datos PostgreSQL usando JPA.

4. **Interacción con el Usuario**:
    - Menú interactivo para consultar, buscar y guardar libros.

---

## 🛠️ Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:
- **Java 17** o superior.
- **PostgreSQL**.
- **Maven**.

Configura tu base de datos PostgreSQL con las credenciales necesarias y asegúrate de actualizarlas en el archivo `application.properties`.

---

## ⚙️ Configuración del Proyecto

1. **Clona el Repositorio**:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd literAlura

2. **Configura la Base de Datos: Asegúrate de que tu base de datos PostgreSQL esté corriendo y crea una base de datos llamada  `liter_alura`.**

    Luego, actualiza el archivo `src/main/resources/application.properties`:

    ```bash
    Copiar código
    spring.datasource.url=jdbc:postgresql://localhost:5432/liter_alura
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update


3. **Instala las Dependencias:**

    ```bash
    mvn clean install

4. **Ejecuta la Aplicación:**

    ```bash
    mvn spring-boot:run

## 📚 Uso del Proyecto
### Menú Interactivo
Al ejecutar la aplicación, verás un menú con las siguientes opciones:

1. Consultar Libros: Muestra una lista de libros obtenidos de la API.
2. Buscar Libro por Título: Permite buscar un libro por su título.
3. Consultar Autores: Muestra una lista de autores.
4. Consultar Autores Vivos por Año: Filtra autores según su año de nacimiento.

### Flujo Principal
1. Selecciona la opción deseada.
2. Interactúa con la aplicación según se solicite (por ejemplo, ingresando un título para buscar).
3. Los datos obtenidos se mostrarán en la consola o se guardarán en la base de datos.
    
    ```bash
    src
    ├── main
    │   ├── java/com/alura/literalura
    │   │   ├── entities
    │   │   │   └── Book.java               // Entidad JPA para libros
                └── Author.java               // Entidad JPA para libros
    │   │   ├── repository
    │   │   │   └── BookRepository.java     // Interfaz JPA para la persistencia
    │   │   │   └── AuthorRepository.java     // Interfaz JPA para la persistencia
    │   │   ├── service
    │   │   │   ├── BookService.java        // Lógica de negocio
    │   │   │   ├── AuthorService.java        // Lógica de negocio
    │   │   │   ├── ConsumoAPI.java         // Manejo de consumo de API externa
    │   │   │   └── ConvertirDatos.java     // Utilidad para deserializar JSON
    │   │   └── LiterAluraApplication.java // Clase principal
    │   └── resources
    │       ├── application.properties     // Configuración de la aplicación
    └── test      

## ✨ Mejoras Futuras
- Implementar una interfaz gráfica o API REST para gestionar las operaciones.
- Añadir validaciones y manejo de errores robusto.
- Permitir guardar traducciones y múltiples autores por libro.
- Paginar las respuestas en la consola al consultar libros.