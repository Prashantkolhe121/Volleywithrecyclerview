package polyglotcoders.org.com.volleyapplication;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BackgroundTask {
    Context context;
    String jsonUrl = "http://192.168.43.237:8080/mobileunbrick/info.php";

    ArrayList<Contact> arrayList = new ArrayList<>();

    public BackgroundTask(Context context)
    {
        this.context = context;
    }
    public ArrayList<Contact> getList()
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, jsonUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               int count = 0;
               while (count<response.length())
               {
                   try {
                       JSONObject jsonObject = response.getJSONObject(count);
                       Contact contact = new Contact(jsonObject.getString("name"),jsonObject.getString("price"));
                       arrayList.add(contact);
                       count++;
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show();
               error.printStackTrace();
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
        return arrayList;
    }

}
