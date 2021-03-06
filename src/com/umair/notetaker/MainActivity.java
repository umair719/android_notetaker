package com.umair.notetaker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private boolean isInEditMode = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button saveButton = (Button) findViewById(R.id.saveButton);

		saveButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText titleEditText = (EditText) findViewById(R.id.titleEditText);
				EditText noteEditText = (EditText) findViewById(R.id.noteEditText);
				// EditText dateTextView =
				// (EditText)findViewById(R.id.dateTextView);

				if (isInEditMode) {
					isInEditMode = false;
					saveButton.setText("Edit");
					titleEditText.setEnabled(false);
					noteEditText.setEnabled(false);

					TextView dateTextView = (TextView) findViewById(R.id.dateTextView);

					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"dd-MM-yyyy HH:mm:ss");
					String date = dateFormat.format(Calendar.getInstance()
							.getTime());
					dateTextView.setText(date);

				} else {
					isInEditMode = true;
					saveButton.setText("Save");
					titleEditText.setEnabled(true);
					noteEditText.setEnabled(true);
				}

				// dateTextView.setEnabled(false);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
