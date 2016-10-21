package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nick LaPosta on 9/22/2016.
 */
public class AStarWindow extends JFrame {

    public Tile[][] tiles;

    public AStarWindow(String title, int x, int y) {
        super(title);
        tiles = new Tile[x][y];
        this.setLayout(new GridLayout(x, y));
        buildTiles();
        this.setVisible(true);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buildTiles() {
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new Tile((int) (Math.random() * 4) + 1);
                this.add(tiles[i][j]);
            }
        }
    }

}
