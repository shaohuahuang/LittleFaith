package com.example.littlefaith;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;

public class FaithCheck extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faith_check);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.faith_check, menu);
		return true;
	}
	
	
	public void onCheckboxClicked(View view) {
	    // Is the view now checked?
	    boolean checked = ((CheckBox) view).isChecked();
	    
	    // Check which checkbox was clicked
	    switch(view.getId()) {
	        case R.id.bibleread:
	            if (checked)
	                // Put some meat on the sandwich 
	            	System.out.println("haha");
	                // Remove the meat
	            break;
	        case R.id.dawnprayer:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break;
	        case R.id.exercise:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break;
	        case R.id.keepawake:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break;
	        case R.id.praise:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break;
	        case R.id.sleep:
	            if (checked)
	                // Cheese me 
	            	System.out.println("haha1");
	                // I'm lactose intolerant
	            break; 
	        // TODO: Veggie sandwich
	    }
	}

}