package tk.thediamondyt.pmmp;

import android.support.v4.app.NotificationCompat;

import android.os.IBinder;
import android.app.Service;
import android.app.PendingIntent;
import android.content.Intent;

public class ServerService extends Service {
	
	@Override
	public int onStartCommand(Intent intent,int flags,int startId) {
		startForeground(1, new NotificationCompat.Builder(getApplicationContext()).setOngoing(true)
						.setSmallIcon(R.drawable.ic_launcher)
						.setContentText("Tap to open the server page")
						.setContentTitle("PocketMine-MP is running")
						.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(getApplicationContext(), MainActivity.class), 0))
						.build());
		return START_NOT_STICKY;
	}

	@Override
	public void onDestroy() {
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
