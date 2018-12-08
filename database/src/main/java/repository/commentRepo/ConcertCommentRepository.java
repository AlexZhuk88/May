package repository.commentRepo;

import model.Concert;
import model.ConcertComment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConcertCommentRepository extends CrudRepository<ConcertComment, Long>, CustomConcertCommentRepository {

    List<ConcertComment> findByConcert(Concert concert);


}


