package com.example.firststepv01;

public class Ad {
    int id, image;
    String title, link, price ;

    public Ad(int id, String title, String link, int image, String price) {
        this.id = id;
        this.price = price;
        this.image = image;
        this.title = title;
        this.link = link;
    }

    public Ad(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
