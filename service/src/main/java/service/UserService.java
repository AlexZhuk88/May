package service;

import dao.userprofile.UserDaoImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public User getUserById(Long id) {
        return UserDaoImpl.getInstance().find(id);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
