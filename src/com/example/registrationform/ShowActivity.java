package com.example.registrationform;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ShowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		Intent intent=getIntent();
		String extras[]=intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE);
		TextView login=(TextView) findViewById(R.id.login_registered);
		TextView email=(TextView) findViewById(R.id.email_registered);
		TextView password =(TextView) findViewById(R.id.password_registered);
		TextView gender=(TextView) findViewById(R.id.gender_registered);
		login.setText("Your login : "+extras[0]);
		email.setText("Your email : "+extras[1]);
		password.setText("Your password : :"+extras[2]);
		gender.setText("Your gender : "+extras[3]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_show, menu);
		return true;
	}

}
