package com.example.serphantid;

public class productsmodel {

   private String Firstname;
    String Sname;
    String Uname;
    String Born;
    String Lenth;
    String Mimage;
    String Limag;
    private productsmodel(){}

    public productsmodel(String firstname, String sname, String uname, String born, String lenth, String mimage, String limag) {
        Firstname = firstname;
        Sname = sname;
        Uname = uname;
        Born = born;
        Lenth = lenth;
        Mimage = mimage;
        Limag = limag;
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

    public String getLimag() {
        return Limag;
    }

    public void setLimag(String limag) {
        Limag = limag;
    }




}
