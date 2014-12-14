import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame {
    private Stat _stat;
    private Deck _deck;
    private Player _player;
    private Dealer _dealer;
    private ExitListener _exitListener;
    
    public Game() {
        // Set JFrame Properties
        this.setSize(600, 600);
        this.setTitle("Blackjack");
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setVisible(true);
        
        // Instantiate Cards
        this._deck = new Deck();
        
        // Instantiate Dealer
        this._dealer = new Dealer(this);
        
        // Instantiate Player
        this._player = new Player(this);
        
        // Add Components
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(0, 150, 0)); // Green background
        this.add(this._player, BorderLayout.SOUTH); // Adds the player cards
        this.add(this._dealer, BorderLayout.NORTH); // Adds the dealers cards
        
        this._stat = new Stat();
        String name = null;
        while (name == null || name.trim().equals("")) {
            name = JOptionPane.showInputDialog(this, "Enter your name for the leaderboards!");
        }
        
        this._stat.name(name);
        this._stat.wins(0);
        this._stat.losses(0);
        
        // Add Exit Listener
        this._exitListener = new ExitListener(this._stat);
        this.addWindowListener(this._exitListener);
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

	/**
	* Determines winner and displays a message via JOptionPane
	*/
    public void determineWinner() {
        StringBuilder fullMessage = new StringBuilder();
        String message;
        if (this._player.getTotal() > 21) {
            message = "You busted!";
            this._stat.lose();
        } else if (this._player.getTotal() == 21) {
            message = "Blackjack! You win!";
            this._stat.win();
        } else if (this._dealer.getDealerScore() > 21) {
            message = "The dealer busted, you win!";
            this._stat.win();
        } else if (this._dealer.getDealerScore() == 21) {
            message = "The dealer has blackjack, you lose!";
            this._stat.lose();
        } else if (this._dealer.getDealerScore() > this._player.getTotal()) {
            message = "The dealer has more than you, you lose!";
            this._stat.lose();
        } else if (this._dealer.getDealerScore() == this._player.getTotal()) {
            message = "You tied!";
        }else {
            message = "You have more than the dealer, you win!";
            this._stat.win();
        }
        fullMessage.append(message);
        fullMessage.append("\nYour total: ").append(this._player.getTotal());
        fullMessage.append("\nDealer's total: ").append(this._dealer.getDealerScore());
        JOptionPane.showMessageDialog(this, fullMessage.toString());
    }
    
    class ExitListener extends WindowAdapter {
        private Stat _stat;
        public ExitListener(Stat s) {
            this._stat = s;
        }
        @Override
        public void windowClosing(WindowEvent e) {
			// Before closing, write the statistics to file
            this._stat.writeToFile();
            System.exit(0);
        }
    }
}
