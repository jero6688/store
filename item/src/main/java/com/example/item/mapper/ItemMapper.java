package com.example.item.mapper;

import com.example.item.pojo.Item;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ItemMapper {

    @Select("SELECT * FROM item LIMIT #{offset}, #{limit}")
    List<Item> findAll(@Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(*) from item")
    Integer searchCount();

    @Delete("DELETE FROM item WHERE id=#{id}")
    void delete(int id);

    @Select("SELECT * FROM ITEM WHERE id =#{id}")
    Item selectById(int id);

    @Insert("INSERT INTO ITEM(id, name, type, price, storage) VALUES(#{id}, #{name}, #{type}, #{price}, #{storage})")
    void insert(Item item);

    @Update("UPDATE ITEM SET name=#{name}, type=#{type}, price=#{price}, storage=#{storage} WHERE id=#{id}")
    void updateById(Item item);

    void deleteByIds(@Param("ids") int[] ids);

    @Select("SELECT * FROM item WHERE name LIKE CONCAT(CONCAT('%', #{name}), '%')")
    List<Item> findByName(String name);

}