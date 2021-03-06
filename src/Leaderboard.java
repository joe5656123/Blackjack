
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Leaderboard extends JFrame {
    private StatCollection _statCollection;
    private InputListener _inputListener;
    
    public Leaderboard (StatCollection sc) {
        this._statCollection = sc;
        Collections.sort(this._statCollection, new Comparator<Stat>() {
            @Override 
            public int compare(Stat p1, Stat p2) {
                return p2.winLossRatio() > p1.winLossRatio() ? 1 : p2.winLossRatio() == p1.winLossRatio() ? 0 : -1;
                //return p2.wins() - p1.wins();
            }
        });
        
        this.setSize(512, 512);
        this.setLayout(new GridLayout((this._statCollection.size() > 10 ? 10 : this._statCollection.size()) + 1, 5));
        this.setLocationRelativeTo(null);
        
        this.add(new JLabel("Place:"));
        this.add(new JLabel("Name:"));
        this.add(new JLabel("W/L Ratio:"));
        this.add(new JLabel("Wins:"));
        this.add(new JLabel("Losses:"));
        
        for (int i = 0; i < (this._statCollection.size() > 10 ? 10 : this._statCollection.size()); i++) {
            Stat s = this._statCollection.get(i);
            this.add(new JLabel((i + 1) + ") "));
            this.add(new JLabel(s.name()));
            this.add(new JLabel("" + s.winLossRatio()));
            this.add(new JLabel("" + s.wins()));
            this.add(new JLabel("" + s.losses()));
        }
        
        this._inputListener = new InputListener(this);
        this.addKeyListener(this._inputListener);
    }
    
    class InputListener extends KeyAdapter {
        private Leaderboard _leaderboard;
        
        public InputListener(Leaderboard l) {
            this._leaderboard = l;
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'd') {
                // This functionality currently does not work!
                int result = JOptionPane.showConfirmDialog(this._leaderboard, "Are you sure you want to delete the leaderboards?", "Warning", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    File f = new File(Constants.STATDIR);
                    f.deleteOnExit();
                    JOptionPane.showMessageDialog(this._leaderboard, "The leaderboards will be deleted on program exit!");
                }
            }
        }        
    }
}
