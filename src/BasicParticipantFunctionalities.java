import java.util.List;
import java.util.Random;

//sorry for the super verbose name. I just want things to be as clear as possible just by reading the name
public abstract class BasicParticipantFunctionalities
{
    List<String> deck;
    List<String> faceUpCards; //universally observable cards. Will be more useful if I plan to add multiplayer
    String name;
    int deckValue = 0;

    int DeckValue() {
        int cardValue = 0;
        for (String s :
                deck) {
            String card = s.substring(1);
            switch (card) {
                case "J", "Q", "K":
                    cardValue += 10;
                    break;
                case "A":
                    cardValue += 11;
                    break;
                default:
                    cardValue += Integer.parseInt(card);
            }
        }
        return cardValue;
    }

    String DrawCard(){
        Random rng = new Random();
        String[] suits = {"c", "d", "h", "s"};

        int suit_choice = rng.nextInt(suits.length);
        List<String> availableIndexes = Game.RemainingDeck.get(suits[suit_choice]);

        int value_choice_index = rng.nextInt(availableIndexes.size());
        String card = suits[suit_choice] + availableIndexes.get(value_choice_index);
        Game.RemainingDeck.remove(availableIndexes.get(value_choice_index));
        return card;

    }



    abstract void Bust(); //since the actions will be different between Player and Dealer

    abstract void TurnAction();
}
