import java.util.ArrayList;
import java.util.List;

public class Dealer extends BasicParticipantFunctionalities
{
    private String name = "Dealer";

    private List<String> shownCards = new ArrayList<>();

    private int numAlreadyShown = 0;

    public Dealer(){
        this.deck = new ArrayList<>();
        System.out.println("Dealer created");
        for(int i = 0; i<2; i++){
            String card = DrawCard();
            deck.add(card);
        }
        FaceUp(numAlreadyShown);
    }

    private void FaceUp(int numAlreadyShown){
        String card = deck.get(numAlreadyShown);
        shownCards.add(card);
        System.out.println(String.format("One of the dealer's cards is %s", card));
        this.numAlreadyShown++;

    }

    void Bust(){

    }

    void TurnAction() {

    }
}
