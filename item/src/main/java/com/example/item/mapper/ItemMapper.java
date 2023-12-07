package com.example.item.mapper;

import com.example.item.pojo.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Select("SELECT * FROM item")
    List<Item> findAll();
    @Delete("DELETE FROM item WHERE id=#{id}")
    void delete(int id);
}