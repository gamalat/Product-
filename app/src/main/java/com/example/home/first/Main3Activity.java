package com.example.home.first;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {


    RequestQueue rq;
    String id;
    public List<pro_detail> arrayList3 = new ArrayList<pro_detail>();

    ImageView imageView;
    TextView textView;
    TextView textView2;
    TextView textView3;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        id = getIntent().getStringExtra("id");
        Toast.makeText(this, "id" + id
                , Toast.LENGTH_SHORT).show();

        imageView= (ImageView) findViewById(R.id.image3);
        textView=(TextView) findViewById(R.id.txt31);
        textView2=(TextView) findViewById(R.id.txt32);
        textView3=(TextView) findViewById(R.id.txt33);
        start();


    }

    public void start() {

        String url = "http://lamsa.pioneers-solutions.org/Api/Helper/GetService?id="+id;
        rq = Volley.newRequestQueue(this);
        final JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Method.GET, url, new Response.Listener<JSONObject>() {
            @Override

            public void onResponse(JSONObject response) {

                try {
                    textView.setText(response.getString("Name"));
                    textView2.setText(response.getString("price"));
                    textView3.setText(response.getString("Description"));
                   Picasso.with(getApplicationContext()).load("http://lamsa.pioneers-solutions.org"+response.getString("Image")).into(imageView);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Main3Activity.this, "error in response", Toast.LENGTH_SHORT).show();
            }
        }
        );
        rq.add(jsonObjectRequest);
    }



}