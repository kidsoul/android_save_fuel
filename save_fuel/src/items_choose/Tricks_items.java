package items_choose;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import my.app.R;
import my.app.R.layout;
import my.app.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.view.Gravity;
import android.view.Menu;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class Tricks_items extends Activity {

	private TextView tv_content_item;
	private int pos_received = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); */
		setContentView(R.layout.activity_tricks_items);
		/*
		 * getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
		 * R.layout.title_bar);
		 */
		tv_content_item = (TextView) findViewById(R.id.tv_item_content);
		// set Title
		Bundle bun = getIntent().getExtras();
		// receive value
		String title_received = bun.getString("item_title");
		pos_received = bun.getInt("pos");

		this.setTitle(title_received);
		// get Content from file
		getData(pos_received);
	}

	private void getData(int pos_received) {
		int data_pos = 0;
		switch (pos_received) {
		case 0:
			data_pos = R.drawable.dont_gas;
			break;
		case 1:
			data_pos = R.drawable.choose_motobyte;
			break;
		case 2:
			data_pos = R.drawable.make_a_rule;
			break;
		default:
			break;
		}
		try {
			String tmp = "";
			StringBuilder sb = new StringBuilder();
			InputStream is = this.getResources().openRawResource(data_pos);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			if (is != null) {
				while ((tmp = br.readLine()) != null) {
					sb.append(tmp + "\n");
				}
			}
			tv_content_item.setText(sb + "");
			is.close();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), e.getMessage(),
					Toast.LENGTH_SHORT).show();
			;
		}
	}
}
