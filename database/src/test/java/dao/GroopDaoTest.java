package dao;

import dao.groopprofile.GroopDao;
import dao.groopprofile.GroopDaoImpl;
import model.Groop;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GroopDaoTest {


    @Test
    public void checkGetById() {
        GroopDao groopDao = new GroopDaoImpl();
        Groop groopTest = groopDao.find(1L);
        assertEquals(groopTest.getGroopname(), "Сразу Май");
        assertEquals(groopTest.getDiscription(), "Брест");


    }

    @Test
    public void checkGetUsername() {
        GroopDaoImpl groopDao = new GroopDaoImpl();
        Groop groopTest = groopDao.getByGroopName("Сразу Май");
        assertEquals(groopTest.getDiscription(), "Брест");
    }

    @Test
    public void checkSave() {
        GroopDao groopDao = new GroopDaoImpl();
        Groop groopCorrect = Groop.builder().groopname("Test").discription("Minsk").build();
        Serializable id = groopDao.save(groopCorrect);
        assertNotNull(id);
        groopDao.delete(groopCorrect);
    }

    @Test
    public void checkDelete() {
        GroopDaoImpl groopDao = new GroopDaoImpl();
        Groop groopDelete = Groop.builder().groopname("Test").discription("Test discription").build();
        groopDao.save(groopDelete);
        Groop groopTest = groopDao.getByGroopName("Test");
        groopDao.delete(groopTest);
    }

    @Test
    public void checkFindAll() {
        GroopDao groopDao = new GroopDaoImpl();
        List<Groop> list = groopDao.findAll();
        assertNotNull(list);
    }

    @Test
    public void checkUpdate() {
        GroopDao groopDao = new GroopDaoImpl();
        Groop groopTest = groopDao.find(1L);
        groopTest.setDiscription("Брест");
        groopDao.update(groopTest);
        assertEquals(groopTest.getDiscription(), "Брест");
    }
}