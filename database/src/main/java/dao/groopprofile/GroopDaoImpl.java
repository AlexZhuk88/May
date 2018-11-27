package dao.groopprofile;

import dao.baseprofile.BaseDaoImpl;
import lombok.Cleanup;

import model.Groop;
import org.hibernate.Session;

import static connection.ConnectionManager.getSession;

public class GroopDaoImpl extends BaseDaoImpl<Long, Groop> implements GroopDao {
    private static final GroopDao INSTANCE = new GroopDaoImpl();

    public Groop getByGroopName(String groopname) {
        @Cleanup Session session = getSession();
        return session.createQuery("select g from Groop g where g.groopname = :groopname", Groop.class)
                .setParameter("groopname", groopname).getSingleResult();
    }

    public static GroopDao getInstance() {
        return INSTANCE;
    }
}
