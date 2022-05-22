package com.example.test.Models;

import java.util.ArrayList;

public class User {
    public static ArrayList<User> userModels = new ArrayList<>();
    public int user_ID;
    public String user_Name;
    public String user_Phone;
    public static User user = null;
    public String user_Password;


    @Override
    public String toString() {
        return "User{" +
                "user_ID=" + user_ID +
                ", user_Name='" + user_Name + '\'' +
                ", user_Phone='" + user_Phone + '\'' +
                ", user_Password='" + user_Password + '\'' +
                '}';
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        this.user_Phone = user_Phone;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public User(int user_ID, String user_Name, String user_Phone, String user_Password) {
        this.user_ID = user_ID;
        this.user_Name = user_Name;
        this.user_Phone = user_Phone;
        this.user_Password = user_Password;
        userModels.add(this);
    }




//    hàm đăng nhập

    public static void login(String user_Name, String user_Password) {
        if (user_Name.equals("") && user_Password.equals("")) {
            System.out.println("đang nhập thành công");
        } else if (user_Name.equals("")) {
            System.out.println("chưa đang nhập mật khẩu");
        } else if (user_Password.equals("")) {
            System.out.println("chưa nhập user");
        } else {
            System.out.println("bạn chưa nhập user và password");
        }
    }
//    hàm đăng kí

    public static ArrayList<User> RegisterUser(int user_ID, String user_Name, String user_Phone, String user_Password) {
        ArrayList<User> userArrayList = new ArrayList<>();
        return userArrayList;
    }

    //    hàm xóa một user
    public static void DeleteUser(int user_ID) {
//       function xóa user
    }

//    public static void Logout(){U == null; }

}
