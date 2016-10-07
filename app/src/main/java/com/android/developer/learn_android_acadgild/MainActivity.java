package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String[] ascending_months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct",
            "Nov", "Dec"
    };
    private static final String[] descending_months = {"Dec", "Nov", "Oct", "Sept", "Aug", "July", "June", "May", "Apr", "Mar",
            "Feb", "Jan"};

    /*
    Use ArrayList as there would be Run-time Exception if a String is used with clear()/remove() adapter.
    */
    private static ArrayList<String> list_months_asce = new ArrayList<>(Arrays.asList(ascending_months));
    private static ArrayList<String> list_months_desc = new ArrayList<>(Arrays.asList(descending_months));

    private Button bt_ascending, bt_descending;
    private ListView listView_months;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_ascending = (Button) findViewById(R.id.ascending);
        bt_descending = (Button) findViewById(R.id.descending);
        listView_months = (ListView) findViewById(R.id.list_month);
        bt_ascending.setOnClickListener(this);
        bt_descending.setOnClickListener(this);
        adapter = new ArrayAdapter<>(this, R.layout.simple_list_item, list_months_asce);
        listView_months.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ascending: {
                Toast.makeText(this, "Sorted in Ascending Order", Toast.LENGTH_SHORT).show();
                if (adapter != null)
                    adapter.clear();
                /*
                * When the adapter is cleared for the first time,"list_months_asce" gets empty.So this check is added.
                * */
                if (list_months_asce.size() == 0)
                    list_months_asce = new ArrayList<>(Arrays.asList(ascending_months));

                adapter.addAll(list_months_asce);
                adapter.notifyDataSetChanged();

                break;
            }

            case R.id.descending: {
                Toast.makeText(this, "Sorted in Descending Order", Toast.LENGTH_SHORT).show();
                list_months_desc = new ArrayList<>(Arrays.asList(descending_months));
                if (adapter != null)
                    adapter.clear();
                adapter.addAll(list_months_desc);
                adapter.notifyDataSetChanged();
                break;
            }

        }
    }
}
