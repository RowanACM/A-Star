package gui;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by Aidan melchior on 12/7/2016.
 */
public class Popup extends JPanel implements ActionListener{

    JButton astar_option, dijkstras_option;
    static JFrame frame = new JFrame("ButtonDemo");

    public Popup()
    {
        //final JFrame frame = new JFrame();

        astar_option = new JButton("A*");
        astar_option.setActionCommand("A*");
        astar_option.setToolTipText("I want to use the A* algorithm");
        astar_option.addActionListener(this);

        dijkstras_option = new JButton("Dijkstra's");
        dijkstras_option.setActionCommand("Dijkstra's algorithm");
        dijkstras_option.setToolTipText("I want to use Dijkstra's algorithm");
        dijkstras_option.addActionListener(this);

        add(astar_option);
        add(dijkstras_option);
        //pack();
        //setVisible(true);

        //dijkstras_option.addActionListener(new java.awt.event.ActionListener() {
        //    public void actionPerformed(java.awt.event.ActionEvent evt) {
         //       AStarWindow.isAStar = false;
         //       AStarWindow.waiting = false;
         //       dispose();
        //    }
        //});

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("A*")) {
            AStarWindow.isAStar = true;
            AStarWindow.waiting = false;
           // System.out.println(AStarWindow.isAStar);
            System.out.println("ok! we're doing " + e.getActionCommand());
            frame.dispose();
        } else {
            AStarWindow.isAStar = false;
            AStarWindow.waiting = false;
            System.out.println("ok! we're doing " + e.getActionCommand());
            frame.dispose();
        }
    }

    public static void create() {
        //System.out.println(AStarWindow.isAStar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Popup newContentPane = new Popup();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

}
