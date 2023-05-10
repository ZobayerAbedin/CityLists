package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    /**
     * test delete() method
     */
    @Test
    public void testDelete() {
        CityList cityList = new CityList();
        City city1 = new City("d", "Dhaka");
        City city2 = new City("k", "Khulna");

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertTrue(!cityList.getCities(0).contains(city1));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * test whether delete function throwing a exception, when we try
     * to delete some non-exist city
     */
    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city1 = new City("d", "Dhaka");
        City city2 = new City("k", "Khulna");

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city = new City("A", "Z");
        City city1 = new City("Z", "A");

        cityList.add(city);
        cityList.add(city1);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(0).get(1)));
    }

    /**
     * test count() method
     */
    @Test
    public void testCount() {
        CityList cityList = new CityList();
        City city1 = new City("A", "Z");
        City city2 = new City("Z", "A");

        cityList.add(city1);
        cityList.add(city2);

        assertEquals(2, cityList.count());
    }

    /**
     * test whether getCitities method sorting the cities in the desired
     * manner
     */
    @Test
    public void testSort() {
        CityList cityList = new CityList();
        City city = new City("A", "Z");
        City city1 = new City("Z", "A");

        cityList.add(city);
        cityList.add(city1);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(0).get(1)));
    }

}
