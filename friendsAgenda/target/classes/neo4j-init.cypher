// Neo4j initialization script (sample data)
CREATE (:PersonGraph {sqlId: 1, username: 'juan', name: 'Juan', age: 30, email: 'juan@example.com'});
CREATE (:PersonGraph {sqlId: 2, username: 'sofia', name: 'Sofia', age: 28, email: 'sofia@example.com'});
CREATE (:PersonGraph {sqlId: 3, username: 'daniel', name: 'Daniel', age: 32, email: 'daniel@example.com'});
CREATE (:PersonGraph {sqlId: 4, username: 'carlos', name: 'Carlos', age: 35, email: 'carlos@example.com'});

// Events
CREATE (:EventGraph {sqlId: 100, name: 'Partido de Futbol'});
CREATE (:EventGraph {sqlId: 101, name: 'Reunión Amigos'});

// Friendships (unidirectional as requested)
MATCH (a:PersonGraph {username:'juan'}), (b:PersonGraph {username:'sofia'})
CREATE (a)-[:FRIEND_OF {since:'2024-01-01'}]->(b);
MATCH (a:PersonGraph {username:'juan'}), (b:PersonGraph {username:'daniel'})
CREATE (a)-[:FRIEND_OF {since:'2024-02-15'}]->(b);

// Attends
MATCH (p:PersonGraph {username:'juan'}), (e:EventGraph {name:'Partido de Futbol'})
CREATE (p)-[:ATTENDS]->(e);
MATCH (p:PersonGraph {username:'daniel'}), (e:EventGraph {name:'Partido de Futbol'})
CREATE (p)-[:ATTENDS]->(e);
