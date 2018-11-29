package repository.ConcertRepo;

import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import model.Concert;
import model.QConcert;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomConcertRepositoryImpl implements CustomConcertRepository {

    private final EntityManager entityManager;

    @Override
    public List<Concert> findByFilters(Integer pagin, int numPage, String place, String city, String groopName) {
        return new JPAQuery<Concert>(entityManager)
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

    @Override
    public Long findCountPage(Integer pagin, int numPage, String place, String city, String groopName) {
        return new JPAQuery<Concert>(entityManager)
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
}
