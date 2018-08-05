package com.lelasoft.recyclerviewwithitemdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemDetailsFragment extends Fragment {
    private TextView itemTF;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_detail,container,false);
        itemTF = rootView.findViewById(R.id.item_details_TF);
        return rootView;
    }

    public void init(final MyItemAdapter.MyCallback callback){
        itemTF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onFlipAction(itemTF.getText().toString());
            }
        });
    }

    public void updateItemDetails(String item) {
        itemTF.setText(item);
    }
}
