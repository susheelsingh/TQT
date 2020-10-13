package com.thequicktax.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.thequicktax.Common.ShareData;
import com.thequicktax.Common.Urls;
import com.thequicktax.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ForgetPassScreenActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText_Login;
    Button button_submit;
    TextView text_Cancel;
    private  String token=null;
    ShareData mSharedData;
    ProgressDialog dialogProgress = null;
    private boolean mStatus;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_screen);
        initObjects();
        token = mSharedData.getString("Auth_token_type", "");
        token = token.concat(" ").concat(mSharedData.getString("Auth_token", ""));
        text_Cancel.setPaintFlags(text_Cancel.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        // ::::::::::::::: OnclickListner ::::::::::::::::::::::
        button_submit.setOnClickListener(this);
        text_Cancel.setOnClickListener(this);
    }
    public void cancel(View view){
        finish();
    }


    private void  initObjects()
    {
        editText_Login=(EditText)findViewById(R.id.editText_Login);
        text_Cancel=(TextView) findViewById(R.id.text_Cancel);
        button_submit=(Button) findViewById(R.id.button_submit);
        mSharedData=new ShareData(ForgetPassScreenActivity.this);
        dialogProgress = new ProgressDialog(ForgetPassScreenActivity.this);
        dialogProgress.setMessage("Please Wait...");
        dialogProgress.setCancelable(false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button_submit:
                String emailId=editText_Login.getText().toString().trim();
                if (editText_Login.getText().toString().isEmpty()) {
                    Toast.makeText(ForgetPassScreenActivity.this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    editText_Login.startAnimation(shake);
                }
                else if(!emailId.matches(emailPattern))
                {
                    Toast.makeText(ForgetPassScreenActivity.this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    editText_Login.startAnimation(shake);
                }
                else
                {
                    dialogProgress.show();
                    checkForgetUserThread();
                }
                break;
            case R.id.text_Cancel:
                finish();
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
        }
    }


    private void checkForgetUserThread() {
        String url = Urls.FORGETPASSUSER;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("EmailId",editText_Login.getText().toString());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    dialogProgress.dismiss();
                    Log.e("forgrtResponse","forgrtResponse"+response);
                    try {
                        /*mStatus=response.getBoolean("Status");
                        if(mStatus)
                        {
                            Intent ForgetPassIntent = new Intent(ForgetPassScreenActivity.this,LoginScreenActivity.class);
                            startActivity(ForgetPassIntent);
                            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                            Toast.makeText(ForgetPassScreenActivity.this,response.getString("Message"),Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(ForgetPassScreenActivity.this,response.getString("Message"),Toast.LENGTH_SHORT).show();
                        }*/
                    }catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("jsonResponse","JsonResponse"+error);
                    dialogProgress.dismiss();
                    if (error instanceof TimeoutError) {
                        Toast.makeText(getApplicationContext(), "Session Time out, Please SignUp Again...", Toast.LENGTH_LONG).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(getApplicationContext(), "Server Authorization Failed", Toast.LENGTH_LONG).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(getApplicationContext(), "Server Error, please try after some time later", Toast.LENGTH_LONG).show();
                    } else if (error instanceof NetworkError) {
                        Toast.makeText(getApplicationContext(), "Network not Available", Toast.LENGTH_LONG).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(getApplicationContext(), "JSONArray Problem", Toast.LENGTH_LONG).show();

                    }
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    final Map<String, String> headers = new HashMap<>();
                    headers.put("Authorization",token);
                    return headers;
                }
            };

            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                    5000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}