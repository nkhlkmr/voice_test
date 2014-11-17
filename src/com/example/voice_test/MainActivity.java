package com.example.voice_test;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	static final int check=111;
	ListView lv;
//	TextView tv;
	ArrayList<String> results;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button_voice = (Button)findViewById(R.id.buttonvoice);
//		 tv = (TextView)findViewById(R.id.textresult);
		lv=(ListView)findViewById(R.id.listViewtest);
		button_voice.setOnClickListener(this);
//test_func();
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak up bitch!");
		startActivityForResult(i, check);
	//	tv.setText(i.toString());
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode==check && resultCode==RESULT_OK){
			results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			lv.setAdapter(new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1,results));
			//results.addAll(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
		} 
		test_func();
		super.onActivityResult(requestCode, resultCode, data);
		
	}
	
	public void test_func(){
		
		for (String x : results) {
			if(x=="test"){
				Toast.makeText(getApplicationContext(), "toast",Toast.LENGTH_LONG ).show();
		}
	//	results.clear();	
		}
	}
}
