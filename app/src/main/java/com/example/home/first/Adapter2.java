package com.example.home.first;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


    public class Adapter2 extends RecyclerView.Adapter<com.example.home.first.Adapter2.ViewHolder2> {

        Context context2;
        public List<pro_detail> list_item2;

        public Adapter2(List<pro_detail> arrayList2, Main2Activity main2Activity) {
            this.list_item2 = list_item2;
            this.context2 = context2;
        }


        public class ViewHolder2 extends RecyclerView.ViewHolder {
            CardView cardView;
            ImageView imageView;
            TextView textView;
            TextView textView2;

            public ViewHolder2(@NonNull View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.card2);
                textView = itemView.findViewById(R.id.txt1);
                textView2 = itemView.findViewById(R.id.txt2);
                imageView = itemView.findViewById(R.id.imageview2);
            }

        }


        @NonNull
        @Override
        public com.example.home.first.Adapter2.ViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_detail, viewGroup, false);
            return new com.example.home.first.Adapter2.ViewHolder2(view);

        }

        @Override
        public void onBindViewHolder(@NonNull com.example.home.first.Adapter2.ViewHolder2 viewHolder, final int  i) {

            viewHolder.textView.setText(list_item2.get(i).Name);
            viewHolder.textView2.setText(list_item2.get(i).price);
            Picasso.with(context2).load("http://lamsa.pioneers-solutions.org" + list_item2.get(i).getImage()).into(viewHolder.imageView);

        }


        @Override
        public int getItemCount() {
            if (list_item2 != null) {
                return list_item2.size();
            } else {


                return 0;
            }
        }
    }

