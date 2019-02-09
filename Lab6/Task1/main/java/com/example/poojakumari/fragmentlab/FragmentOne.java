package com.example.poojakumari.fragmentlab;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentOne extends Fragment {

    public ArrayList<String> list;
    private ListView lv;
    private View view;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_fragment_one,container,false);
        lv= view.findViewById(R.id.listView);
        list = new ArrayList<String>();
        for(int i=0;i<20;i++)
        {
            list.add("Student id "+i);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,list);
        lv.setAdapter(arrayAdapter);
        return view;
    }
}
