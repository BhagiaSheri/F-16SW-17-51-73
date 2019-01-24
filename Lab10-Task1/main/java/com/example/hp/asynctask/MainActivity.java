package com.example.hp.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    TextView status_tv;
    Button startBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=findViewById(R.id.progressBar);
        status_tv=findViewById(R.id.status);
        startBtn=findViewById(R.id.startButton);

       startBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               new Downloader().execute();
           }
       });
    }

   class Downloader extends AsyncTask<Integer,Integer,Integer>{

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           pb.setMax(100);
       }

       @Override
       protected void onProgressUpdate(Integer... values) {
           super.onProgressUpdate(values);
           pb.setProgress(values[0]);
           if(values[0]==100){
               status_tv.setText("Downloading Completed!");
           }
           else {
               status_tv.setText(values[0] + "%");
           }
           }

       @Override
       protected Integer doInBackground(Integer... integers) {
           for(int i=0; i<=100; i++){
               publishProgress(i);

               try{
                   Thread.sleep(100);
               }catch (Exception ex){
                   ex.getMessage();
               }
           }
           return null;
       }

       @Override
       protected void onPostExecute(Integer integer) {
           super.onPostExecute(integer);
           Toast.makeText(getApplicationContext(),"Download Completed",Toast.LENGTH_LONG).show();
       }


   }

}
