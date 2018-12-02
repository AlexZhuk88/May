package service;

import lombok.RequiredArgsConstructor;
import model.ConcertPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ConcertPlaceRepo.ConcertPlaceRepository;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConcertPlaceService {

    private final ConcertPlaceRepository concertPlaceRepository;

    public void saveConcertPlace(ConcertPlace concertPlace){
        concertPlaceRepository.save(concertPlace);
    }

}
