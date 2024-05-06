package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23bensh";
    private final String JSON_FILE = "metal.json";

    private ArrayList<Metal> MetalArraylist=new ArrayList<>();

    private ArrayList<RecyclerViewItem> RecyclerViewItems = new ArrayList<>();
    private RecyclerViewAdapter adapter;

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();

        MetalArraylist.add(new Metal("Matterhorn","Alps",4478));
        MetalArraylist.add(new Metal("Mont Blanc","Alps",4808));
        MetalArraylist.add(new Metal("Denali","Alaska",6190));

        new JsonFile(this, this).execute(JSON_FILE);

        for(Metal m : MetalArraylist){
            RecyclerViewItems.add(new RecyclerViewItem(m.getName()));
        }


        for(RecyclerViewItem r : RecyclerViewItems){
            Log.d("Kyckling1", r.getTitle());
        }

        adapter = new RecyclerViewAdapter(this, RecyclerViewItems, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", ""+ json);

        Type type = new TypeToken<List<Metal>>() {}.getType();
        MetalArraylist = gson.fromJson(json, type);
        for(Metal m : MetalArraylist){
            RecyclerViewItems.add(new RecyclerViewItem(m.getName()));
        }
    }

}
