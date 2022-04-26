package com.github.darthwotan.old;

import java.util.ArrayList;
import java.util.List;

public class DataOld {
    public List<ProfileOld> array_ProfileOld = new ArrayList<>();
    public List<Integer> array_id = new ArrayList<>();

    public DataOld(){

    }
    public void add_element(ProfileOld PROFILEOld){
        array_ProfileOld.add(PROFILEOld); array_id.add(PROFILEOld.getID());
    }

    public void remove_element(int id){
        array_ProfileOld.remove(search_index(id)); array_id.remove(search_index(id));
    }

    public boolean check_existing_id(int id){
        for(int i=0; i<array_id.size(); i++){
            if(id == array_id.get(i)) {
                return true;
            }
        }
        return false;
    }

    public int search_index(int id){
        for(int i=0; i<array_id.size(); i++) {
            if(id == array_id.get(i)) return i;
        }
        return -1;
    }

    public ProfileOld search_profil(int id){
        if (check_existing_id(id)) {
            int index = search_index(id);
            return array_ProfileOld.get(index);
        }
        else return new ProfileOld();
    }

    public List<ProfileOld> getArray_profile() {
        return array_ProfileOld;
    }

    public void setArray_profile(List<ProfileOld> array_ProfileOld) {
        this.array_ProfileOld = array_ProfileOld;
    }

    public List<Integer> getArray_id() {
        return array_id;
    }

    public void setArray_id(List<Integer> array_id) {
        this.array_id = array_id;
    }
}
