
import java.awt.*;
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
        this._hitListener = new HitListener(this);
        
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
        for (Component c : this._cardsPanel.getComponents()) {
            if (c instanceof Card) {
                total += ((Card)c).getWorth();
            }
        }
        return total;
    }
    
    // Action Listeners
    private class HitListener implements ActionListener {
        private final Player _player;
        
        public HitListener(Player p) {
            this._player = p;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            this._player._cardsPanel.add(this._player._deck.draw());
            this._player.setVisible(false);
            this._player.setVisible(true);
            
            // Remove Me!
            System.out.println("Total: " + this._player.getTotal());
        }
    }
}
