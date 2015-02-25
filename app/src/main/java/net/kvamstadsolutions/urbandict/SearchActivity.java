package net.kvamstadsolutions.urbandict;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.kvamstadsolutions.urbandict.advanced.UrbanWordListActivity;


public class SearchActivity extends ActionBarActivity {

    Button submitButton;
    Button advancedSubmitButton;
    EditText searchQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        submitButton = (Button) findViewById(R.id.submit);

        searchQuery = (EditText) findViewById(R.id.search_query);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = searchQuery.getText().toString();


                Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
                intent.putExtra("query", search);
                startActivity(intent);
                //Toast.makeText(SearchActivity.this, "Search: " + search, Toast.LENGTH_SHORT).show();
            }
        };

        submitButton.setOnClickListener(listener);

        advancedSubmitButton = (Button) findViewById(R.id.advancedSearch);
        advancedSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = searchQuery.getText().toString();
                Intent intent = new Intent(SearchActivity.this, UrbanWordListActivity.class);
                intent.putExtra("query", search);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
