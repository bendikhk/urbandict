package net.kvamstadsolutions.urbandict.advanced.backend.urbandict;

import java.util.List;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.kvamstadsolutions.urbandict.data.SearchResult;
import net.kvamstadsolutions.urbandict.data.UrbanWord;

public class UrbDictRestClientUtils {

	private static final String TAG = "UrbDictRestClientUtils";

	public static List<UrbanWord> ListUrbanWordsFromJson(String json) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		SearchResult searchResult = gson.fromJson(json, SearchResult.class);
		
		List<UrbanWord> words = searchResult.getList();
		
		for(UrbanWord word : words) {
			Log.d(TAG, word.toString());
		}
		
		return words;
	}
}
