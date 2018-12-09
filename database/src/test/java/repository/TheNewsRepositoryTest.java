package repository;

import config.TestConfiguration;
import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.commentRepo.ConcertCommentRepository;
import repository.concertRepo.ConcertRepository;
import repository.theNewsRepo.TheNewsRepository;
import repository.userProRepo.UserProRepository;
import util.DatabaseHelper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class TheNewsRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;
    @Autowired
    private UserProRepository userProRepository;
    @Autowired
    private ConcertCommentRepository concertCommentRepository;
    @Autowired
    private TheNewsRepository theNewsRepository;
    @Autowired
    private ConcertRepository concertRepository;

    @Before
    public void init() {
        databaseHelper.cleanDatabase();
        databaseHelper.prepareData();
    }


    @Test
    public void checkCount() {
        Optional<User> user = userProRepository.findByEmail("Alex@mail.ru");
        Optional<Concert> concert= concertRepository.findById(1L);
        ConcertComment concertComment = new ConcertComment(user.get(),Timing.of(LocalDate.now(), LocalTime.now()),"Сохранил коммент", concert.get());
        ConcertComment concertComment1 = concertCommentRepository.save(concertComment);
        System.out.println("");
    }


    @Test
    public void checkByFilters() {
        List<TheNew> listNews = theNewsRepository.findByFilters(5, 1, "2018-11-11", "2025-11-12", "Alex");
        System.out.println();
    }
}
