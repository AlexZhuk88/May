package dao;

import dao.userprofile.UserDao;
import dao.userprofile.UserDaoImpl;
import model.User;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserDaoTest {


    @Test
    public void checkGetById() {
        UserDao userDao = new UserDaoImpl();
        User userTest = userDao.find(9L);
        assertEquals(userTest.getUsername(), "Alex");
        assertEquals(userTest.getEmail(), "Alex@mail.ru");
        assertEquals(userTest.getPassword(), "111");
    }

    @Test
    public void checkGetUsername() {
        UserDaoImpl userDao = new UserDaoImpl();
        User userTest = userDao.getByUsername("Alex");
        assertEquals(userTest.getEmail(), "Alex@mail.ru");
        assertEquals(userTest.getPassword(), "111");
    }

    @Test
    public void checkSave() {
        UserDao userDao = new UserDaoImpl();
        User userCorrect = User.builder().username("Test49").email("Test@mail.ru").password("111").build();
        Serializable id = userDao.save(userCorrect);
        assertNotNull(id);
        userDao.delete(userCorrect);
    }

    @Test
    public void checkDelete() {
        UserDaoImpl userDao = new UserDaoImpl();
        User userDelete = User.builder().username("TestForDelete").email("Test@mail.ru").password("111").build();
        userDao.save(userDelete);
        User userTest = userDao.getByUsername("TestForDelete");
        userDao.delete(userTest);
    }

    @Test
    public void checkFindAll() {
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.findAll();
        assertNotNull(list);
    }

    @Test
    public void checkUpdate() {
        UserDao userDao = new UserDaoImpl();
        User userTest = userDao.find(9L);
        userTest.setPassword("111");
        userDao.update(userTest);
        assertEquals(userTest.getPassword(), "111");
    }
}