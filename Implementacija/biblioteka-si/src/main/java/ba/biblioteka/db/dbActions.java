package ba.biblioteka.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.*;
import java.sql.Statement;

import ba.biblioteka.models.Osoba;

        public class dbActions {

                private Connection connect = null;
                private Statement statement = null;
                private PreparedStatement preparedStatement = null;
                private ResultSet resultSet = null;

                final private String host = "localhost:3306";
                final private String username = "EtfSI2016";
                final private String password = "2016SIEtf";
                final private String database = "tim7";

                public void connectToDB() throws Exception {
                        try {
                                
                                Class.forName("com.mysql.jdbc.Driver");
                                connect = DriverManager.getConnection("jdbc:mysql://" + host + "/"
                                                + database + "?" + "user=" + username + "&password=" + password);

                        } catch (Exception e) {
                                throw e;
                        }
                }

                public List<Osoba> readUsers() throws Exception {
                        try {
                                statement = connect.createStatement();
                                resultSet = statement
                                                .executeQuery("select * from " + database + ".osoba");
                                List<Osoba> users = new ArrayList<Osoba>();
                                while (resultSet.next()) {
                                        String korisnicko_ime = resultSet.getString("korisnicko_ime");
                                        String sifra = resultSet.getString("sifra");
                                        Osoba user = new Osoba();
                                        user.setKorisnicko_ime(korisnicko_ime);
                                        user.setSifra(sifra);
                                        users.add(user);
                                        
                                }
                                return users;
                        } catch (Exception e) {
                                throw e;
                        }
                }
                
              
                
                public void storeUser(String korisnicko_ime, String sifra) throws Exception {
                    try {
                    		
                            statement = connect.createStatement();
               
                             PreparedStatement statement = connect.prepareStatement("INSERT INTO " + database + ".osoba (korisnicko_ime, sifra) VALUES ( ?, ?)");
                             statement.setString(1, korisnicko_ime);
                             statement.setString(2, sifra);
                             statement.execute();
                    } catch (Exception e) {
                            throw e;
                    }
                }
                
                
                public Osoba searchUserForLogin(String korisnicko_ime, String sifra) throws Exception {
                    try {

                        statement = connect.createStatement();
                        
                    	PreparedStatement statement = connect.prepareStatement("select * from " + database + ".osoba WHERE korisnicko_ime=? AND sifra=?");
                    	statement.setString(1,korisnicko_ime);
                    	statement.setString(2,sifra);
                        resultSet = statement.executeQuery();
    
                        Integer _id = null;
                        String _korisnicko_ime = null;
                        String _sifra = null;
                        String _ime = null;
                        String _prezime = null;
                        String _tip = null;
                        
                    
     
                        while (resultSet.next()) {
                        	
                        	_id = resultSet.getInt("id");
                        	_korisnicko_ime = resultSet.getString("korisnicko_ime");
                            _sifra = resultSet.getString("sifra");
                        	_ime = resultSet.getString("ime");
                            _prezime = resultSet.getString("prezime");
                            _tip = resultSet.getString("tip");
                            
                         
                        }

                      
                      
                        if(_korisnicko_ime != null && _sifra != null){
                        	
                        	Osoba user = new Osoba();
                        	user.setKorisnicko_ime(_korisnicko_ime);
                            user.setSifra(_sifra);
                            user.setId(_id);
                            user.setTip(_tip);
                            user.setIme(_ime);
                            user.setPrezime(_prezime);
                           
                            
                            return user;
                        }
                        else
                        	return null;

                    } catch (Exception e) {
                            throw e;
                    }
            }
                
               
                public void close() {
                        try {
                                if (resultSet != null) {
                                        resultSet.close();
                                }

                                if (statement != null) {
                                        statement.close();
                                }

                                if (connect != null) {
                                        connect.close();
                                }
                        } catch (Exception e) {

                        }
                }

        }


