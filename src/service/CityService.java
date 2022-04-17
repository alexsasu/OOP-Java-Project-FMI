package service;

import model.City;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityService {
    private static CityService INSTANCE = null;
    private final ReadService readService = ReadService.getInstance();
    private final WriteService writeService = WriteService.getInstance();

    private final String fileName = "src/csvFiles/Cities.csv";
    private List<City> cities = new ArrayList<>();

    private CityService() { }

    public static CityService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CityService();
        }

        return INSTANCE;
    }

    public City getCityById(Integer idCity) {
        try {
            int currentPosition = 0, index = -1;
            for (City city : cities) {
                if (city.getIdCity().equals(idCity)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return cities.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public City getCityByName(String name) {
        try {
            int currentPosition = 0, index = -1;
            for (City city : cities) {
                if (city.getName().equals(name)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return cities.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public List<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        cities.add(city);
    }

//    public void updateCityById(Integer idCity) {
//
//    }

    public void deleteCityById(Integer idCity) {
        try {
            int currentPosition = 0, index = -1;
            for (City city : cities) {
                if (city.getIdCity().equals(idCity)) {
                    index = currentPosition;
                }
                ++currentPosition;
            }
            cities.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readCitiesFromFile() {
        String[] cities = readService.readFromFile(this.fileName).split("\n");

        try {
            for (String city : cities) {
                String[] cityInfo = city.split(",");
                City cityToBeAdded = new City(Integer.parseInt(cityInfo[0]), cityInfo[1]);
                this.cities.add(cityToBeAdded);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void writeCitiesToFile() {
        // Deleting file contents
        try {
            new FileOutputStream(this.fileName).close();
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }

        for (City city : cities) {
            String cityInfo = city.getIdCity() + "," + city.getName();

            writeService.writeToFile(fileName, cityInfo);
        }
    }
}
