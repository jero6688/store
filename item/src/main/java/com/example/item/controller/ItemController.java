package com.example.item.controller;

import com.example.item.controller.utils.R;
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
        return items;
    }

    @PostMapping("add")
    public R addItem(@RequestBody Item item){
        boolean flag=itemService.add(item);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        boolean flag=itemService.delete(id);
        System.out.println("调用了");
        return flag;
    }

    @GetMapping("selectById/{id}")
    public void selectById(@PathVariable("id") int id) {
        Item item = itemService.selectById(id);
        System.out.println("selectOne");
    }

    @PostMapping("/deleteByIds")
    public int deleteByIds(@RequestBody int[] ids) {
        return itemService.deleteByIds(ids);
    }
}
