package com.example.demoSpringfood.service;

import com.example.demoSpringfood.dto.ItemDto;


import java.util.List;

public interface ItemService {
    void saveItem(ItemDto dto);
    void deleteItem(String id);
    void updateItem(ItemDto dto);
    ItemDto searchItem(String id);

    List<ItemDto> getAllItem();
}
