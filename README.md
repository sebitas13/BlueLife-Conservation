# Sistema de Gestión de Captura de Especies Marítimas

Este proyecto es una aplicación de escritorio en Java diseñada para gestionar la captura de especies marítimas por parte de empresas pesqueras. El sistema ayuda a controlar y monitorear las capturas, promoviendo la sostenibilidad de los recursos marinos, alineado con el Objetivo 14 de las Naciones Unidas sobre la vida submarina.

## Características

- **Gestión de capturas**: Permite a las empresas pesqueras registrar y gestionar capturas de especies.
- **Monitoreo de especies**: Ofrece seguimiento del estado de las especies, verificando si están aptas para la pesca.
- **Control de ventas**: Gestiona las ventas de especies capturadas por las empresas.
- **Visualización de datos**: Muestra la información de las especies, su explotación y cantidad capturada.
- **Interfaz amigable**: La aplicación cuenta con una interfaz sencilla y fácil de usar para el usuario final.

## Demo

Aquí se puede ver un video demostrativo de la aplicación en funcionamiento:

## Instalación

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/tu_usuario/BlueLife-Conservation.git
   cd BlueLife-Conservation    

2. **Configura la base de datos:**

Asegúrate de tener Oracle Express instalado.
Importa las tablas necesarias ejecutando los scripts SQL proporcionados en la carpeta database.

3. **Configura las conexiones:**

Abre el archivo de configuración de la conexión a la base de datos y asegúrate de que las credenciales y URL de conexión sean correctas.

4. **Ejecuta la aplicación:**

Compila y ejecuta la aplicación desde tu IDE favorito (por ejemplo, NetBeans).

5. **Librerías necesarias**

La aplicación utiliza las siguientes librerías:

- HikariCP: Para la gestión de conexiones de base de datos.
- SLF4J: Para el manejo de logs.
- Oracle JDBC Driver: Para la conexión con la base de datos Oracle.
- JTable: Para la visualización de datos en tablas.
- Swing: Para la interfaz gráfica de usuario.

Para instalarlas, asegúrate de agregar los JAR necesarios en tu proyecto o gestionarlos a través de un build tool como Maven.

6. **Diagrama Relacional**

![DRBD](https://github.com/user-attachments/assets/90a0c943-d881-4cfc-8734-95ea99436a75)


7. **Tecnologías utilizadas**

- Java (Swing para la interfaz de usuario)
- JDBC para la conexión a la base de datos Oracle
- HikariCP para el pool de conexiones
- SQL para la gestión de datos
- MVC (Modelo-Vista-Controlador) y patrones de diseño como Singleton e Inyección de Dependencias

8. **Autor**

Jesús Sebastián Huamanculi

La implementación del sistema no solo optimiza la gestión de las capturas pesqueras, sino que contribuye a la conservación de los recursos marinos. Para más información sobre la importancia de este tipo de iniciativas, puedes consultar el Objetivo 14 de la ONU.

