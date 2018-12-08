package repository.theNewsRepo;


import model.TheNew;

import java.util.List;

public interface CustomTheNewsRepository {

    List<TheNew> findByFilters(Integer pagin, int numPage, String starttime, String endtime, String author);

    Long findCountPage(Integer pagin, int numPage, String place, String city, String groopName);
}



