package kr.com.djam.eatgo.application;

import kr.com.djam.eatgo.domain.User;
import kr.com.djam.eatgo.domain.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        
        return users;
    }

    public User addUser(String email, String name) {
        User user = User.builder()
                .name(name)
                .email(email)
                .level(1L)
                .build();
        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
       User user = userRepository.findById(id).orElse(null);

       user.setEmail(email);
       user.setName(name);
       user.setLevel(level);

       return user;
    }

    public User deactiveUser(long id) {
        //TODO : 실제로 일어날 일
        User user = userRepository.findById(id).orElse(null);

        user.deactivate();

        return user;
    }
}
