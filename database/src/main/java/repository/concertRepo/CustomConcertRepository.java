package repository.concertRepo;

import model.Concert;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface CustomConcertRepository {

    List<Concert> findByFilters(Integer pagin, int numPage, String place, String city, String groopName);

    Long findCountPage(Integer pagin, int numPage, String place, String city, String groopName);

}
