package tk.thediamondyt.pmmp.activities;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import tk.thediamondyt.pmmp.fragments.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {
	
	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		
		getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
	}
}
