package com.home.urix.lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * Records container
 * @author Plaksenkov Yurii
 * @version 0.0.1
 * @since 0.0.1
 */
public class NoteBook {

    private List<NoteBookRecord> recordsList = new ArrayList<>();
    /**
     * Add user object to model
     * @param record - The added user
     */
    public void addRecord(NoteBookRecord record){
        recordsList.add(record);
    }
}
