package com.moller.Models;

public class ComboItem {
    private String value;
    private String alias;

    public ComboItem(String itemValue, String itemAlias) {
        value = itemValue;
        alias = itemAlias;
    }

    public String GetValue() {
        return value;
    }

    public String GetAlias() {
        return alias;
    }
}
