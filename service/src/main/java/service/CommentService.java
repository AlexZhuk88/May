package service;

import lombok.RequiredArgsConstructor;
import model.Concert;
import model.ConcertComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.commentRepo.ConcertCommentRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommentService {

    private final ConcertCommentRepository concertCommentRepository;

    @Transactional
    public List<ConcertComment> findAllComments(Concert concert) {
        return concertCommentRepository.findByConcertOrderByTimingAsc(concert);
    }
    @Transactional
    public void saveComment(ConcertComment comment){
        concertCommentRepository.save(comment);
    }

    @Transactional
    public void deleteCommentByConcertId(Long id){
        concertCommentRepository.deleteAllByConcertId(id);
    }

    @Transactional
    public Long findCountComentByConcert(Long id){
        return concertCommentRepository.findCountCommentByConcert(id);
    }

    public void deleteComment(Long id){
        concertCommentRepository.deleteById(id);
    }
}
