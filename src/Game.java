import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame {
    private int numWins;
    private int numLosses;
    private Deck _deck;
    private Player _player;
    private Dealer _dealer;
    private JButton _newGameButton;
    
    public Game() {
        // Set JFrame Properties
        this.setSize(600, 600);
        this.setTitle("Blackjack");
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setVisible(true);
        
        // Instansiate Cards
        this._deck = new Deck();
        
        // Configure Dealer
        this._dealer = new Dealer(this);
        
        // Configure Player
        this._player = new Player(this); // Adds the player panel
        
        // Add Components
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(0, 150, 0)); // Green background
        this.add(this._player, BorderLayout.SOUTH); // Adds the player cards
        this.add(this._dealer, BorderLayout.NORTH); // Adds the dealers cards
        
        // TODO: Read wins / losses in from file
        
        this.numWins = 0;
        this.numLosses = 0;
    }
    
    public void restartGame(Game g) {
        this.remove(this._player);
        this.remove(this._dealer);
        
        this._dealer = new Dealer(this);
        this._player = new Player(this);
        
        this.add(this._dealer, BorderLayout.NORTH);
        this.add(this._player, BorderLayout.SOUTH);
        
        this.repaint();
        this.revalidate();
    }
    
    public Player getPlayer() {
        return this._player;
    }
    
    public Dealer getDealer() {
        return this._dealer;
    }
    
    public Deck getDeck() {
        return this._deck;
    }

    public void determineWinner() {
        StringBuilder fullMessage = new StringBuilder();
        String message;
        if (this._player.getTotal() > 21) {
            message = "You busted!";
            this.numLosses++;
        } else if (this._player.getTotal() == 21) {
            message = "Blackjack! You win!";
            this.numWins++;
        } else if (this._dealer.getDealerScore() > 21) {
            message = "The dealer busted, you win!";
            this.numWins++;
        } else if (this._dealer.getDealerScore() == 21) {
            message = "The dealer has blackjack, you lose!";
            this.numLosses++;
        } else if (this._dealer.getDealerScore() > this._player.getTotal()) {
            message = "The dealer has more than you, you lose!";
            this.numLosses++;
        } else if (this._dealer.getDealerScore() == this._player.getTotal()) {
            message = "You tied!";
        }else {
            message = "You have more than the dealer, you win!";
            this.numWins++;
        }
        fullMessage.append(message);
        fullMessage.append("\nYour total: ").append(this._player.getTotal());
        fullMessage.append("\nDealer's total: ").append(this._dealer.getDealerScore());
        fullMessage.append("\nWins: ").append(this.numWins);
        fullMessage.append("\nLosses: ").append(this.numLosses);
        if (this.numLosses > 0) fullMessage.append("\nWin / Loss Ratio: ").append(this.numWins / this.numLosses);
        JOptionPane.showMessageDialog(this, fullMessage.toString());
    }
}
