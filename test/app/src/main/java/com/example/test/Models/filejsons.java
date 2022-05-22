package com.example.test.Models;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class filejsons {
    public static void GetUser(Context context) {
        String jsString = "";
        // dọc file dữ liệu giả
        try {
            InputStream isx = context.getAssets().open("user.json");
            int size = isx.available();
            byte[] buffer = new byte[size];
            isx.read(buffer);
            isx.close();
            jsString = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(jsString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int user_ID = Integer.parseInt(jsonObject.get("user_ID").toString());
                User user = new User(user_ID,
                        jsonObject.get("user_Name").toString(),
                        jsonObject.get("user_Password").toString(),
                        jsonObject.get("user_Phone").toString());
            }
        } catch (IOException e) {
            Log.i("IOException", e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static void GetProducts(Context context) {
        String jsString = "";
        // dọc file dữ liệu giả
        try {
            InputStream isx = context.getAssets().open("category.json");
            int size = isx.available();
            byte[] buffer = new byte[size];
            isx.read(buffer);
            isx.close();
            jsString = new String(buffer, "UTF-8");

            JSONArray jsonCategoriesArray = new JSONArray(jsString);
            for (int i = 0; i < jsonCategoriesArray.length(); i++) {
                JSONObject jsonCategory = jsonCategoriesArray.getJSONObject(i);
                int category_ID = Integer.parseInt(jsonCategory.get("category_ID").toString());
                Categories categories = new Categories(category_ID, jsonCategory.get("category_Name").toString());

//                 khai báo đối tượng Product Array
//                JSONArray productList = jsonCategory.getJSONArray("product_list");
//                for (int j = 0; j < productList.length(); i++) {
//                    JSONObject jsonProduct = productList.getJSONObject(j);
//                    int product_id = Integer.parseInt(jsonProduct.get("product_ID").toString());
//
//                    // Array chứa các phần tử hình
//                    ArrayList<String> productImage = new ArrayList<>();
//                    for (int k = 0; k < jsonProduct.getJSONArray("product_Image").length(); k++)
//                        productImage.add(jsonProduct.getJSONArray("product_Image").getString(k));
//                    Products products = new Products(product_id,
//                            jsonProduct.get("product_Name").toString(),
//                            jsonProduct.getDouble("product_Price"),
//                            jsonProduct.get("product_Des").toString(),
//                            productImage,
//                            category_ID);
//                }
            }
        } catch (Exception e) {
            Log.i("IOException", e.getMessage());
        }
    }
}

