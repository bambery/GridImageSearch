package wszolek.lauren.imagesearch;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ResultActivity extends AppCompatActivity {
    private GridView gvResults;
    private ArrayList<ImageResult> imageResults;
    private ImageResultAdapter irAdapter;
    private static final String BASE_URL = "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=8&q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageResults = new ArrayList<ImageResult>();
        irAdapter = new ImageResultAdapter(this, imageResults);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // set up the listener for when the search is performed
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // perform query here
                searchImages(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    private void searchImages(String query) {
        AsyncHttpClient client = new AsyncHttpClient();
        try {
            client.get(BASE_URL + URLEncoder.encode(query, "utf-8"), new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    try {
                        JSONArray results = null;
                        JSONObject imagesJSON = response.getJSONObject("responseData");
                        if(response != null){
                            results = imagesJSON.getJSONArray("results");
                            // results will never be null, if no results length with be 0
                            for(int i = 0; i < results.length(); i++) {
                                JSONObject imageJSON = results.getJSONObject(i);
                                ImageResult image = new ImageResult();
                                image.height = Integer.getInteger(imageJSON.getString("height"));
                                image.width = Integer.getInteger(imageJSON.getString("width"));
                                image.url = imageJSON.getString("url");
                                image.tbUrl = imageJSON.getString("tbUrl");
                            }
                        }
                    } catch (JSONException e) {
                        // Invalid JSON format, show appropriate error.
                        e.printStackTrace();
                    }
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
