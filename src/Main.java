public class Main
{
    //a little disclaimer: my experience in OOP is, like, 99% from C#
    //so I do know OOP concepts pretty well, but my execution in Java may not be smoothest

    public static int numPlayers = 1;
    public static void main(String[] args)
    {
        Game.NewRound();
        System.out.println("""
                The game is still primitive. Maybe one day I will allow more players to join in.
                Type *help to get some basic rundowns
                Please type your name""");

        String name = Game.TakeInput("string");
        Player player = new Player(name, numPlayers);
        Dealer dealer = new Dealer();
        player.TurnAction();
    }
}
