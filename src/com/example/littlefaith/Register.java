package com.example.littlefaith;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

@SuppressLint("NewApi")
public class Register extends Activity {
	EditText email,username,password,passconfirm;
	Spinner department;
	Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		StrictMode.ThreadPolicy policy = new StrictMode.
				ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy); 
				
		//initialize the elements
		email = (EditText)findViewById(R.id.emailreg);
		username = (EditText)findViewById(R.id.usernamereg);
		password = (EditText)findViewById(R.id.passwordreg);
		passconfirm = (EditText)findViewById(R.id.passconfirm);
		
		department = (Spinner)findViewById(R.id.department);
		submit = (Button)findViewById(R.id.registerdone);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.department_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
        department.setAdapter(adapter);
        
        
        submit.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub email,username,password,passconfirm;
				
				String _department = department.getSelectedItem().toString();
				String _email = email.getText().toString();
				String _username = username.getText().toString();
				String _password = password.getText().toString();
				String _passconfirm = passconfirm.getText().toString();
				DataPost post = new DataPost();
				JSONObject _json = new JSONObject();
				try {
					_json.put("try", 1);
					_json.put("email", _email);
					_json.put("name", _username);
					_json.put("password", _password);
					_json.put("department", _department);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(_email.length()<1||_username.length()<1||_password.length()<1||_passconfirm.length()<1){ 
					DialogFragment newFragment = new DialogAlerting("Got field not filled!");
				    newFragment.show(getFragmentManager(), "missiles1"); 
				}
				else{
					if(!_password.equals(_passconfirm)){
						DialogFragment newFragment = new DialogAlerting("Retype your pass!");
					    newFragment.show(getFragmentManager(), "missiles1"); 
					}else{ 
						post.postData(_json);
						String error = post.stringReturned();
						//to remind the user that the email has been registered
						if(error.contains("PRIMARY")){
							DialogFragment newFragment = new DialogAlerting("Email has been registered");
						    newFragment.show(getFragmentManager(), "missiles1"); 
						}
						if(error.equals("success")){
							Intent i = new Intent(Register.this,CalendarView.class);
							startActivity(i); 
						}
					}
				} 
				
	
				
			}
        	
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
