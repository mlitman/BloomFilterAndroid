package com.example.awesomefat.bloomfilterandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class CheckValueActivity extends AppCompatActivity
{
    private TextView bloomFilterTV;
    private EditText searchStringET;
    private TextView resultTV;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_value);
        this.bloomFilterTV = (TextView)this.findViewById(R.id.bloomFilterTV);
        this.bloomFilterTV.setText(Arrays.toString(BloomCore.theBloomFilter));
        this.searchStringET = (EditText)this.findViewById(R.id.searchStringET);
        this.resultTV = (TextView)this.findViewById(R.id.resultTV);
    }

    public void searchButtonPressed(View v)
    {
        int val = HashCentral.stringHash(this.searchStringET.getText().toString(), 16);
        if(BloomCore.theBloomFilter[val] == 1)
        {
            this.resultTV.setText("TRUE");
        }
        else
        {
            this.resultTV.setText("FALSE");
        }
    }
}
