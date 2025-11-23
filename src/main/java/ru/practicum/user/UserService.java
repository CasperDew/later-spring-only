package ru.practicum.user;

import ru.practicum.item.dto.ItemDto;
import ru.practicum.user.dto.UserDto;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<UserDto> getAllUsers();
    User saveUser(UserDto userDto);
}
