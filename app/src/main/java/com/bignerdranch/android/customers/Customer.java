package com.bignerdranch.android.customers;


public class Customer {

    private int id;
    private String fname;
    private String lname;
    private String email;
    private String tel;
    private String tel_type;
    private String address;
    private String city;
    private String state;
    private String zip;

    public Customer (){
    }

    public Customer (String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }
    public Customer(int id, String fname, String lname, String email, String tel, String tel_type, String address, String city, String state, String  zip){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.tel = tel;
        this.tel_type = tel_type;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Customer(String fname, String lname, String email, String tel, String tel_type, String address, String city, String state, String zip){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.tel = tel;
        this.tel_type = tel_type;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getId() {

        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel_type() {
        return tel_type;
    }

    public void setTel_type(String tel_type) {
        this.tel_type = tel_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}