package com.example.hp.lab4_task1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
   Toolbar tb;
   ListView lv;
   ArrayList<String> list;
    static String rno;
    static long id;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.toolbar);
        lv=findViewById(R.id.listview);
        setSupportActionBar(tb);
        registerForContextMenu(lv);
        list= new ArrayList<String>();
        for(int i=1;i<=100;i++){
            if(i%2!=0) {
                list.add("F16SW-" + i);
            }
        }

      arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.activity_list_item, android.R.id.text1,list);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rno=lv.getItemAtPosition(position).toString();
                id=lv.getItemIdAtPosition(position);
                Toast.makeText(getApplicationContext(),"Your Roll Number Is: "+rno+" Item-Id is: "+id,Toast.LENGTH_SHORT).show();
            }
        });


    }


//Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf=getMenuInflater();
        mf.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.login:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.signin:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }

    }

    //Context Menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater cmf = getMenuInflater();
       cmf.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
         final AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.edit:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                //Alert Dialoge Start!
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
                // Set the dialog title and message. myAlertBuilder.setTitle("Alert");
                myAlertBuilder.setMessage("Are you sure you want to delete this item?");
                //Add the dialog buttons.
                myAlertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        // User clicked Yes button.
                       arrayAdapter.remove(arrayAdapter.getItem(info.position));
                       Toast.makeText(getApplicationContext(), "Item Deleted Successfully!", Toast.LENGTH_SHORT).show();
                    } });

                myAlertBuilder.setNegativeButton("NO", null);

                //  Create and show the AlertDialog.
                // myAlertBuilder.show();
                AlertDialog alertDialog = myAlertBuilder.create();
                alertDialog.show();
                //Alert Dialoge End!

                return true;

            case R.id.copy:
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }


}
