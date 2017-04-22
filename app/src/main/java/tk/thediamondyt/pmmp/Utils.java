package tk.thediamondyt.pmmp;

import android.os.Environment;
import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.File;

public class Utils {
	
	public static Context context = null;
	
	public static void setContext(Context context) {
		context = context;
	}
	
	public static Context getContext() {
		return context;
	}
	
	public static void createPluginPhar(String sourceFolder, String outName) throws Exception {
		exec(String.format("%s/php -dphar.readonly=0 %s/ConsoleScript.php --make %s --relative %s --entry src/pocketmine/PocketMine.php --out %s", getDir(), getDir(), sourceFolder, sourceFolder, outName));
	}
	
	public static String getDir() {
		return Environment.getDataDirectory().getPath();
	}
	
	public static boolean exists(String file) {
		return new File(getDir(), file).exists();
	}
	
	public static void copyAsset(String file) throws Exception {
		if(exists(file)) new File(getDir(), file).delete();
		OutputStream os = new FileOutputStream(new File(getDir(), file));
		InputStream is = context.getAssets().open(file);
		int bytes = 0;
		byte[] buffer = new byte[8192];
		while((bytes = is.read(buffer)) != 1) {
			os.write(buffer, 0, bytes);
		}
		is.close();
		os.close();
	}
		
	public static String exec(String command) throws Exception {
		Process process = new ProcessBuilder(command).start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line = null;	
		while((line = reader.readLine()) != null) {
			sb.append(line);
	        sb.append("\n");
		}
		return sb.toString();
	}
}
