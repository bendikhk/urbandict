package net.kvamstadsolutions.urbandict;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import net.kvamstadsolutions.urbandict.data.UrbanWord;
import net.kvamstadsolutions.urbandict.util.TestUtil;


public class UrbanWordActivity extends ActionBarActivity {


    TextView urbanWord;
    TextView urbanDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urban_word);

        int position = getIntent().getExtras().getInt("position");

        UrbanWord word = TestUtil.generateUrbanWords().get(position);

        urbanWord = (TextView) findViewById(R.id.urban_word);
        urbanDescription = (TextView) findViewById(R.id.urban_description);

        urbanWord.setText(word.getDefinition());
        urbanDescription.setText(word.getExample());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_urban_word, menu);
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
