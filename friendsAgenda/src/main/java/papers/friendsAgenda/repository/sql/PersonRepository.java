package papers.friendsAgenda.repository.sql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import papers.friendsAgenda.domain.sql.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    // Retorna todas las personas ordenadas por nombre
    @Query("SELECT p FROM Person p ORDER BY p.name")
    List<Person> buscarTodos();

    // Busca por el campo personId (si no es la PK)
    @Query("SELECT p FROM Person p WHERE p.personId = ?1")
    Person buscarPorId(Integer id);

    // Busca por email exacto
    @Query("SELECT p FROM Person p WHERE p.email = ?1")
    Person buscarPorEmail(String email);

    // Busca por nombre (contiene)
    @Query("SELECT p FROM Person p WHERE p.name LIKE %?1%")
    List<Person> buscarPorNombre(String name);

}
