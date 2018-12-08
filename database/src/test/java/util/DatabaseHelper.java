package util;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DatabaseHelper {

    @Autowired
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public DatabaseHelper(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void cleanDatabase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Comment ").executeUpdate();
        entityManager.createQuery("delete from Meeting ").executeUpdate();
        entityManager.createQuery("delete from TheNew ").executeUpdate();
        entityManager.createQuery("delete from User ").executeUpdate();
        entityManager.createQuery("delete from ConcertPlace ").executeUpdate();
        entityManager.createQuery("delete from Concert").executeUpdate();
        entityManager.createQuery("delete from Groop").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void prepareData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Groop srazyMay = Groop.builder().groopname("Сразу Май Test").discription("Брест").build();
        Groop bi2 = Groop.builder().groopname("Би2 Test").discription("Минск").build();
        Groop aria = Groop.builder().groopname("Ария Test").discription("Брест").build();
        Groop timeMachine = Groop.builder().groopname("Машина времени Test").discription("Гродно").build();
        Groop lube = Groop.builder().groopname("Любэ Test").discription("Гомель").build();

        entityManager.persist(srazyMay);
        entityManager.persist(bi2);
        entityManager.persist(aria);
        entityManager.persist(timeMachine);
        entityManager.persist(lube);

        User alex = User.builder().username("Alex").email("Alex@mail.ru").password("111").role(Role.ADMIN).build();

        entityManager.persist(alex);

        Concert concertFirst = Concert.builder().concertName("Концерт№101").groop(srazyMay).discription("Будет круто!").timing(Timing.of(LocalDate.now(), LocalTime.now())).build();
        Concert concertSecond = Concert.builder().concertName("Концерт№102").groop(bi2).discription("Будет круто!").timing(Timing.of(LocalDate.now(), LocalTime.now())).build();
        Concert concertThird = Concert.builder().concertName("Концерт№103").groop(aria).discription("Будет круто!").timing(Timing.of(LocalDate.now(), LocalTime.now())).build();
        Concert concertForst = Concert.builder().concertName("Концерт№104").groop(timeMachine).discription("Будет круто!").timing(Timing.of(LocalDate.now(), LocalTime.now())).build();
        Concert concertFives = Concert.builder().concertName("Концерт№105").groop(lube).discription("Будет круто!").timing(Timing.of(LocalDate.now(), LocalTime.now())).build();

        entityManager.persist(concertFirst);
        entityManager.persist(concertSecond);
        entityManager.persist(concertThird);
        entityManager.persist(concertForst);
        entityManager.persist(concertFives);

        entityManager.persist(ConcertPlace.builder().concert(concertFirst).city("Minsk").place("Ресторан").entrance("9 BYN").build());
        entityManager.persist(ConcertPlace.builder().concert(concertSecond).city("Брест").place("Паб").entrance("5 BYN").build());
        entityManager.persist(ConcertPlace.builder().concert(concertThird).city("Гродно").place("Ресторан").entrance("Free").build());
        entityManager.persist(ConcertPlace.builder().concert(concertForst).city("Брест").place("Ресторан").entrance("5 BYN").build());
        entityManager.persist(ConcertPlace.builder().concert(concertFives).city("Гродно").place("Паб").entrance("6 BYN").build());

        TheNew theNew1 = TheNew.builder()
                .newsname("Новость Тест1")
                .discription("Будет круто")
                .timing(Timing.of(LocalDate.of(2018, 11, 11), LocalTime.of(13, 12, 16)))
                .user(alex)
                .build();

        TheNew theNew2 = TheNew.builder()
                .newsname("Новость Тест2")
                .discription("Будет круто")
                .timing(Timing.of(LocalDate.of(2017, 11, 11), LocalTime.of(13, 12, 16)))
                .user(alex)
                .build();

        TheNew theNew3 = TheNew.builder()
                .newsname("Новость Тест3")
                .discription("Будет круто")
                .timing(Timing.of(LocalDate.of(2019, 11, 11), LocalTime.of(13, 12, 16)))
                .user(alex)
                .build();

        TheNew theNew4 = TheNew.builder()
                .newsname("Новость Тест4")
                .discription("Будет круто")
                .timing(Timing.of(LocalDate.of(2020, 11, 11), LocalTime.of(13, 12, 16)))
                .user(alex)
                .build();

        TheNew theNew5 = TheNew.builder()
                .newsname("Новость Тест5")
                .discription("Будет круто")
                .timing(Timing.of(LocalDate.of(2025, 11, 11), LocalTime.of(13, 12, 16)))
                .user(alex)
                .build();

        entityManager.persist(theNew1);
        entityManager.persist(theNew2);
        entityManager.persist(theNew3);
        entityManager.persist(theNew4);
        entityManager.persist(theNew5);

        ConcertComment concertComment1 = new ConcertComment(alex,Timing.of(LocalDate.of(2017, 11, 11), LocalTime.of(13, 12, 16)),"Коммент",concertFirst);
        NewsComment newstComment1 = new NewsComment(alex,Timing.of(LocalDate.of(2017, 11, 11), LocalTime.of(13, 12, 16)),"Коммент", theNew1);
        entityManager.persist(concertComment1);
        entityManager.persist(newstComment1);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
