package com.github.darthwotan;

import java.util.List;
import java.util.Scanner;

public class ACCOUNT {

    private int user_id;
    private PROFILE user;
    public DATA data = new DATA();

    public ACCOUNT(String name, String address, String password, int age){
        user = new PROFILE(name, address, age, password);
        user_id = user.getID();



    }

    public ACCOUNT(){
        user = make_acc();
        user_id = user.getID();
    }

    public ACCOUNT(boolean a){

    }

    public ACCOUNT(int id){
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

    public PROFILE make_acc() {
        String name = create_name(), address = create_address(), password = create_password();
        int age = create_age();
        PROFILE acc = new PROFILE(name, address, age, password);
        data.add_element(acc);
        return acc;
    }

    public void delete_acc(int id){
        for(int i = 0; i < data.getArray_id().size(); i++) {
            if (data.getArray_id().get(i) == id) {
                data.getArray_id().remove(i);
                data.getArray_profile().remove(i);
            }
        }
    }

    public PROFILE search_profile(int id){
        int index = 0;
        for(int i = 0; i<data.getArray_id().size(); i++){
            if(data.getArray_id().get(i) == id) {
                index = i;
                break;
            }
        }
        return data.getArray_profile().get(index);
    }

    public List<Integer> getArray_id() {
        return data.getArray_id();
    }

    public void setArray_id(List<Integer> array_id) {
        data.setArray_id(array_id);
    }

    public List<PROFILE> getArray_profile() {
        return data.getArray_profile();
    }

    public void setArray_profile(List<PROFILE> array_profile) {
        data.setArray_profile(array_profile);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public PROFILE getUser() {
        return user;
    }

    public void setUser(PROFILE user) {
        this.user = user;
    }
}
