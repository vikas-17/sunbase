package com.SpringCrud.SpringAngular.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "customer")
public class Customer {
    @Id
    @Column(name = "customer_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerid;
    @Column(name = "first_name", length = 50)
    private String first_name;
    @Column(name = "last_name", length = 50)
    private String last_name;
    @Column(name = "street", length = 50)
    private String street;
    @Column(name = "address", length = 50)
    private String address;
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "state", length = 50)
    private String state;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "phone", length = 12)
    private int phone;

    public Customer(String first_name, String last_name, String street, String address, String city, String state, String email, int phone) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.street = street;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
    }

    public Customer() {
    }



    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid=" + customerid +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", street='" + street + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}