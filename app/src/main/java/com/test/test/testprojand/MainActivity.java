package com.test.test.testprojand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.Button;

import com.test.test.testprojand.AsyncTaskPackage.AsyncInterface;
import com.test.test.testprojand.AsyncTaskPackage.AsyncTaskGetData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button button;
    String strUrl;
    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    CardView cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);
        cardView4 = findViewById(R.id.cardView4);

        SetCardViewListener();

        Utils.SetActionBarDetail(MainActivity.this, "NYT");

    }


    //region set listener
    public void SetCardViewListener(){
        cardView1.setOnClickListener(view -> {
            AsyncTaskGetData asyncTaskGetData = new AsyncTaskGetData(MainActivity.this, new AsyncInterface() {
                @Override
                public void AsyncResult(Object result, Boolean isSuccess) {
                    if (isSuccess) {
                        try {
                            Object object = new JSONTokener(result.toString()).nextValue();
                            System.out.println("object 222 : " + ((JSONObject)((JSONArray)((JSONObject)((JSONObject)object).get("response")).get("docs")).get(8)).get("pub_date"));
                            System.out.println("object 222 : " + ((JSONObject)((JSONArray)((JSONObject)((JSONObject)object).get("response")).get("docs")).get(8)).get("abstract"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            asyncTaskGetData.execute(setCommonHttp("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=QhYmHzOevePoHl6pMWoRGcR4SGGpRh8f"), setRequestProperty());
        });

        cardView2.setOnClickListener(view -> {
            AsyncTaskGetData asyncTaskGetData = new AsyncTaskGetData(MainActivity.this, (result, isSuccess) -> {
                if (isSuccess) {
                    try {
                        Object object = new JSONTokener(result.toString()).nextValue();
                        System.out.println("object : " + ((JSONObject)object).get("response"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            asyncTaskGetData.execute(setCommonHttp("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=QhYmHzOevePoHl6pMWoRGcR4SGGpRh8f"), setRequestProperty());
        });

        cardView3.setOnClickListener(view -> {
            AsyncTaskGetData asyncTaskGetData = new AsyncTaskGetData(MainActivity.this, (result, isSuccess) -> {
                if (isSuccess) {
                    try {
                        Object object = new JSONTokener(result.toString()).nextValue();
                        System.out.println("object : " + ((JSONObject)object).get("response"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            asyncTaskGetData.execute(setCommonHttp("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=QhYmHzOevePoHl6pMWoRGcR4SGGpRh8f"), setRequestProperty());
        });

        cardView4.setOnClickListener(view -> {
            AsyncTaskGetData asyncTaskGetData = new AsyncTaskGetData(MainActivity.this, (result, isSuccess) -> {
                if (isSuccess) {
                    try {
                        Object object = new JSONTokener(result.toString()).nextValue();
                        System.out.println("object : " + ((JSONObject)object).get("response"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            asyncTaskGetData.execute(setCommonHttp("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=QhYmHzOevePoHl6pMWoRGcR4SGGpRh8f"), setRequestProperty());
        });

    }
    //endregion

    //region common function
    public HashMap setCommonHttp(String strUrl) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("URL",strUrl);
        hashMap.put("setConnectTimeout","15000");
        return hashMap;
    }


    public HashMap setRequestProperty() {
        HashMap<String, Object> hashMapRequestProperty = new HashMap<>();
        hashMapRequestProperty.put("Content-Type", "application/json");
        hashMapRequestProperty.put("Content-Encoding", "gzip");
        return  hashMapRequestProperty;
    }
    //endregion

}