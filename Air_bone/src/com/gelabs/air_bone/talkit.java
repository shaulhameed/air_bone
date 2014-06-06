package com.gelabs.air_bone;

import java.util.Locale;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.util.Log;

public class talkit extends Activity implements
TextToSpeech.OnInitListener{
	private TextToSpeech tts = new TextToSpeech(this, this);
	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.US);

			// tts.setPitch(5); // set pitch level

			 tts.setSpeechRate(1); // set speech speed rate

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "Language is not supported");
			} else {
				//btnSpeak.setEnabled(true);
				speakOut();
			}

		} else {
			Log.e("TTS", "Initilization Failed");
		}


	}
	public void speakOut() {

		String text = "hiii";

		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}
}
