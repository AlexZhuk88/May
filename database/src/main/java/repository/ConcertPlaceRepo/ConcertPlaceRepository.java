package repository.ConcertPlaceRepo;

import model.ConcertPlace;
import org.springframework.data.repository.CrudRepository;

public interface ConcertPlaceRepository extends CrudRepository<ConcertPlace, Long>, CustomConcertPlaceRepository {

}


