package com.spotter.tutoring.utils;

import com.spotter.tutoring.model.Tutor;

import java.util.ArrayList;
import java.util.List;

public class TutorData {

    private static final List<Tutor> tutors = new ArrayList<>();

    static {
        tutors.add(new Tutor("Alice Basket", "Math", 4.7));
        tutors.add(new Tutor("Daniel Agudelo", "Physics", 2.6));
        tutors.add(new Tutor("Manny Flanks", "", 4.6));

    }

    public static List<Tutor> getTutors(){
        return new ArrayList<>(tutors);
    }

}
