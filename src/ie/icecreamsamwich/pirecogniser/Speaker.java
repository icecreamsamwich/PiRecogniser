package ie.icecreamsamwich.pirecogniser;
/**
 * Copyright 2003 Sun Microsystems, Inc.
 * 
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL 
 * WARRANTIES.
 */
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
//import com.sun.speech.freetts.audio.JavaClipAudioPlayer;

/**
 * Simple program to demonstrate the use of the FreeTTS speech
 * synthesizer.  This simple program shows how to use FreeTTS
 * without requiring the Java Speech API (JSAPI).
 */
public class Speaker {

	private Voice helloVoice;
	private VoiceManager voiceManager;

	/**
	 * Example of how to list all the known voices.
	 */
	public static void listAllVoices() {
		System.out.println();
		System.out.println("All voices available:");        
		VoiceManager voiceManager = VoiceManager.getInstance();
		Voice[] voices = voiceManager.getVoices();
		for (int i = 0; i < voices.length; i++) {
			System.out.println("    " + voices[i].getName()
					+ " (" + voices[i].getDomain() + " domain)");
		}
	}

	public void initialize() {
		String voiceName = "kevin16";
		/*(args.length > 0)
                ? args[0]
                : "kevin16";*/

		System.out.println();
		System.out.println("Using voice: " + voiceName);

		/* The VoiceManager manages all the voices for FreeTTS.
		 */
		voiceManager = VoiceManager.getInstance();
		helloVoice = voiceManager.getVoice(voiceName);

		if (helloVoice == null) {
			System.err.println(
					"Cannot find a voice named "
							+ voiceName + ".  Please specify a different voice.");
			System.exit(1);
		}

		/* Allocates the resources for the voice.
		 */
		helloVoice.allocate();
	}

	public void speak(String detail) {
		/* Synthesize speech.
		 */
		helloVoice.speak(detail);
	}

	public void deinitialize() {
		/* Clean up and leave.
		 */
		helloVoice.deallocate();
	}
}