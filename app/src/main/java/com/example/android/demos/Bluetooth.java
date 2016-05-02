package com.example.android.demos;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class Bluetooth extends AppCompatActivity {
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
       /* if (bluetoothAdapter.isEnabled()){
            Toast.makeText(getApplicationContext(),"Bluetooth is  on",Toast.LENGTH_LONG).show();


        }else{
            Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(intent);
            if (bluetoothAdapter.isEnabled()){
                Toast.makeText(getApplicationContext(),"Bluetooth is turned on",Toast.LENGTH_LONG).show();

            }
        }*/


    }
    public void turnBluetoothOff(View view){
        bluetoothAdapter.disable();
        if (bluetoothAdapter.isEnabled()){
            Toast.makeText(getApplicationContext(),"Bluetooth could not be disabled",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(getApplicationContext(),"Bluetooth Turned off",Toast.LENGTH_LONG).show();
        }



    }

    public void findDiscoverableDevices(View view){
        Intent intent= new Intent(bluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivity(intent);



    }

    public void viewPairedDevices(View view){
        Set <BluetoothDevice>pairedDevices=bluetoothAdapter.getBondedDevices();
        ListView listView=(ListView)findViewById(R.id.listView_PairedDevices);
        ArrayList pairedDevicesArrayList=new ArrayList();
        for (BluetoothDevice bluetoothDevice:pairedDevices){
            pairedDevicesArrayList.add(bluetoothDevice.getName());


        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,pairedDevicesArrayList);
        listView.setAdapter(arrayAdapter);



    }


}
