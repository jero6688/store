package com.example.item.controller;


import com.alibaba.fastjson.JSON;
import com.example.item.pojo.Item;
import com.example.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("findAll")
    public List<Item> findAll() {
        List<Item> items = itemService.findAll();
        System.out.println(items);
        return items;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        itemService.delete(id);
        System.out.println("item delete");
    }
}
