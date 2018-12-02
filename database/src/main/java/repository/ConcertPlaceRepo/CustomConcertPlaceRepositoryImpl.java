package repository.ConcertPlaceRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomConcertPlaceRepositoryImpl implements CustomConcertPlaceRepository {

    private final EntityManager entityManager;
}
