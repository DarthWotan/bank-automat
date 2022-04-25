package com.github.darthwotan;

public class PROFILE {
    private String name, address, password;
    private int age;
    private BANK account;

    public PROFILE(String n, String a, int ag, String pass){
        name = n; address = a; age = ag; password = pass;
        account = new BANK(name);


    }

    public PROFILE(){
        name = "Max Mustermann"; address = "Mustermannstraße 13"; age = 28; account = new BANK(name);
    }

    public void change_address(String a){
        address = a;
    }

    public void change_name(String n){
        name = n;
    }

    public int getMoney(){
        return this.account.getMoney();
    }

    public void setMoney(int money){
        this.account.setMoney(money);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getID(){
        return this.account.getUser_id();
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BANK getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        account.setName(name);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
