package net.kvamstadsolutions.urbandict.advanced.backend.urbandict;

import java.util.List;

import android.util.Log;


import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import net.kvamstadsolutions.urbandict.advanced.backend.AsyncCallback;
import net.kvamstadsolutions.urbandict.data.UrbanWord;

public class UrbDictRestClientUsage {

	private static final String TAG = "UrbDictClientUsage";

	public void getLookupWord(final AsyncCallback<List<UrbanWord>> callback, String searchTerm) {

		
		Log.d(TAG, "looking up word!");
		String url = "define";
		// ?coordinates=(x=600000,y=6642000)&proposals=5;
		RequestParams params = new RequestParams();
		params.add("term", searchTerm);
		// params.add("coordinates", ;
		// params.add("coordinates", "(x=600000,y=6642000");
		UrbDictRestClient.get(url, params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {
				
				Log.d(TAG, "Received search result from API");
				// List<Stop> result =
				List<UrbanWord> result = UrbDictRestClientUtils.ListUrbanWordsFromJson(response);
				callback.onSuccess(result);
			}

		});

	}

}
