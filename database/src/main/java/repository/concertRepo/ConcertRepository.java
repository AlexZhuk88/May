package repository.concertRepo;

import dto.GroopDto;
import model.Concert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConcertRepository extends CrudRepository<Concert, Long>, CustomConcertRepository {

    Concert findByConcertName(String name);

    @Query(value = "select distinct cp.city from ConcertPlace cp")
    List<String> findAllCity();

    @Query(value = "select distinct cp.place from ConcertPlace cp")
    List<String> findAllPlace();

    @Query(value = "select distinct g.groopname from Groop g")
    List<String> findAllGroop();

    @Query(value = "select distinct g.id as id, g.groopname as groopname from smay_db.groop g order by id", nativeQuery = true)
    List<GroopDto> findAllGropWithId();

    @Query(value = "select distinct g.groopname from Groop g")
    List<String> findAllGroopy();

}


