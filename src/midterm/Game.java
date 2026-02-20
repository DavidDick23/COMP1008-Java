//region Instructions
/*
Scenario-1: Create a class Game representing a video game.

It must have:
    double version
    String title (validate with regex: ^[A-Za-z0-9 ]+$)
    int[] scores

Requirements:
    Constructors (at least 2)
    Static factories (betaVersion(), fullRelease())
    Validation with exceptions
    toString() that constructs a string using the StringBuilder
    Unit tests: 1 regular test, 1 parameterized test for version and title, totaling 4 tests
 */
//endregion Instructions

package midterm;

//Imports
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Game
{
    //region Properties
    private double version;
    private String title;
    private int[] scores;
    //endregion properties

    //region Getters
    public double getVersion() {
        return version;
    }

    public String getTitle() {
        return title;
    }

    public int[] getScores() {
        return scores;
    }
    //endregion Getters

    //region Constructors
    public Game () { }
    public Game(double version, String title)
    {
        this.version = version;

        try
        {
            if (isValidTitle(title))
            {
                this.title = title;
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid title: " + e.getMessage());
        }
    }

    public Game(double version, String title, int[] scores)
    {
        this.version = version;
        this.scores = scores;

        try
        {
            if (isValidTitle(title))
            {
                this.title = title;
            }
            else
            {
                System.out.println("Invalid title: " + title);
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid title: " + e.getMessage());
        }
    }
    //endregion Constructors

    //region Static Factories
    public static Game betaVersion(String title, int[] scores)
    {
        Game game = new Game();
        game.version = 0.1;
        game.scores = scores;

        return game;
    }

    public static Game fullRealease(String title, int[] scores)
    {
        Game game = new Game();

        game.version = 1.0;
        game.title = title;
        game.scores = scores;

        return game;
    }
    //endregion Static Factories

    //Verify Game Title
    private boolean isValidTitle(String title)
    {
        return Pattern.matches("^[A-Za-z0-9 ]+$", title);
    }

    //region Unit Tests
    @Test
    public void constructorTest()
    {
        String title = "Game Title";
        int[] scores = new int[] {1,2,3,4,5,6,7,8,9,10};

        Game game = new Game();
        assertNotNull(game.scores);
        assertEquals(game.scores, scores);
    }

    @ParameterizedTest
    @ValueSource(strings = {"game1", "game2", "game3"})
    public void testGameTitle(String title)
    {
        Game game = new Game();
        game.title = title;
        assertEquals(title, game.getTitle());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 2.0, 1.0})
    public void testGameVersion(double version)
    {
        Game game = new Game();
        game.version = version;
        assertEquals(version, game.version);
    }
    //endregion
}
