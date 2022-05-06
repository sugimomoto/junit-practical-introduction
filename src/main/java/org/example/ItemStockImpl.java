package org.example;

import java.util.HashMap;

public class ItemStockImpl implements ItemStock {

    private HashMap<String,Integer> items;

    public ItemStockImpl(){
        items = new HashMap<>();
    }

    @Override
    public void add(String item, int num) {
        if(items.containsKey(item)){
            Integer currentNum = items.get(item);
            items.put(item,currentNum + num);
        }else{
            items.put(item,num);
        }
    }

    @Override
    public int size(String item) {
        if(items.containsKey(item)){
            return items.get(item);
        }

        return 0;
    }

    @Override
    public boolean contains(String name) {
        return items.containsKey(name);
    }
}
