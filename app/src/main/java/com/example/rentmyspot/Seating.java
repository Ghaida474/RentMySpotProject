package com.example.rentmyspot;

public class Seating {
    String Sname;
    String Scategory;
    int Sprice;
    String Sdescription;

    public Seating(String Sname,String Scatogary,int Sprice,String Sdescription) {
        this.Sname = Sname;
        this.Scategory = Scatogary;
        this.Sprice = Sprice;
        this.Sdescription = Sdescription;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getScategory() {
        return Scategory;
    }

    public void setScategory(String scatogary) {
        Scategory = scatogary;
    }

    public int getSprice() {
        return Sprice;
    }

    public void setSprice(int sprice) {
        Sprice = sprice;
    }

    public String getSdescription() {
        return Sdescription;
    }

    public void setSdescription(String sdescription) {
        Sdescription = sdescription;
    }

    @Override
    public String toString() {
        return "Seating{" +
                "Sname='" + Sname + '\'' +
                ", Scatogary='" + Scategory + '\'' +
                ", Sprice=" + Sprice +
                ", Sdescription='" + Sdescription + '\'' +
                '}';
    }
}
