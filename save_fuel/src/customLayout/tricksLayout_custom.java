package customLayout;

import java.util.ArrayList;
import java.util.List;

import my.app.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class tricksLayout_custom extends ArrayAdapter<String>{

	private Activity context = null;
	private int layoutId = 0;
	private ArrayList<String> arrTricks = null;
	
	/*private ImageView iv;
	private TextView tv;*/
	
	public tricksLayout_custom(Activity ct, int textViewResourceId,
			ArrayList<String> objects) {
		super(ct, textViewResourceId, objects);
		this.arrTricks = objects;
		this.context = ct;
		this.layoutId = textViewResourceId;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = context.getLayoutInflater();
		convertView = inflater.inflate(layoutId, null);
		if(arrTricks.size() > 0 && position >= 0){
			final ImageView iv = (ImageView) convertView.findViewById(R.id.iv_tricks);
			final TextView tv = (TextView) convertView.findViewById(R.id.tv_tricks);
			
			final String tmp = arrTricks.get(position);
			tv.setText(tmp);
			iv.setImageResource(R.drawable.pick_saving);
		}
		
		return convertView;
	}
}
