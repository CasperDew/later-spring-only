package ru.practicum.user.dto;

import lombok.*;
import ru.practicum.user.UserState;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String registrationDate;
    private UserState state;
}
