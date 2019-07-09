package com.example.ayomide.atsnoti.Model;

public class PupilData {
    private String name, image, age, grade;
    private String phone, address, gName, gEmail, gOfficeAddress;

    public PupilData() {
    }

    public PupilData(String name, String image, String age, String grade, String phone, String address, String gName, String gEmail, String gOfficeAddress) {
        this.name = name;
        this.image = image;
        this.age = age;
        this.grade = grade;
        this.phone = phone;
        this.address = address;
        this.gName = gName;
        this.gEmail = gEmail;
        this.gOfficeAddress = gOfficeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgEmail() {
        return gEmail;
    }

    public void setgEmail(String gEmail) {
        this.gEmail = gEmail;
    }

    public String getgOfficeAddress() {
        return gOfficeAddress;
    }

    public void setgOfficeAddress(String gOfficeAddress) {
        this.gOfficeAddress = gOfficeAddress;
    }
}
