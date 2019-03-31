package com.company;

public class Artist extends Person{
    private Album[] albums = new Album[100];
    private Single[] singles = new Single[100];
    private String stageName;
    private int albumNumber = 0;
    private int singlesNumber = 0;

    public int getAlbumNumber() {
        return albumNumber;
    }

    public int getSinglesNumber() {
        return singlesNumber;
    }

    public Artist (String newStageName, String newName, String newEmail, int newCNP){
        this.stageName = newStageName;
        this.name = newName;
        this.eMail = newEmail;
        this.CNP = newCNP;
    }

    public void addSingle (Single newSingle) {
        singles[singlesNumber] = newSingle;
        singlesNumber++;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public void addAlbums(Album newAlbum) {
        albums[albumNumber] = newAlbum;
        albumNumber++;
    }

    public String getStageName() {
        return stageName;
    }

    public Single[] getSingles() {
        return singles;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
}
