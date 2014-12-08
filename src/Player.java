
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Player extends JPanel {
    private final Deck _deck;
    private Dealer _dealer;
    private final JPanel _cardsPanel;
    private final JButton _hit;
    private final JButton _stand;
    
    private final HitListener _hitListener;
    private final StandListener _standListener;
    
    public Player(Deck d, Dealer de) {
        // Initialization
        this._cardsPanel = new JPanel();
        this._hit = new JButton("HIT");
        this._stand = new JButton("STAND");
        this._deck = d;
        this._dealer = de;
        this._hitListener = new HitListener(this);
        this._standListener = new StandListener(this, this._dealer);
        
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
        this._stand.addActionListener(this._standListener);
        
        // Add Initial Cards
        this.addCard(new Card(this._deck.draw(), false));
        this.addCard(this._deck.draw());
    }
    
    public void addCard(Card c) {
        this._cardsPanel.add(c);
    }
    
    public void clearCards() {
        this._cardsPanel.removeAll();
    }
    
    public int getTotal() {
        int total = 0;
        for (Component c : this._cardsPanel.getComponents()) {
            if (c instanceof Card) {
                total += ((Card)c).getWorth();
            }
        }
        return total;
    }
    
    public boolean busted() {
        return this.getTotal() > 21;
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
            
            // TODO: Remove Me!
            System.out.println("Total: " + this._player.getTotal());
        }
    }
    
    private class StandListener implements ActionListener {
        private final Player _player;
        private final Dealer _dealer;
        
        public StandListener(Player p, Dealer d) {
            this._player = p;
            this._dealer = d;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // Flips all player cards face up
            for(Component c: this._player._cardsPanel.getComponents()){
                if (c instanceof Card)
                    ((Card)c).setSelected(true);
            }
            
            // TODO: Signal dealer to start their turn!
        }
    }
}
