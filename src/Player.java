
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Player extends JPanel {
    private Game _game;
    private Deck _deck;
    private Dealer _dealer;
    private JPanel _cardsPanel;
    private JButton _hit;
    private JButton _stand;
    private JButton _newGameButton;
    private JLabel _score;
    
    private HitListener _hitListener;
    private StandListener _standListener;
    private ExitListener _exitListener;
    
    public Player(Game g) {
        // Initialization
        this._game = g;
        this._cardsPanel = new JPanel();
        this._hit = new JButton("HIT");
        this._stand = new JButton("STAND");
        this._deck = g.getDeck();
        this._dealer = g.getDealer();
        this._hitListener = new HitListener(this);
        this._standListener = new StandListener(this, this._dealer);
        this._exitListener = new ExitListener(this._game);
        this._newGameButton = new JButton("New Game");
        this._score = new JLabel();
        
        // Layout
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0, 150, 0));
        this._cardsPanel.setBackground(new Color(0, 150, 0));
        
        // Add Components
        this.add(_stand);
        this.add(_score);
        this.add(_cardsPanel);
        this.add(_hit);
        this.add(_newGameButton);
        
        // Add action listeners
        this._hit.addActionListener(this._hitListener);
        this._stand.addActionListener(this._standListener);
        this._newGameButton.addActionListener(this._exitListener);
        
        // Add Initial Cards
        this.addCard(new Card(this._deck.draw(), false));
        this.addCard(this._deck.draw());
        this._score.setText(Integer.toString(this.getTotal()));
        
		// If either player has 21, end the player's turn
        if (this.getTotal() == 21 || this._dealer.getDealerScore() == 21) {
            this._standListener.actionPerformed(null);
        }
    }
    
    public void addCard(Card c) {
        this._cardsPanel.add(c);
    }
    
    public void clearCards() {
        this._cardsPanel.removeAll();
    }
    
	/**
	* Switches all cards to face up
	*/
    public void showAllCards() {
        for(Component c: this._cardsPanel.getComponents()){
            if (c instanceof Card) {
                ((Card)c).setReadonlyFace();
            }
        }
    }
    
    public void setGame(Game g) {this._game = g;}
    
	/**
	* Returns the total value of all cards
	*/
    public int getTotal() {
        int total = 0;
        for (Component c : this._cardsPanel.getComponents()) {
            if (c instanceof Card) {
                total += ((Card)c).getWorth();
            }
        }
        this._score.setText(Integer.toString(total));
        return total;
    }
    
    public boolean busted() {
        return this.getTotal() > 21;
    }

	/**
	* Disables the Hit and Stand buttons
	*/
    public void disableButtons() {
        this._hit.setEnabled(false);
        this._stand.setEnabled(false);
    }
    
	/**
	* Enables the Hit and Stand buttons
	*/
    public void enableButtons() {
        this._hit.setEnabled(true);
        this._stand.setEnabled(true);
    }
    
	/**
	* Checks to see if the player has the specified card in his/her hand
	* @returns the index of first card, or -1
	*/
    public int hasCard(Denomination d) {
        int count = 0;
        for (Component c : this._cardsPanel.getComponents()) {
            if (c instanceof Card && ((Card)c).getDenomination().equals(d.toString())) {
                return count;
            }
            count++;
        }
        return -1;
    }

	/**
	* Main method used to differentiate between an Ace with a value of 11 or 1
	*/
    private boolean switchToHardAce() {
        Component[] c = this._cardsPanel.getComponents();
        for (int i = 0; i < c.length; i++) {
            if (c[i] instanceof Card && ((Card)c[i]).getDenomination().equals(Denomination.Ace.toString())) {
                ((Card)c[i]).switchToHardAce();
                return true;
            }
        }
        return false;
    }
    
    // Action Listeners
    private class HitListener implements ActionListener {
        private Player _player;
        
        public HitListener(Player p) {
            this._player = p;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
			// Draws a card
            this._player._cardsPanel.add(this._player._deck.draw());
			this._player.repaint();
			this._player.revalidate();
            
			// If the player has 'busted'
            if (this._player.getTotal() > 21) {
				// Determine if an Ace could be switched to value: 1
                if (this._player.hasCard(Denomination.Ace) != -1) {
                    while (this._player.getTotal() > 21) {
                        if (!this._player.switchToHardAce()) {
                            break;
                        }
                    }
                }
            }
			// If the player has blackjack or has busted, end turn
            if (this._player.getTotal() >= 21) {
                this._player._standListener.actionPerformed(null);
            }
        }
    }
    
    private class StandListener implements ActionListener {
        private Player _player;
        private Dealer _dealer;
        
        public StandListener(Player p, Dealer d) {
            this._player = p;
            this._dealer = d;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {  
            // Flips all player cards face up
            this._player.showAllCards();
            
            // Flips all dealer cards face up
            this._dealer.showAllCards();
            
            // Disables hit / stand buttons
            this._player.disableButtons();

            // Signals dealer to start their turn
            this._dealer.startDealerTurn(this._player);
        }
    }
    private class ExitListener implements ActionListener {
        private Game _game;
        
        public ExitListener(Game g) {
            this._game = g;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
			// Clears the board to begin a new game
            this._game.restartGame(this._game);
        }
    }
}
