package com.example.homework10;

import java.util.ArrayList;
import java.util.Iterator;

public class WebPages {
    private int id = 0;
    private String url = "";
    private ArrayList <String> UrlPages;
    static WebPages webPages;

    public WebPages(){
        UrlPages = new ArrayList<String>();

    }
    public static WebPages getSingleton(){
        if(webPages == null){
            webPages = new WebPages();
        }
        return webPages;
    }

    public int getIndex(){
        return this.id;
    }

    public void setIndexBack(int id){
        if (this.id <= id){
        }
        else {
            this.id -= id;

        }
    }
    public void setIndexFront(int id){
        if (this.id >= UrlPages.size()){

        }
        else {
            this.id += id;

        }
    }
    public void addWebPagesToList(String s){
        //Lista lähtee
        if(UrlPages.size() <= 10){
            UrlPages.add(s);
            this.id += 1;
            System.out.println(UrlPages.size());
        }
        else {
            //No room anymore
        }
    }

    public ArrayList<String> getUrlPages() {
        return UrlPages;
    }

    public void listMaker(){
        while (UrlPages.size()-1 >= this.id){
            UrlPages.remove(UrlPages.size()-1);
        }
    }
}

