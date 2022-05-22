package com.example.test.Models;

import java.util.ArrayList;

public class Categories {

    public static ArrayList<Categories> categories = new ArrayList<>();
    private int Category_ID;
    private String Category_Name;
    private ArrayList<Products> products = new ArrayList<>();

    @Override
    public String toString() {
        return "Categories{" +
                "Category_ID=" + Category_ID +
                ", Category_Name='" + Category_Name + '\'' +
                ", products=" + products +
                '}';
    }


    public int getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(int category_ID) {
        Category_ID = category_ID;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }



    public  static  Categories GetCategoryById(int id){
        for (Categories item:
                Categories.categories) {
            if (item.getCategory_ID() == id){
                return item;
            }
        }
        return  null;
    }


    public Categories(int category_ID, String category_Name) {
        Category_ID = category_ID;
        Category_Name = category_Name;
     // tự add chính nó tạo ra một mãng category
       categories.add(this);
    }
    // thêm danh mục sản phẩm
    public static void addCategory(int category_ID, String category_Name){}

    // sủa danh mục

    public static void update(){}

}
