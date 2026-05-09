# 🎓 Catálogo de Carreras UASD

Sistema desarrollado en JavaFX para la gestión y visualización de información académica de carreras universitarias de la UASD.

---

## 📌 Descripción del Proyecto

Este proyecto consiste en una aplicación de escritorio desarrollada con Java y JavaFX que permite administrar y consultar información relacionada con:

* Facultades
* Escuelas
* Carreras universitarias

El sistema utiliza una base de datos MySQL para almacenar la información y sigue una estructura organizada utilizando el patrón DAO.

---

## 🛠️ Tecnologías Utilizadas

* Java 23
* JavaFX 21
* Maven
* MySQL
* CSS
* FXML
* JDBC

---

## 📂 Estructura del Proyecto

```bash
CatalogoCarreras-main/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/catagolocarreras/
│   │   │       ├── Controllers/
│   │   │       ├── DAO/
│   │   │       ├── Models/
│   │   │       ├── DatabaseConnection.java
│   │   │       ├── InicioApplication.java
│   │   │       └── Launcher.java
│   │   │
│   │   └── resources/
│   │       ├── css/
│   │       ├── Img/
│   │       └── com/example/catagolocarreras/
│   │
├── pom.xml
├── README.md
└── config.properties.example
```

---

## ⚙️ Funcionalidades

* Visualización de carreras universitarias
* Organización por facultades y escuelas
* Conexión a base de datos MySQL
* Interfaz gráfica amigable con JavaFX
* Arquitectura organizada por capas
* Uso de modelos y DAO para manejo de datos

---

## 🗄️ Base de Datos

El proyecto utiliza MySQL como sistema gestor de base de datos.

### Configuración recomendada

1. Crear una base de datos en MySQL.
2. Importar el script SQL correspondiente.
3. Configurar las credenciales de conexión.

Ejemplo de configuración:

```properties
DB_URL=jdbc:mysql://localhost:3306/catalogo_carreras
DB_USER=root
DB_PASSWORD=1234
```

---

## ▶️ Cómo Ejecutar el Proyecto

### Requisitos

* JDK 23 o superior
* Maven 3.6+
* MySQL Server
* IDE recomendado: IntelliJ IDEA o NetBeans

### Pasos

1. Clonar el repositorio:

```bash
git clone https://github.com/usuario/CatalogoCarreras.git
```

2. Entrar a la carpeta del proyecto:

```bash
cd CatalogoCarreras
```

3. Compilar el proyecto:

```bash
mvn clean compile
```

4. Ejecutar la aplicación:

```bash
mvn javafx:run
```

---

## 🧩 Arquitectura del Proyecto

El sistema está organizado utilizando una estructura por capas:

### 📁 Models

Contiene las clases que representan las entidades del sistema:

* Carrera
* Facultad
* Escuela

### 📁 DAO

Contiene la lógica de acceso y manipulación de datos.

### 📁 Controllers

Controla la interacción entre la interfaz y la lógica del sistema.

### 📁 Resources

Contiene:

* Archivos FXML
* Estilos CSS
* Imágenes del sistema

---

## 🎨 Interfaz Gráfica

La interfaz fue desarrollada utilizando JavaFX y FXML, permitiendo una experiencia visual moderna y organizada.

Características:

* Diseño intuitivo
* Navegación sencilla
* Estilos personalizados con CSS
* Integración de imágenes e iconos

---

## 📦 Dependencias Principales

El proyecto utiliza las siguientes dependencias:

* JavaFX Controls
* JavaFX FXML
* MySQL Connector/J
* ControlsFX
* FormsFX
* ValidatorFX
* BootstrapFX
* JUnit 5

---

## 👨‍💻 Autor

Proyecto desarrollado como práctica académica para gestión de información universitaria.

---

## 📄 Licencia

Este proyecto es de uso educativo y académico.

---

## 🚀 Posibles Mejoras Futuras

* Implementar sistema de login
* Agregar búsqueda avanzada
* Exportar reportes en PDF
* Añadir más módulos administrativos
* Mejorar validaciones
* Implementar CRUD completo
* Migrar a arquitectura MVC más avanzada

---

## 📸 Vista General del Sistema

Aplicación de escritorio orientada a la administración y consulta de carreras universitarias dentro de la UASD mediante una interfaz gráfica moderna y conectada a MySQL.
