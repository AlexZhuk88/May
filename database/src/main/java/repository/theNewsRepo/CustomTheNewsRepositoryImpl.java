package repository.theNewsRepo;

import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import model.Concert;
import model.QConcert;
import model.QTheNew;
import model.TheNew;
import org.springframework.beans.factory.annotation.Autowired;
import util.DateFormater;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomTheNewsRepositoryImpl implements CustomTheNewsRepository {

    private final EntityManager entityManager;

        @Override
    public List<TheNew> findByFilters(Integer pagin, int numPage, String starttime, String endtime, String author) {
        return new JPAQuery<TheNew>(entityManager)
                .select(QTheNew.theNew)
                .from(QTheNew.theNew)
                .where(author.equals("Все авторы") ? null : QTheNew.theNew.user.username.eq(author))
                .where(starttime.equals("Без ограничений") ? null : QTheNew.theNew.timing.date.after(DateFormater.formatDate(starttime)))
                .where(endtime.equals("Без ограничений") ? null : QTheNew.theNew.timing.date.before(DateFormater.formatDate(endtime)))
                .orderBy(QTheNew.theNew.id.asc())
                .limit(pagin)
                .offset(numPage * pagin - pagin)
                .fetch();
    }

    @Override
    public Long findCountPage(Integer pagin, int numPage, String starttime, String endtime, String author) {
        return new JPAQuery<TheNew>(entityManager)
                .select(QTheNew.theNew)
                .from(QTheNew.theNew)
                .where(author.equals("Все авторы") ? null : QTheNew.theNew.user.username.eq(author))
                .where(starttime.equals("Без ограничений") ? null : QTheNew.theNew.timing.date.after(DateFormater.formatDate(starttime)))
                .where(endtime.equals("Без ограничений") ? null : QTheNew.theNew.timing.date.before(DateFormater.formatDate(endtime)))
                .orderBy(QTheNew.theNew.id.asc())
                .limit(pagin)
                .offset(numPage * pagin - pagin)
                .fetchCount();
    }
}
