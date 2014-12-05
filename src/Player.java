
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class Player extends JPanel {
    private Deck _deck;
    private JPanel _cardsPanel;
    private JButton _hit;
    private JButton _stand;
    
    private HitListener _hitListener;
    
    public Player(Deck d) {
        // Initialization
        this._cardsPanel = new JPanel();
        this._hit = new JButton("HIT");
        this._stand = new JButton("STAND");
        this._deck = d;
        this._hitListener = new HitListener(this._cardsPanel, this._deck);
        
        // Layout
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0, 150, 0));
        this._cardsPanel.setBackground(new Color(0, 150, 0));
        
        // Add Components
        this.add(_stand);
        this.add(_cardsPanel);
        this.add(_hit);
        
        // Add action listeners
        this._hit.addActionListener(this._hitListener);
    }
    
    public void addCard(Card c) {
        this._cardsPanel.add(c);
    }
    
    public void clearCards() {
        this._cardsPanel.removeAll();
    }
    
    public int getTotal() {
        int total = 0;
        // TODO: Iterate through _cardsPanel and calculate total
        return total;
    }
    
    // Action Listeners
    private class HitListener implements ActionListener {
        private JPanel _cardsPanel;
        private Deck _deck;
        
        public HitListener(JPanel cp, Deck d) {
            this._cardsPanel = cp;
            this._deck = d;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            this._cardsPanel.add(this._deck.draw());
        }
    }
}
