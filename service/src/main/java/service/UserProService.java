package service;

import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.userProRepo.UserProRepository;


@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserProService {

    private final UserProRepository userProRepository;


    public User saveUser(User user) {
        User userSaved = userProRepository.save(user);
        return userSaved;
    }
    @Transactional
    public User findById (String email){
        return userProRepository.findByEmail(email).get();
    }


}
