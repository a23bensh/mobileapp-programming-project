package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
    private final String JSON_FILE = "metal";

    private ArrayList<Metal> MetalArraylist=new ArrayList<>();

    private ArrayList<RecyclerViewItem> RecyclerViewItems = new ArrayList<>();
    private RecyclerViewAdapter adapter;

    private Gson gson;

    WebView myWebView;
    public void showExternalWebPage(){
        myWebView.loadUrl("file:///android_res/layout/activity_main.xml");
    }

    public void showInternalWebPage(){
        myWebView.loadUrl("file:///android_asset/about.html");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myWebView = findViewById(R.id.my_webview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("file:///android_res/layout/activity_main.xml");


        gson = new Gson();

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_external_web) {
            Log.d("==>","Will display external web page");
            showExternalWebPage();
            return true;
        }

        if (id == R.id.action_internal_web) {
            Log.d("==>","Will display internal web page");
            showInternalWebPage();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", ""+ json);

        Type type = new TypeToken<List<Metal>>() {}.getType();
        MetalArraylist = gson.fromJson(json, type);
        for(Metal m : MetalArraylist){

        }
    }

}
