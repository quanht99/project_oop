package test;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Speck {
    private static Voice voice;
    public static void main(String[] args){
        System.out.println("Hello");

        VoiceManager vm = VoiceManager.getInstance();
        Voice voice = vm.getVoice("kevin16");
        voice.allocate();
        voice.speak("Hello");
    }
}
