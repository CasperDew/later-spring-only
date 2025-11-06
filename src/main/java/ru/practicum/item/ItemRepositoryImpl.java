package ru.practicum.item;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class ItemRepositoryImpl implements ItemRepository {
    private final Map<Long, Item> storage = new HashMap<>();
    private final AtomicLong idSeq = new AtomicLong(0);

    @Override
    public List<Item> findByUserId(long userId) {
        return storage.values().stream()
                .filter(i -> i.getUserId() != null && i.getUserId() == userId)
                .sorted(Comparator.comparing(Item::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Item save(Item item) {
        if (item.getId() == null) {
            long id = idSeq.incrementAndGet();
            item.setId(id);
        }
        storage.put(item.getId(), item);
        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        Item existing = storage.get(itemId);
        if (existing != null && existing.getUserId() != null && existing.getUserId() == userId) {
            storage.remove(itemId);
        }
    }
}
