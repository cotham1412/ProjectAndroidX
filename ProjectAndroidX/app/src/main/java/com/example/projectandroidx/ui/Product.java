package com.example.projectandroidx.ui;public class Product {

    private String productName;
    private String productPrice;
    private String productImage;
    private String productDescription;

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Product(String productName, String productPrice, String productImage, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
    }
}
