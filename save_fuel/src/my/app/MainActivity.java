package my.app;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		TabHost tab = getTabHost();
		//
			TabSpec ts_tricks = tab.newTabSpec("Tricks");
			ts_tricks.setIndicator("Tricks",
					getResources().getDrawable(R.drawable.pick_saving));
			Intent intent_image = new Intent(this, Activity_tricks.class);
			ts_tricks.setContent(intent_image);
		//
			TabSpec ts_note = tab.newTabSpec("Note");
			ts_note.setIndicator("Note",
					getResources().getDrawable(R.drawable.noting));
			Intent intent_song = new Intent(this, Activity_note.class);
			ts_note.setContent(intent_song);
		//
			TabSpec ts_analysis = tab.newTabSpec("Analysis");
			ts_analysis.setIndicator("Analysis", getResources().getDrawable(R.drawable.analysis));
			Intent intent_movie = new Intent(this, Activity_analysis.class);
			ts_analysis.setContent(intent_movie);
		//
			
		tab.addTab(ts_tricks);
		tab.addTab(ts_note);
		tab.addTab(ts_analysis);
		
		tab.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
