package com.example.registrationform;

import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final String EXTRA_MESSAGE = "com.example.registrationform.MESSAGE";
	public EditText login;
    public EditText email;
    public EditText password;
    public EditText cpassword;
    public RadioButton female;
    public CheckBox agree;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		login=(EditText) findViewById(R.id.login);
		email=(EditText) findViewById(R.id.email);
		password=(EditText) findViewById(R.id.password);
		cpassword=(EditText) findViewById(R.id.password_confirm);
		female=(RadioButton) findViewById(R.id.female);
		agree=(CheckBox) findViewById(R.id.agreement);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	public void send(View view){
		login.setBackgroundColor(Color.TRANSPARENT);
		password.setBackgroundColor(Color.TRANSPARENT);
		cpassword.setBackgroundColor(Color.TRANSPARENT);
		email.setBackgroundColor(Color.TRANSPARENT);
		boolean valid=checkAll();
		if (valid){
			Intent intent=new Intent(this,ShowActivity.class);
			String extras[]=new String[4];
			extras[0]=login.getText().toString();
			extras[1]=email.getText().toString();
			extras[2]=password.getText().toString();
			extras[3]=female.isChecked()?"female":"male";
			intent.putExtra(EXTRA_MESSAGE, extras);
			startActivity(intent);
			
		}
	}

	private boolean checkAll() {
		// TODO Auto-generated method stub
		
		if (!valid_login() || !valid_password() || !valid_email() || !agree.isChecked() || !password.getText().toString().equals(password.getText().toString())){
			 if(!valid_login())
			 {
				login.setBackgroundColor(Color.RED);
				 
			 }
			
			 if(!valid_password()){
				 
				 password.setBackgroundColor(Color.RED);
			 }
			
			 if(!valid_email()){
				 email.setBackgroundColor(Color.RED);
				 
			 }
			 
			 if( !password.getText().toString().equals(cpassword.getText().toString())){
				 cpassword.setBackgroundColor(Color.RED);
				 
				 
			 }
			 if(!agree.isChecked()){
				 Toast.makeText(getApplicationContext(), "to register you have to accept agreement",Toast.LENGTH_SHORT ).show();
				 
			 }
			 
			return false;}
		return true;
	}

	public boolean valid_email() {
		// TODO Auto-generated method stub
		boolean bool=true;
		String em=email.getText().toString();
		if(em.indexOf('@')<0) return false;
		StringTokenizer stk=new StringTokenizer(em,"@");
		String log=stk.nextToken();
		String domen=stk.nextToken();
		if(log.length()<4) return false;
		if(domen.length()<6) return false;
		if(domen.indexOf('.')<0) return false;
		for (int i = 0; i < log.length(); i++) {
			char c=log.charAt(i);
			if (!(  (c>='a' && c<='z')  || (c>='A' && c<='Z') || (c>='0' && c<='9')|| c=='.' || c=='-' || c=='_')) return false;
		}
		char f=log.charAt(0);
		  if(f=='.' || f=='-' || f=='_') return false;
		f=log.charAt(log.length()-1);
		  if(f=='.' || f=='-' || f=='_') return false;
		
		  for (int i = 1; i < log.length()-1; i++) {
			char c=log.charAt(i);
			char c1=log.charAt(i+1);
			if((c=='.' || c=='-' || c=='_') && (c1=='.' || c1=='-' || c1=='_') ) return false;
		}
		
		
		StringTokenizer s=new StringTokenizer(domen,".");
	    String dom="";
		for (int i = 0; i <=s.countTokens(); i++) {
			dom=s.nextToken();
			if(dom.length()<2) return false;
			for (int j = 0; j < dom.length(); j++) {
				char c=dom.charAt(j);
				if (!(  (c>='a' && c<='z')  || (c>='A' && c<='Z'))) return false;
			}
		}
		
		
	
		return bool;
	}

	private boolean valid_password() {
		// TODO Auto-generated method stub
		String pass=password.getText().toString();
		for (int i = 0; i < pass.length(); i++) {
			char c=pass.charAt(i);
			if (!(  (c>='a' && c<='z')  || (c>='A' && c<='Z') || (c>='0' && c<='9')   )) return false;
		}
		return true;
	}

	private boolean valid_login() {
		// TODO Auto-generated method stub
		String log=login.getText().toString();
		for (int i = 0; i < log.length(); i++) {
			char c=log.charAt(i);
			if (!(  (c>='a' && c<='z')  || (c>='A' && c<='Z') || (c>='0' && c<='9')   )) return false;
		}
		return true;
	}

}
