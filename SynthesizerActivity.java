package com.example.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttonScale;
    private Button buttonScale2;
    private Button buttonScale3;
    private Button buttonTTLS;
    private Button come;
    private Button lick;
    private Button chord;
    private CheckBox checkBox_main_2nd;
    private CheckBox checkbox_repeat;

    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;
    private Map<Integer,Integer> noteMap;

    public static final float DEFAULT_VOLUME = 1.0f;
    public static final float DEFAULT_RATE = 1.0f;

    public static final int DEFAULT_PRIORITY = 1;
    public static final int WHOLE_NOTE = 1000;
    public static final int HALF_NOTE = 500;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {
        //List<Integer> someList = new ArrayList<>();
        noteMap = new HashMap<>();
        //store key value pair
        //key is button id, value is noteId
        noteMap.put(R.id.button_synth_a,noteA);
        noteMap.put(R.id.button_synth_b,noteB);
        noteMap.put(R.id.button_synth_bb,noteBb);
        noteMap.put(R.id.button_synth_c,noteC);
        //repeat for all notes
        noteMap.put(R.id.button_synth_cs,noteCs);
        noteMap.put(R.id.button_synth_d,noteD);
        noteMap.put(R.id.button_synth_ds,noteDs);
        noteMap.put(R.id.button_synth_e,noteE);
        noteMap.put(R.id.button_synth_f,noteF);
        noteMap.put(R.id.button_synth_fs,noteFs);
        noteMap.put(R.id.button_synth_g,noteG);
        noteMap.put(R.id.button_synth_gs,noteGs);
    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 10);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCs = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDs = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFs = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGs = soundPool.load(this, R.raw.scalegs, 1);




    }

    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();

        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);

        buttonScale.setOnClickListener(this);
        buttonScale2.setOnClickListener(this);
        buttonScale3.setOnClickListener(this);
        buttonTTLS.setOnClickListener(this);
        checkBox_main_2nd.setOnClickListener(this);
        checkbox_repeat.setOnClickListener(this);
        come.setOnClickListener(this);
        lick.setOnClickListener(this);
        chord.setOnClickListener(this);

    }

    private void wireWidgets(){
        buttonTTLS = findViewById(R.id.button_main_song);
        buttonScale2 = findViewById(R.id.button_main_scale2);
        buttonScale3 = findViewById(R.id.button_main_scale3);
        come = findViewById(R.id.button_main_caya);
        lick = findViewById(R.id.button_main_lick);
        chord = findViewById(R.id.button_main_chord);

        buttonScale = findViewById(R.id.button_main_scale);
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);
        checkBox_main_2nd = findViewById(R.id.checkBox_main_2nd);
        checkbox_repeat = findViewById(R.id.checkBox_main_repeat);

    }

    @Override
    public void onClick(View v) {
        // one method to handle the clicks of all buttons
        //but don't forget to tell the buttons who is doing the listening
        switch(v.getId()){
//            case R.id.button_synth_a:
//                soundPool.play(noteA, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_bb:
//                soundPool.play(noteBb, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "Bb", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_b:
//                soundPool.play(noteB, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_c:
//                soundPool.play(noteC, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_cs:
//                soundPool.play(noteCs, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_d:
//                soundPool.play(noteD, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_ds:
//                soundPool.play(noteDs, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_e:
//                soundPool.play(noteE, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_f:
//                soundPool.play(noteF, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_fs:
//                soundPool.play(noteFs, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_g:
//                soundPool.play(noteG, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_synth_gs:
//                soundPool.play(noteGs, 1.0f, 1.0f, 1, 0, 1.0f);
//                //Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.button_main_scale:
                playScale();
                break;
            case R.id.button_main_scale2:
                playScale2();
                break;
            case R.id.button_main_scale3:
                playScale3();
                break;
            case R.id.button_main_song:
                playTTLS();
                break;
            case  R.id.button_main_caya:
                playCAYA();
                break;
            case R.id.button_main_lick:
                playLick();
                break;
            case R.id.button_main_chord:
                playChord();
                break;

        }
    }

    private void playChord() {

        playEACs();
        delay(HALF_NOTE/3*2);
        playEACs();
        delay(HALF_NOTE/2);
        playEACs();
        delay(HALF_NOTE/2);
        playEACs();
        delay(HALF_NOTE/4);
        playEACs();
        delay(HALF_NOTE/2);
        playDsGsB();
        delay(HALF_NOTE/2);
        playGsCsE();
        delay(HALF_NOTE/2);

        List<Note> notes = new ArrayList<>();
        notes.add(new Note(noteFs));
        notes.add(new Note(noteE));
        notes.add(new Note(noteCs));
        notes.add(new Note(noteE));
        notes.add(new Note(noteFs));
        notes.add(new Note(noteE));
        notes.add(new Note(noteCs));
        notes.add(new Note(noteE));
        notes.add(new Note(noteFs));
        notes.add(new Note(noteE));





        notes.add(new Note(noteCs));
        notes.add(new Note(noteB));
        notes.add(new Note(noteCs));
        notes.add(new Note(noteB));
        notes.add(new Note(noteCs));
        notes.add(new Note(noteFs));
;
        notes.add(new Note(noteE));
        for (Note note : notes) {


                playNote(note.getNoteId());
                delay(HALF_NOTE / 3);

        }

        if(checkbox_repeat.isChecked()){
            playEACs();
            delay(HALF_NOTE/3*2);
            playEACs();
            delay(HALF_NOTE/2);
            playEACs();
            delay(HALF_NOTE/2);
            playEACs();
            delay(HALF_NOTE/4);
            playEACs();
            delay(HALF_NOTE/2);
            playDsGsB();
            delay(HALF_NOTE/2);
            playGsCsE();
            delay(HALF_NOTE/2);




            for (Note note : notes) {


                playNote(note.getNoteId());
                delay(HALF_NOTE / 3);

            }
        }
    }

    private void playEACs() {
        playNote(noteE);
        playNote(noteA);
        playNote(noteCs);
    }

    private void playDsGsB(){
        playNote(noteDs);
        playNote(noteGs);
        playNote(noteB);
    }

    private void playGsCsE(){
        playNote(noteGs);
        playNote(noteCs);
        playNote(noteE);
    }

    private void playLick() {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(noteC));
        notes.add(new Note(noteD));
        notes.add(new Note(noteDs));
        notes.add(new Note(noteF));
        notes.add(new Note(noteD));
        notes.add(new Note(noteBb));
        notes.add(new Note(noteC));
        int i = 0;
        for (Note note : notes) {

            i = i + 1;
            if (i == 5 ) {
                playNote(note.getNoteId());
                delay(HALF_NOTE);
            }
            else {
                playNote(note.getNoteId());
                delay(HALF_NOTE / 2);
            }
        }

    }

    private void playCAYA() {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(noteA));
        notes.add(new Note(noteA));
        notes.add(new Note(noteBb));
        notes.add(new Note(noteB));
        notes.add(new Note(noteD));
        notes.add(new Note(noteB));
        notes.add(new Note(noteD));
        notes.add(new Note(noteB));
        notes.add(new Note(noteB));
        notes.add(new Note(noteBb));
        notes.add(new Note(noteA));
        notes.add(new Note(noteE));
        notes.add(new Note(noteA));
        notes.add(new Note(noteA));
        int i = 0;
        for (Note note : notes) {

            i = i + 1;
            if (i == 4 || i == 14) {
                playNote(note.getNoteId());
                delay(HALF_NOTE);
            }
            else {
                playNote(note.getNoteId());
                delay(HALF_NOTE / 2);
            }
        }
        if(checkbox_repeat.isChecked()){
            int c = 0;
            for (Note note : notes) {

                c = c + 1;
                if (c == 4 || c == 14) {
                    playNote(note.getNoteId());
                    delay(HALF_NOTE);
                }
                else {
                    playNote(note.getNoteId());
                    delay(HALF_NOTE / 2);
                }
            }
        }
    }

    private void playTTLS() {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(noteA));
        notes.add(new Note(noteA));
        notes.add(new Note(noteE));
        notes.add(new Note(noteE));
        notes.add(new Note(noteFs));
        notes.add(new Note(noteFs));
        notes.add(new Note(noteE));


        for (Note note : notes) {
            playNote(note.getNoteId());
            delay(HALF_NOTE);
        }

        delay(HALF_NOTE);

        List<Note> notes2 = new ArrayList<>();
        notes2.add(new Note(noteD));
        notes2.add(new Note(noteD));
        notes2.add(new Note(noteCs));
        notes2.add(new Note(noteCs));
        notes2.add(new Note(noteB));
        notes2.add(new Note(noteB));
        notes2.add(new Note(noteA));
        for (Note note2 : notes2) {
            playNote(note2.getNoteId());
            delay(HALF_NOTE);
        }

        delay(HALF_NOTE);


        if(checkBox_main_2nd.isChecked()) {


            for (int x = 1; x <= 2; x++) {
                List<Note> notes3 = new ArrayList<>();
                notes3.add(new Note(noteE));
                notes3.add(new Note(noteE));
                notes3.add(new Note(noteD));
                notes3.add(new Note(noteD));
                notes3.add(new Note(noteCs));
                notes3.add(new Note(noteCs));
                notes3.add(new Note(noteB));
                for (Note note3 : notes3) {
                    playNote(note3.getNoteId());
                    delay(HALF_NOTE);
                }
                delay(HALF_NOTE);

            }
        }
    }

    private void playScale3() {
        playNote(noteA, 0);
        delay(HALF_NOTE);
        playNote(noteB, 0);
        delay(HALF_NOTE);
        playNote(noteCs, 0);
        delay(HALF_NOTE);
        playNote(noteD, 0);
        delay(HALF_NOTE);
        playNote(noteE, 0);
        delay(HALF_NOTE);
        playNote(noteFs, 0);
        delay(HALF_NOTE);
        playNote(noteG, 0);
    }

    private void playScale2() {
        playNote(noteA, 0);
        delay(WHOLE_NOTE);
        playNote(noteB, 0);
        delay(WHOLE_NOTE);
        playNote(noteC, 0);
        delay(WHOLE_NOTE);
        playNote(noteD, 0);
        delay(WHOLE_NOTE);
        playNote(noteE, 0);
        delay(WHOLE_NOTE);
        playNote(noteF, 0);
        delay(WHOLE_NOTE);
        playNote(noteG, 0);
    }

    private void playScale() {
        //play all the notes one at a time with a delay in between
        //soundPool.play(noteA,DEFAULT_VOLUME,DEFAULT_VOLUME,DEFAULT_PRIORITY,0,DEFAULT_RATE);



        List<Note> notes = new ArrayList<>();
        notes.add(new Note(noteA));

        notes.add(new Note(noteE));
        notes.add(new Note(noteFs));
        notes.add(new Note(noteE));





        notes.add(new Note(noteB));
        notes.add(new Note(noteCs));
        notes.add(new Note(noteFs));
        ;
        notes.add(new Note(noteE));


        for(Note note : notes){
            playNote(note);

        }
//        playNote(noteA, 0);
//        delay(WHOLE_NOTE);
//        playNote(noteBb, 0);
//        delay(WHOLE_NOTE);
//        playNote(noteB, 0);

    }

    public void playSong(Song song){
        for(Note note : song.getNotes()){
            playNote(note.getNoteId(),0);
            delay(WHOLE_NOTE);
        }
    }

    private void playNote(int note){
        playNote(note,0);
    }

    private void playNote(Note note){
        playNote(note.getNoteId());
    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, loop, DEFAULT_RATE);
    }

    private class KeyboardNoteListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            // get the id of the button that was clicked
            int id = view.getId();
            // use the map to figure out what note to play
            int note = noteMap.get(id);
            // play the note
            playNote(note);
        }
    }



}
