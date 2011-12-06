package android.hardware;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.util.Log;
import java.lang.ref.WeakReference;

public class TvOut {
	private static final String ITVOUT = "android.hardware.tvout";
	private static final boolean LOG = true;
	private static final String TAG = "TvOut-Client";
	private static final int TVOUT_COMPLETE = 2;
	private static final int TVOUT_NOP = 0;
	private static final int TVOUT_PREPARED = 1;
	private EventHandler mEventHandler;
	private int mListenerContext;
	private int mNativeContext;

	static {
		System.loadLibrary("tvout_jni");
	}

	public TvOut() {
		Log.i("TvOut-Client", "TvOut +");
		_native_setup(new WeakReference<TvOut>(this));
		Log.i("TvOut-Client", "TvOut -");
	}

	private native void _DisableTvOut();

	private native void _EnableTvOut();

	private native void _SetOrientation(int i);

	private native void _SetTvScreenSize(int i);

	private native void _SetTvSystem(int i);

	private native void _TvOutResume(int i);

	private native void _TvOutSetImageString(String s);

	private native void _TvOutSuspend(String s);

	private native boolean _TvoutSubtitleIsEnable();

	private native boolean _TvoutSubtitlePostBitmap(Bitmap b, int i);

	private native boolean _TvoutSubtitleSetStatus(int i);

	private native int _getSubtitleHDMIHeight();

	private native int _getSubtitleHDMIWidth();

	private native boolean _isEnabled();

	private native boolean _isSuspended();

	private native boolean _isTvoutCableConnected();

	private final native void _native_setup(Object o);

	private final native void _release();

	private native void _setTvoutCableConnected(int paramInt);

	@SuppressWarnings("unchecked")
	private static void postEventFromNative(Object tvref, int what, int i1, int i2, Object o) {
		Log.i("TvOut-Client", "postEventFromNative +");
		TvOut tv = (TvOut) ((WeakReference<TvOut>) tvref).get();
		if (tv == null)
			return;
		if (tv.mEventHandler != null) {
			Message msg = tv.mEventHandler.obtainMessage(what, i1, i2, o);
			tv.mEventHandler.sendMessage(msg);
		}
		Log.i("TvOut-Client", "postEventFromNative -");
	}

	public void DisableTvOut() {
		Log.i("TvOut-Client", "DisableTvOut +");
		_DisableTvOut();
		Log.i("TvOut-Client", "DisableTvOut -");
	}

	public void EnableTvOut() {
		Log.i("TvOut-Client", "EnableTvOut +");
		_EnableTvOut();
		Log.i("TvOut-Client", "EnableTvOut -");
		for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
			Log.i("TvOut-Client", " > " + e.getFileName() + ":" + e.getMethodName());
		}
	}

	public void SetOrientation(int i) {
		Log.i("TvOut-Client", "SetOrientation +");
		_SetOrientation(i);
		Log.i("TvOut-Client", "SetOrientation -");
	}

	public void SetTvScreenSize(int i) {
		Log.i("TvOut-Client", "SetTvScreenSize +");
		_SetTvScreenSize(i);
		Log.i("TvOut-Client", "SetTvScreenSize -");
	}

	public void SetTvSystem(int i) {
		Log.i("TvOut-Client", "SetTvSystem +");
		_SetTvSystem(i);
		Log.i("TvOut-Client", "SetTvSystem -");
	}

	public void TvOutResume(int i) {
		Log.i("TvOut-Client", "TvOutResume +");
		_TvOutResume(i);
		Log.i("TvOut-Client", "TvOutResume -");
	}

	public void TvOutSetImageString(String s) {
		Log.i("TvOut-Client", "TvOutSetImageString +");
		_TvOutSetImageString(s);
		Log.i("TvOut-Client", "TvOutSetImageString -");
	}

	public void TvOutSuspend(Context ctx, String s) {
		Log.i("TvOut-Client", "TvOutSuspend +");
		ctx.getResources();
		String str = ctx.getString(17040347);
		Log.i("TvOut-Client", "TvOutSuspend " + str);
		Log.i("TvOut-Client", "drawText succeeded ");
		if (s.equals("")) {
			_TvOutSetImageString(str);
			_TvOutSuspend(s);
		}
		_TvOutSuspend(s);
		Log.i("TvOut-Client", "TvOutSuspend -");
	}

	public int TvoutSubtitleGetHeight() {
		Log.i("TvOut-Client", "TvoutSubtitleGetHeight");
		return _getSubtitleHDMIHeight();
	}

	public int TvoutSubtitleGetWidth() {
		Log.i("TvOut-Client", "TvoutSubtitleGetWidth");
		return _getSubtitleHDMIWidth();
	}

	public boolean TvoutSubtitleIsEnable() {
		Log.e("TvOut-Client", "TvoutSubtitleIsEnable");
		return _TvoutSubtitleIsEnable();
	}

	public boolean TvoutSubtitlePostBitmap(Bitmap paramBitmap, int paramInt) {
		Log.e("TvOut-Client", "TvoutSubtitlePostBitmap");
		return _TvoutSubtitlePostBitmap(paramBitmap, paramInt);
	}

	public boolean TvoutSubtitleSetStatus(int paramInt) {
		Log.e("TvOut-Client", "TvoutSubtitleSetStatus");
		return _TvoutSubtitleSetStatus(paramInt);
	}

	protected void finalize() {
		Log.i("TvOut-Client", "finalize +");
		_release();
		Log.i("TvOut-Client", "finalize -");
	}

	public boolean isEnabled() {
		Log.e("TvOut-Client", "isEnabled");
		return _isEnabled();
	}

	public boolean isSuspended() {
		Log.i("TvOut-Client", "isSuspended");
		return _isSuspended();
	}

	public boolean isTvoutCableConnected() {
		Log.i("TvOut-Client", "isTvoutCableConnected");
		return _isTvoutCableConnected();
	}
	
	public Parcel newRequest() {
		Log.i("TvOut-Client", "newRequest +");
		Parcel p = Parcel.obtain();
		p.writeInterfaceToken("android.hardware.tvout");
		Log.i("TvOut-Client", "newRequest -");
		return p;
	}

	public void release() {
		Log.i("TvOut-Client", "release +");
		_release();
		Log.i("TvOut-Client", "release -");
	}

	public void reset() {
		Log.i("TvOut-Client", "reset +");
		this.mEventHandler.removeCallbacksAndMessages(null);
		Log.i("TvOut-Client", "reset -");
	}

	public void setTvoutCableConnected(int paramInt) {
		Log.i("TvOut-Client", "setTvoutCableConnected +");
		_setTvoutCableConnected(paramInt);
	}
	
	private class EventHandler extends Handler {
		private TvOut mTvOut;

		public EventHandler(TvOut tv, Looper l) {
			super();
			this.mTvOut = tv;
		}

		public void handleMessage(Message msg) {
			Log.i("TvOut-Client", "handleMessage");
			if (this.mTvOut.mNativeContext == 0)
				Log.w("TvOut-Client", "tvout went away with unhandled events");
		}
	}
}
