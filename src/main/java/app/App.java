package org.example;

import dao.CountryDAO;
import model.City;
import model.Country;

public class App {

    public static void main(String[] args) {
        CountryDAO countryDAO = new CountryDAO();


        Country ukraine = new Country();
        ukraine.setName("Ukraine");

        City kyiv = new City();
        kyiv.setName("Kyiv");
        kyiv.setCountry(ukraine);

        City lviv = new City();
        lviv.setName("Lviv");
        lviv.setCountry(ukraine);

        ukraine.getCities().add(kyiv);
        ukraine.getCities().add(lviv);


        countryDAO.addCountry(ukraine);


        System.out.println(countryDAO.getAllCountries());
    }
}
