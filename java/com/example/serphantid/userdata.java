package com.example.serphantid;

public class userdata {
String Firstname,Sname,Uname,Born,Lenth,Mimage,Limage,Habitat,Idn,Toxic,Profilepic;

public userdata(){}



    public userdata(String firstname, String sname, String uname, String born, String lenth, String mimage, String limage,String habitat, String idn, String toxic, String profilepic) {
        Firstname = firstname;
        Sname = sname;
        Uname = uname;
        Born = born;
        Lenth = lenth;
        Mimage = mimage;
        Limage = limage;
        Habitat = habitat;
        Idn = idn;
        Toxic = toxic;
        Profilepic = profilepic;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getBorn() {
        return Born;
    }

    public void setBorn(String born) {
        Born = born;
    }

    public String getLenth() {
        return Lenth;
    }

    public void setLenth(String lenth) {
        Lenth = lenth;
    }

    public String getMimage() {
        return Mimage;
    }

    public void setMimage(String mimage) {
        Mimage = mimage;
    }

    public String getLimage() {
        return Limage;
    }

    public void setLimage(String limage) {
        Limage = limage;
    }

    public String getHabitat() {
        return Habitat;
    }

    public void setHabitat(String habitat) {
        Habitat = habitat;
    }

    public String getIdn() {
        return Idn;
    }

    public void setIdn(String idn) {
        Idn = idn;
    }

    public String getToxic() {
        return Toxic;
    }

    public void setToxic(String toxic) {
        Toxic = toxic;
    }

    public String getProfilepic() {
        return Profilepic;
    }

    public void setProfilepic(String profilepic) {
        Profilepic = profilepic;
    }
}
