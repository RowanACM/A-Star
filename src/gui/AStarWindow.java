package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nick LaPosta on 9/22/2016.
 * modified by aMelchior
 */
public class AStarWindow extends JFrame {

    private static final String TITLE = "A*";
    private static final int ROWS = 15;
    private static final int COLS = 15;
    public static Tile[][] tiles;

    public static AStarWindow window = new AStarWindow(TITLE, ROWS, COLS);

    private AStarWindow(String title, int x, int y) {
        super(title);
        tiles = new Tile[x][y];
        this.setLayout(new GridLayout(x, y));
        buildTiles();
        this.setVisible(true);
        this.setSize(800, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static AStarWindow getInstance() {
        return window;
    }

    public static int[] getTilesSize() {
        int[] size = {ROWS,COLS};
        return size;
    }

    public Tile getTile(int[] location) {
        return tiles[location[0]][location[1]];
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
