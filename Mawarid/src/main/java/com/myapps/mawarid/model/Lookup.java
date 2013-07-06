package com.myapps.mawarid.model;

/**
 * Created by mhewedy on 7/6/13.
 */
public class Lookup {
    private int code;
    private String value;
    private String valueEnglish;

    public Lookup(int code, String value, String valueEnglish) {
        this.code = code;
        this.value = value;
        this.valueEnglish = valueEnglish;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getValueEnglish() {
        return valueEnglish;
    }

    @Override
    public String toString() {
        return value != null ? value.trim() : "";
    }
}
