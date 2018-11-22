package dao.userprofile;

import dao.baseprofile.BaseDaoImpl;
import lombok.Cleanup;
import model.User;
import org.hibernate.Session;

import static connection.ConnectionManager.getSession;

public class UserDaoImpl extends BaseDaoImpl<Long, User> implements UserDao {
    private static final UserDao INSTANCE = new UserDaoImpl();

    public User getByUsername(String username) {
        @Cleanup Session session = getSession();
        return session.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
