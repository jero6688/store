package com.example.item.controller;

import com.example.item.controller.utils.R;
import com.example.item.pojo.Item;
import com.example.item.service.ItemService;
import com.example.item.service.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("findAll")
    public PageResult<Item> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        List<Item> items = itemService.findAll(page, size);
        int count = itemService.searchCount();
        PageResult<Item> pageResult = new PageResult<>(items, count);
        return pageResult;
    }

    @PostMapping("add")
    public R addItem(@RequestBody Item item){
        boolean flag=itemService.add(item);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        boolean flag=itemService.delete(id);
        System.out.println("调用了delete");
        return flag;
    }

    @GetMapping("/selectById/{id}")
    public Item selectById(@PathVariable("id") Integer id) {
        Item item = itemService.selectById(id);
        return item;
    }

    @GetMapping("/selectByName/{name}")
    public List<Item> findByName(@PathVariable("name") String name) {
        List<Item> items = itemService.findByName(name);
        return items;
    }

    @PutMapping("updata")
    public boolean updata(@RequestBody Item item){
        System.out.println("use selectone");
        return itemService.update(item);
    }
    @PostMapping("/deleteByIds")
    public int deleteByIds(@RequestBody int[] ids) {
        return itemService.deleteByIds(ids);
    }
}
