package com.atumra.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectForMessage implements Cloneable{
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    protected Object clone() {
        ObjectForMessage deepClone = new ObjectForMessage();
        deepClone.setData(new ArrayList<>(data));
        return deepClone;
    }
}
