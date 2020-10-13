package com.thequicktax.Common;
import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

class RequestQueueSingleton {
    private static RequestQueueSingleton requestQueueSingleton;
    private RequestQueue requestQueue;
    private static Context context;

    private RequestQueueSingleton(Context ctx){
        context = ctx;
        requestQueue = getRequestQueue();
    }

    public static synchronized  RequestQueueSingleton getInstance(Context context){
        if (requestQueueSingleton == null){
            requestQueueSingleton = new RequestQueueSingleton(context);
        }
        return requestQueueSingleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
}
