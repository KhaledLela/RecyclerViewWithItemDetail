package com.lelasoft.recyclerviewwithitemdetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import eu.davidea.flipview.FlipView;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyViewHolder>{

    private MyCallback callback;

    public interface MyCallback{
        void onFlipAction(String item);
    }

    final List<String> dataSet;
    public MyItemAdapter(MyCallback callback,List<String> items) {
        this.callback = callback;
        dataSet = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(getItem(i));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_TF);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String item = getItem(getAdapterPosition());
                    callback.onFlipAction(item);
                }
            });
        }
    }

    private String getItem(int index){
        return dataSet.get(index);
    }
}
