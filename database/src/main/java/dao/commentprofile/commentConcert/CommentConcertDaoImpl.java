package dao.commentprofile.commentConcert;

import dao.baseprofile.BaseDaoImpl;
import lombok.Cleanup;
import model.ConcertComment;
import org.hibernate.Session;

import static connection.ConnectionManager.getSession;

public class CommentConcertDaoImpl extends BaseDaoImpl<Long, ConcertComment> implements CommentConcertDao {
    private static final CommentConcertDao INSTANCE = new CommentConcertDaoImpl();

    public ConcertComment getByCommentConcertId(String commentConcertId) {
        @Cleanup Session session = getSession();
        return session.createQuery("select cc from Comment cc where cc.id = :commentConcertId", ConcertComment.class)
                .setParameter("commentConcertId", commentConcertId).getSingleResult();
    }

    public static CommentConcertDao getInstance() {
        return INSTANCE;
    }
}
