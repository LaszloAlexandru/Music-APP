package com.company.Services;

import com.company.Entity.Artist;

import java.sql.*;
import java.util.ArrayList;

public class SongsHandlerService {

    private Connection con = null;
    private String databaseName = "musicapp";
    private String url="jdbc:mysql://127.0.0.1:4040/"+databaseName+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username="root";
    private String password="laszloaa1";



    public ArrayList<Artist> readArtist () throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url,username,password);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }
        String query = "SELECT * FROM ARTISTI";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<Artist> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("idArtisti");
            String nume = rs.getString("Nume");
            String prenume = rs.getString("Prenume");
            int prodID = rs.getInt("idProducator");
            int CNP = rs.getInt("CNP");
            //String email = rs.getString("email");
            String email = "hatz@gmail.com";
            System.out.println(nume + " " + prenume);
            Artist artist = new Artist(nume,prenume,email,CNP);
            lista.add(artist);
        }
        return lista;
    }
    public void deleteArtist (int numeDeSters) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        String query = "DELETE FROM ARTISTI WHERE idArtisti = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, numeDeSters);
        ps.executeUpdate();
    }
}
