package com.example.project;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class Metal {

    private String name;
    private String location;
    private int height;

    public Metal ()
    {
        name="Saknar namn";
        location="Saknar plats";
        height=-1;
    }

    public Metal (String n, String l, int h)
    {
        name=n;
        location=l;
        height=h;
    }

    public String info(){
        String tmp= new String();
        tmp+=name+" är i "+location+" och är "+height+"m hög";
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
        return name;
    }
}