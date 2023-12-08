package com.example.item.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.item.pojo.Item;
import com.example.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("findAll")
    public List<Item> findAll() {
        List<Item> items = itemService.findAll();
        return items;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        itemService.delete(id);
        System.out.println("item delete");
    }

    @GetMapping("selectById/{id}")
    public Item selectById(@PathVariable("id") int id) {
        Item item = itemService.selectById(id);
        System.out.println("selectOne");
        return item;
    }

    @PostMapping("/deleteByIds")
    public int deleteByIds(@RequestBody int[] ids) {
        return itemService.deleteByIds(ids);
    }
}
