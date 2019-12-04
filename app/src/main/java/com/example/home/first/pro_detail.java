package com.example.home.first;

public class pro_detail {

    String Description;
    String Id;
    String Image;
    String Name;
    int price;
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public pro_detail(String description, String id, String image, String name, int price) {
        Description = description;
        Id = id;
        Image = image;
        Name = name;
        price = price;
    }

    public String getName() {
        return Name;

    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        price = price;
    }


}
