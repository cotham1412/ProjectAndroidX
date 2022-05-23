package com.example.projectandroidx.ui.Adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroidx.R;
import com.example.projectandroidx.ui.Product;

import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {
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


    public MyRecycleViewAdapter(Activity context, int layoutID, int layoutID_invert, ArrayList<Product> products) {
        this.context = context;
        this.layoutID = layoutID;
        this.products = products;
        this.layoutID_invert = layoutID_invert;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {   //them implement vao`
        //hàm tạo mới
        // khoi tao ham` onclick
        private ImageView productImage;
        private TextView productName;
        private TextView productPrice;
        private View.OnClickListener onClick;
        private OnItemClickListener onItemClickListener;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //viết các find view id
            productImage = itemView.findViewById(R.id.product_image);
            productImage.setOnClickListener(this);// vi` moi lan` tab vao` khu vuc thi se goi toi ham` o duoi
            productName = itemView.findViewById(R.id.product_name);
            productName.setOnClickListener(this);
            productPrice = itemView.findViewById(R.id.product_price);
            productPrice.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) { // moi lan` click vao` 1 phan` tu thi` se goi den ham` nay`
            // Log.d("test","called");

            if (onClick!=null){  // kiem tra gia tri cua onclick neu gia tri khac null thi`
                onClick.onClick(view); // view vi` onClick (View view)
            }
        }

        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { // ham` xu ly uy quyen
            int pos = position; // khai tao bien pos vi position ko cho dung` truc tiep
            Product product = products.get(position);
            holder.productName.setText(product.getProductName());
            holder.productPrice.setText(product.getProductPrice());

            //xu ly
            holder.onClick = new View.OnClickListener(){
                @Override
                public void onClick(View view){ // view vi` onClick (View view)
                    //Log.d("test","called");
                    if (onItemClickListener != null) { // if else de kiem tra gia tri cua bien
                        onItemClickListener.onItemClick(pos,holder.itemView); // truyen bien pos (bien kep cua position) vao`
                    }else {
                        Log.d("adapter","you must setOnItemClickListener befor");
                    }
                }
            };
            //ham` dc goi khi tap vao` doi tuong
        }

        // define Interface for co che uy quyen
        public interface OnItemClickListener{
            public void onItemClick( int position,View view ); // bien position de dinh nghia gia tri khi click vao` doi tuong bat ki`
        }
    }

}
