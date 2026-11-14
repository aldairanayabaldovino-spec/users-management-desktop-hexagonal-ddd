\# Gestión de Usuarios y Empleados - CEA



Aplicación de escritorio desarrollada en Java que permite gestionar usuarios y empleados mediante operaciones CRUDL (crear, consultar, actualizar, eliminar y listar). El proyecto utiliza arquitectura hexagonal, principios de Domain-Driven Design (DDD) y buenas prácticas de desarrollo.



\## Tecnologías utilizadas



\- Java 17.

\- Maven.

\- MySQL.

\- JUnit 5.

\- JaCoCo para medir la cobertura de pruebas.

\- Apache NetBeans.



\## Arquitectura del proyecto



El proyecto está organizado siguiendo la arquitectura hexagonal:



\- \*\*Dominio:\*\* contiene los modelos, objetos de valor, eventos, excepciones y patrones relacionados con las reglas del negocio.

\- \*\*Aplicación:\*\* contiene los casos de uso, servicios y puertos que coordinan las operaciones.

\- \*\*Infraestructura:\*\* contiene los adaptadores, persistencia, configuración y componentes de entrada y salida.



\## Elementos de Domain-Driven Design implementados



\### Modelo de dominio



`EmpleadoModel` representa al empleado y utiliza objetos de valor para manejar sus datos principales.



\### Objetos de valor (Value Objects)



Se implementaron:



\- `NombreEmpleado`

\- `DocumentoEmpleado`

\- `CargoEmpleado`

\- `Salario`



Estas clases centralizan validaciones y representan conceptos del dominio.



\### Eventos de dominio



Se implementaron:



\- `EmpleadoRegistradoDomainEvent`

\- `EmpleadoActualizadoDomainEvent`



Representan hechos importantes relacionados con los empleados. Las clases están creadas y probadas, aunque su publicación y consumo todavía no están conectados al flujo de los casos de uso.



\### Fábrica (Factory)



`EmpleadoFactory` permite crear instancias de `EmpleadoModel` centralizando el proceso de construcción.



\### Especificación (Specification)



`EmpleadoConSalarioMinimoSpecification` permite comprobar si un empleado cumple una condición relacionada con su salario mínimo.



\### Excepciones de dominio



`EmpleadoInvalidoException` representa errores relacionados con datos inválidos de un empleado.



\## Funcionalidades



\- Registro, consulta, actualización, eliminación y listado de usuarios.

\- Registro, consulta, actualización, eliminación y listado de empleados.

\- Validación de información del dominio.

\- Persistencia mediante adaptadores.

\- Separación de responsabilidades mediante arquitectura hexagonal.



\## Pruebas



El proyecto incluye pruebas unitarias para verificar el comportamiento de los modelos, objetos de valor, eventos, excepciones y patrones implementados.



La cobertura se verifica mediante JaCoCo.



\## Ejecución



El proyecto puede abrirse desde Apache NetBeans como proyecto Maven. La configuración de conexión a la base de datos se encuentra en los archivos de configuración de infraestructura.



\## Propósito académico



Este proyecto se desarrolla como parte de las actividades de Desarrollo de Software, con el propósito de aplicar arquitectura hexagonal, conceptos de DDD, patrones de diseño, pruebas automatizadas y control de versiones con Git.

