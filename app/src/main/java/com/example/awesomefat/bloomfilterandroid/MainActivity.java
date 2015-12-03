package com.example.awesomefat.bloomfilterandroid;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    private EditText wordTV;
    private TextView answerTV;
    private ListView theList;
    private ArrayAdapter<String> theAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.wordTV = (EditText)this.findViewById(R.id.wordTV);
        this.answerTV = (TextView)this.findViewById(R.id.answerTV);
        this.theList = (ListView)this.findViewById(R.id.theList);
        this.theAdapter = new ArrayAdapter<String>(this,R.layout.simple_table_row, R.id.rowText);
        this.theList.setAdapter(theAdapter);
        Arrays.fill(BloomCore.theBloomFilter, 0);

    }

    public void checkValueButtonPressed(View v)
    {
        Intent i = new Intent(this, CheckValueActivity.class);
        this.startActivity(i);
    }

    public void hashButtonPressed(View v)
    {
        this.theAdapter.add(this.wordTV.getText().toString());
        BloomCore.theBloomFilter[HashCentral.stringHash(this.wordTV.getText().toString(), 16)] = 1;
        this.answerTV.setText(Arrays.toString(BloomCore.theBloomFilter));
    }
}
