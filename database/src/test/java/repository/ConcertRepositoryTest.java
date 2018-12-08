package repository;

import config.TestConfiguration;
import model.Concert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.concertRepo.ConcertRepository;
import repository.userProRepo.UserProRepository;
import util.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class ConcertRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private UserProRepository userProRepository;

    @Autowired
    private ConcertRepository concertRepository;

    @Before
    public void init() {
        databaseHelper.cleanDatabase();
        databaseHelper.prepareData();
    }

    @Test
    public void checkFindByName() {
        Concert concert = concertRepository.findByConcertName("Концерт№101");
        Assert.assertNotNull(concert);
    }

    @Test
    public void checkCount() {
        Long count = concertRepository.findCountPage(2, 2, "Все места", "Все города", "Все группы");
        System.out.println(count);
    }

    @Test
    public void checkFindAll() {
        List list = new ArrayList() {
        };
        concertRepository.findAll().forEach(list::add);
        assertEquals(list.size(), 5);
    }

    @Test
    public void checkByFilters() {
        List<Concert> concertListDto = concertRepository.findByFilters(2, 1, "Все места", "Все города", "Все группы");
        System.out.println();
    }

    @Test
    public void checkGetUserByEmail() {

        System.out.println(userProRepository.findByEmail("Alex@mail.ru"));
        System.out.println();
    }

    @Test
    public void checkFindAllCity() {
        List<String> listAllCity = concertRepository.findAllCity();
        System.out.println();
    }

    @Test
    public void checkFindAllPlace() {
        List<String> listAllPlace = concertRepository.findAllPlace();
        System.out.println();
    }

    @Test
    public void checkFindAllGroop() {
        List<String> listAllGroop = concertRepository.findAllGroop();
        System.out.println(listAllGroop);
    }

    @Test
    public void checkFindAllGroopy() {
        List<String> listGroop = concertRepository.findAllGroopy();
        System.out.println();
    }


//
//    @Test
//    public void checkFindByName() {
//        Movie interstellar = movieRepository.findByName("Interstellar");
//        System.out.println(interstellar);
//        Assert.assertNotNull(interstellar);
//    }
//
//    @Test
//    public void checkFindByNameAndDirectorFirstName() {
//        Movie movie = movieRepository.findByNameAndDirectorFirstName("Memento", "Christopher");
//        System.out.println();
//    }
//
//    @Test
//    public void checkFindAllByReleaseYear() {
//        List<Movie> result = movieRepository.findAllByReleaseYearBetweenOrderByName(2012, 2015, PageRequest.of(0, 1));
//        System.out.println();
//    }
//
//    @Test
//    public void checkCustomMethod() {
//        Optional<Movie> movie = movieRepository.customMethod("Memento", "Christopher");
//        assertTrue(movie.isPresent());
//    }
//
//    @Test
//    public void checkNativeQuery() {
//        Optional<Movie> movie = movieRepository.customMethodNative("Memento", "Christopher");
//        System.out.println();
//    }
//
//    @Test
//    public void checkNativeQuery2() {
//        Optional<MovieSecondDto> movie = movieRepository.customMethodNative3("Memento", "Christopher");
//        movie.ifPresent(it -> System.out.println("Movie: " + it.getName() + ", " + it.getDirectorId()));
//    }
//
//    @Test
//    public void checkCriteriaApi() {
//        List<Movie> memento = movieRepository.findByCriteriaApi("Memento");
//        System.out.println();
//    }
}
