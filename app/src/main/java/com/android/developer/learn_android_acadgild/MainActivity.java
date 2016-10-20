package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.developer.learn_android_acadgild.adapter.CustomAdapter;
import com.android.developer.learn_android_acadgild.mBeans.Details;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddDialogForm.DialogForm {

    private static final int add_id = 100;
    private ArrayList<Details> detail;
    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detail = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
        adapter = new CustomAdapter(this, detail);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, add_id, 1, "Add");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case add_id:
                AddDialogForm dialog = new AddDialogForm();
                dialog.show(getSupportFragmentManager(), "DialogTag");
                break;
        }
        return true;
    }

    @Override
    public void onFinishDialog(String Name, String Phone, String Dob) {
        detail.add(new Details(Name, Phone, Dob));
        adapter.notifyDataSetChanged();
    }
}
