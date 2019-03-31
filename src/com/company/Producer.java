package com.company;

public class Producer extends Person {

    private String companyName;
    private Artist[] artists = new Artist[50];
    private int artistNumber= 0;

    public Producer () {}
    public Producer(String newName,String newCompanyName,String newEmail,int newCNP){
        name = newName;
        companyName = newCompanyName;
        eMail = newEmail;
        CNP = newCNP;
    }

    public void addArtist (Artist newArtist){
        artists[artistNumber] = newArtist;
        artistNumber++;
    }

    public void setCompanyName(String newCompanyName) {
        companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public int getArtistNumber() {
        return artistNumber;
    }
}
