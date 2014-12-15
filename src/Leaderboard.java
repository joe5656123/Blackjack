
import java.awt.GridLayout;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Leaderboard extends JFrame {
    private StatCollection _statCollection;
    
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
    }
}
