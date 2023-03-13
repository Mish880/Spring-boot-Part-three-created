package com.example.demoSpringfood.service.impl;

import com.example.demoSpringfood.dto.ItemDto;
import com.example.demoSpringfood.entity.Item;
import com.example.demoSpringfood.repo.ItemRepo;

import com.example.demoSpringfood.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveItem(ItemDto dto) {
        if (!repo.existsById(dto.getItemid())) {
            repo.save(mapper.map(dto, Item.class));
        } else {
            throw new RuntimeException("Item is Already Exist...!");
        }

    }

    @Override
    public void deleteItem(String id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Item ID... No Such Item...!");
        }
    }

    @Override
    public void updateItem(ItemDto dto) {
        if (repo.existsById(dto.getItemid())) {
            repo.save(mapper.map(dto,Item.class));
        } else {
            throw new RuntimeException("No Such FoodMeal To Update..! Please Check the ID..!");
        }
    }

    @Override
    public ItemDto searchItem(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), ItemDto.class);
        } else {
            throw new RuntimeException("No AdminStaff For" + id + "..!");
        }
    }

    @Override
    public List<ItemDto> getAllItem() {
        return mapper.map(repo.findAll(),new TypeToken<List<ItemDto>>(){

        }.getType());
    }
}
