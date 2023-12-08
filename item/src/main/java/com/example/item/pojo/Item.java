package com.example.item.pojo;

import lombok.Data;

@Data
public class Item {
    int id;
    String name;
    String type;
    int price;
    int storage;
}
