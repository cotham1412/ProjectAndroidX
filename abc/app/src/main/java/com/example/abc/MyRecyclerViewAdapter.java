package com.example.abc;

import android.app.Activity;
import android.app.Person;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
//    bước 1 làm recycler

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    //bước 2 : có 3 tham số
    private Activity context;
    private int layoutID;
    private int layoutID_invert;
    private ArrayList<Person> people;
    private OnItemClickListener onItemClickListener; // khoi tao ham` de su dung bien interface

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    // kêt thúc bước
    // bước 3: tạo contructer
    public MyRecyclerViewAdapter(Activity context, int layoutID,int layoutID_invert, ArrayList<Person> people) {
        this.context = context;
        this.layoutID = layoutID;
        this.people = people;
        this.layoutID_invert =layoutID_invert;
    }

    //kết thúc bước
    //bước 4 định nghĩa viewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {   //them implement vao`
        //hàm tạo mới
        private ImageView imgbangcap;
        private TextView txthoten;
        private TextView txtsothich;
        private View.OnClickListener onClick; // khoi tao ham` onclick

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //viết các find view id
//            imgbangcap = itemView.findViewById(R.id.imgbangcap);
//            imgbangcap.setOnClickListener(this);// vi` moi lan` tab vao` khu vuc thi se goi toi ham` o duoi
//            txthoten = itemView.findViewById(R.id.lblhoten);
//            txthoten.setOnClickListener(this);
//            txtsothich = itemView.findViewById(R.id.lblsothich);
//            txtsothich.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) { // moi lan` click vao` 1 phan` tu thi` se goi den ham` nay`
            // Log.d("test","called");

            if (onClick!=null){  // kiem tra gia tri cua onclick neu gia tri khac null thi`
                onClick.onClick(view); // view vi` onClick (View view)
            }
        }
    }

    // hàm tạo viewholder
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = context.getLayoutInflater();
        CardView cardView = (CardView) inflater.inflate(viewType, viewGroup, false);
        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    //hàm tái sử dụng đổ dữ liệu
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { // ham` xu ly uy quyen
//        int pos = position; // khai tao bien pos vi position ko cho dung` truc tiep
//        Person person = people.get(position);
//        holder.txthoten.setText(person.getName());
//        holder.txtsothich.setText(person.getSoThich());
//        if (person.getBangCap().equalsIgnoreCase(QLNS2021.daihoc)) {
//            holder.imgbangcap.setImageResource(R.mipmap.university);
//        } else if (person.getBangCap().equalsIgnoreCase(QLNS2021.caodang)) {
//            holder.imgbangcap.setImageResource(R.mipmap.college);
//        } else if (person.getBangCap().equalsIgnoreCase(QLNS2021.trungcap)) {
//            holder.imgbangcap.setImageResource(R.mipmap.midium);
//        } else {
//            holder.imgbangcap.setImageResource(R.mipmap.none);
//        }
//        //xu ly
//        holder.onClick = new View.OnClickListener(){
//            @Override
//            public void onClick(View view){ // view vi` onClick (View view)
//                //Log.d("test","called");
//                if (onItemClickListener != null) { // if else de kiem tra gia tri cua bien
//                    onItemClickListener.onItemClick(pos,holder.itemView); // truyen bien pos (bien kep cua position) vao`
//                }else {
//                    Log.d("adapter","you must setOnItemClickListener befor");
//                }
//            }
//        };
//        //ham` dc goi khi tap vao` doi tuong
//    }
//    // kết thúc bước 4
//
//    //phần tử mảng
    @Override
    public int getItemCount() {
        return people.size();
    }

    //bước 5 cách trả về các layout khác nhau
    @Override
    public int getItemViewType(int position) {
        // trả về 2 layout nếu chẵn sẽ vào layout trên
        if (position % 2 ==0){
            return layoutID;
        }
        else {
            return  layoutID_invert;
        }
    }

    // define Interface for co che uy quyen
    public interface OnItemClickListener{
        public void onItemClick( int position,View view ); // bien position de dinh nghia gia tri khi click vao` doi tuong bat ki`
    }
}
