package com.thequicktax.Threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.thequicktax.Common.ShareData;
import com.thequicktax.Common.Urls;
import com.thequicktax.Communications.Http;
import com.thequicktax.Listner.OnGetNewTokenListener;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;

public class GetAuthToken  extends AsyncTask<Void, Void, Integer> {
    private String jsonString;
    private int mSuccess;
    private String mAccessToken, mExpires, mTokenType;
   // private String mainToken = "Basic em93ZWRvX3Jlc3RfYXBpX2NsaWVudF8yODk0NTU6SzdNVDgwMVdRNVhQZ002VXNqd3FJSkFB";
    private String mainToken= "s-dDmM8u2dJ4sPLBaDvA5xZRHJ86GUshu9RmsYxwhMazB6swC7DbJPeZHIsE7FpFzHUPaH5DgzQOph4kpcrblqmQz8upitNYxxh9e_XdhVrumEm1XOE9ax4hEgcfwOVfUa6NYw0eHUQr_RpO1ucgpiAJg3L2sG5zC7r6mYZfLh7hzQ4t2zCE7lEzlNU1wQut9k9hnzBAuAJWT8wb3f0OB0y48u-LwOFmNV6dJ9LLJ0ief5t7BojATHErlGv0k_w4UbuzrwHskg8WHQvLzajpGQaOBUcAQ6cilttHTdy5JT3LjGqDfnkwKcmUg6g4fHGxPklx9vM0yYVSt77Mqht8xQ";
    private ShareData mShardData;
    private OnGetNewTokenListener onGetNewTokenListener;

    public GetAuthToken(Context context){
        mShardData = new ShareData(context);
        try{
            onGetNewTokenListener = (OnGetNewTokenListener) context;
        } catch (ClassCastException e){
            onGetNewTokenListener = null;
        }

    }
    private HashMap<String,String> getAuthMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("grant_type","password");
        map.put("Username","test1@test.com");
        map.put("Password","0x0001E240");
        return map;
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        Http http = new Http();
        jsonString = http.getAuthToken( Urls.Token,getAuthMap(),mainToken);
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            Log.e("Token Response is = ",jsonString);
            mShardData.putString("Auth_token",jsonObject.getString("access_token"));
            mShardData.putString("Auth_token_expires",jsonObject.getString("expires_in"));
            mShardData.putString("Auth_token_type",jsonObject.getString("token_type"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        if (onGetNewTokenListener != null)
            onGetNewTokenListener.onGetNewToken();
    }
}
