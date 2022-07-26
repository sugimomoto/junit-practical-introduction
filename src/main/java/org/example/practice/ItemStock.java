package org.example.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStock {

    private List<Item> items = new ArrayList<>();
    private final Map<String,Integer> values = new HashMap<String,Integer>();

    public void add(Item item){
        Integer num = values.get(item.name);
        if(num == null){
            num = 0;
        }

        num++;
        values.put(item.name,num);
    }

    public int getNum(Item item){
        Integer num = values.get(item.name);
        return num != null ? num : 0;
    }
}
