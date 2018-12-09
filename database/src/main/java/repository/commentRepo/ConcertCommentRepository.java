package repository.commentRepo;

import model.Concert;
import model.ConcertComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConcertCommentRepository extends CrudRepository<ConcertComment, Long>, CustomConcertCommentRepository {

    List<ConcertComment> findByConcert(Concert concert);

    void deleteAllByConcertId(Long id);

}


