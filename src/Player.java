import java.util.ArrayList;
import java.util.List;

public class Player extends BasicParticipantFunctionalities {
    private int chips;

    private static int playerNumber;

    private int betAmount = 0;

    public void PlaceBet(){
        System.out.println("""
                Please place a bet amount.
                Bet amount must not surpass your current chip balance""");
        betAmount = Integer.parseInt(Game.TakeInput("int"));
        if(betAmount > chips){
            System.out.println("""
                    Invalid bet amount""");
            PlaceBet();
        }
    }

    public Player(String name, int playerNumber)
    {
        this.name = name;
        this.chips = 200;
        this.playerNumber = playerNumber;
        this.deck = new ArrayList<>();
        Main.numPlayers++;
        System.out.println(String.format("Player %s created as player number %s", name, playerNumber));
        System.out.println();

        System.out.println("""
                Starting amount of chips: 200
                Get to 500 chips to win, or lose if you have chips left""");
        PlaceBet();
        System.out.println();

        for(int i = 0; i<2; i++){
            BroadcastDrawCard();
        }
        BroadcastDeckValue();
    }

    public void TurnAction() //public so that the Dealer can call action
    {
        if(Game.Round != 1)
        {
            PlaceBet();
        }
        System.out.println(String.format("""
                Player %s, please take one action by typing one of these numbers:
                0 to draw a card
                1 to pass the drawing card""", playerNumber));
        int response = Game.TakeInput(1);

        switch(response)
        {
            case 0:
                BroadcastDrawCard();
                BroadcastDeckValue();
            case 1:
                System.out.println(String.format("Player %s, aka. %s, chose to not draw a card", playerNumber, name));
        }
    }

    private void BroadcastDrawCard(){
        DrawCard();
        String card = DrawCard();
        deck.add(card);
        System.out.println(String.format("%s drew card %s", name, card));
    }

    private void BroadcastDeckValue(){
        deckValue = DeckValue();
        System.out.println(String.format("Player %s's, aka. %s's, deck value is %s", playerNumber, name, deckValue));
    }

    void Bust(){

    }
}
