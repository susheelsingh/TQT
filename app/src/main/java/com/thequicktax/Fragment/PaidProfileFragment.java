package com.thequicktax.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.thequicktax.Activity.LoginScreenActivity;
import com.thequicktax.Activity.SignupScreenActivity;
import com.thequicktax.Common.ShareData;
import com.thequicktax.Common.Urls;
import com.thequicktax.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PaidProfileFragment extends Fragment implements View.OnClickListener {
   View mView;
   EditText edt_Firstname,edt_Lastname,edtDob,edt_moblieNmuber,edt_Email,edt_PanCardNumber,edt_AdharNumber,
           edt_AlternateMobileNo,edt_Location;
   Button button_profileSubmit;
    private ShareData mSharedData;
    private String token = null;
    ProgressDialog dialogProgress = null;
    boolean mStatus;

    public PaidProfileFragment() {
        // Required empty public constructor
    }

    public static PaidProfileFragment newInstance(String param1, String param2) {
        PaidProfileFragment fragment = new PaidProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Profile");
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_paid_profile, container, false);
        initObjects();
        token = mSharedData.getString("Auth_token_type", "");
        token = token.concat(" ").concat(mSharedData.getString("Auth_token", ""));

        // :::::::::::::: OnclickButtonSubmit::::::::::::::::::::
        button_profileSubmit.setOnClickListener(this);
        return  mView;
    }

    private void initObjects()
    {
        edt_Firstname=(EditText)mView.findViewById(R.id.edt_Firstname);
        edt_Lastname=(EditText)mView.findViewById(R.id.edt_Lastname);
        edtDob=(EditText)mView.findViewById(R.id.edtDob);
        edt_moblieNmuber=(EditText)mView.findViewById(R.id.edt_moblieNmuber);
        edt_Email=(EditText)mView.findViewById(R.id.edt_Email);
        edt_PanCardNumber=(EditText)mView.findViewById(R.id.edt_PanCardNumber);
        edt_AdharNumber=(EditText)mView.findViewById(R.id.edt_AdharNumber);
        edt_AlternateMobileNo=(EditText)mView.findViewById(R.id.ResidentialStatus);
        edt_Location=(EditText)mView.findViewById(R.id.edt_EmployerType);
        button_profileSubmit=(Button)mView.findViewById(R.id.button_profileSubmit);
        mSharedData=new ShareData(getActivity());
    }

    @Override
    public void onClick(View v) {
        if(edt_Firstname.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Please enter your first name", Toast.LENGTH_SHORT).show();
        }else if(edt_Lastname.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Please enter your last name", Toast.LENGTH_SHORT).show();
        }else if(edtDob.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Please enter your date of birth", Toast.LENGTH_SHORT).show();
        }else if(edt_Email.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Please enter your email id", Toast.LENGTH_SHORT).show();
        }else if(edt_moblieNmuber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Please enter your mobile number", Toast.LENGTH_SHORT).show();
        }else if(edt_PanCardNumber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Please enter your pancar number", Toast.LENGTH_SHORT).show();
        }else if(edt_AdharNumber.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Please enter your adhar number", Toast.LENGTH_SHORT).show();
        }else if(edt_AlternateMobileNo.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Please enter your alternate mobile number", Toast.LENGTH_SHORT).show();
        }else if(edt_Location.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Please enter your location", Toast.LENGTH_SHORT).show();
        }else {
            updateProfileThread();
        }

    }

    private void updateProfileThread() {
        String url = Urls.UPDATEPROFILE;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("UserId","1");
            jsonObject.put("FirstName",edt_Firstname.getText().toString());
            jsonObject.put("MiddleName","");
            jsonObject.put("LastName",edt_Lastname.getText().toString());
            jsonObject.put("DOB","05-Nov-87 11:36:41 PM");
            jsonObject.put("EmailId",edt_Email.getText().toString());
            jsonObject.put("MobileNo",edt_moblieNmuber.getText().toString());
            jsonObject.put("AltMobileNo",edt_AlternateMobileNo.getText().toString());
            jsonObject.put("PanNo",edt_PanCardNumber.getText().toString());
            jsonObject.put("AdharNo",edt_AdharNumber.getText().toString());
            jsonObject.put("Address",edt_Location.getText().toString());

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    dialogProgress.dismiss();
                    Log.e("jsonResponse","JsonResponse"+response);
                    try {
                        mStatus=response.getBoolean("Status");
                        if(mStatus)
                        {

                        }
                        else
                        {
                            Toast.makeText(getActivity(),response.getString("Message"),Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(getActivity(), "Session Time out, Please SignUp Again...", Toast.LENGTH_LONG).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(getActivity(), "Server Authorization Failed", Toast.LENGTH_LONG).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(getActivity(), "Server Error, please try after some time later", Toast.LENGTH_LONG).show();
                    } else if (error instanceof NetworkError) {
                        Toast.makeText(getActivity(), "Network not Available", Toast.LENGTH_LONG).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(getActivity(), "JSONArray Problem", Toast.LENGTH_LONG).show();

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

            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}