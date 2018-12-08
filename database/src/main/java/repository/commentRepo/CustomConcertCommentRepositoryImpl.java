package repository.commentRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomConcertCommentRepositoryImpl implements CustomConcertCommentRepository {

    private final EntityManager entityManager;

}
