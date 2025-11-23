package ru.practicum.item.dto;

import lombok.*;
import ru.practicum.user.User;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private Long userId;
    private String url;
    private Set<String> tags;
}
