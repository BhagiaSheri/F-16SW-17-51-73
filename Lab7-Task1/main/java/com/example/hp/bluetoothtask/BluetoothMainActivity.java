package com.example.hp.bluetoothtask;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Set;

public class BluetoothMainActivity extends AppCompatActivity {

    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lv;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_main);
        BA = BluetoothAdapter.getDefaultAdapter();
        lv=findViewById(R.id.devicesList);

    }

    public void turnOn(View v){
        Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(turnOn, 0);
    }
    public void getVissible(View v){
     BA.startDiscovery();
    }
    public void pairedDevices(View v){
        pairedDevices = BA.getBondedDevices();
        list = new ArrayList<String>();
        for(BluetoothDevice bt : pairedDevices) {
            list.add(bt.getName());
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1,list);
        lv.setAdapter(arrayAdapter);
        }



    public void turnOff(View v){
    BA.disable();
    }
}
