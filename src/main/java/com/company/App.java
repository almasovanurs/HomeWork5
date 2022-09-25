package com.company;

import com.company.model.City;
import com.company.model.Country;
import com.company.model.util.bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )  {

      // bd.getById(2);



      // creatTablePeople();
       // creatTableCity();
      // creatTableCountry();

      /* insertTablePeople(6,"Joseph Robinette ","Biden",79,"president");
        insertTablePeople(7,"Kim ","Jong un",38,"president");
       insertTablePeople(8,"Shinzō","Abe",67,"president");

        insertTableCities(11,5,"Washington","10million");
      insertTableCities(22,8,"Seul","22million");
      insertTableCities(33,9,"Tokio","23million");

       insertTableCountries(1,"USA","English",900000);
        insertTableCountries(2,"Korea","Korean",637822);
        insertTableCountries(3,"Japon","Japon",100203);

        List<City> allCities = getAllCity();
        System.out.println(allCities);

      List<Country> allCountry = getAllCountry();
      System.out.println(allCountry);*/






    }
        public static void creatTablePeople() {
        String SQL = "CREATE TABLE IF NOT EXISTS people(" +
                " id INT PRIMARY KEY ," +
                " name VARCHAR(50) NOT NULL ," +
                " surname VARCHAR(50) NOT NULL," +
                " age INT," +
                " position VARCHAR(50) NOT NULL)";
        try (Connection conn = bd.connect();
             Statement statement = conn.createStatement()){
            statement.executeUpdate(SQL);
            System.out.println("tablisa uspeshno koshuldu1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        public static void insertTablePeople(int id, String name, String surname, int age, String position){
        String SQL = "INSERT INTO people (id,name,surname,age,position ) VALUES(?,?,?,?,?)";
        try(Connection connect = bd.connect();
            PreparedStatement statement = connect.prepareStatement(SQL)){
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setString(3,surname);
            statement.setInt(4,age);
            statement.setString(5,position);
            statement.executeUpdate();
            System.out.println("informasiya koshuldu1");
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }



        public static void creatTableCity(){
        String SQL = "CREATE TABLE  city(" +
                "id INT NOT NULL," +
                "countryId INT PRIMARY KEY, " +
                "name VARCHAR (50) NOT NULL UNIQUE ," +
                "city_measures VARCHAR(90) NOT NULL)";
        try (Connection conn = bd.connect();
             Statement statement = conn.createStatement()){
            statement.executeUpdate(SQL);
            System.out.println("tablisa uspeshno tuzuldu2");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

        public static void insertTableCities(int id,int countryId,String name, String city_measures){
        String SQL2 = "INSERT INTO city(id,name,countryId ,city_measures) VALUES(?,?,?,?)";
        try(Connection connect = bd.connect();
            PreparedStatement statement = connect.prepareStatement(SQL2)){
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setInt(3,countryId);
            statement.setString(4,city_measures);
            statement.executeUpdate();
            System.out.println("maalymat koshuldu2");
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }
        public static List<City> getAllCity() {
        String sql = "SELECT * FROM city";
        List<City> cities = new ArrayList<>();
        try (Connection conn = bd.connect();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                City city = new City();
                int id = resultSet.getInt("id");
                int countryId = resultSet.getInt("countryId");
                String name = resultSet.getString("name");
                String city_measures = resultSet.getString("city_measures");
                int peopleId = resultSet.getInt("peopleId" + name);
                city.setId(id);
                city.setCountryId(countryId);
                city.setName(name);
                city.setCity_measures(city_measures);
                city.setPeopleId(peopleId);
                cities.add(city);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }
        public static void creatTableCountry(){
        String SQL =  "CREATE TABLE IF NOT EXISTS country(" +
                " id INT PRIMARY KEY ," +
                "tongue VARCHAR (100) NOT NULL," +
                "square INTEGER," +
                " name VARCHAR (50) NOT NULL )";
        try (Connection conn = bd.connect();
             Statement statement = conn.createStatement()){
            statement.executeUpdate(SQL);
            System.out.println("tablisa uspeshno tuzuldu3");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

        public static void insertTableCountries(int id,String name, String tongue, int square){
        String SQL = "INSERT INTO country(id,name, tongue,square) VALUES(?,?,?,?)";
        try(Connection connect = bd.connect();
            PreparedStatement statement = connect.prepareStatement(SQL)){
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setString(3,tongue);
            statement.setInt(4,square);
            statement.executeUpdate();
            System.out.println("maalymat koshuldu3");
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }
        public static List<Country> getAllCountry() {
        String sql = "SELECT * FROM country";
        List<Country> countries = new ArrayList<>();
        try (Connection conn = bd.connect();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Country country = new Country();
                int id = resultSet.getInt("id");
                int tongue = resultSet.getInt("tongue");
                String name = resultSet.getString("name");
                String square = resultSet.getString("square");
                country.setId(id);
                country.setTongue(String.valueOf(tongue));
                country.setName(name);
                country.setSquare(Integer.parseInt(square));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return countries;
    }



    }

