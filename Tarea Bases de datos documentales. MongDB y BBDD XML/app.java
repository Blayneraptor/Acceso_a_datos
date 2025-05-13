import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;

/**
 * Aplicación para gestionar una base de datos MongoDB de equipos de fútbol.
 * Implementa las operaciones especificadas en la tarea.
 */
public class app {
    public static void main(String[] args) {
        // Conexión a MongoDB
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            System.out.println("Conexión a MongoDB establecida correctamente");

            // 1. Crear base de datos llamada liga
            MongoDatabase database = mongoClient.getDatabase("liga");
            System.out.println("1. Base de datos 'liga' creada correctamente");

            // 2. Crear colección llamada equipos
            // Verificar si la colección ya existe
            boolean collectionExists = database.listCollectionNames()
                    .into(new java.util.ArrayList<>()).contains("equipos");
            
            if (!collectionExists) {
                database.createCollection("equipos");
            }
            
            MongoCollection<Document> equiposCollection = database.getCollection("equipos");
            System.out.println("2. Colección 'equipos' creada correctamente");

            // Limpiar colección para evitar duplicados en ejecuciones repetidas
            equiposCollection.drop();
            database.createCollection("equipos");
            equiposCollection = database.getCollection("equipos");

            // 3. Añadir tres equipos con la estructura especificada
            // Equipo 1: Real Madrid
            Document direccionEntrenador1 = new Document()
                    .append("calle", "Calle Serrano, 123")
                    .append("codigoPostal", "28006")
                    .append("ciudad", "Madrid");

            Document entrenador1 = new Document()
                    .append("idPersonal", "E001")
                    .append("nombre", "Carlo Ancelotti")
                    .append("fechaNacimiento", "1959-06-10")
                    .append("direccion", direccionEntrenador1)
                    .append("telefono", "600111222");

            // Jugadores del equipo 1
            Document direccionJugador1 = new Document()
                    .append("calle", "Paseo de la Castellana, 200")
                    .append("codigoPostal", "28046")
                    .append("ciudad", "Madrid");

            Document jugador1 = new Document()
                    .append("idPersonal", "J001")
                    .append("nombre", "Vinicius Jr")
                    .append("fechaNacimiento", "2000-07-12")
                    .append("direccion", direccionJugador1)
                    .append("telefono", "600123456");

            Document direccionJugador2 = new Document()
                    .append("calle", "Avenida de Concha Espina, 1")
                    .append("codigoPostal", "28036")
                    .append("ciudad", "Madrid");

            Document jugador2 = new Document()
                    .append("idPersonal", "J002")
                    .append("nombre", "Jude Bellingham")
                    .append("fechaNacimiento", "2003-06-29")
                    .append("direccion", direccionJugador2)
                    .append("telefono", "600789012");

            Document equipo1 = new Document()
                    .append("nombre", "Real Madrid")
                    .append("entrenador", entrenador1)
                    .append("jugadores", Arrays.asList(jugador1, jugador2))
                    .append("ciudad", "Madrid");

            // Equipo 2: Barcelona
            Document direccionEntrenador2 = new Document()
                    .append("calle", "Avenida Diagonal, 500")
                    .append("codigoPostal", "08029")
                    .append("ciudad", "Barcelona");

            Document entrenador2 = new Document()
                    .append("idPersonal", "E002")
                    .append("nombre", "Hansi Flick")
                    .append("fechaNacimiento", "1965-02-24")
                    .append("direccion", direccionEntrenador2)
                    .append("telefono", "601222333");

            // Jugadores del equipo 2
            Document direccionJugador3 = new Document()
                    .append("calle", "Carrer de Balmes, 150")
                    .append("codigoPostal", "08008")
                    .append("ciudad", "Barcelona");

            Document jugador3 = new Document()
                    .append("idPersonal", "J003")
                    .append("nombre", "Pedri González")
                    .append("fechaNacimiento", "2002-11-25")
                    .append("direccion", direccionJugador3)
                    .append("telefono", "602123456");

            Document direccionJugador4 = new Document()
                    .append("calle", "Passeig de Gràcia, 75")
                    .append("codigoPostal", "08008")
                    .append("ciudad", "Barcelona");

            Document jugador4 = new Document()
                    .append("idPersonal", "J004")
                    .append("nombre", "Lamine Yamal")
                    .append("fechaNacimiento", "2007-07-13")
                    .append("direccion", direccionJugador4)
                    .append("telefono", "602987654");

            Document equipo2 = new Document()
                    .append("nombre", "FC Barcelona")
                    .append("entrenador", entrenador2)
                    .append("jugadores", Arrays.asList(jugador3, jugador4))
                    .append("ciudad", "Barcelona");

            // Equipo 3: Atlético de Madrid
            Document direccionEntrenador3 = new Document()
                    .append("calle", "Paseo de Recoletos, 40")
                    .append("codigoPostal", "28001")
                    .append("ciudad", "Madrid");

            Document entrenador3 = new Document()
                    .append("idPersonal", "E003")
                    .append("nombre", "Diego Simeone")
                    .append("fechaNacimiento", "1970-04-28")
                    .append("direccion", direccionEntrenador3)
                    .append("telefono", "603333444");

            // Jugadores del equipo 3
            Document direccionJugador5 = new Document()
                    .append("calle", "Calle Gran Vía, 30")
                    .append("codigoPostal", "28013")
                    .append("ciudad", "Madrid");

            Document jugador5 = new Document()
                    .append("idPersonal", "J005")
                    .append("nombre", "Antoine Griezmann")
                    .append("fechaNacimiento", "1991-03-21")
                    .append("direccion", direccionJugador5)
                    .append("telefono", "604123456");

            Document direccionJugador6 = new Document()
                    .append("calle", "Calle Alcalá, 120")
                    .append("codigoPostal", "28009")
                    .append("ciudad", "Madrid");

            Document jugador6 = new Document()
                    .append("idPersonal", "J006")
                    .append("nombre", "Koke Resurrección")
                    .append("fechaNacimiento", "1992-01-08")
                    .append("direccion", direccionJugador6)
                    .append("telefono", "604987654");

            Document equipo3 = new Document()
                    .append("nombre", "Atlético de Madrid")
                    .append("entrenador", entrenador3)
                    .append("jugadores", Arrays.asList(jugador5, jugador6))
                    .append("ciudad", "Madrid");

            // Insertar los tres equipos
            equiposCollection.insertMany(Arrays.asList(equipo1, equipo2, equipo3));
            System.out.println("3. Tres equipos añadidos correctamente");

            // 6. Consulta para mostrar información de todos los equipos
            System.out.println("\n6. Información de todos los equipos:");
            List<Document> allTeams = equiposCollection.find().into(new java.util.ArrayList<>());
            for (Document team : allTeams) {
                System.out.println("Equipo: " + team.getString("nombre"));
                System.out.println("Ciudad: " + team.getString("ciudad"));
                Document coach = (Document) team.get("entrenador");
                System.out.println("Entrenador: " + coach.getString("nombre"));
                
                System.out.println("Jugadores:");
                List<Document> players = (List<Document>) team.get("jugadores");
                for (Document player : players) {
                    System.out.println("  - " + player.getString("nombre") + 
                                      " (ID: " + player.getString("idPersonal") + ")");
                }
                System.out.println("-----------------------------");
            }

            // 7. Consulta para mostrar equipos de una ciudad específica (Madrid)
            String ciudadBuscar = "Madrid";
            System.out.println("\n7. Equipos de " + ciudadBuscar + ":");
            List<Document> teamsByCity = equiposCollection.find(Filters.eq("ciudad", ciudadBuscar))
                    .into(new java.util.ArrayList<>());
            
            for (Document team : teamsByCity) {
                System.out.println("- " + team.getString("nombre"));
            }

            // 8. Consulta para mostrar el equipo de un jugador con un idPersonal determinado
            String idJugadorBuscar = "J003"; // Pedri González
            System.out.println("\n8. Equipo del jugador con ID " + idJugadorBuscar + ":");
            
            Document teamWithPlayer = equiposCollection.find(
                    Filters.elemMatch("jugadores", Filters.eq("idPersonal", idJugadorBuscar)))
                    .first();
            
            if (teamWithPlayer != null) {
                System.out.println("Equipo: " + teamWithPlayer.getString("nombre"));
                
                // Buscar y mostrar los datos del jugador específico
                List<Document> players = (List<Document>) teamWithPlayer.get("jugadores");
                for (Document player : players) {
                    if (idJugadorBuscar.equals(player.getString("idPersonal"))) {
                        System.out.println("Datos del jugador:");
                        System.out.println("  Nombre: " + player.getString("nombre"));
                        System.out.println("  Fecha de nacimiento: " + player.getString("fechaNacimiento"));
                        System.out.println("  Teléfono: " + player.getString("telefono"));
                        Document dir = (Document) player.get("direccion");
                        System.out.println("  Dirección: " + dir.getString("calle") + ", " + 
                                          dir.getString("codigoPostal") + ", " + 
                                          dir.getString("ciudad"));
                        break;
                    }
                }
            } else {
                System.out.println("No se encontró ningún equipo con un jugador con ID " + idJugadorBuscar);
            }

            // 9. Modificar la ciudad de un equipo (Barcelona)
            String equipoModificar = "FC Barcelona";
            String nuevaCiudad = "Girona";
            
            Bson filter = Filters.eq("nombre", equipoModificar);
            Bson update = Updates.set("ciudad", nuevaCiudad);
            
            equiposCollection.updateOne(filter, update);
            System.out.println("\n9. Ciudad del equipo " + equipoModificar + " modificada a " + nuevaCiudad);

            // 10. Modificar el teléfono de un jugador determinado (Jude Bellingham)
            String idJugadorModificar = "J002"; // Jude Bellingham
            String nuevoTelefono = "699999999";
            
            Bson filterTeam = Filters.elemMatch("jugadores", Filters.eq("idPersonal", idJugadorModificar));
            Bson updatePhone = Updates.set("jugadores.$.telefono", nuevoTelefono);
            
            equiposCollection.updateOne(filterTeam, updatePhone);
            System.out.println("\n10. Teléfono del jugador con ID " + idJugadorModificar + " modificado a " + nuevoTelefono);

            // Mostrar los cambios realizados
            System.out.println("\nDatos actualizados después de las modificaciones:");
            allTeams = equiposCollection.find().into(new java.util.ArrayList<>());
            for (Document team : allTeams) {
                System.out.println("Equipo: " + team.getString("nombre"));
                System.out.println("Ciudad: " + team.getString("ciudad"));

                List<Document> players = (List<Document>) team.get("jugadores");
                for (Document player : players) {
                    if (idJugadorModificar.equals(player.getString("idPersonal")) || 
                        equipoModificar.equals(team.getString("nombre"))) {
                        System.out.println("  Jugador: " + player.getString("nombre") + 
                                          " (ID: " + player.getString("idPersonal") + ")");
                        System.out.println("  Teléfono: " + player.getString("telefono"));
                    }
                }
                System.out.println("-----------------------------");
            }

        } catch (Exception e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
