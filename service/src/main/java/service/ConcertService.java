package service;

import dto.ConcertFilterDto;
import lombok.RequiredArgsConstructor;
import model.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ConcertRepo.ConcertRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConcertService {

    private final ConcertRepository concertRepository;

    public ConcertFilterDto prepareConcertPage(Integer pagin, int numPage, String place, String city, String groop) {
        List<String> listPlace = concertRepository.findAllPlace();
        listPlace.add("Все места");
        List<String> listCities = concertRepository.findAllCity();
        listCities.add("Все города");
        List<String> listGroops = concertRepository.findAllGroop();
        listGroops.add("Все группы");
        List<Concert> listConcert = concertRepository.findByFilters(pagin, numPage, place, city, groop);
        Long count = concertRepository.findCountPage(pagin, numPage, place, city, groop);
        return ConcertFilterDto.builder().listPlace(listPlace)
                .listCity(listCities)
                .listGroop(listGroops)
                .countConcert(count)
                .listConcert(listConcert)
                .build();
    }
}
