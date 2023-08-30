import java.util.*;

public class Game
{
    private int turn = 1;
    public static int Round = 1;
    private static Scanner input = new Scanner(System.in);
    public static String TakeInput(String inputType)
    {
        String in = input.nextLine();
        if(in.equalsIgnoreCase("*help"))
        {
            String rundown = """
                    Basic rules: 
                    At the start of each round, all players and the dealer will be given 2 cards
                    The dealer has one card face-up (visible to everyone)
                    All players place an amount of bet, not surpassing their current balance
                    Who gets to 500 wins the game
                    Return to the request above the 'Basic Rules' to proceed
                    """;

            System.out.println(rundown);
            return TakeInput(inputType);
        }

        switch(inputType){
            case "string":
                return in;
            case "int":
                try {
                    Integer.parseInt(in);
                }
                catch(Exception e) {
                    System.out.println("Invalid input, please retype");
                    return TakeInput(inputType);
                }
        }
        return in;
    }
    //some functions will have options, and numbers are used to mark options.
    public static int TakeInput(int maximumCommandIndex){
        String in = input.nextLine();
        try {
            Integer.parseInt(in);
        }
        catch(Exception e) {
            System.out.println("Invalid input, please retype");
            return TakeInput(maximumCommandIndex);
        }
        return Integer.parseInt(in);
    }
    private static final List<String> cardIndex = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "J", "Q", "K", "A");
    public static HashMap<String, List<String>> RemainingDeck = new HashMap<>();

    public static void NewRound(){
        RemainingDeck.put("c", cardIndex);
        RemainingDeck.put("d", cardIndex);
        RemainingDeck.put("h", cardIndex);
        RemainingDeck.put("s", cardIndex);
    }

    //i will be using lots of Yes/No questions so, better have this as a separate method.
   public static boolean ResponseYesNo(String answer)
   {
        if(answer=="0"){
            return false;
        }
        if(answer=="1"){
            return true;
        }
        System.out.println("Invalid answer. Defaulting to 'no'");
        return false;
   }


}
