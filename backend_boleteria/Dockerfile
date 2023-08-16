# Se utiliza la imagen oficial de OpenJDK 17 como base
FROM openjdk:17
#PUERTO QUE SE VA A CORRER
EXPOSE 8081
# Se establece el directorio de trabajo dentro del contenedor
WORKDIR /app
# Se copia el archivo JAR de la aplicación en el contenedor
COPY target/backend_boleteria-0.0.1-SNAPSHOT.jar target/backend_boleteria-0.0.1-SNAPSHOT.jar
#EJECUTAR EL CMD O COMANDO PARA EL CHATBOT
ENTRYPOINT ["java", "-jar", "target/backend_boleteria-0.0.1-SNAPSHOT.jar"]
