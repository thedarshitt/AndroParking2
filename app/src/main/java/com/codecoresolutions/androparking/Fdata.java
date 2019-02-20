package com.codecoresolutions.androparking;

//MODAL CLASS
public class Fdata {
    String uname,vno,uid,arrTime;

    public Fdata() {
    }

    public Fdata(String uname, String vno, String uid, String arrTime) {
        this.uname = uname;
        this.vno = vno;
        this.uid = uid;
        this.arrTime = arrTime;
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
}
