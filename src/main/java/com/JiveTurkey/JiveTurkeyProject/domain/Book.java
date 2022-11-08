package com.JiveTurkey.JiveTurkeyProject.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String image;

    private double price;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "category_ID",nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    private int Stock;

    private String sku;


    public Book(){}

    public Long getBookId() {
        return id;
    }

    public void setBookId(Long bookId) {
        this.id = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public int getQuantInStock() {
        return Stock;
    }

    public void setQuantInStock(int quantInStock) {
        Stock = Stock;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", Stock=" + Stock +
                ", sku='" + sku + '\'' +
                '}';
    }
}
