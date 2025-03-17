package com.example.model;

public class Gadgets {
    private int id;
    private String model;
    private String imageUrl;
    private String type;
    private String description;
    private String Brand;

    public Gadgets(int id, String model, String imageUrl, String type, String description, String Brand )
    {
        this.id = id;
        this.model = model;
        this.imageUrl = imageUrl;
        this.type = type;
        this.description = description;
        this.Brand = Brand;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getModel()
    {
        return model;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getType()
    {
        return type;
    }

    public String getDescription()
    {
        return description;
    }

    public String getBrand()
    {
        return Brand;
    }
}
