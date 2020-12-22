package kr.com.djam.eatgo.application;

import kr.com.djam.eatgo.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UserServiceTests {

    private UserService userSevice;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userSevice = new UserService(userRepository);
    }
    @Test
    public void registerUser(){
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        userSevice.registerUser(email, name, password);

        verify(userRepository).save(any());
    }

}