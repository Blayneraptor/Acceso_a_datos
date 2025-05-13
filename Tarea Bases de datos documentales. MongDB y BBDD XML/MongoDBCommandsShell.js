// Comandos para MongoDB Shell
// 1. Crear base de datos llamada liga
// En mongosh, simplemente escribe:
// use liga
// O también puedes usar:
db = db.getSiblingDB("liga");

// 2. Crear colección llamada equipos
db.createCollection("equipos");

// Equipo 1: Real Madrid
db.equipos.insertOne({
  nombre: "Real Madrid",
  entrenador: {
    idPersonal: "E001",
    nombre: "Carlo Ancelotti",
    fechaNacimiento: "1959-06-10",
    direccion: {
      calle: "Calle Serrano, 123",
      codigoPostal: "28006",
      ciudad: "Madrid"
    },
    telefono: "600111222"
  },
  jugadores: [
    {
      idPersonal: "J001",
      nombre: "Vinicius Jr",
      fechaNacimiento: "2000-07-12",
      direccion: {
        calle: "Paseo de la Castellana, 200",
        codigoPostal: "28046",
        ciudad: "Madrid"
      },
      telefono: "600123456"
    },
    {
      idPersonal: "J002",
      nombre: "Jude Bellingham",
      fechaNacimiento: "2003-06-29",
      direccion: {
        calle: "Avenida de Concha Espina, 1",
        codigoPostal: "28036",
        ciudad: "Madrid"
      },
      telefono: "600789012"
    }
  ],
  ciudad: "Madrid"
})

// Equipo 2: FC Barcelona
db.equipos.insertOne({
  nombre: "FC Barcelona",
  entrenador: {
    idPersonal: "E002",
    nombre: "Hansi Flick",
    fechaNacimiento: "1965-02-24",
    direccion: {
      calle: "Avenida Diagonal, 500",
      codigoPostal: "08029",
      ciudad: "Barcelona"
    },
    telefono: "601222333"
  },
  jugadores: [
    {
      idPersonal: "J003",
      nombre: "Pedri González",
      fechaNacimiento: "2002-11-25",
      direccion: {
        calle: "Carrer de Balmes, 150",
        codigoPostal: "08008",
        ciudad: "Barcelona"
      },
      telefono: "602123456"
    },
    {
      idPersonal: "J004",
      nombre: "Lamine Yamal",
      fechaNacimiento: "2007-07-13",
      direccion: {
        calle: "Passeig de Gràcia, 75",
        codigoPostal: "08008",
        ciudad: "Barcelona"
      },
      telefono: "602987654"
    }
  ],
  ciudad: "Barcelona"
})

// Equipo 3: Atlético de Madrid
db.equipos.insertOne({
  nombre: "Atlético de Madrid",
  entrenador: {
    idPersonal: "E003",
    nombre: "Diego Simeone",
    fechaNacimiento: "1970-04-28",
    direccion: {
      calle: "Paseo de Recoletos, 40",
      codigoPostal: "28001",
      ciudad: "Madrid"
    },
    telefono: "603333444"
  },
  jugadores: [
    {
      idPersonal: "J005",
      nombre: "Antoine Griezmann",
      fechaNacimiento: "1991-03-21",
      direccion: {
        calle: "Calle Gran Vía, 30",
        codigoPostal: "28013",
        ciudad: "Madrid"
      },
      telefono: "604123456"
    },
    {
      idPersonal: "J006",
      nombre: "Koke Resurrección",
      fechaNacimiento: "1992-01-08",
      direccion: {
        calle: "Calle Alcalá, 120",
        codigoPostal: "28009",
        ciudad: "Madrid"
      },
      telefono: "604987654"
    }
  ],
  ciudad: "Madrid"
})

// 6. Consulta para mostrar información de todos los equipos
// En mongosh reciente puede usar:
db.equipos.find().pretty();
// O alternativamente en cualquier versión:
db.equipos.find().forEach(printjson);

// 7. Consulta para mostrar equipos de una ciudad específica (Madrid)
// En mongosh reciente:
db.equipos.find({ ciudad: "Madrid" }).pretty();
// O alternativamente:
db.equipos.find({ ciudad: "Madrid" }).forEach(printjson);

// 8. Consulta para mostrar los datos del equipo de un jugador con un idPersonal determinado
// En mongosh reciente:
db.equipos.find({ "jugadores.idPersonal": "J003" }).pretty();
// O alternativamente:
db.equipos.find({ "jugadores.idPersonal": "J003" }).forEach(printjson);

// Para obtener más detalles sobre el jugador específico dentro del equipo:
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

// 9. Modificar la ciudad de un equipo (Barcelona)
db.equipos.updateOne(
  { nombre: "FC Barcelona" },
  { $set: { ciudad: "Girona" } }
)

// Verificar que se ha modificado
// En mongosh reciente:
db.equipos.find({ nombre: "FC Barcelona" }).pretty();
// O alternativamente:
db.equipos.find({ nombre: "FC Barcelona" }).forEach(printjson);

// 10. Modificar el teléfono de un jugador determinado (Jude Bellingham, J002)
db.equipos.updateOne(
  { "jugadores.idPersonal": "J002" },
  { $set: { "jugadores.$.telefono": "699999999" } }
)

// Verificar que se ha modificado
// En mongosh reciente:
db.equipos.find({ "jugadores.idPersonal": "J002" }).pretty();
// O alternativamente:
db.equipos.find({ "jugadores.idPersonal": "J002" }).forEach(printjson);

// Mostrar los cambios realizados
// En mongosh reciente:
db.equipos.find().pretty();
// O alternativamente:
db.equipos.find().forEach(printjson);
