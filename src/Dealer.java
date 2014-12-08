import java.awt.*;
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
        /*
        Card c = new Card(this._deck.draw(), false, true);
        c.setSelected(true);
        this.add(c);
        */
        this.add(new Card(this._deck.draw(), false, true));
        this.add(new Card(this._deck.draw(), false, true));
    }
    
    public void startTurn(){
        
    }
}
