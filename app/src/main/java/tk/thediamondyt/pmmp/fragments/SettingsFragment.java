package tk.thediamondyt.pmmp.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import tk.thediamondyt.pmmp.R;

public class SettingsFragment extends PreferenceFragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}
}
