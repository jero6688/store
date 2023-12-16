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
  
    public List<Item> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<Item> items = itemMapper.findAll(offset, size);
        return items;
    }
    public int searchCount(){
        Integer count = itemMapper.searchCount();
        return count;
    }

    public boolean delete(int id){
        itemMapper.delete(id);
        return true;
    }

    public Item selectById(int id){
       return itemMapper.selectById(id);

    }

    public boolean add(Item item){
        itemMapper.insert(item);
        return true;
    }

    public boolean update(Item item){
        itemMapper.updateById(item);
        return true;
    }

    public List<Item> findByName(String name) {
        List<Item> items = itemMapper.findByName(name);
        return items;
    }

    public int deleteByIds(int[] ids){
        itemMapper.deleteByIds(ids);
        return 1;
    }
}