package net.kvamstadsolutions.urbandict;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.kvamstadsolutions.urbandict.data.UrbanWord;
import net.kvamstadsolutions.urbandict.util.TestUtil;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;


public class SearchResultActivity extends ActionBarActivity {

    private static final String TAG = "SearchResult";

    TextView searchTitle;
    ListView listView;

    ArrayAdapter<UrbanWord> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        Bundle extras = getIntent().getExtras();
        String query = extras.getString("query");
        Log.d(TAG, "Retrieved query: " + query);

        searchTitle = (TextView) findViewById(R.id.title);

        searchTitle.setText("Searched for: " + query);

        listView = (ListView) findViewById(R.id.result_list);

        List<UrbanWord> urbanWords = TestUtil.generateUrbanWords();

        adapter = new ArrayAdapter<UrbanWord>(this, android.R.layout.simple_list_item_1, urbanWords);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(SearchResultActivity.this, "Clicked: " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SearchResultActivity.this, UrbanWordActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
