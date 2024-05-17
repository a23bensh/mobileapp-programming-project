package com.example.project;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;

public class Metal {
    private String name;
    @SerializedName("category")
    private String Category;
    @SerializedName("cost")
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
  public Metal (String name) {this.name = name;}
    public void setName(String n)
    {
        name=n;
    }

    public String getName()
    {
        return name;
    }

    public String getCategory() {
        return Category;
    }

    public int getCost() {
        return Cost;
    }

    @Override
    @NonNull
    public String toString() {

        return name+" är i albumet: "+Category+" och kostar: "+Cost+"kr";

    }
}