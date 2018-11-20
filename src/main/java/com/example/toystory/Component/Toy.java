package com.example.toystory.Component;

public class Toy {
    private String name;
    private String producer;
    private String imgUrl;

    public Toy(String name, String producer, String imgUrl) {
        this.name = name;
        this.producer = producer;
        this.imgUrl = imgUrl;
    }

    public Toy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
