package dao.commentprofile.commentNew;

import dao.baseprofile.BaseDaoImpl;
import lombok.Cleanup;
import model.NewsComment;
import org.hibernate.Session;

import static connection.ConnectionManager.getSession;

public class CommentNewDaoImpl extends BaseDaoImpl<Long, NewsComment> implements CommentNewDao {
    private static final CommentNewDao INSTANCE = new CommentNewDaoImpl();

    public NewsComment getByCommentNewId(String commentNewId) {
        @Cleanup Session session = getSession();
        return session.createQuery("select cn from Comment cn where cn.id = :commentNewId", NewsComment.class)
                .setParameter("commentNewId", commentNewId).getSingleResult();
    }

    public static CommentNewDao getInstance() {
        return INSTANCE;
    }
}
