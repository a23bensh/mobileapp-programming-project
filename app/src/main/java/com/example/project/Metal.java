package com.example.project;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class Metal {

    private String name;
    private String Category;
    private int Cost;

    public Metal ()
    {
        name="Saknar namn";
        Category="Saknar category";
        Cost=3;
    }

    public Metal (String n, String l, int h)
    {
        name=n;
        Category=l;
        Cost=h;
    }

    public String info(){
        String tmp= new String();
        tmp+=name+" är i "+Category+" och är "+Cost+"m hög";
        return tmp;
    }

    public void setName(String n)
    {
        name=n;
    }

    public String getName()
    {
        return name;
    }

    @Override
    @NonNull
    public String toString() {

        return name+" är i albumet: "+Category+" och kostar: "+Cost+"kr";

    }
}