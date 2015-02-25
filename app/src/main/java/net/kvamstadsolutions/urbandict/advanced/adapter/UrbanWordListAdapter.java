package net.kvamstadsolutions.urbandict.advanced.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.kvamstadsolutions.urbandict.R;
import net.kvamstadsolutions.urbandict.data.UrbanWord;


public class UrbanWordListAdapter extends ArrayAdapter<UrbanWord> {

	static class ViewHolder {
		TextView word;
		TextView description;
		TextView author;
		TextView thumbsUpCount;
		TextView thumbsDownCount;
	}

	private LayoutInflater inflater;
	private Activity activity;
	private List<UrbanWord> words;
	
	public UrbanWordListAdapter(Activity activity, int resource, List<UrbanWord> words) {
		super(activity, resource, words);
		this.activity = activity;
		this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		this.words = words;
	}

	@Override
	public View getView(int position, View v, ViewGroup parent) {
		ViewHolder holder;
		
		if (v == null) {
			holder = new ViewHolder();
			v = inflateViewType(R.layout.urban_word_list_item, holder);
			
		} else {
			holder = (ViewHolder) v.getTag();
		}
		
		UrbanWord word = words.get(position);
		
		holder.word.setText(word.getWord());
		holder.description.setText(word.getDefinition());
		holder.author.setText(word.getAuthor());
		holder.thumbsDownCount.setText("" + word.getThumbs_down());
		holder.thumbsUpCount.setText("" + word.getThumbs_up());
		
		return v;
	}
	
	private View inflateViewType(int itemViewType, ViewHolder holder) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(itemViewType, null);
		holder.word = (TextView) v.findViewById(R.id.urban_word);
		holder.description = (TextView) v.findViewById(R.id.urban_description);
		holder.author = (TextView) v.findViewById(R.id.urban_author);
		holder.thumbsDownCount = (TextView) v.findViewById(R.id.thumbs_down_count);
		holder.thumbsUpCount = (TextView) v.findViewById(R.id.thumbs_up_count);
		
		v.setTag(holder);
		return v;
	}
}
