import java.io.Console;
import java.util.Scanner;

public class Main
{
    //a little disclaimer: my experience in OOP is, like, 99% from C#
    //so I do know OOP concepts pretty well, but my execution in Java may not be smoothest
    //missing a lot of exception handling, for example, you can enter letters for bet amount and the game will, break
    //in my honest opinion, the coding here is really messy. If you would like a more organized project, please do let me know.

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        Game.NewGame();

        System.out.println("Game started");
        System.out.println("Card suits: c = club, d = diamond, h = heart");
        System.out.println("Select your name (please don't name yourself Dealer, it will break the game): ");
        String name = TakeInput();
        Player dealer = new Player("Dealer");
        Player player = new Player(name);

    }

    public static String TakeInput(){
        return input.nextLine();
    }
}
