package kr.com.djam.eatgo.application;

import kr.com.djam.eatgo.domain.User;
import kr.com.djam.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String email, String name, String password){
        System.out.println("service");
        User user = User.builder()
                .id(1004L)
                .email(email)
                .name(name)
                .password(password)
                .build();

        System.out.println(user.getId() + " : " + user.getEmail());
        return userRepository.save(user);
    }
}
