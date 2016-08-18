import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static java.awt.SystemColor.text;

/**
 * Created by 1234 on 12.07.2016.
 */
public class PlayField extends JFrame{

    public PlayField(){
        setTitle("My first GUI");
        setBounds(500,150,506,578);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        JPanel downPanel = new JPanel(new GridLayout());

        JButton firstButton = new JButton("New Game");
        JButton secondButton = new JButton("Exit Game");

        downPanel.add(firstButton);
        downPanel.add(secondButton);

        downPanel.setPreferredSize(new Dimension(1, 50));;

        firstButton.setBackground(Color.CYAN);
        secondButton.setBackground(Color.CYAN);

        add(downPanel, BorderLayout.SOUTH);

        GameMap gamePanel = new GameMap();
        add(gamePanel, BorderLayout.CENTER);

        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("gamePanel Wight - "+gamePanel.getWidth()+"  gamePanel Height - "+gamePanel.getHeight());

            }
        });
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}