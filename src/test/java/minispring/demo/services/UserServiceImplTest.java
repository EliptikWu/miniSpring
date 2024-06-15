package minispring.demo.services;

import domain.User;
import mapping.dtos.UserDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import repository.UserRepository;
import service.impl.UserServiceImpl;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;

    @InjectMocks
    private UserRepository repository;

    @Test
    void addUser() {
        User expected = User.builder()
                .idUser(1L)
                .name("Li")
                .email("li@gmail.com")
                .telephone("123")
                .build();
        Mockito.when(repository.saveUser(any())).thenReturn(expected);

        UserDto result = userService.addUser(UserDto.builder()
                .userName("Li")
                .email("li@gmail.com")
                .telephone("123")
                .build());
        assertEquals(expected.getName(), result.userName());
    }

    @Test
    void removeUser() {
        Long userId = 1L;
        userService.removeUser(userId);
        verify(repository, (1))
    }

}
