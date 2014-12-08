import java.awt.*;
import static java.lang.Thread.sleep;
import javax.swing.*;

public class Dealer extends JPanel {
    private final Deck _deck;
    
    public Dealer(Deck d) {
        // Add Objects
        this._deck = d;
        
        // Set JPanel Properties
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0, 150, 0));
        
        // Add Initial Cards
        this.add(new Card(this._deck.draw(), false, true));
        this.add(new Card(this._deck.draw(), false, true));
    }
    
    public void showAllCards() {
        for(Component c: this.getComponents()){
            if (c instanceof Card){
                ((Card)c).setReadonlyFace();
            }
        }
    }
	
    public void startDealerTurn() {

        boolean stand = false;
        
        while (!stand){
            if (getDealerScore() < 17){
                Card c = new Card(this._deck.draw(), false, true);
                c.setVisible(false);
                c.setReadonlyFace();
                this.add(c);
                c.setVisible(true);
            }
            else
                stand = true;
        }
        
        System.out.println("Dealer Total: " + getDealerScore());
    }
    
    public int getDealerScore(){
        int dealerTotal = 0;
        
        for(Component c: this.getComponents()){
            if (c instanceof Card)
                dealerTotal += ((Card)c).getWorth();
        }
        
        return dealerTotal;
    }
}
