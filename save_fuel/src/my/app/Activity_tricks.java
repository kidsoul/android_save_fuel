package my.app;

import items_choose.Tricks_items;

import java.util.ArrayList;

import customLayout.tricksLayout_custom;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity_tricks extends Activity {

	private ListView lvTricks;
	private ArrayList<String> arrTricks = null;
	private ArrayAdapter<String> adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tricks);

		lvTricks = (ListView) findViewById(R.id.lv_tricks);
		arrTricks = new ArrayList<String>();
		adapter = new tricksLayout_custom(Activity_tricks.this,
				R.layout.tricks_layout, arrTricks);
		lvTricks.setAdapter(adapter);

		showTricks();
		lvTricks.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				
				String title_send = arrTricks.get(pos);
				int position = pos;
				Intent intent = new Intent(Activity_tricks.this, Tricks_items.class);
				Bundle bundle = new Bundle();
				// post value
				bundle.putString("item_title", title_send);
				bundle.putInt("pos", position);
				
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}

	private void showTricks() {
		arrTricks.add("Không thúc ga");
		arrTricks.add("Chọn loại xe phù hợp");
		arrTricks.add("Đi đúng tốc độ, tránh bốc đồng");
		adapter.notifyDataSetChanged();
	}

}
