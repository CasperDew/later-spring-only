package ru.practicum.user;


import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.item.Item;
import ru.practicum.item.QItem;
import ru.practicum.item.dto.ItemDto;
import ru.practicum.item.dto.ItemMapper;
import ru.practicum.user.dto.UserDto;
import ru.practicum.user.dto.UserMapper;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<UserDto> getAllUsers() {
        List<User> users = repository.findAll();
        return UserMapper.mapToUserDto(users);
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = repository.save(UserMapper.mapToNewUser(userDto));
        return repository.save(user);
    }
}
