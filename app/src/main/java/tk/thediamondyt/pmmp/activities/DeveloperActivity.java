package tk.thediamondyt.pmmp.activities;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;

import android.os.Bundle;
import android.content.DialogInterface;

import tk.thediamondyt.pmmp.R;
import tk.thediamondyt.pmmp.Utils;
import tk.thediamondyt.pmmp.tasks.CreatePharTask;

public class DeveloperActivity extends AppCompatActivity {
String e = "";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_install);
		Utils.setContext(this);
		String k = "";
		try {
		    new CreatePharTask(this).execute("t", "t");
			k = Utils.exec("logcat");

			//new AlertDialog.Builder(this).setTitle("Error").setMessage(k).create().show();
	    } catch (Exception ex) {
		
				//String k = Utils.exec("logcat");
			
			new AlertDialog.Builder(this).setTitle("Error").setMessage(ex.getMessage() + "\n\n" + e).create().show();
		
		}
	}
	
	public void a(String k) {
		e += k;
	}
}
