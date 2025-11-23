package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.user.dto.UserDto;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        log.info("Получен список пользователей");
        return userService.getAllUsers();
    }

    @PostMapping
    public User saveNewUser(@RequestBody UserDto user) {
        log.info("Добавлен новый пользователь");
        return userService.saveUser(user);
    }
}
