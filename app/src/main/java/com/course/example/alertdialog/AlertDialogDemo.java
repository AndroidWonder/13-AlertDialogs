package com.course.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageView;
import android.view.Gravity;

public class AlertDialogDemo extends Activity {
	Button btnGo;
	EditText txtMsg;
	String msg;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtMsg =  (EditText)findViewById(R.id.txtMsg);
        
        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				
				//create dialog
		        AlertDialog dialog = new AlertDialog.Builder(AlertDialogDemo.this).create();
		        
		      //set message, title, and icon
	        	dialog.setTitle("Terminator"); 
	        	dialog.setMessage("Are you sure that you want to quit?"); 
	        	dialog.setIcon(R.drawable.ic_menu_end_conversation);
	        	
	        	//set three option buttons
	        	dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() { 
	        		public void onClick(DialogInterface dialog, int whichButton) { 
	            	 //whatever should be done when answering "YES" goes here
	        		 msg = "YES " + whichButton;
	        		 txtMsg.setText(msg);
	        		}              
	        	});//setPositiveButton
	        	
	        	dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() { 
	        		public void onClick(DialogInterface dialog, int whichButton) { 
	            	 //whatever should be done when answering "NO" goes here
	        		 msg = "NO " + whichButton;	
	        		 txtMsg.setText(msg); 
	             } 
	        	});//setNegativeButton
	        	
	        		dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Cancel",	new DialogInterface.OnClickListener() {
	        		public void onClick(DialogInterface dialog, int whichButton) {
	               	 //whatever should be done when answering "CANCEL" goes here
	        		 msg = "CANCEL " + whichButton;
	        		 txtMsg.setText(msg);
	        		}//OnClick
	        	});//setNeutralButton
	        		
			    dialog.show();
			    
			    //Note: In general,
			    //after showing a dialog you should have NO more 
			    //code. Let the buttons of the dialog box handle
			    //the rest of the logic. For instance, in this 
			    //example a dialog box is displayed (once shown
			    //you can not interact with the parent until the
			    //dialog is closed) however the code in the parent 
			    //continues to execute after the show() method is 
			    //called.
			    
				txtMsg.setText("I am here!");
				
				//Create Toast
				Toast toast = Toast.makeText(getApplicationContext(), 
						"Alert Dialog Box Example", Toast.LENGTH_LONG);
				toast.show();
			}
        	
        });
    }//onCreate
    
    //Display a toast with an image when activity is paused
    @Override
    protected void onPause(){
    	super.onPause();
    	Toast toast = Toast.makeText(this, "Toast with Image", Toast.LENGTH_LONG);
    	ImageView view = new ImageView(this);
    	view.setImageResource(R.drawable.image2);
    	toast.setView(view);
    	toast.show();
    }
    
}