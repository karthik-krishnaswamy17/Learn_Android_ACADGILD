package com.android.developer.learn_android_acadgild;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.developer.learn_android_acadgild.Constants.constants;

import static com.android.developer.learn_android_acadgild.SharedPrefManager.SharedPrefManager.getPrefVal;
import static com.android.developer.learn_android_acadgild.SharedPrefManager.SharedPrefManager.getSharedPref;
import static com.android.developer.learn_android_acadgild.SharedPrefManager.SharedPrefManager.setStringPrefVal;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_save, bt_show;
    private SharedPreferences sp;
    private EditText viewName, viewAge, viewPhone, viewCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewName = (EditText) findViewById(R.id.name);
        viewAge = (EditText) findViewById(R.id.age);
        viewCity = (EditText) findViewById(R.id.city);
        viewPhone = (EditText) findViewById(R.id.phone);

        bt_save = (Button) findViewById(R.id.bt_save);
        bt_show = (Button) findViewById(R.id.bt_show);
        bt_save.setOnClickListener(this);
        bt_show.setOnClickListener(this);
        sp = getSharedPref(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id) {
            case R.id.bt_save:
                String nameValue = viewName.getText().toString();
                String ageValue = viewAge.getText().toString();
                String cityValue = viewCity.getText().toString();
                String phoneValue = viewPhone.getText().toString();
                setStringPrefVal(this, constants.NAME, nameValue);
                setStringPrefVal(this, constants.AGE, ageValue);
                setStringPrefVal(this, constants.CITY, cityValue);
                setStringPrefVal(this, constants.PHONE, phoneValue);
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_show:
                String name = getPrefVal(this, constants.NAME);
                String age = getPrefVal(this, constants.AGE);
                String city = getPrefVal(this, constants.CITY);
                String phone = getPrefVal(this, constants.PHONE);
                String details = "Name:" + name + "\nAge:" + age + "\nCity:" + city + "\nPhone:" + phone;
                Toast.makeText(this, details, Toast.LENGTH_SHORT).show();
                break;
        }

    }


}
