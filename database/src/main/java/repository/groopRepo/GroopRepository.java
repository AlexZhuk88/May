package repository.groopRepo;

import model.Groop;
import org.springframework.data.repository.CrudRepository;

public interface GroopRepository extends CrudRepository<Groop, Long>, CustomGroopRepository {

    Groop findByGroopname(String name);

}


