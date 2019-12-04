package com.example.home.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RequestQueue rq;

    productAdapter p;
    String url = "http://lamsa.pioneers-solutions.org/Api/Helper/GetCategories";
    public List<product> arrayList1 = new ArrayList<product>();

    // final ArrayList<product>arrayList=new ArrayList<product>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        start();
    }

    public void start() {


        rq = Volley.newRequestQueue(this);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


//                try {
//                    jsonArray = response.getJSONArray();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                for (int i = 0; i < response.length(); i++) {

                    try {

                        JSONObject jsonObject = response.getJSONObject(i);
                        String dec = jsonObject.getString("Description");
                        int id = (int) jsonObject.getInt("Id");
                        String image = jsonObject.getString("Image");
                        String name = jsonObject.getString("Name");
                        arrayList1.add(new product(dec + ""
                                , id + ""
                                , image.replace("..", "") + ""
                                , name + ""));
                        p = new productAdapter(arrayList1, MainActivity.this);

                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        recyclerView.setAdapter(p);
                        p.notifyItemChanged(arrayList1.size());

                        Toast.makeText(MainActivity.this, "good", Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(
                        MainActivity.this, "error in response", Toast.LENGTH_SHORT).show();

            }
        }
        );
        rq.add(jsonObjectRequest);
    }


}

