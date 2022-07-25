package org.example.practice;

import java.util.ArrayList;
import java.util.List;

public class ItemStock {

    private List<Item> items = new ArrayList<>();

    public void add(Item item){
        items.add(item);
    }

    public int getNum(Item item){

        int count = 0;

        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).name == item.name){
                count++;
            }
        }

        return count;
    }
}
