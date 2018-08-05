package com.lelasoft.recyclerviewwithitemdetail;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flipview.FlipView;

public class MainActivity extends AppCompatActivity implements MyItemAdapter.MyCallback {

    private FlipView flipView;
    private ItemDetailsFragment itemDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipView = findViewById(R.id.flip_layout);

        List<String> dataSet = new ArrayList<>();
        dataSet.add("Item 1");
        dataSet.add("Item 2");
        dataSet.add("Item 3");
        dataSet.add("Item 4");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyItemAdapter(this,dataSet));
        itemDetailsFragment= (ItemDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_item_detail);
        itemDetailsFragment.init(this);
    }



    @Override
    public void onFlipAction(String item) {
        if (flipView.isFlipped())
            flipView.flip(false);
        else {
            flipView.flip(true);
            itemDetailsFragment.updateItemDetails(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (flipView.isFlipped())
            flipView.flip(false);
        else
            super.onBackPressed();
    }
}
