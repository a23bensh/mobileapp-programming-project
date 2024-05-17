package com.example.project;

@SuppressWarnings("WeakerAccess")
public class RecyclerViewItem {

    private String title;
    private String title1;
    private int title2;

    public RecyclerViewItem(String title, String title1, int title2) {
        this.title = title;
        this.title1 = title1;
        this.title2 = title2;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle1() {
        return title1;
    }

    public int getTitle2() {
        return title2;
    }
}