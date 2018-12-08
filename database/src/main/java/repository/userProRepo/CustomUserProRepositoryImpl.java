package repository.userProRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomUserProRepositoryImpl implements CustomUserProRepository {

    private final EntityManager entityManager;



}
