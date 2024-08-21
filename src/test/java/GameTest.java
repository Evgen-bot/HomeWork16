import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testFirstPlayerWin() {
        Player vovan = new Player(1, "Вован", 130);
        Player vasyan = new Player(2, "Васян", 100);
        Game game = new Game();

        game.register(vovan);
        game.register(vasyan);
        int actual = game.round("Вован", "Васян");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSecondPlayerWin() {
        Player vovan = new Player(12, "Вован", 130);
        Player vasyan = new Player(124, "Васян", 100);
        Game game = new Game();

        game.register(vovan);
        game.register(vasyan);
        int actual = game.round("Васян", "Вован");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayerEqual() {
        Player vovan = new Player(12, "Вован", 100);
        Player vasyan = new Player(124, "Васян", 100);
        Game game = new Game();

        game.register(vovan);
        game.register(vasyan);
        int actual = game.round("Васян", "Вован");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player vovan = new Player(2, "Вован", 130);
        Game game = new Game();

        game.register(vovan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Гошан", "Вован"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player vovan = new Player(1, "Вован", 130);
        Game game = new Game();

        game.register(vovan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вован", "Гошан"));
    }
}


