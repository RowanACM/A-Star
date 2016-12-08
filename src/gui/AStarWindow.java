package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nick LaPosta on 9/22/2016.
 */
public class AStarWindow extends JFrame {

	private static final String TITLE = "A*";
    private static final int ROWS = 15;
    private static final int COLS = 15;

    public static boolean waiting = true;
    public static boolean isAStar = true;
    public static int[] goalLoc= {1,1};
    public static  int[] startLoc = {13,13};

	public static AStarWindow window = new AStarWindow(TITLE, ROWS, COLS);

	public static int[] getTilesSize() {

		int[] size = {ROWS, COLS};
		return size;
	}

	public static AStarWindow getInstance() {
		return window;
	}

    public Tile[][] tiles;



    private AStarWindow(String title, int row, int col) {
        super(title);
        tiles = new Tile[row][col];
        this.setLayout(new GridLayout(row, col));
        buildTiles();
        tiles[goalLoc[0]][goalLoc[1]].setGoal();
        this.setVisible(true);
        this.setSize(800, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Tile getTile(int[] location) {
        return tiles[location[0]][location[1]];
    }

    private void buildTiles() {
        for(int row = 0; row < tiles.length; row++) {
            for(int col = 0; col < tiles[row].length; col++) {
                tiles[row][col] = new Tile((int) (Math.random() * 4) + 1);
                //tiles[row][col] = new Tile( 1); //flat version
                this.add(tiles[row][col]);
            }
        }
    }



}
