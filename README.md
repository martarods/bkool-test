## Versiones utilizadas
  - Springboot 3.2.3
  - Maven 3.9.5
  - Java 17

## Para ejecutar el proyecto correctamente:
- Ejecuta `mvn clean package`.
- Luego, ejecuta `docker-compose up --build`.

## Para probar las distintas funcionalidades:
- Descarga la colección de Postman incluida.
- Crea un usuario.
- Autentícalo para obtener el token.
- Utiliza el token en el resto de consultas como Bearer.
- Se proporcionan ejemplos de diferentes bicicletas con múltiples items para probar los endpoints directamente.
