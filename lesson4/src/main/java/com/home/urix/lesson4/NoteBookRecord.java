package com.home.urix.lesson4;

import java.time.LocalDate;
import java.util.Date;

public class NoteBookRecord {
    private String lastname;
    private String firstname;
    private String patronymic;
    private String nickName;
    private String comment;
    private GroupsEnum group;
    private String mobPhone;
    private String homePhone;
    private String secondMobilePhone;
    private String email;
    private String skype;
    private Address address;
    private Date inputDate;
    private Date changedDate;



    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nick) {
        this.nickName = nick;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public GroupsEnum getGroup() {
        return group;
    }

    public void setGroup(GroupsEnum group) {
        this.group = group;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getSecondMobilePhone() { return secondMobilePhone; }

    public void setSecondMobilePhone(String secMobPhone) {
        this.secondMobilePhone = secMobPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    class Address{
        private String zipCode;
        private String city;
        private String street;
        private String houseNum;
        private String flatNum;

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String index) {
            this.zipCode = index;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getHouseNum() {
            return houseNum;
        }

        public void setHouseNum(String houseNum) {
            this.houseNum = houseNum;
        }

        public String getFlatNum() {
            return flatNum;
        }

        public void setFlatNum(String flatNum) {
            this.flatNum = flatNum;
        }
    }
}
