package com.android.developer.learn_android_acadgild;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.developer.learn_android_acadgild.CustomAdapter.Adapter;
import com.android.developer.learn_android_acadgild.mbeans.Contacts;

import java.util.ArrayList;

import static com.android.developer.learn_android_acadgild.R.string.call;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SOME_FEATURES_PERMISSIONS = 117;
    private final int call_id = 10, sms_id = 11;
    private String[] contact_name = {"Pushpa", "Latha", "Arjun", "Kiran", "Arnav"};
    private String[] contact_phone = {"9987788775", "9988778874", "9988778844", "7988778877", "9968778877"};
    private ArrayList<Contacts> contacts;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacts = new ArrayList<>();
        for (int i = 0; i < contact_name.length; i++) {
            contacts.add(new Contacts(contact_name[i], contact_phone[i]));
        }

        listView = (ListView) findViewById(R.id.contact_listView);
        Adapter adapter = new Adapter(this, contacts);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(R.string.select);
        menu.add(0, call_id, 1, call);
        menu.add(0, sms_id, 2, R.string.sms);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        View v = info.targetView;
        String phone = ((TextView) v.findViewById(R.id.phone)).getText().toString();
        switch (id) {
            case call_id: {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, call_id);
                } else {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phone));
                    startActivity(callIntent);
                }
                break;
            }

            case sms_id: {

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS}, sms_id);
                } else {
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("smsto", phone, null));
                    startActivity(smsIntent);
                }
                break;

            }

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case call_id: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission given.Please try to call now.", Toast.LENGTH_SHORT).show();
                } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "You need to provide permission for this app to make a call else you cant call.", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case sms_id: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission given.Please try to sms now.", Toast.LENGTH_SHORT).show();
                } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "You need to provide permission for this app to send sms else you cant.", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }

    }
}
