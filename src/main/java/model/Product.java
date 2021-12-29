package model;

public class Product {
    private int id;
    private String name;
    private int idCategory;
    private double price;
    private String description;
    private String producer;
    private String image;


    public Product() {
    }

    public Product(int id, String name, double price, String description, String producer, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
        this.image = image;
    }

    public Product(int id, String name, int idCategory, double price, String description, String producer, String image) {
        this.id = id;
        this.name = name;
        this.idCategory = idCategory;
        this.price = price;
        this.description = description;
        this.producer = producer;
        this.image = image;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
