package com.github.darthwotan.old;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public List<Profile> array_Profile = new ArrayList<>();
    public List<Integer> array_id = new ArrayList<>();

    public Data(){

    }
    public void add_element(Profile PROFILE){
        array_Profile.add(PROFILE); array_id.add(PROFILE.getID());
    }

    public void remove_element(int id){
        array_Profile.remove(search_index(id)); array_id.remove(search_index(id));
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

    public Profile search_profil(int id){
        if (check_existing_id(id)) {
            int index = search_index(id);
            return array_Profile.get(index);
        }
        else return new Profile();
    }

    public List<Profile> getArray_profile() {
        return array_Profile;
    }

    public void setArray_profile(List<Profile> array_Profile) {
        this.array_Profile = array_Profile;
    }

    public List<Integer> getArray_id() {
        return array_id;
    }

    public void setArray_id(List<Integer> array_id) {
        this.array_id = array_id;
    }
}
