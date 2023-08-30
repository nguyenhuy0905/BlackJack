import java.util.ArrayList;
import java.util.List;

public class Player {
    //i'm being lazy here. Some of the Dealer-exclusive methods will still be put in here.
    private List<String> deck = new ArrayList<>();

    public int BetAmount;

    public void ShowDeck() {
        System.out.println("Cards in deck: ");
        for (String card :
                deck) {
            System.out.println(card);
        }
    }

    private String name;
    private int chips;

    public void AddChips(int amount) {
        chips += amount;
        System.out.println(String.format("New chip balance: %s", chips));
        if (chips >= 500) {
            System.out.println("You won!");
            //let's pretend the game is over here. I haven't the time to code a restart function
        }
    }

    public void SubtractChips(int amount) {
        chips -= amount;
        System.out.println(String.format("New chip balance: %s", chips));
        if (chips <= 0) {
            System.out.println("You lost lol");
            //let's pretend the game is over here.
        }
    }

    public Player(String name) {
        this.name = name;
        chips = 200;
        System.out.println(String.format("Player %s created", name));
        deck.add(Game.DrawCard());
        deck.add(Game.DrawCard());
        if (name != "Dealer") {
            System.out.println("Place bet amount: ");
            BetAmount = Integer.parseInt(Main.TakeInput());
            System.out.println(String.format("Starting chip balance: %s", chips));
            ShowDeck();
            DeckValue();
            return;
        }
        FaceUp(0);
    }

    public int DeckValue() {
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
        System.out.println(String.format("%1s deck has value of %2s", name, cardValue));
        System.out.println("Please select an action: " +
                "1 for Hit, " +
                "2 for Pass");
        CardAction(Main.TakeInput());
        return cardValue;


    }

    //actions
    private void CardAction(String input) {
        switch (input) {
            case "1":
                System.out.println("You chose to draw a card");
                String card = Game.DrawCard();
                deck.add(card);
                System.out.println(String.format("Drew a %s card", card));
                DeckValue();
                break;
            case "2":
                System.out.println("You chose to not draw a new card");
            default:
                break;
        }
    }

    //the methods down here are dealer-specific.
    public String FaceUp(int index) {
        System.out.println(String.format("One of the dealer's cards is %s", deck.get(index)));
        if (index == deck.size() && index > 16) {
            {
                String card = Game.DrawCard();
                deck.add(card);
                System.out.println(String.format("The dealer drew a %s card", card));
            }
        }
        return deck.get(index);
    }
}
