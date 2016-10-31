package com.android.developer.learn_android_acadgild;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by karthik90 on 10/31/2016.
 */

public class BackgroundActivity extends AsyncTask<Integer, Void, String> {
    String myFileName, data;
    File rootFolder, myFile;
    private Activity activity;
    private TextView textView;

    public BackgroundActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * Initialize File and textView UI before background process starts
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        myFileName = "myFile.txt";
        rootFolder = Environment.getExternalStorageDirectory();
        myFile = new File(rootFolder, myFileName);
        data = ((EditText) this.activity.findViewById(R.id.editText)).getText().toString();
        textView = (TextView) this.activity.findViewById(R.id.content);
    }

    @Override
    protected String doInBackground(Integer... params) {
        Integer id = params[0];
        switch (id) {
            case R.id.bt_data:
                try {
                    myFile.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(myFile);
                    fileOutputStream.write(data.getBytes());
                    fileOutputStream.close();
                    return "created";
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.bt_delete:
                if (myFile.exists()) {
                    myFile.delete();
                    return "deleted";
                }
                break;
        }

        return "nan";

    }

    private void showToast(String res) {

        if (res.equals("created")) {
            this.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "File Created Successfully and data added.", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (res.equals(("deleted"))) {
            this.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "File deleted Successfully", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            this.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "File not found.", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


    @Override
    protected void onPostExecute(String res) {
        super.onPostExecute(res);
        showToast(res);
        displayContents(myFile);
    }


    private void displayContents(File myFile) {

        try {
            String aDataRow = " ", aBuffer = " ";
            FileInputStream fileinputStream = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(
                    new InputStreamReader(fileinputStream));

            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer += aDataRow + "\n";
            }
            textView.setText(aBuffer);
            myReader.close();
        } catch (FileNotFoundException e) {
            textView.setText(" ");
            showToast("nan");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
