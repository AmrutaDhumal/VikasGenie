package net.aeontest.vikadgenie;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class VollyClass {

    private void _login() {
      //  String JSON_URL = "http://192.168.1.14:8090/UserLogin?mobileno=" + mobileno + "&PWD=" + PwdString;
        //creating a string request to send request to the url
        StringRequest request = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.equals(null)) {
                    Log.e("Your Array Response", response);
                } else {
                    Log.e("Your Array Response", "Data Null");
                }

                dialog3.dismiss();
                try {
                    //getting the whole json object from the response
                    JSONObject obj = new JSONObject(response);

                    //we have the array named hero inside the object
                    //so here we are getting that json array
                    String status = obj.getString("status");
                    String message = obj.getString("message");
                    useid = obj.getString("userId");
                    editor.putString("UserID", useid);
                    editor.commit();
                    Log.d("UserID", useid);
                    if (status.equalsIgnoreCase("0")) {
                        //Toast.makeText(LoginActivity.this,"Already Registered Mobile No.", Toast.LENGTH_SHORT).show();
                        new AlertDialog.Builder(LoginActivity.this)
                                .setMessage("Already Registered Mobile No. Please use another number")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {


                                    }
                                })

                                .show();

                    } else if (status.equalsIgnoreCase("1")) {
                        Toast.makeText(LoginActivity.this, "Login Successfully ", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(LoginActivity.this, SecondActivity.class);
                        startActivity(i);
                    }
                    Log.d("ffff", status);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error is ", "" + error);
            }


        });


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

    }
}
