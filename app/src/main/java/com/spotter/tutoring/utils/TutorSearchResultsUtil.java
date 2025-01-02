package com.spotter.tutoring.utils;

import android.util.Log;

import com.spotter.tutoring.model.Tutor;

import java.util.ArrayList;
import java.util.List;

public class TutorSearchResultsUtil {

    public static List<Tutor> filterTutors(List<Tutor> tutors, String query){

        if(query.isEmpty()){
            Log.d("TutorSearchResults", "Search query is empty");
            return tutors;
        }
        final List<Tutor> filteredTutors = new ArrayList<>();
        for(Tutor tutor: tutors){
            if (tutor.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredTutors.add(tutor);
            }
        }

        return filteredTutors;
    }
}
