package play;

public class App 
{
    private static Game game = new Game();
    public static void main( String[] args )
    {
        game.setGameType();
        game.playGame();
    }
}