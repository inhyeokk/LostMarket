package com.sejong.unknown.view.setting;

import android.content.Intent;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.sejong.unknown.R;
import com.sejong.unknown.view.login.LoginActivity;

public class SettingFragment extends PreferenceFragmentCompat {

    private final String TAG = "SETTING_FRAGMENT";

    private Preference managerLogin;

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.pref_settings);

        managerLogin = findPreference("managerLogin");
        managerLogin.setOnPreferenceClickListener(preference -> {
            goToLoginActivity();
            return true;
        });
    }

    private void goToLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        getActivity().startActivity(intent);
    }
}
