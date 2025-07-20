package com.hemza.rental_backend.dto;

import org.springframework.web.multipart.MultipartFile;

public class RentalRequestDTO {
    private String name;
    private Double surface;
    private Double price;
    private MultipartFile picture;
    private String description;

    public RentalRequestDTO() {}

    // Getters & setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSurface() { return surface; }
    public void setSurface(Double surface) { this.surface = surface; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public MultipartFile getPicture() { return picture; }
    public void setPicture(MultipartFile picture) { this.picture = picture; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

