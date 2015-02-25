package net.kvamstadsolutions.urbandict.advanced;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import net.kvamstadsolutions.urbandict.R;
import net.kvamstadsolutions.urbandict.advanced.adapter.UrbanWordListAdapter;
import net.kvamstadsolutions.urbandict.advanced.backend.AsyncCallback;
import net.kvamstadsolutions.urbandict.advanced.backend.Backend;
import net.kvamstadsolutions.urbandict.data.UrbanWord;

public class UrbanWordListActivity extends Activity {

	private static final String TAG = "UrbanWordListActivity";
	private String searchTerm;

	private ListView wordList;
	private UrbanWordListAdapter adapter;
	//ArrayAdapter<UrbanWord> adapter2;
	private Backend backend;
	private AsyncCallback<List<UrbanWord>> callback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_urban_word_list);

		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		if (b.containsKey("query")) {
			searchTerm = b.getString("query");
			Log.d(TAG, "Received searchTerm: " + searchTerm);
		}

		bindViews();

		bind();

		backend = new Backend();

		//adapter2 = new ArrayAdapter<UrbanWord>(this, android.R.layout.simple_list_item_1);
		adapter = new UrbanWordListAdapter(this, R.layout.urban_word_list_item, new ArrayList<UrbanWord>());
		wordList.setAdapter(adapter);

		
		search();
		
		//Generate words
		//generateExample();
	}

	private void generateExample() {
		List<UrbanWord> words = backend.generateUrbanWords();
		for(UrbanWord word : words) {
			adapter.add(word);
		}
	}

	private void search() {
		backend.lookupUrbanWords(callback, searchTerm);
		//TEST
	}

	private void bindViews() {
		wordList = (ListView) findViewById(R.id.wordList);
	}

	private void bind() {
		callback = new AsyncCallback<List<UrbanWord>>() {
			
			@Override
			public void onSuccess(final List<UrbanWord> result) {
			
				Log.d(TAG, "Success! Received: " + result.size() + " items!");
				/**
				 * Here we have to use a special method called runOnUiThread()
				 * because our backend call runs on another thread.
				 */
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						for (UrbanWord word : result) {
							adapter.add(word);
						}
					}
				});
			
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Log.w(TAG, "Failed to load resources!");
			}
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_search_result, menu);
		return true;
	}

}
