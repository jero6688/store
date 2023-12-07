package com.example.item.service;

import com.example.item.mapper.ItemMapper;
import com.example.item.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {
    @Autowired
    ItemMapper itemMapper;
    public List<Item> findAll(){
        List<Item> items = itemMapper.findAll();
        return items;
    }
    public void delete(int id){
        itemMapper.delete(id);
    }

}