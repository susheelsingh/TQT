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
import com.thequicktax.Pozo.User;
import com.thequicktax.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignupScreenActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText_Login,editText_Email,editText_MobileNumber,editText_Password,editText_ConfirmPassword;
    Button button_signup;
    TextView text_Cancel,text_login;
    private ShareData mSharedData;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private String token = null;
    ProgressDialog dialogProgress = null;
    boolean mStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        initObjects();

        token = mSharedData.getString("Auth_token_type", "");
        token = token.concat(" ").concat(mSharedData.getString("Auth_token", ""));

        text_Cancel.setPaintFlags(text_Cancel.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // :::::::::::::::::::: OnclickListner :::::::::::::::::::::::::
        button_signup.setOnClickListener(this);
        text_Cancel.setOnClickListener(this);
        text_login.setOnClickListener(this);
    }

    public void cancel(View view){
        finish();
    }

    private void  initObjects()
    {
        editText_Login=(EditText)findViewById(R.id.editText_Login);
        editText_Email=(EditText)findViewById(R.id.editText_Email);
        editText_MobileNumber=(EditText)findViewById(R.id.editText_MobileNumber);
        editText_Password=(EditText)findViewById(R.id.editText_Password);
        editText_ConfirmPassword=(EditText)findViewById(R.id.editText_ConfirmPassword);
        text_Cancel=(TextView) findViewById(R.id.text_Cancel);
        button_signup=(Button) findViewById(R.id.button_signup);
        text_login=(TextView)findViewById(R.id.text_login);

        mSharedData=new ShareData(SignupScreenActivity.this);
        dialogProgress = new ProgressDialog(SignupScreenActivity.this);
        dialogProgress.setMessage("Please Wait...");
        dialogProgress.setCancelable(false);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.button_signup:

                String emailId=editText_Email.getText().toString().trim();
                if (editText_Login.getText().toString().isEmpty()) {
                    Toast.makeText(SignupScreenActivity.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    editText_Login.startAnimation(shake);

                } else if (editText_Email.getText().toString().isEmpty()) {
                    Toast.makeText(SignupScreenActivity.this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    editText_Email.startAnimation(shake);

                }
                else if(!emailId.matches(emailPattern))
                {
                    Toast.makeText(SignupScreenActivity.this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    editText_Email.startAnimation(shake);
                }
                else if (editText_MobileNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SignupScreenActivity.this, "Please Enter Valid MobileNo", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    editText_MobileNumber.startAnimation(shake);
                }
                else if(editText_MobileNumber.getText().toString().trim().length()<10)
                {
                    Toast.makeText(SignupScreenActivity.this, "Please Enter Valid MobileNo", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    editText_MobileNumber.startAnimation(shake);
                }
                else if(editText_Password.getText().toString().isEmpty())
                {
                    Toast.makeText(SignupScreenActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    editText_Password.startAnimation(shake);
                }
                else if(editText_ConfirmPassword.getText().toString().isEmpty())
                {
                    Toast.makeText(SignupScreenActivity.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    editText_ConfirmPassword.startAnimation(shake);
                }
                else {
                     dialogProgress.show();
                    registrationThread();
                }
                break;
            case R.id.text_Cancel:
                finish();
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.text_login:
                finish();
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
        }

    }

     private void registrationThread() {
        String url =Urls.BaseUrl+Urls.Register;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("LoginTypeID","1");
            jsonObject.put("Fullname",editText_Login.getText().toString());
            jsonObject.put("EmailId",editText_Email.getText().toString());
            jsonObject.put("MobileNo",editText_MobileNumber.getText().toString());
            jsonObject.put("Password",editText_Password.getText().toString());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    dialogProgress.dismiss();
                    Log.e("jsonResponse","JsonResponse"+response);
                    try {
                        mStatus=response.getBoolean("Status");
                        if(mStatus)
                        {
                            mSharedData.putBoolean("is_user_logged_in", true);
                           // mSharedData.putString("logged_fullName", editText_Login.getText().toString().trim());
                           // mSharedData.putString("logged_emailId", editText_Email.getText().toString().trim());
                            mSharedData.putString("logged_user",response.getString("UserId"));
                           // mSharedData.putString("logged_mobileNumber", editText_MobileNumber.getText().toString().trim());

                            startActivity(new Intent(SignupScreenActivity.this, LoginScreenActivity.class));
                            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                            Toast.makeText(SignupScreenActivity.this,response.getString("Message"),Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(SignupScreenActivity.this,response.getString("Message"),Toast.LENGTH_SHORT).show();
                        }
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