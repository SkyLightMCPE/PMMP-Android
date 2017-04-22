package tk.thediamondyt.pmmp.activities;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;

import android.os.Bundle;
import android.content.DialogInterface;

import tk.thediamondyt.pmmp.R;
import tk.thediamondyt.pmmp.Utils;

public class InstallActivity extends AppCompatActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_install);
		Utils.setContext(this);
		
	}
	
	private void install() {	
		if(Utils.exists("php") || Utils.exists("ConsoleScript.php")) {
			new AlertDialog.Builder(this).setCancelable(false)
			    .setTitle("Already installed!").setMessage("Hey, joe. It looks like everything is already installed!")
				.setPositiveButton("Install again", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int p1) {
						install();
					}
				})
				.setNegativeButton("Back", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int p1) {
						finish();
					}
				}).create().show();
			return;
		}
		try {
		    Utils.copyAsset("php");
			Utils.copyAsset("ConsoleScript.php");
	    } catch(Exception ex) {
			
		}
	}
}
