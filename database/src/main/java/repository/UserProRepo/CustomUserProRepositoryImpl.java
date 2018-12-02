package repository.UserProRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomUserProRepositoryImpl implements CustomUserProRepository {

    private final EntityManager entityManager;



}
