package repository.commentRepo;

import model.Concert;
import model.ConcertComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConcertCommentRepository extends CrudRepository<ConcertComment, Long>, CustomConcertCommentRepository {

    List<ConcertComment> findByConcertOrderByTimingAsc(Concert concert);

    void deleteAllByConcertId(Long id);

    @Query(value = "select count(*) from smay_db.comment where smay_db.comment.concert_id=:id;", nativeQuery = true)
    Long findCountCommentByConcert(@Param("id") Long id);

}


