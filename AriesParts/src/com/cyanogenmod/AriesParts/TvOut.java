package com.cyanogenmod.AriesParts;

import android.content.Context;
import android.os.PowerManager;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.util.Log;

public class TvOut implements OnPreferenceChangeListener {

	private android.hardware.TvOut mTvout = null;
	private PowerManager.WakeLock mWakeLock = null;

	public TvOut(Context ctx) {
		Log.i("TvOut-Pref", "created");
		mTvout = new android.hardware.TvOut();
		PowerManager pm = (PowerManager) ctx.getSystemService(Context.POWER_SERVICE);
		mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "TvOut-Pref");
	}

	public static boolean isSupported() {
		return true;
	}

	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		Boolean enable = (Boolean) newValue;
		if (enable) {
			mTvout.SetOrientation(0);
			mTvout.EnableTvOut();
			if (!mWakeLock.isHeld())
				mWakeLock.acquire();
		} else {
			mTvout.DisableTvOut();
			if (mWakeLock.isHeld())
				mWakeLock.release();
		}
		return true;
	}

}
