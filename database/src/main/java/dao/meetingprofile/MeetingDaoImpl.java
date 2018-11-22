package dao.meetingprofile;

import dao.baseprofile.BaseDaoImpl;
import lombok.Cleanup;
import model.Meeting;
import org.hibernate.Session;

import static connection.ConnectionManager.getSession;

public class MeetingDaoImpl extends BaseDaoImpl<Long, Meeting> implements MeetingDao {
    private static final MeetingDao INSTANCE = new MeetingDaoImpl();

    public Meeting getByMeetingName(String meetingName) {
        @Cleanup Session session = getSession();
        return session.createQuery("select m from Meeting m where m.meetingName = :meetingName", Meeting.class)
                .setParameter("meetingName", meetingName).getSingleResult();
    }

    public static MeetingDao getInstance() {
        return INSTANCE;
    }
}
