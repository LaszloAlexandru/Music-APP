package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        MusicAPP musicAPP = MusicAPP.getMusicAppService();
        System.out.print("1 to add Artist\n" +
                "2 to add Producer \n" +
                "3 to Display All artists\n" +
                "4 to Display All Producers\n" +
                "5 to Search a producer\n" +
                "6 to Search an artist\n" +
                "7 to Search an album\n" +
                "8 to add Song to album");
        option = scanner.nextInt();
        scanner.nextLine();
        while (option != 0) {
            switch (option) {
                case 1:
                    System.out.println("Introduceti Nume, Nume de scena, Email , CNP");
                    String name = scanner.nextLine();
                    String stageName = scanner.nextLine();
                    String email = scanner.nextLine();
                    int cnp = scanner.nextInt();
                    scanner.nextLine();
                    Artist newArtist = new Artist(stageName, name, email, cnp);
                    System.out.println("Adaugati albume da/nu?");
                    String addAlbumOption = scanner.nextLine();
                    if (addAlbumOption.equals("da")) {
                        System.out.println("Alegeti numele, Genul si data de lansare a albumului");
                        Album newAlbum = new Album();
                        String albumName = scanner.nextLine();
                        String genre = scanner.nextLine();
                        String releaseDate = scanner.nextLine();
                        newAlbum.setName(albumName);
                        newAlbum.setGenre(genre);
                        newAlbum.setReleaseDate(releaseDate);
                        System.out.println("Introduceti numarul de cantece din acest album");
                        int numberOfSongs = scanner.nextInt();
                        scanner.nextLine();
                        newAlbum.addSongs(numberOfSongs);
                        newArtist.addAlbums(newAlbum);
                        musicAPP.addAlbums(newAlbum);
                    }
                    System.out.println("Adaugati single-uri?");
                    String addSingleOption = scanner.nextLine();
                    if (addSingleOption.equals("da")) {
                        System.out.println("Cate single-uri sunt?");
                        int numberOfSingles = scanner.nextInt();
                        scanner.nextLine();
                        for (int i = 0; i < numberOfSingles; i++) {
                            System.out.println("Introduce numele,genul,durata, data lansarii si rankingul: ");
                            String singleName = scanner.nextLine();
                            String singleGenre = scanner.nextLine();
                            int singleDuration = scanner.nextInt();
                            scanner.nextLine();
                            String singleDate = scanner.nextLine();
                            String singleRankings = scanner.nextLine();
                            Single newSingle = new Single(singleName, singleGenre, singleDuration, singleDate, singleRankings);
                            newArtist.addSingle(newSingle);
                        }
                    }
                    musicAPP.addArtists(newArtist);
                    break;
                case 2:
                    System.out.println("Introduceti Nume,Numele Companiei, eMail, CNP");
                    String producerName = scanner.nextLine();
                    String companyName = scanner.nextLine();
                    String producerEmail = scanner.nextLine();
                    int producerCnp = scanner.nextInt();
                    scanner.nextLine();
                    Producer newProducer = new Producer(producerName, companyName, producerEmail, producerCnp);
                    musicAPP.addProducers(newProducer);
                    break;
                case 3:
                    Artist[] artists = musicAPP.getArtists();
                    for (int i = 0; i < musicAPP.getArtistsNumber(); i++) {
                        System.out.println("Stage Name:" + artists[i].getStageName() + "\nEmail: " + artists[i].geteMail() + "\n");
                        System.out.println("Albume:");
                        Album[] albums = artists[i].getAlbums();
                        for (int j = 0; j < artists[i].getAlbumNumber(); j++) {
                            System.out.println("Album name: " + albums[j].getName() + "\nAlbum genre: " + albums[j].getGenre() +
                                    "\nAlbum release date: " + albums[j].getReleaseDate());
                            Song[] songs = albums[j].getSongs();
                            System.out.println(albums[j].getNumberOfSongs());
                            for (int h = 0; h < albums[j].getNumberOfSongs(); h++) {

                                System.out.println("Song name: " + songs[h].getName() + " Song Genre: " + songs[h].getGenre() +
                                        "Song duration: " + songs[h].getDuration());
                            }

                        }
                        System.out.println("Singles:");
                        Single[] singles = artists[i].getSingles();
                        for (int j = 0; j < artists[i].getSinglesNumber(); j++) {
                            System.out.println("Single name: " + singles[j].getName() + "Single Genre: " + singles[j].getGenre() +
                                    "Ranking: " + singles[j].getRankings() + "Single Release Date:" + singles[j].getReleaseDate()
                                    + "Duration:" + singles[j].getDuration());
                        }
                    }
                    break;
                case 4:
                    Producer[] producers = musicAPP.getProducers();
                    for (int i = 0; i < musicAPP.getProducersNumber(); i++) {
                        System.out.println("Numele Companiei:" + producers[i].getCompanyName() + "E-mail: " + producers[i].geteMail());
                        Artist[] artistiSemnati = producers[i].getArtists();
                        for (int j = 0; j < producers[i].getArtistNumber(); j++) {
                            System.out.println("Numele artist: " + artistiSemnati[j].getStageName() + "\n");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Search a producer");
                    String producerToSearch = scanner.nextLine();
                    musicAPP.serchProducer(producerToSearch);
                    break;
                case 6:
                    System.out.println("Search an artist");
                    String artistToSearch = scanner.nextLine();
                    musicAPP.searchArtists(artistToSearch);
                    break;
                case 7:
                    System.out.println("Search an album");
                    String albumToSearch = scanner.nextLine();
                    musicAPP.searchAlbums(albumToSearch);
                    break;
                case 8:
                    System.out.println("Name an artist and and album that you want to add the new song to:");
                    String artistName = scanner.nextLine();
                    String albumName = scanner.nextLine();
                    System.out.println("Introduce numele, genul si durata cantecului(in secunde)");
                    String songName = scanner.nextLine();
                    String genre = scanner.nextLine();
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    Song newSong = new Song(songName,genre,duration);
                    musicAPP.addSongToAlbum(newSong,albumName,artistName);
                    break;
            }
            System.out.print("1 to add Artist\n" +
                    "2 to add Producer \n" +
                    "3 to Display All artists\n" +
                    "4 to Display All Producers\n" +
                    "5 to Search a producer\n" +
                    "6 to Search an artist\n" +
                    "7 to Search an album\n"+
                    "8 to add a song to an album\n");
            option = scanner.nextInt();
            scanner.nextLine();
        }
    }
}
