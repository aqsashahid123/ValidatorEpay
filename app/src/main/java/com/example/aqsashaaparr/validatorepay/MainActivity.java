package com.example.aqsashaaparr.validatorepay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonScan;
    private TextView textViewName, textViewAddress;




    private IntentIntegrator qrScan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//        buttonScan = (Button) findViewById(R.id.buttonScan);
//        textViewName = (TextView) findViewById(R.id.textViewName);
//        textViewAddress = (TextView) findViewById(R.id.textViewAddress);

        qrScan = new IntentIntegrator(this);
        qrScan.initiateScan();
      //  buttonScan.setOnClickListener(this);





    }


    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){


        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result!= null){

        if (result.getContents()==null){

            Toast.makeText(getApplicationContext(),"Result not found",Toast.LENGTH_SHORT).show();

        }

        else {

            try{

                JSONObject object = new JSONObject(result.getContents());
            //    textViewName.setText(object.getString());



            }
            catch (JSONException e){

                e.printStackTrace();
            }



        }


        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }



    }
    @Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();
    }


}
