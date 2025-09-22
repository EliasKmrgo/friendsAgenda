package papers.friendsAgenda.repository.sql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import papers.friendsAgenda.domain.sql.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("from Person p order by p.name")
    List<Person> buscarTodos();

    @Query("from Person p where p.id = ?1")
    Person buscarPorId(Integer id);

    @Query("from Person p where p.email = ?1")
    Person buscarPorEmail(String email);

    @Query("from Person p where p.name like %?1%")
    List<Person> buscarPorNombre(String name);
}
