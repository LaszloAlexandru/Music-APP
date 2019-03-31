package com.company;

public class MusicAPP {

    private Artist[] artists = new Artist[100];
    private Producer[] producers = new Producer[100];
    private Album[] albums = new Album [1000];

    private int producersNumber = 0;
    private int artistsNumber = 0;
    private int albumsNumber = 0;
    private static MusicAPP instance;

    public int getProducersNumber() {
        return producersNumber;
    }

    public int getAlbumsNumber() {
        return albumsNumber;
    }

    public static MusicAPP getMusicAppService()
    {
        if (instance == null)
        {
            instance = new MusicAPP();
        }
        return instance;
    }

    public Producer[] getProducers() {
        return producers;
    }

    public int serchProducer(String searchedCompany){
        for(int i = 0;i<producersNumber;i++){
            if(searchedCompany.equals(producers[i].getCompanyName())){
                Artist[]  artistiSemnati = producers[i].getArtists();
                for(int j = 0;j<producers[i].getArtistNumber();j++){
                    System.out.println("Numele artist: " + artistiSemnati[j].getStageName()+ "\n");
                }
                return 0;
            }
        }
        return 1;
    }

    public void addSongToAlbum(Song newSong, String albumName, String artistStageName){
        int gasit = 0;
        for(int j = 0;j<artistsNumber;j++){
            if(artists[j].getStageName().equals(artistStageName)){
                gasit = 1;
                Album[] albumsOfArtist = artists[j].getAlbums();
                for(int i = 0 ;i< artists[j].getAlbumNumber();i++){
                    System.out.println(albumsOfArtist[i].getName());
                    if(albumsOfArtist[i].getName().equals(albumName)){
                        gasit=2;
                        int numberOfSongs = albumsOfArtist[i].getNumberOfSongs();
                        if(numberOfSongs == 20){
                            System.out.println("No room for more songs");
                        }
                        else {
                            Song[] songs = albumsOfArtist[i].getSongs();
                            songs[numberOfSongs] = newSong;
                            albumsOfArtist[i].setNumberOfSongs(numberOfSongs+1);
                            albumsOfArtist[i].setSongs(songs);
                            for(int it = 0;it <albumsNumber;it++){
                                if(albums[it].getName().equals(albumName)){
                                    albums[it] = albumsOfArtist[i];
                                }
                            }
                        }
                    }
                }
            }
        }
        if(gasit ==0){
            System.out.println("Artistul nu a fost gasit");
        }
        if(gasit == 1){
            System.out.println("Albumul nu a fost gasit");
        }
    }

    public int searchArtists(String artistName){
        for(int i = 0;i < artistsNumber;i++){
            if(artists[i].getStageName().equals(artistName)){
                System.out.println("Stage Name:" + artists[i].getStageName()+ "\nEmail: " + artists[i].geteMail() + "\n");
                System.out.println("Albume:");
                Album[] albums = artists[i].getAlbums();
                for(int j = 0;j<artists[i].getAlbumNumber();j++){
                    System.out.println("Album name: " + albums[j].getName() + "\nAlbum genre: " + albums[j].getGenre() +
                            "\nAlbum release date: " + albums[j].getReleaseDate());
                    Song[] songs = albums[j].getSongs();
                    for(int h=0;h<albums[j].getNumberOfSongs();h++){
                        System.out.println("Song name: " + songs[h].getName()+" Song Genre: " + songs[h].getGenre()+
                                "Song duration: " + songs[h].getDuration());
                    }

                }
                System.out.println("Singles:");
                Single[] singles= artists[i].getSingles();
                for(int j = 0;j<artists[i].getSinglesNumber();j++){
                    System.out.println("Single name: " + singles[j].getName()+ "Single Genre: " +singles[j].getGenre()+
                            "Ranking: "+singles[j].getRankings()+ "Single Release Date:" +singles[j].getReleaseDate()
                            +"Duration:" +singles[j].getDuration());
                }
                return 0;
            }
        }
        return 1;
    }

    public int searchAlbums(String albumName){
        for(int j = 0;j<albumsNumber;j++){
            if(albums[j].getName().equals(albumName)){
                System.out.println("Album name: " + albums[j].getName() + "\nAlbum genre: " + albums[j].getGenre() +
                        "\nAlbum release date: " + albums[j].getReleaseDate());
                Song[] songs = albums[j].getSongs();
                for(int h=0;h<albums[j].getNumberOfSongs();h++){
                    System.out.println("Song name: " + songs[h].getName()+" Song Genre: " + songs[h].getGenre()+
                            "Song duration: " + songs[h].getDuration());
                }
                return 0;
            }
        }
        return 1;
    }

    public void addProducers(Producer producers) {
        this.producers[producersNumber] = producers;
        producersNumber++;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public void addAlbums(Album album){
        albums[albumsNumber] = album;
        albumsNumber++;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public void addArtists(Artist artists)
    {
        this.artists[artistsNumber] = artists;
        artistsNumber++;
    }

    public int getArtistsNumber() {
        return artistsNumber;
    }

    public void setArtistsNumber(int artistsNumber) {
        this.artistsNumber = artistsNumber;
    }
}
