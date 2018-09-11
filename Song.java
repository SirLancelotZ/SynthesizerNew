package com.example.synthesizer;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private List<Note> notes;

public Song(){
    notes = new ArrayList<>();
}

    public Song(List<Note> notes) {
        this.notes = notes;
    }
}
