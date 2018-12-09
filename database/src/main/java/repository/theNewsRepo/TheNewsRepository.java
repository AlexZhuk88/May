package repository.theNewsRepo;

import model.TheNew;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TheNewsRepository extends CrudRepository<TheNew, Long>, CustomTheNewsRepository {

    @Query(value = "select distinct username\n" +
            "from smay_db.news n\n" +
            "       join smay_db.user u on n.author_id = u.id order by username", nativeQuery = true)
    List<String> findAllAuthors();
}


