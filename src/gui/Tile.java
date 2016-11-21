package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lapost48 on 9/22/2016.
 * modified by aMelchior
 */
public class Tile extends JPanel {

    private int cost;

    public Tile(int cost) {
        this.cost = cost;
        int colorVar = cost * 63;
        this.setBackground(new Color(colorVar, colorVar, colorVar));
    }

    public int cost() {
        return cost;
    }

    public void setCurrentPath() {
        this.setBackground(new Color(0, 255 - (21 * (4 - cost)), 0));
    }

    public void setFrontier() {
        this.setBackground(new Color(255 - (21 * (4 - cost)), 255 - (21 * (4 - cost)), 0));
    }

    public void setClosed() {
        this.setBackground(new Color(255 - (21 * (4 - cost)), 0, 0));
    }

}
