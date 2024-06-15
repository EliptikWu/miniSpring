package minispring.demo.services;

import domain.User;
import mapping.dtos.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.UserRepository;
import service.impl.UserServiceImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServiceImpl service;

    private User user;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .idUser(1L)
                .name("Li")
                .telephone("123")
                .email("li@gmail.com")
                .username("li")
                .password("password")
                .build();

        userDto = UserDto.builder()
                .idUser(1L)
                .name("Li")
                .telephone("123")
                .email("li@gmail.com")
                .username("li")
                .password("password")
                .build();
    }
    @Test
    void testList() throws SQLException {
        when(repository.findAll()).thenReturn(List.of(user));

        List<UserDto> users = service.getUsers();

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("Li", users.get(0).name());
    }

    @Test
    void testSearchById() throws SQLException {
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        Optional<UserDto> result = service.getUserById(1L);

        assertNotNull(result);
        assertEquals("Li", result.get().name());
    }

    @Test
    void testSave() throws SQLException {
        service.addUser(userDto);

        verify(repository, times(1)).save(any(User.class));
    }

    @Test
    void testRemove() throws SQLException {
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        service.removeUser(1L);

        verify(repository, times(1)).delete(any(User.class));
    }

    @Test
    void testSearchByUser() throws SQLException {
        when(repository.findByUser("li@gmail.com")).thenReturn(user);

        Optional<UserDto> result = service.searchByUser("li@gmail.com");

        assertTrue(result.isPresent());
        assertEquals("Li", result.get().name());
    }
}
