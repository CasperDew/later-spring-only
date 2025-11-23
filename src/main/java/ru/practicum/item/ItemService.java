package ru.practicum.item;

import ru.practicum.item.dto.ItemDto;

import java.util.List;
import java.util.Set;

public interface ItemService {
    List<ItemDto> getItems(Long userId);

    List<ItemDto> getItems(Long userId, Set<String> tags);

    ItemDto addNewItem(Long userId, ItemDto itemDto);

    void deleteItem(Long userId, Long itemId);
}
