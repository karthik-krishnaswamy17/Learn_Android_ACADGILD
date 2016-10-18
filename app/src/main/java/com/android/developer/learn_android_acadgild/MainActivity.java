package com.android.developer.learn_android_acadgild;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.android.developer.learn_android_acadgild.Database.DBHelper;
import com.android.developer.learn_android_acadgild.Utils.CommonUtilities;
import com.android.developer.learn_android_acadgild.Utils.Constants;
import com.android.developer.learn_android_acadgild.model.productData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String products[] = {"LG Printer", "HP Printer", "Acer Aspire Laptop", "Samsung Mobile"};
    private DBHelper dbHelper;
    private List<productData> dataList;
    private AutoCompleteTextView auto_names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = CommonUtilities.getDBObject(this);
        insertProduct();
        int count = dbHelper.getFullCount(Constants.PRODUCT_RECORD, null);
        if (count == 0)
            insertProduct();
        else {
            deleteProduct();
            insertProduct();
        }
        dataList = dbHelper.getAllProducts();
        List<String> productName = new ArrayList<String>();

        for (int i = 0; i < dataList.size(); i++) {
            productName.add(i, dataList.get(i).getProduct_name());
        }
        auto_names = (AutoCompleteTextView) findViewById(R.id.result);
        auto_names.setThreshold(1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productName);
        auto_names.setAdapter(adapter);

    }

    private void deleteProduct() {

        dbHelper.deleteRecords(Constants.PRODUCT_RECORD, null, null);
    }

    private void insertProduct() {
        for (int i = 0; i < products.length; i++) {
            ContentValues vals = new ContentValues();
            vals.put(Constants.PRODUCT_NAME, products[i]);
            dbHelper.insertContentVals(Constants.PRODUCT_RECORD, vals);
        }

    }
}
