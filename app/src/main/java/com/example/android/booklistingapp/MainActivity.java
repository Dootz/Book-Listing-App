package com.example.android.booklistingapp;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int numberOfResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfResults = 1;
        display();

        Button submitBT = (Button) findViewById(R.id.submit);
        Button removeBT = (Button) findViewById(R.id.remove);
        Button addBT = (Button) findViewById(R.id.add);

        final EditText editText = (EditText) findViewById(R.id.editTextView);
        submitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchFor = editText.getText().toString();
                Intent listIntent = new Intent(MainActivity.this, BookList.class);
                listIntent.putExtra("searchFor", searchFor);
                listIntent.putExtra("numberOfResults", numberOfResults);
                startActivity(listIntent);
            }
        });

        addBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfResults++;
                display();
            }
        });
        removeBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOfResults > 0) {
                    numberOfResults--;
                    display();
                }
            }
        });
    }

    private void display() {
        TextView infoTextView = (TextView) findViewById(R.id.number_of_results);
        infoTextView.setText("" + numberOfResults);
    }
}
