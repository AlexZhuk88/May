package dao;

import dao.commentprofile.commentConcert.CommentConcertDao;
import dao.commentprofile.commentConcert.CommentConcertDaoImpl;
import dao.commentprofile.commentNew.CommentNewDao;
import dao.commentprofile.commentNew.CommentNewDaoImpl;
import dao.concertprofile.ConcertDao;
import dao.concertprofile.ConcertDaoImpl;
import dao.groopprofile.GroopDao;
import dao.groopprofile.GroopDaoImpl;
import dao.newsprofile.NewsDao;
import dao.newsprofile.NewsDaoImpl;
import dao.userprofile.UserDao;
import dao.userprofile.UserDaoImpl;
import model.Concert;
import model.ConcertComment;
import model.Groop;
import model.NewsComment;
import model.TheNew;
import model.Timing;
import model.User;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentDaoTest {


//    @Test
//    public void checkGetById() {
//        ConcertDao concertDao = new ConcertDaoImpl();
//        Concert concertTest = concertDao.find(3L);
//        assertEquals(concertTest.getConcertName(), "First concert");
//    }
//
//    @Test
//    public void checkGetUsername() {
//        ConcertDaoImpl concertDao = new ConcertDaoImpl();
//        Concert concertTest = concertDao.getByConcertNname("First concert");
//        assertEquals(concertTest.getDiscription(), "My discription");
//    }

//    @Test
//    public void checkSave() {
//        NewsDao newsDao = new NewsDaoImpl();
//        TheNew newsTest = newsDao.find(3L);
//        UserDao userDao = new UserDaoImpl();
//        User userTest = userDao.find(1L);
//        CommentNewDao cnDao = new CommentNewDaoImpl();
//        NewsComment newsComment = new NewsComment(userTest, Timing.of(LocalDate.now(), LocalTime.now()), "Ехо-хо", newsTest);
//        Serializable id = cnDao.save(newsComment);
//        assertNotNull(id);
//        cnDao.delete(newsComment);
//
//        ConcertDao concertDao = new ConcertDaoImpl();
//        Concert concertTest = concertDao.find(3L);
//        User userTest2 = userDao.find(2L);
//        CommentConcertDao ccDao = new CommentConcertDaoImpl();
//        ConcertComment concertComment = new ConcertComment(userTest2, Timing.of(LocalDate.now(), LocalTime.now()), "Ехо-хо", concertTest);
//        Serializable id2 = ccDao.save(concertComment);
//        assertNotNull(id2);
//        ccDao.delete(concertComment);
//    }

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

//    @Test
//    public void checkFindAll() {
//        ConcertDao concertDao = new ConcertDaoImpl();
//        List<Concert> list = concertDao.findAll();
//        assertNotNull(list);
//    }
//
//    @Test
//    public void checkUpdate() {
//        ConcertDao concertDao = new ConcertDaoImpl();
//        Concert concertTest = concertDao.find(5L);
//        concertTest.setDiscription("My discription");
//        concertDao.update(concertTest);
//        assertEquals(concertTest.getDiscription(), "My discription");
//    }
}