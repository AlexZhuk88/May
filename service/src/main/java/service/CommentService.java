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


//    public Optional<Concert> findById(Long id){
//        return concertRepository.findById(id);
//    }

    public List<ConcertComment> findAllComments(Concert concert) {
        return concertCommentRepository.findByConcert(concert);
    }

    public void saveComment(ConcertComment comment){
        concertCommentRepository.save(comment);
    }

//    public List<String> findAllGroop() {
//        return concertRepository.findAllGroopy();
//    }

//    public Concert saveConcert(Concert concert){
//        Concert concertSaved = concertRepository.save(concert);
//        return concertSaved;
//    }
//
//    public void saveConcertPlace(ConcertPlace concertPlace){
//        concertPlaceRepository.save(concertPlace);
//    }


}
