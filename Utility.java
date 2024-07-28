package org.example;

import java.util.ArrayList;
import java.util.List;

public class Utility<T> {
    private List<T> items;

    public Utility() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}
