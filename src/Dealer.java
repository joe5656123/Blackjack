
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
        Card c = new Card(this._deck.draw(), true, true);
        c.setReadonlyFace();
        this.add(c);
        this.add(new Card(this._deck.draw(), false, true));
    }

    public void showAllCards() {
        for (Component c : this.getComponents()) {
            if (c instanceof Card) {
                ((Card) c).setReadonlyFace();
            }
        }
    }

    public void startDealerTurn(Player p) {
        this._player = p;

        boolean stand = _player.getTotal() >= 21;
        
        // Dealer hits up to 16 and stands on 17 and above,
        // Dealer will hit on soft 17 (has Ace at value: 11)
        while (!stand) {
            if (this.getDealerScore() < 17 || (this.hasCard(Denomination.Ace) != -1 && this.getDealerScore() <= 17)) {
                Card c = new Card(this._deck.draw(), false, true);
                c.setVisible(false);
                c.setReadonlyFace();
                this.add(c);
                c.setVisible(true);
            } else {
                stand = true;
            }
            
            // TODO: TEST Code Ace logic here?
            if (this.getDealerScore() > 21) {
                if (this.hasCard(Denomination.Ace) != -1) {
                    while (this.getDealerScore() > 21) {
                        if (!this.switchToHardAce()) {
                            break;
                        }
                    }
                }
            }
            // I don't like the sleep...
            // try { Thread.sleep(500); } catch (Exception ex) { }
        }

        // Ends dealer's turn
        this._game.determineWinner();
    }

    public int getDealerScore() {
        int dealerTotal = 0;

        for (Component c : this.getComponents()) {
            if (c instanceof Card) {
                dealerTotal += ((Card) c).getWorth();
            }
        }

        return dealerTotal;
    }

    private boolean switchToHardAce() {
        Component[] c = this.getComponents();
        for (int i = 0; i < c.length; i++) {
            if (c[i] instanceof Card && ((Card) c[i]).getDenomination().equals(Denomination.Ace.toString())) {
                ((Card) c[i]).switchToHardAce();
                return true;
            }
        }
        return false;
    }

    public int hasCard(Denomination d) {
        int count = 0;
        for (Component c : this.getComponents()) {
            if (c instanceof Card && ((Card) c).getDenomination().equals(d.toString())) {
                return count;
            }
            count++;
        }
        return -1;
    }
}
