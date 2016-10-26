package com.android.developer.learn_android_acadgild;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_start;
    ProgressBar progressBar1, progressBar2, progressBar3, progressBar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_start = (Button) findViewById(R.id.bt_startDownload);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        bt_start.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        new ParallelProgress1().execute();
    }


    class ParallelProgress1 extends AsyncTask<Void, Integer, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar1.setVisibility(View.VISIBLE);
            progressBar2.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... aVoid) {

            for (int i = 1; i <= 5; i++) {
                sleep();
                publishProgress(i * 20);
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar1.setProgress(values[0]);
            progressBar2.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            new ParallelProgress2().execute();

        }

        private void sleep() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Log.e("String", e.toString());
            }
        }
    }

    class ParallelProgress2 extends AsyncTask<Void, Integer, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar3.setVisibility(View.VISIBLE);
            progressBar4.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... aVoid) {

            for (int i = 1; i <= 5; i++) {
                sleep();
                publishProgress(i * 20);
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar3.setProgress(values[0]);
            progressBar4.setProgress(values[0]);
        }

        private void sleep() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Log.e("String", e.toString());
            }
        }
    }
    
    
}

