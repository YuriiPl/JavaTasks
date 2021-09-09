package com.home.urix.lesson4.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Records container
 * @author Plaksenkov Yurii
 * @version 0.0.1
 * @since 0.0.1
 */
public class NoteBook {

    private List<NoteBookRecord> recordsList = new ArrayList<>();

    public NoteBook(){
        //Filling the "database" to emulate the situation with the existing login
        NoteBookRecord nr = new NoteBookRecord();
        nr.setNickName("Nick1");
        recordsList.add(nr);
        nr = new NoteBookRecord();
        nr.setNickName("Нік1");
        recordsList.add(nr);
    }

    /**
     * Add user object to model
     * @param record - The added user
     */
    public void insertRecord(NoteBookRecord record) throws LoginExistsException{
        if(checkIfLoginAlreadyExists(record.getNickName())){
            throw new LoginExistsException(record);
        }
        recordsList.add(record);
    }

    private boolean checkIfLoginAlreadyExists(String nickName) {
        ListIterator<NoteBookRecord> it = recordsList.listIterator();
        while (it.hasNext()){
            NoteBookRecord record=it.next();
            if(record.getNickName().equals(nickName)){
                return true;
            }
        }
        return false;
    }
}
