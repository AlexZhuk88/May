package repository.UserProRepo;

import model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserProRepository extends CrudRepository<User, Long>, CustomUserProRepository {

    Optional<User> findByEmail(String email);
}


