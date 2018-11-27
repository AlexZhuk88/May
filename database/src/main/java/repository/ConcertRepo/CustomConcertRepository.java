package repository.ConcertRepo;

import model.Concert;

import java.util.List;

public interface CustomConcertRepository {

    List<Concert> findByFilters(Integer pagin, int numPage, String place, String city, String groopName);

    Long findCountPage(Integer pagin, int numPage, String place, String city, String groopName);
}
