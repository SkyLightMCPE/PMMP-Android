package tk.thediamondyt.pmmp.tasks;

import android.os.AsyncTask;
import android.content.Context;
import android.content.DialogInterface;
import android.app.ProgressDialog;

import tk.thediamondyt.pmmp.Utils;
import tk.thediamondyt.pmmp.activities.DeveloperActivity;

public class CreatePharTask extends AsyncTask<String, Integer, String> {
	
	public ProgressDialog dialog;
	public DeveloperActivity context;
	
	public CreatePharTask(DeveloperActivity context) {
		context = context;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		//DeveloperActivity ctx = context;
		context.a("* onPreExcute start\n");
		dialog = new ProgressDialog(context);
		//ctx.a("constructed progress dialog\n");
		dialog.setTitle("Packing phar archive");
		//ctx.a("set dialog title\n");
		dialog.setMessage("Getting ready...");
		dialog.setCancelable(true);
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setIndeterminate(true);
		dialog.create();
		//ctx.a("creating dialog\n");
		dialog.show();
		//ctx.a("dialog created\n");
	}

	@Override
	protected String doInBackground(String... params) {
		String result = "";
		//context.a("doInBackground called\n");
		/*try {
			// Worst code ever written
		    result = Utils.exec("%s/php -dphar.readonly=0 %s/ConsoleScript.php --make %s/src --relative %s --entry %s/src/pocketmine/PocketMine.php --out %s");
			   /* Utils.getDir(), // App dir
				Utils.getDir(), // App dir
				params[0], // Source path
				params[0], // Source path
				params[0], // Source path
				params[1] // Output phar name
			//);
	    } catch (Exception ex) {
			dialog.setMessage(ex.getMessage());
		}
		dialog.setMessage(result);*/
		return result;
	}
	
	@Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
    }
}
