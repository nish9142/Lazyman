package com.example.satyanishanth.politics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;


public class MainActivity extends AppCompatActivity {
    MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.recycleviewhome);
        postadapter adapter =new postadapter(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchView = findViewById(R.id.searchbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        MenuItem item =menu.findItem(R.id.searchbar);
        searchView.setMenuItem(item);


        return super.onCreateOptionsMenu(menu);

    }
}
