package com.test.test.testprojand;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.test.testprojand.RecyclerViewPackage.ModelRecyclerView;
import com.test.test.testprojand.RecyclerViewPackage.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    List<ModelRecyclerView> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Utils.SetActionBarDetail(ListActivity.this, "Articles");

        SetRecyclerSetting();
        Utils.SetActionBarDetail(ListActivity.this, "Articles");
    }

    public void SetRecyclerSetting() {
        recyclerView = findViewById(R.id.recycView);

        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        layoutManager = new LinearLayoutManager(ListActivity.this);
        list = new ArrayList<>();

        list.add(new ModelRecyclerView("This","Data"));

        onNotifyDataChange(list);
    }

    public void onNotifyDataChange(List<ModelRecyclerView> thisList) {
        System.out.println("call Me");
        recyclerViewAdapter = new RecyclerViewAdapter(ListActivity.this, thisList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
