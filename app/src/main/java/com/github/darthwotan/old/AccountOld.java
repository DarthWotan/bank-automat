package com.github.darthwotan.old;

import java.util.List;
import java.util.Scanner;

public class AccountOld {

    private int user_id;
    private ProfileOld user;
    public DataOld dataOld = new DataOld();

    public AccountOld(String name, String address, String password, int age){
        user = new ProfileOld(name, address, age, password);
        user_id = user.getID();



    }

    public AccountOld(){
        user = make_acc();
        user_id = user.getID();
    }

    public AccountOld(boolean a){

    }

    public AccountOld(int id){
        user_id = id;
        user = search_profile(this.user_id);
    }

    public String create_name(){
        System.out.println("Whats your name?");
        Scanner input1 = new Scanner(System.in);
        return input1.nextLine();
    }
    public String create_address(){
        System.out.println("Whats your address?");
        Scanner input1 = new Scanner(System.in);
        return input1.nextLine();
    }
    public int create_age(){

        System.out.println("How old are you?");
        Scanner input1 = new Scanner(System.in);
        while(!input1.hasNextInt()) {
            System.out.println("Invalid answer, try again");
            input1.next();
        }
        return input1.nextInt();



    }
    public String create_password(){
        System.out.println("Set your password");
        Scanner input1 = new Scanner(System.in);
        return input1.nextLine();
    }

    public ProfileOld make_acc() {
        String name = create_name(), address = create_address(), password = create_password();
        int age = create_age();
        ProfileOld acc = new ProfileOld(name, address, age, password);
        dataOld.add_element(acc);
        return acc;
    }

    public void delete_acc(int id){
        for(int i = 0; i < dataOld.getArray_id().size(); i++) {
            if (dataOld.getArray_id().get(i) == id) {
                dataOld.getArray_id().remove(i);
                dataOld.getArray_profile().remove(i);
            }
        }
    }

    public ProfileOld search_profile(int id){
        int index = 0;
        for(int i = 0; i< dataOld.getArray_id().size(); i++){
            if(dataOld.getArray_id().get(i) == id) {
                index = i;
                break;
            }
        }
        return dataOld.getArray_profile().get(index);
    }

    public List<Integer> getArray_id() {
        return dataOld.getArray_id();
    }

    public void setArray_id(List<Integer> array_id) {
        dataOld.setArray_id(array_id);
    }

    public List<ProfileOld> getArray_profile() {
        return dataOld.getArray_profile();
    }

    public void setArray_profile(List<ProfileOld> array_profileOld) {
        dataOld.setArray_profile(array_profileOld);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public ProfileOld getUser() {
        return user;
    }

    public void setUser(ProfileOld user) {
        this.user = user;
    }
}
