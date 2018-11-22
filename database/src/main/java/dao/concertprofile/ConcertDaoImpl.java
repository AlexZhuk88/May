package dao.concertprofile;

import com.querydsl.jpa.impl.JPAQuery;
import dao.baseprofile.BaseDaoImpl;
import lombok.Cleanup;
import model.Concert;
import model.Groop;
import model.QConcert;
import org.hibernate.Session;

import java.util.List;

import static connection.ConnectionManager.getSession;

public class ConcertDaoImpl extends BaseDaoImpl<Long, Concert> implements ConcertDao {
    private static final ConcertDao INSTANCE = new ConcertDaoImpl();

    public Concert getByConcertNname(String concertName) {
        @Cleanup Session session = getSession();
        return session.createQuery("select c from Concert c where c.concertName = :concertName", Concert.class)
                .setParameter("concertName", concertName).getSingleResult();
    }

    public List<String> getAllPlaces() {
        @Cleanup Session session = getSession();
        return session.createQuery("select distinct cp.place from ConcertPlace cp ", String.class).list();
    }

    public List<Groop> getAllGroops() {
        @Cleanup Session session = getSession();
        return session.createQuery("select distinct c.groop from Concert c", Groop.class).list();
    }

    public List<String> getAllCities() {
        @Cleanup Session session = getSession();
        return session.createQuery("select distinct cp.city from ConcertPlace cp", String.class).list();
    }

    public List<Concert> findByFilters(Integer pagin, int numPage, String place, String city, String groopName) {
        @Cleanup Session session = getSession();
        return new JPAQuery<Concert>(session)
                .select(QConcert.concert)
                .from(QConcert.concert)
                .where(place.equals("Все места") ? null : QConcert.concert.concertPlace.place.eq(place))
                .where(city.equals("Все города") ? null : QConcert.concert.concertPlace.city.eq(city))
                .where(groopName.equals("Все группы") ? null : QConcert.concert.groop.groopname.eq(groopName))
                .orderBy(QConcert.concert.id.asc())
                .limit(pagin)
                .offset(numPage * pagin - pagin)
                .fetch();
    }

    public Long findCountPage(Integer pagin, Integer numPage, String place, String city, String groopName) {
        @Cleanup Session session = getSession();
        return new JPAQuery<Concert>(session)
                .select(QConcert.concert)
                .from(QConcert.concert)
                .where(place.equals("Все места") ? null : QConcert.concert.concertPlace.place.eq(place))
                .where(city.equals("Все города") ? null : QConcert.concert.concertPlace.city.eq(city))
                .where(groopName.equals("Все группы") ? null : QConcert.concert.groop.groopname.eq(groopName))
                .orderBy(QConcert.concert.id.asc())
                .limit(pagin)
                .offset(numPage * pagin - pagin)
                .fetchCount();
    }

    public static ConcertDao getInstance() {
        return INSTANCE;
    }
}
