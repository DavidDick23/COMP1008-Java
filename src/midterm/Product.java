//region Instructions
/*
Create a class Product representing a store item.

It must have:
    double price (positive only)
    String sku (validate with regex: ^[A-Z]{3}-\d{4}$)
    int[] monthlySales

Requirements:
    Constructors (at least 2)
    Static factory named fromSKU(String)
    Validation with exceptions (price & sku)
    toString() method that uses StringBuilder in method body for sku getter
    Unit test checking SKU format and price range (1 regular test, 1 parameter test for sku and price, totaling 4 tests)
 */
//endregion

package midterm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Product
{
    //region Properties
    private double price;
    private String sku;
    private int[] monthlySales;
    //endregion Properties

    //region Constructors
    public Product() {}
    public Product(int price)
    {
        this.price = price;
    }

    public Product(int price, String sku)
    {
        this.price = price;

        try
        {
            if (isValidSku(sku))
            {
                this.sku = sku;
            }
            else
            {
                System.out.println("Invalid sku: " + sku);
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid sku: " + e.getMessage());
        }
    }

    public Product(int price, String sku, int[] monthlySales)
    {
        this.price = price;
        this.monthlySales = monthlySales;

        try
        {
            if (isValidSku(sku))
            {
                this.sku = sku;
            }
            else
            {
                System.out.println("Invalid sku: " + sku);
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid sku: " + e.getMessage());
        }
    }
    //endregion Constructors

    //Static Factory
    public static Product fromSku(String sku)
    {
        Product product = new Product();
        product.sku = sku;

        return product;
    }

    //Verify Sku
    private boolean isValidSku(String sku)
    {
        return Pattern.matches("^[A-Za-z0-9 ]+$", sku);
    }

    //region Unit Tests
    @Test
    public void constructorTest()
    {
        String sku = "aw12345";
        double price = 12.99;
        int[] monthlySales = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Product product = new Product();
        assertNotNull(monthlySales);
        assertEquals(sku, this.sku);
        assertEquals(price, this.price);
    }

    @ParameterizedTest
    @ValueSource(doubles = {11.44, 2.99})
    public void testPrice(double price)
    {
        Product product = new Product();
        assertEquals(price, product.price);
    }

    @ParameterizedTest
    @ValueSource(strings = {"er2323", "cd6789"})
    public void testSku(String sku)
    {
        Product product = new Product();

        assertEquals(sku, product.sku);
    }
    //endregion
}
