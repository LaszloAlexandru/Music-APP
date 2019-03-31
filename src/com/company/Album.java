package com.company;
import java.util.Scanner;
public class Album implements Info {
    private Song[] songs = new Song[20];
    private int numberOfSongs = 0;
    private String name;
    private String releaseDate;
    private String genre;

    public Song[] getSongs() {
        return songs;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public void addSongs(int numberOfNewSongs) {
        if(numberOfNewSongs+ numberOfSongs > 20){
            System.out.println("Nu mai pot fi adaugate melodii");
        }
        else{
            Scanner scanner = new Scanner(System.in);
            for(int i = numberOfSongs; i<numberOfSongs+numberOfNewSongs;i++){
                System.out.println(i);
                System.out.println("Introduce numele, genul si durata cantecului(in secunde)");
                String songName = scanner.nextLine();
                String genre = scanner.nextLine();
                int duration = scanner.nextInt();
                scanner.nextLine();
                Song newSong = new Song(songName,genre,duration);
                songs[i] = newSong;
            }
            numberOfSongs = numberOfSongs + numberOfNewSongs;
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
