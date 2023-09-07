# Alance especificaciones y configuraciones del proyecto
Proyecto de practica para **reserva de boleto de una boleteria de buses**, lo que contiene el proyecto es lo siguiente:
 * Crud de buses
 * Crud de Horarios
 * Crud de compra y reserva de asientos
 * Validaciones
#
# El lenguaje y libreria a utilizar son las siguientes:
 * Java 17
 * Maven 3.1.1
 * Maria Db
 * Validation
 * opencsv
La base de datos que se utilizo fue **MySql Maria Db**, la cual el nombre de la base de datos es **bd_boleteria**.
#
# Instalacion de  las dependencias
 * Primero verificar que tengas instalado java 17 o que sea el lenguaje predeterminado
 * Ejecutar el siguiente comando mvn install
 * Ejecutar el comando mvn start para ejecutar el proyecto
 * Tener un archivo .env para las configuraciones de claves tanto mysql y proyecto
#
# DockerFile
Se realiza una configuracion para ejecutarlo con Docker, la cual se ejecutara en el puerto 8081, los comandos a ejecutar son los siguientes:
 * sudo docker run -d chatbot --net=host chatbot

