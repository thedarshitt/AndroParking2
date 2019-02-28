package com.codecoresolutions.androparking;

//MODAL CLASS
public class Fdata {
    String uname,vno,uid,arrTime,slot,date;

    public Fdata(String uname, String vno, String uid, String arrTime, String slot, String date) {
        this.uname = uname;
        this.vno = vno.toUpperCase();
        this.uid = uid;
        this.arrTime = arrTime;
        this.slot = slot;
        this.date = date;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
