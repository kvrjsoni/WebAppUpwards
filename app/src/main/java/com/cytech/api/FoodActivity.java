package com.cytech.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

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

public class FoodActivity extends AppCompatActivity {
    private String url = "https://www.datakick.org/api/items";
    private RecyclerView bList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Food> foodList;
    private FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        init();
        getData();
    }


    /**
     * Starter method
     * @param context
     */
    public static void start(Context context) {
        Intent starter = new Intent(context, FoodActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    /**
     * Initializations of Views
     */
    private void init()
    {
        bList=findViewById(R.id.main_list);
        foodList =new ArrayList<>();
        adapter = new FoodAdapter(getApplicationContext(), foodList);
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration=new DividerItemDecoration(bList.getContext(),linearLayoutManager.getOrientation());
        bList.setHasFixedSize(true);
        bList.setLayoutManager(linearLayoutManager);
        bList.addItemDecoration(dividerItemDecoration);
        bList.setAdapter(adapter);

    }

    /**
     * Volley call to get Data to Show
     */
    private void getData()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 43; i < response.length(); i++) {
                    try
                    {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Food food = new Food();
                        food.setName("Food Name: "+jsonObject.getString("name"));
                        food.setBrand_name("Brand Name: "+jsonObject.getString("brand_name"));
                        food.setSize("Size: "+jsonObject.getString("size"));
                        foodList.add(food);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }




}
