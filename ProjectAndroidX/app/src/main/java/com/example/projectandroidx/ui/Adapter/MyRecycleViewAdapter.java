package com.example.projectandroidx.ui.Adapter;

import android.app.Activity;
import android.app.Person;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroidx.ui.Product;

import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder>  {
    //bước 2 : có 3 tham số
    private Activity context;
    private int layoutID;
    private int layoutID_invert;
    private ArrayList<Product> products;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public MyRecycleViewAdapter(Activity context, int layoutID, int layoutID_invert, ArrayList<Person> people) {
        this.context = context;
        this.layoutID = layoutID;
        this.products = ;
        this.layoutID_invert =layoutID_invert;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {   //them implement vao`
        //hàm tạo mới
        // khoi tao ham` onclick

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);




        }

        @Override
        public void onClick(View view) { // moi lan` click vao` 1 phan` tu thi` se goi den ham` nay`
            // Log.d("test","called");


        }
    }

}
