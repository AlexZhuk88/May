package dao.newsprofile;

import dao.baseprofile.BaseDaoImpl;
import lombok.Cleanup;
import model.TheNew;
import org.hibernate.Session;

import static connection.ConnectionManager.getSession;


public class NewsDaoImpl extends BaseDaoImpl<Long, TheNew> implements NewsDao {
    private static final NewsDao INSTANCE = new NewsDaoImpl();

    public TheNew getByUsername(String newsname) {
        @Cleanup Session session = getSession();
        return session.createQuery("select n from TheNew n where n.newsname = :newsname", TheNew.class)
                .setParameter("newsname", newsname).getSingleResult();
    }

    public static NewsDao getInstance() {
        return INSTANCE;
    }
}
