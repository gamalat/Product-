package com.example.home.first;

public class product {
    String Description;
    String Id;
    String Image;
    String Name;

    public String getDescription() {
        return Description;
    }

    public String getId() {
        return Id;
    }

    public String getImage() {
        return Image;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public product(String description, String id, String image, String name) {
        Description = description;
        Id = id;
        Image = image;
        Name = name;

    }


}
