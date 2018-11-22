package dao;

import dao.concertprofile.ConcertDao;
import dao.concertprofile.ConcertDaoImpl;
import dao.groopprofile.GroopDao;
import dao.groopprofile.GroopDaoImpl;
import model.Concert;
import model.Groop;
import model.Timing;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConcertDaoTest {


    @Test
    public void checkGetById() {
        ConcertDao concertDao = new ConcertDaoImpl();
        Concert concertTest = concertDao.find(1L);
        assertEquals(concertTest.getConcertName(), "Концерт№1");
    }

    @Test
    public void checkAllPlaces() {
        ConcertDao concertDao = new ConcertDaoImpl();
        List<String> listAllPlaces = ((ConcertDaoImpl) concertDao).getAllPlaces();
        assertNotNull(listAllPlaces);
    }

    @Test
    public void checkAllGroops() {
        ConcertDao concertDao = new ConcertDaoImpl();
        List<Groop> listAllGroops = ((ConcertDaoImpl) concertDao).getAllGroops();
        assertNotNull(listAllGroops);
    }

    @Test
    public void checkGetUsername() {
        ConcertDaoImpl concertDao = new ConcertDaoImpl();
        Concert concertTest = concertDao.getByConcertNname("Концерт№1");
        assertEquals(concertTest.getDiscription(), "Будет руто!");
    }

    @Test
    public void checkFindByFilters() {
        ConcertDaoImpl concertDao = new ConcertDaoImpl();
        List<Concert> listConcert = concertDao.findByFilters(20, 2, "Все места", "Все города", "Все группы");
        assertNotNull(listConcert);
    }

    @Test
    public void checkCountPage(){
        ConcertDaoImpl concertDao = new ConcertDaoImpl();
        Long countConcert = concertDao.findCountPage(2, 2, "Все места", "Все города", "Все группы");
        assertNotNull(countConcert);
    }

    @Test
    public void checkSave() {
        GroopDao groopDao = new GroopDaoImpl();
        Groop groopTest = groopDao.find(1L);
        ConcertDao concertDao = new ConcertDaoImpl();
        Concert concertCorrect = Concert.builder().concertName("Third concert").timing(Timing.of(LocalDate.now(), LocalTime.now())).groop(groopTest).build();
        Serializable id = concertDao.save(concertCorrect);
        assertNotNull(id);
        concertDao.delete(concertCorrect);
    }

    @Test
    public void checkDelete() {
//        GroopDao groopDao = new GroopDaoImpl();
//        Groop groopTest = groopDao.find(1L);
//        ConcertDaoImpl concertDao = new ConcertDaoImpl();
//        Concert concertDelete = Concert.builder().concertName("DeletedConcert").groop(groopTest).build();
//        concertDao.save(concertDelete);
//        Concert concertTest = concertDao.getByConcertNname("TestForDelete");
//        concertDao.delete(concertTest);
    }

    @Test
    public void checkFindAll() {
        ConcertDao concertDao = new ConcertDaoImpl();
        List<Concert> list = concertDao.findAll();
        assertNotNull(list);
    }

    @Test
    public void checkUpdate() {
        ConcertDao concertDao = new ConcertDaoImpl();
        Concert concertTest = concertDao.find(5L);
        concertTest.setDiscription("My discription");
        concertDao.update(concertTest);
        assertEquals(concertTest.getDiscription(), "My discription");
    }
}