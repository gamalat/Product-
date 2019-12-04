package com.example.home.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class pro2Adapter extends  RecyclerView.Adapter<pro2Adapter.ViewHolder> {

    public List<pro_detail> list_item2;
    Context context2;

    public pro2Adapter(List<pro_detail> list_item2, Context context) {
        this.list_item2 = list_item2;
        this.context2 = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;
        TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card2);
            textView = itemView.findViewById(R.id.txt1);
            textView2 = itemView.findViewById(R.id.txt2);
            imageView = itemView.findViewById(R.id.imageview2);
        }

    }



    @NonNull
    @Override

    public pro2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_detail, viewGroup, false);
        return new pro2Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pro2Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(list_item2.get(i).getName());
        viewHolder.textView2.setText( list_item2.get(i).getPrice()+"");
        Picasso.with(context2).load("http://lamsa.pioneers-solutions.org" + list_item2.get(i).getImage()).into(viewHolder.imageView);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context2, "go to third activity", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context2, Main3Activity.class);
                intent.putExtra("id",list_item2.get(i).getId());
                context2.startActivity(intent);
            }
        });

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