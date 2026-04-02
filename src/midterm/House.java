//region Instructions
/*
Scenario-2: Create a class House representing a residential building.

It must have:
    int rooms (1–20)
    String address (validate with regex: ^[A-Za-z0-9 ,.-]+$)
    int[] renovationYears

Requirements:
    Constructors (at least 2)
    Static factories (newHouse(), oldHouse())
    Regex validation and exception handling
    toString() that constructs a string using the StringBuilder
    Unit tests: 1 regular test, 1 parameterized test for rooms and address, totaling 4 tests
 */
//endregion Instructions

package midterm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class House
{
    //region Properties
    private int rooms;
    private String address;
    private int[] renovationYears;
    //endregion Properties

    //region Constructors
    public House(){}
    public House(int rooms)
    {
        this.rooms = rooms;
    }
    public House(int rooms, String address)
    {
        this.rooms = rooms;

        try
        {
            if (isValidAddress(address))
            {
                this.address = address;
            }
            else
            {
                System.out.println("Invalid address: " + address);
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid address: " + e.getMessage());
        }
    }

    public House(int rooms, String address, int[] renovationYears)
    {
        this.rooms = rooms;
        this.renovationYears = renovationYears;

        try
        {
            if (isValidAddress(address))
            {
                this.address = address;
            }
            else
            {
                System.out.println("Invalid address: " + address);
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid address: " + e.getMessage());
        }
    }
    //endregion Constructors

    //region Static Factories
    public static House oldHouse(int[] renovationYears)
    {
        House house = new House();

        house.rooms = 3;
        house.address = "1 Charming Street";
        house.renovationYears = renovationYears;

        return house;
    }

    public static House newHouse(int[] renovationYears)
    {
        House house = new House();

        house.rooms = 6;
        house.address = "13 Elm Street";
        house.renovationYears = renovationYears;

        return house;
    }
    //endregion Static Factories

    //Verify Street Address
    private boolean isValidAddress(String address)
    {
        return Pattern.matches("^[A-Za-z0-9 ]+$", address);
    }

    //region Unit Tests
    @Test
    public void constructorTest()
    {
        String address = "address";
        int rooms = 3;
        int[] renovationYears = new int[6];

        House house = new House();
        assertNotNull(house.address);
        assertEquals(rooms, house.rooms);
        assertEquals(renovationYears, house.renovationYears);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123 New Street"})
    public void testAddress(String address)
    {
        House house = new House();
        house.address = address;
        assertEquals(address, house.address);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    public void testRooms(int rooms)
    {
        House house = new House();
        house.rooms = rooms;
        assertEquals(rooms, house.rooms);
    }
    //endregion
}
