package com.example.home.first;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    // SharedPreferences sharedPreferences;
    RecyclerView recyclerView2;
    RequestQueue rq;
    public List<pro_detail> arrayList2 = new ArrayList<pro_detail>();
    pro2Adapter p2;
    String id;


    // final ArrayList<product>arrayList=new ArrayList<product>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView2 = (RecyclerView) findViewById(R.id.enas);
        recyclerView2.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(p2);

        id = getIntent().getStringExtra("id");
        Toast.makeText(this, "id" + id
                , Toast.LENGTH_SHORT).show();

//        arrayList2.add(new pro_detail("ddd", "", "", "", 1));
//        arrayList2.add(new pro_detail("ddd", "", "", "", 1));
//        arrayList2.add(new pro_detail("ddd", "", "", "", 1));
//        p2 = new Adapter2(arrayList2, Main2Activity.this);
//        p2.notifyItemInserted(arrayList2.size()-1);
        start();

    }


    public void start() {


        String url = "http://lamsa.pioneers-solutions.org/Api/Helper/GetServicesOfCategories?id="+id;
        rq = Volley.newRequestQueue(this);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


//                try {
//                    jsonArray = response.getJSONArray();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                        Toast.makeText(Main2Activity.this, "MMMM", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < response.length(); i++) {

                    try {

                        JSONObject jsonObject = response.getJSONObject(i);
                        String dec = jsonObject.getString("Description");
                        int id = (int) jsonObject.getInt("Id");

                        String image = jsonObject.getString("Image");
                        String name = jsonObject.getString("Name");
                        int price =  jsonObject.getInt("price");
                        arrayList2.add(new pro_detail(dec, id+"", image.replace("..", ""), name, price));
                      //  arrayList2.add(new product(dec, id, image.replace("..", ""), name));
                        //  p2=new p
                        // ro2Adapter().( arrayList2,Main2Activity.this);
                        p2 = new pro2Adapter(arrayList2, Main2Activity.this);
                        recyclerView2.setLayoutManager(new LinearLayoutManager(Main2Activity.this));

                        recyclerView2.setAdapter(p2);
                        p2.notifyItemChanged(arrayList2.size()-1);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Main2Activity.this, "error in response", Toast.LENGTH_SHORT).show();

            }
        }
        );
        rq.add(jsonObjectRequest);
    }


}


