package com.example.aqsashaaparr.validatorepay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.stetho.Stetho;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FareDataRequest extends AppCompatActivity {
    String URL="http://epay.cybussolutions.com/Api_Service/getWholeFareData";
    TextView tvS;
        FareData fareData;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare_data_request);
db = new DatabaseHandler(this);




        tvS = (TextView)findViewById(R.id.tvs);
        fareData = new FareData();


        final StringRequest request =new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
             //   Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i =0; i< jsonArray.length();i++){

                        JSONObject jsonObject = new JSONObject(jsonArray.getString(i));
                        fareData.setFare_ID(jsonObject.get("Fare_ID").toString());
                        fareData.setFare_route(jsonObject.get("Fare_route").toString());
                        fareData.setFare_price(jsonObject.get("Fare_price").toString());
                        fareData.setFare_type(jsonObject.get("Fare_type").toString());
                        fareData.setAdded_by(jsonObject.get("added_by").toString());
                        fareData.setUpdate_by(jsonObject.get("update_by").toString());
                        fareData.setDate_updated(jsonObject.get("date_updated").toString());
                        fareData.setDate_added(jsonObject.get("date_added").toString());

                        db = new DatabaseHandler(getApplicationContext());
                        db.addFareData(fareData);
//                        tvS.setText(jsonObject.get("Fare_ID").toString());
                    }



                }
                catch (JSONException e){

                    e.printStackTrace();

                }




            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        String message = null;
                        if (error instanceof NetworkError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        }



                    }
                }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

//                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(History.this);
//                    String userid = preferences.getString("id","");
//                    map.put("userid",userid);
                return map;


            }



        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



      //  db.getData(11);
        Toast.makeText(getApplicationContext(),String.valueOf(db.getContactsCount()),Toast.LENGTH_LONG).show();
    }
}
