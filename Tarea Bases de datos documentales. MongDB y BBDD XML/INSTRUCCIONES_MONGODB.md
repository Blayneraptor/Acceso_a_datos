# Instrucciones para ejecutar comandos en MongoDB

El archivo MongoDBCommandsShell.js contiene comandos para MongoDB, pero algunos pueden generar errores de sintaxis según la versión de MongoDB que estés utilizando. Aquí tienes instrucciones paso a paso para ejecutar los comandos correctamente:

## Pasos a seguir:

1. **Inicia MongoDB Shell**:
   - Abre una terminal o consola
   - Escribe `mongosh` (para MongoDB 5.0+) o `mongo` (para versiones anteriores)

2. **Crea la base de datos "liga"**:
   ```
   use liga
   ```

3. **Crea la colección "equipos"**:
   ```
   db.createCollection("equipos")
   ```

4. **Verifica que la colección se ha creado**:
   ```
   show collections
   ```
   O alternativamente:
   ```
   db.getCollectionNames()
   ```

5. **Inserta los equipos** (copia y pega uno por uno desde MongoDBCommandsShell.js)

6. **Realiza consultas** (copia y pega una por una):
   - Para mostrar todos los equipos:
     ```
     db.equipos.find().pretty()
     ```
     O en versiones que no soportan .pretty():
     ```
     db.equipos.find().forEach(printjson)
     ```

   - Para mostrar equipos de Madrid:
     ```
     db.equipos.find({ciudad: "Madrid"}).pretty()
     ```
     O:
     ```
     db.equipos.find({ciudad: "Madrid"}).forEach(printjson)
     ```

   - Para buscar el equipo de un jugador con ID "J003":
     ```
     db.equipos.find({"jugadores.idPersonal": "J003"}).pretty()
     ```
     O:
     ```
     db.equipos.find({"jugadores.idPersonal": "J003"}).forEach(printjson)
     ```

   - Para obtener más detalles sobre el jugador con ID "J003":
     ```
     db.equipos.aggregate([
       { $match: { "jugadores.idPersonal": "J003" } },
       { $unwind: "$jugadores" },
       { $match: { "jugadores.idPersonal": "J003" } },
       { $project: { 
           "nombre_equipo": "$nombre", 
           "nombre_jugador": "$jugadores.nombre",
           "fechaNacimiento": "$jugadores.fechaNacimiento",
           "direccion": "$jugadores.direccion",
           "telefono": "$jugadores.telefono"
         }
       }
     ])
     ```

7. **Realiza modificaciones**:
   - Para cambiar la ciudad del FC Barcelona a Girona:
     ```
     db.equipos.updateOne(
       { nombre: "FC Barcelona" },
       { $set: { ciudad: "Girona" } }
     )
     ```

   - Para modificar el teléfono del jugador con ID "J002":
     ```
     db.equipos.updateOne(
       { "jugadores.idPersonal": "J002" },
       { $set: { "jugadores.$.telefono": "699999999" } }
     )
     ```

8. **Verifica los cambios**:
   ```
   db.equipos.find().pretty()
   ```
   O:
   ```
   db.equipos.find().forEach(printjson)
   ```

## Notas importantes:

- **Uso de punto y coma**: En MongoDB Shell, los punto y coma (`;`) al final de cada comando son opcionales.
- **Compatibilidad**: Si encuentras errores con `.pretty()`, utiliza `.forEach(printjson)` en su lugar.
- **Palabras clave especiales**: Comandos como `use`, `show collections` son parte del shell y no del lenguaje JavaScript, por lo que pueden no funcionar en archivos .js cargados completos.

Para ejecutar todos los comandos en secuencia, es mejor copiarlos y pegarlos uno por uno en el shell de MongoDB en lugar de cargar el archivo completo.
