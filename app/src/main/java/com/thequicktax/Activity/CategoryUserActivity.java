package com.thequicktax.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thequicktax.R;

public class CategoryUserActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_CaLogin,button_TaxUser,button_Bt_Admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_user);
        initObjects();
        //:::::::::::: OncliclkListner:::::::::::

        button_CaLogin.setOnClickListener(this);
        button_TaxUser.setOnClickListener(this);
        button_Bt_Admin.setOnClickListener(this);

    }
    private void initObjects()
    {
        button_CaLogin=(Button)findViewById(R.id.button_CaLogin);
        button_TaxUser=(Button)findViewById(R.id.button_TaxUser);
        button_Bt_Admin=(Button)findViewById(R.id.button_Bt_Admin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_CaLogin:
                Intent CaLogingIntent = new Intent(CategoryUserActivity.this, LoginScreenActivity.class);
                CaLogingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(CaLogingIntent);
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                break;
            case R.id.button_TaxUser:
                Intent TaxUserIntent = new Intent(CategoryUserActivity.this, LoginScreenActivity.class);
                TaxUserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(TaxUserIntent);
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                break;
            case R.id.button_Bt_Admin:
                Intent AdminIntent = new Intent(CategoryUserActivity.this, LoginScreenActivity.class);
                AdminIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(AdminIntent);
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                break;
        }
    }
}