package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {


    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList mockEmptyCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = mockEmptyCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = mockEmptyCityList();
        City city = mockCity();
        Assertions.assertFalse(list.hasCity(city));
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city));
        City otherCity = new City("Charleston", "PEI");
        Assertions.assertFalse(list.hasCity(otherCity));
    }

    @Test
    void testDeleteCity() {
        CustomList cityList = mockEmptyCityList();
        City city = mockCity();
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
        cityList.addCity(city);
        Assertions.assertTrue(cityList.hasCity(city));
        cityList.deleteCity(city);
        Assertions.assertFalse(cityList.hasCity(city));
        City otherCity = new City("Charleston", "PEI");
        assertThrows(IllegalArgumentException.class , () -> {
            cityList.deleteCity(otherCity);
        });
    }
}
