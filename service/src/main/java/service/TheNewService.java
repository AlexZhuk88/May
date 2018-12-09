package service;

import dto.ConcertFilterDto;
import dto.NewsFilterDto;
import lombok.RequiredArgsConstructor;
import model.Concert;
import model.ConcertPlace;
import model.TheNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.theNewsRepo.TheNewsRepository;
import util.DateFormater;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TheNewService {

    private final TheNewsRepository theNewsRepository;


//    public Optional<Concert> findById(Long id){
//        return concertRepository.findById(id);
//    }

    public NewsFilterDto prepareNewsPage(Integer pagin, int numPage, String starttime, String endtime, String author) {
        List<String> listAuthors = theNewsRepository.findAllAuthors();
        listAuthors.add(0,"Все авторы");
        List<TheNew> listNews = theNewsRepository.findByFilters(pagin, numPage, starttime, endtime, author);
        Long count = theNewsRepository.findCountPage(pagin, numPage, starttime, endtime, author);
        return NewsFilterDto.builder().listAuthors(listAuthors)
                .dataStart(starttime)
                .dataEnd(endtime)
                .countNews(count)
                .listNews(listNews)
                .build();
    }

    public List<String> findAllAuthors() {
        return theNewsRepository.findAllAuthors();
    }

//    public Concert saveConcert(Concert concert){
//        Concert concertSaved = concertRepository.save(concert);
//        return concertSaved;
//    }

//    public void saveConcertPlace(ConcertPlace concertPlace){
//        concertPlaceRepository.save(concertPlace);
//    }


}
