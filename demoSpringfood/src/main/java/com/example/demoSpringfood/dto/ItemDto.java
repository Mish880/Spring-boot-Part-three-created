package com.example.demoSpringfood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemDto {
    private String itemid;
    private String itemname;
    private int    itemqty;
    private int    itemsalary;
}
