package com.example.test.Models;

import java.util.ArrayList;

public class Products {

    public static ArrayList<Products> products = new ArrayList<>();
    private int product_ID;
    private String product_Name;
    private double product_Price;
    private String product_Des;
    private ArrayList<String> product_Image;
    private Categories categories;

    public Products(int product_ID,
                    String product_Name,
                    double product_Price,
                    String product_Des,
                    ArrayList<String> product_Image,
                    int category_ID)
    {

        Categories categories = Categories.GetCategoryById(category_ID);
        if(categories == null){
            return;
        }
        this.product_ID = product_ID;
        this.product_Name = product_Name;
        this.product_Price = product_Price;
        this.product_Des = product_Des;
        this.product_Image = product_Image;
        this.categories = categories;
    }




    public static ArrayList<Products> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Products> products) {
        Products.products = products;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public double getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(double product_Price) {
        this.product_Price = product_Price;
    }

    public String getProduct_Des() {
        return product_Des;
    }

    public void setProduct_Des(String product_Des) {
        this.product_Des = product_Des;
    }

    public ArrayList<String> getProduct_Image() {
        return product_Image;
    }

    public void setProduct_Image(ArrayList<String> product_Image) {
        this.product_Image = product_Image;
    }


    @Override
    public String toString() {
        return "Products{" +
                "product_ID=" + product_ID +
                ", product_Name='" + product_Name + '\'' +
                ", product_Price=" + product_Price +
                ", product_Des='" + product_Des + '\'' +
                ", product_Image=" + product_Image +
                ", categories=" + categories +
                '}';
    }


    // xóa một sản phẩm
    public static void DeleteProduct(int product_ID){ }

//   thêm một sản phẩm
    public static void AddProduct(){}

//   sửa sản phẩm

    public static void UpdateProduct(){}

//    tìm kiếm sản phẩm
//    public static ArrayList<Products> SearchProduct(String keyWord){
//        ArrayList<Products> productList = new ArrayList<>();
//        for (Products products: products){
//            if(products.address.){
//
//            }
//        }
//
//    }


}
