    # NEO4J SETUP - friendsAgenda

    Diseño requerido:

    - Base relacional (SQL): guarda datos personales básicos de las personas (person table).
      * Esta base **NO** almacena relaciones ni detalles de hobbies ni eventos.
      * Se mantiene mínima para cumplir con la restricción del enunciado (monolito + poliglota).

    - Base de grafos (Neo4j): almacena relaciones entre personas y eventos.
      * Nodos: PersonGraph, EventGraph
      * Relaciones (unidireccional): FRIEND_OF (de PersonGraph a PersonGraph), ATTENDS (de PersonGraph a EventGraph)

    - Base documental (MongoDB - "BongoBD"): almacena hobbies y detalles de eventos como documentos JSON.
      * Ejemplo: collection `profiles` con documentos que incluyen `sqlId` para referenciar la persona en SQL y un campo `hobbies` que es un arreglo JSON.

    Cambios realizados en el código (en src/main/java/papers/friendsAgenda/domain/neo4j):
    - Friendship.java: implementada como @RelationshipProperties para permitir propiedades en la relación (e.g., since).
    - PersonGraph.java: adaptada para exponer relaciones como List<Friendship> y List<EventGraph> (unidireccionales).

    Archivos añadidos:
    - src/main/resources/neo4j-init.cypher: script de ejemplo para crear nodos y relaciones en Neo4j.

    Cómo usar:
    1. Levanta tu base SQL con el schema.sql existente (solo tabla person).
    2. Levanta MongoDB y crea la colección `profiles`. Inserta documentos con referencia `sqlId` y `hobbies` como array JSON. Ej:
       {
         "sqlId": 1,
         "hobbies": ["Futbol", "Lectura"]
       }
    3. Levanta Neo4j (p. ej. Docker). Ejecuta el script `neo4j-init.cypher` en Neo4j Browser o usando `cypher-shell` para poblar ejemplo de datos.
    4. Ajusta `Neo4jSyncService` si quieres sincronizar automáticamente personas desde SQL a Neo4j. Actualmente el servicio existente en el proyecto sólo necesita crear nodos PersonGraph a partir de la tabla person.

    Restricciones atendidas:
    - Lista de hobbies en formato JSON: cumplida mediante MongoDB (campo `hobbies` array JSON).
    - Relaciones y eventos en base de datos orientada a grafos: cumplido con Neo4j.
    - Datos personales en base relacional: mantenido en SQL.

    Si quieres, puedo:
- Modificar `Neo4jSyncService` para que lea la tabla `person` y cree nodos `PersonGraph` automáticamente (ya existe en el proyecto una clase `Neo4jSyncService.class` compilada en target, pero no tenemos el .java exacto modificado). 
- Preparar scripts adicionales para poblar MongoDB.
- Generar un ZIP con estos cambios (listo) para que lo descargues e importes en tu IDE.
