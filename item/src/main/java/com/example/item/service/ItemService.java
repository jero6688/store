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

    public int update(Item item){
        itemMapper.updateById(item);
        return 1;
    }

    public int deleteByIds(int[] ids){
        itemMapper.deleteByIds(ids);
        return 1;
    }
}