package repository.GroopRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomGroopRepositoryImpl implements CustomGroopRepository {

    private final EntityManager entityManager;

}
