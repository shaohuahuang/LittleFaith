package com.example.littlefaith;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
 
@SuppressLint("NewApi")
public class Login extends Activity {
	Button register,login; 
	TextView username,password;
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		register = (Button)findViewById(R.id.register);
		login =(Button)findViewById(R.id.login);
		username = (TextView)findViewById(R.id.username);
		password = (TextView)findViewById(R.id.password);
		
		//to remember some data;
		final Help help = new Help(this);
		String name = help.getShared("email");
		if(!name.equalsIgnoreCase(""))
		{
		     username.setText(name);
		}
//		final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//		String name = preferences.getString("email","");
//	    if(!name.equalsIgnoreCase(""))
//		{
//		     username.setText(name);
//		}
		
		login.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String _username = username.getText().toString();
				String _password = password.getText().toString();
				final JSONObject _json = new JSONObject();
			
				try {
					_json.put("loginCheck", 1); 
					_json.put("email", _username);
					_json.put("password", _password); 
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(_username.length()<1||_password.length()<1){
					DialogFragment newFragment = new DialogAlerting("Got field not filled!");
				    newFragment.show(getFragmentManager(), "missiles1"); 
				}else{
					Thread t = new Thread(){
						public void run(){ 
							DataPost post = new DataPost();
							post.postData(_json);
							String msg = post.stringReturned();
							
							if(msg.equals("wrong email")){
								DialogFragment newFragment = new DialogAlerting("Email not correct!");
							    newFragment.show(getFragmentManager(), "missiles1"); 
							}
							if(msg.equals("password not correct")){
								DialogFragment newFragment = new DialogAlerting("Password does not match");
							    newFragment.show(getFragmentManager(), "missiles1"); 
							}
							if(msg.contains("Login Sucessfully")){
								
								help.setShared("email", _username);
								Intent i = new Intent(Login.this,CalendarView.class);
								startActivity(i);
							}
						}
					};
					t.start();
					
					
				}
				
				
			}
			
		});
		
		register.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent i = new Intent(Login.this,Register.class);
				startActivity(i);
			}
 
		}); 

	}  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
}
	 
 
