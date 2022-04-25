package com.github.darthwotan;

import java.util.ArrayList;
import java.util.List;

public class DATA {
    public List<PROFILE> array_PROFILE = new ArrayList<>();
    public List<Integer> array_id = new ArrayList<>();

    public DATA(){

    }
    public void add_element(PROFILE PROFILE){
        array_PROFILE.add(PROFILE); array_id.add(PROFILE.getID());
    }

    public void remove_element(int id){
        array_PROFILE.remove(search_index(id)); array_id.remove(search_index(id));
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

    public PROFILE search_profil(int id){
        if (check_existing_id(id)) {
            int index = search_index(id);
            return array_PROFILE.get(index);
        }
        else return new PROFILE();
    }

    public List<PROFILE> getArray_profile() {
        return array_PROFILE;
    }

    public void setArray_profile(List<PROFILE> array_PROFILE) {
        this.array_PROFILE = array_PROFILE;
    }

    public List<Integer> getArray_id() {
        return array_id;
    }

    public void setArray_id(List<Integer> array_id) {
        this.array_id = array_id;
    }
}
