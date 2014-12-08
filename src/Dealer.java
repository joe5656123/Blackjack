import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dealer extends JPanel {
    private Deck _deck;
    private Player _player;
    private Game _game;
    
    public Dealer(Game g) {
        // Add Objects
        this._deck = g.getDeck();
        this._player = g.getPlayer();
        this._game = g;
        
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
	
    public void startDealerTurn(Player p) {
        this._player = p;
        
        boolean stand = _player.busted();
        
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
