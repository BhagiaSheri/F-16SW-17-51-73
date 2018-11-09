package com.example.hp.lab2_task2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class GroupInfo_MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    ImageView img_v;
    Button btn1,btn2;
    int member=1;
    String info[][]={{"Aniqa Saleem","F16SW73","aniqa@gmail.com","19-October-1999"},{"Bhagia Sheri","F16SW51","bhagiasheri24@gmail.com","02-August-1998"},{"Pooja Kumari","F16SW17","poojakumari11228gamil.com","02-June-1998"}};;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info__main);
        tv1=findViewById(R.id.name_tv);
        tv2=findViewById(R.id.rollno_tv);
        tv3=findViewById(R.id.email_tv);
        tv4=findViewById(R.id.dob_tv);
        btn1=findViewById(R.id.next_btn);
        btn2=findViewById(R.id.previous_btn);
        img_v=findViewById(R.id.imgView);

        tv1.setText(info[0][0]);
        tv2.setText(info[0][1]);
        tv3.setText(info[0][2]);
        tv4.setText(info[0][3]);
        img_v.setImageResource(R.drawable.aniqa);

       }

       public void nextBtnClick(View v){
         member++;
           if(member>3){
               member=3;
               Toast.makeText(getApplicationContext(),"This Is The Last Member Of Team!!!",Toast.LENGTH_SHORT).show();
           }
        if(member==1) {
            tv1.setText(info[0][0]);
            tv2.setText(info[0][1]);
            tv3.setText(info[0][2]);
            tv4.setText(info[0][3]);
            img_v.setImageResource(R.drawable.aniqa);
        }
        if(member==2) {
               tv1.setText(info[1][0]);
               tv2.setText(info[1][1]);
               tv3.setText(info[1][2]);
               tv4.setText(info[1][3]);
               img_v.setImageResource(R.drawable.bhagia);
           }
           if(member==3) {
               tv1.setText(info[2][0]);
               tv2.setText(info[2][1]);
               tv3.setText(info[2][2]);
               tv4.setText(info[2][3]);
               img_v.setImageResource(R.drawable.pooja);
           }
       }
       public void preBtnClick(View v){
           member--;
           if(member<1){
               member=1;
               Toast.makeText(getApplicationContext(),"This Is The First Member Of Team!!!",Toast.LENGTH_SHORT).show();
           }
           if(member==1) {
               tv1.setText(info[0][0]);
               tv2.setText(info[0][1]);
               tv3.setText(info[0][2]);
               tv4.setText(info[0][3]);
               img_v.setImageResource(R.drawable.aniqa);
           }
           if(member==2) {
               tv1.setText(info[1][0]);
               tv2.setText(info[1][1]);
               tv3.setText(info[1][2]);
               tv4.setText(info[1][3]);
               img_v.setImageResource(R.drawable.bhagia);
           }
           if(member==3) {
               tv1.setText(info[2][0]);
               tv2.setText(info[2][1]);
               tv3.setText(info[2][2]);
               tv4.setText(info[2][3]);
               img_v.setImageResource(R.drawable.pooja);
           }
       }
}
