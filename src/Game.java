import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Game
{
    private static final List<String> cardIndex = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "J", "Q", "K", "A");
    public static HashMap<String, List<String>> RemainingDeck = new HashMap<>();

    public static void NewGame(){
        RemainingDeck.put("c", cardIndex);
        RemainingDeck.put("d", cardIndex);
        RemainingDeck.put("h", cardIndex);
        RemainingDeck.put("s", cardIndex);
    }

    public static String DrawCard(){
        Random rng = new Random();
        String[] suits = {"c", "d", "h", "s"};

        int suit_choice = rng.nextInt(suits.length);
        List<String> availableIndexes = RemainingDeck.get(suits[suit_choice]);

        int value_choice_index = rng.nextInt(availableIndexes.size());
        String card = suits[suit_choice] + availableIndexes.get(value_choice_index);
        RemainingDeck.remove(availableIndexes.get(value_choice_index));
        return card;
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
