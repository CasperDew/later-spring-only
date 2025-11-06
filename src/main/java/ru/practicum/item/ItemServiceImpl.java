package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;


    @Override
    public List<Item> getItems(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Item addNewItem(Long userId, Item item) {
        if (userId == null) {
            throw new IllegalArgumentException("User id is required");
        }
        if (item == null) {
            throw new IllegalArgumentException("Item is required");
        }
        if (!StringUtils.hasText(item.getUrl())) {
            throw new IllegalArgumentException("Item url is required");
        }

        item.setUserId(userId);
        item.setId(null);
        return repository.save(item);
    }

    @Override
    public void deleteItem(Long userId, Long itemId) {
        repository.deleteByUserIdAndItemId(userId, itemId);
    }
}
