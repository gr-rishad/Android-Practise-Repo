package com.example.deleterecyclerviewitemthroughswipee.JWT;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.deleterecyclerviewitemthroughswipee.NavigationDrawer;
import com.example.deleterecyclerviewitemthroughswipee.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText userNameEditText,passwordEditText;
    Button sendButton;
    RequestQueue requestQueue;
    RequestQueue getRequestQueue;
    RequestQueue employeeRequestQueue;
    String token_URL="http://apps.diu.edu.bd/token/generate-token";

    SharedPreferences sharedPreferences;
    boolean doubleBackToExitPressedOnce= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);



        userNameEditText=(EditText) findViewById(R.id.userNameId);
        passwordEditText=(EditText) findViewById(R.id.passwordId);
        sendButton= (Button)findViewById(R.id.btnSendId);


        sharedPreferences= getSharedPreferences("sessionPrefs", Context.MODE_PRIVATE);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   System.out.println("Working");
               postRequest();
              //getRequest();
               //getEmployeeRequest();
            }
        });
    }



        @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            Intent intent= new Intent(Intent.ACTION_MAIN);
           // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
            return;
        }
       this.doubleBackToExitPressedOnce=true;
        Toast.makeText(getApplicationContext(),"Double Press To Exit",Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        },2000);

    }

    private void postRequest(){

        String userName = userNameEditText.getText().toString().trim();
        String password=passwordEditText.getText().toString().trim();
        final JSONObject body=new JSONObject();
        try {
            body.put("username",userName);
            body.put("password",password);

        } catch (JSONException e) {
            e.printStackTrace();
        }
     //   final String b=body.toString();


        requestQueue=Volley.newRequestQueue(LoginActivity.this);
        JsonObjectRequest stringRequest=new JsonObjectRequest(Request.Method.POST, token_URL,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //System.out.println(response);
                try {
                    //Toast.makeText(getApplicationContext(),"Response ;"+response.get("token"),Toast.LENGTH_SHORT).show();

                    String userName=response.get("username").toString();
                    String token=  response.get("token").toString();
                    String status=response.get("status").toString();



                   //getEmployeeRequest(userName);

                   getRequest(userName,token,status);

//                    System.out.println(sts);
//                    SharedPreferences.Editor editor= sharedPreferences.edit();
//                    editor.putString("AuthToken",ab);
//                    editor.commit();
//
//                    if (sts.equals("success")){
//                        Intent i = new Intent(LoginActivity.this, Details.class);
//                        startActivity(i);
//                    }else {
//                        Toast.makeText(getApplicationContext(),"InCorrect",Toast.LENGTH_SHORT).show();
//                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Response ;"+error,Toast.LENGTH_SHORT).show();
               // System.out.println(error);

            }
        });

//        {
//            @Override
//            public byte[] getBody(){
//                try {
//                    return b.getBytes("utf-8");
//                }catch (Exception e){
//                    return null;
//                }
//
//            }

//            @Override
//            public Map<String,String> getHeaders() throws AuthFailureError{
//                Map<String,String> headers= new HashMap<String,String>();
//                //String credentials ="userName:password";
//                //String auth= "Basic"+ Base64.encodeToString(credentials.getBytes(),Base64.NO_WRAP);
//                headers.put("Content-Type","application/json");
//
//                return headers;
//            }
//        };
        requestQueue.add(stringRequest);

    }

    private void getRequest(String userName, final String token, String status){

         final String getToken= token;
        System.out.println("Get token"+getToken);
         String getUserName= userName;
         final String getStatus= status;
        String getUrl="http://apps.diu.edu.bd/apps/apiClient/getApiClientById?id=10";
        getRequestQueue = Volley.newRequestQueue(LoginActivity.this);

        JsonObjectRequest getReq = new JsonObjectRequest(Request.Method.GET, getUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               // Toast.makeText(getApplicationContext(),"get Response 123 ======"+response,Toast.LENGTH_SHORT).show();

              //  if (getStatus.equals("success")){
                    try {
                        String clientName= response.get("clientName").toString();
                        System.out.println(clientName);

//                        Intent i = new Intent(LoginActivity.this, NavigationDrawer.class);
//                       i.putExtra("clientName",clientName);
//                       startActivity(i);
                      // finish();


                    }catch (Exception e ){

                    }





//                    }else {
//                        Toast.makeText(getApplicationContext(),"InCorrect",Toast.LENGTH_SHORT).show();
                    }



               // System.out.println(response);

            //}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // As of f605da3 the following should work
                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        // Now you can use any deserializer to make sense of data
                        JSONObject obj = new JSONObject(res);
                    } catch (UnsupportedEncodingException e1) {
                        // Couldn't properly decode data to string
                        e1.printStackTrace();
                    } catch (JSONException e2) {
                        // returned data is not JSONObject?
                        e2.printStackTrace();
                    }
                }
            }
        })
        {



            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> setReq= new HashMap<>();
                setReq.put("Content-Type","application/json");
                setReq.put("Authorization","Bearer " +getToken);
                return setReq;
            }
        };
        getRequestQueue.add(getReq);
    }

    private void getEmployeeRequest(String userName){


         employeeRequestQueue=Volley.newRequestQueue(LoginActivity.this);
         String getUserName = userName;
        final String employeeUrl="http://apps.diu.edu.bd/apps/admin/v1/employee?clientName=DiuAdminAndroidApp&clientSecret=651dd7bc-a6d5-11e9-97a7-17d65b43ae42&apiKey=6407f954-a6e0-11e9-974c-097e44827da8&employeeId="+getUserName;
       // String password=passwordEditText.getText().toString().trim();


         JsonObjectRequest employeeJsonRequest= new JsonObjectRequest(Request.Method.GET, employeeUrl, null, new Response.Listener<JSONObject>() {
             @Override
             public void onResponse(JSONObject response) {
                // System.out.println("Response"+response);

                 try {
                   String  employeeName = response.get("employeeName").toString();
                   String  designation = response.get("designation").toString();

                     Intent i = new Intent(LoginActivity.this, NavigationDrawer.class);
                     i.putExtra("employeeName",employeeName);
                     i.putExtra("designation",designation);
                     startActivity(i);
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }




             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {

             }
         }){

             @Override
             protected Map<String, String> getParams() throws AuthFailureError {

                 Map<String,String> setEmployee= new HashMap<>();
                  setEmployee.put("Content-Type","application/json");
//                 setEmployee.put("employeeId",employeeUrl.concat(userName));
                 return setEmployee;
             }
         };
            employeeRequestQueue.add(employeeJsonRequest);
    }

}
