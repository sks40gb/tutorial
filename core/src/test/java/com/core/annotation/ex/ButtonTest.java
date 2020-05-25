package com.core.annotation.ex;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

public class ButtonTest {

    @Test
    public void main() {

        ButtonFrame frame = new ButtonFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }
}

/**
 *
 * A frame with a button panel
 *
 */
class ButtonFrame extends JFrame {

    public static final int DEFAULT_WIDTH = 350;
    public static final int DEFAULT_HEIGHT = 200;
    private JPanel panel;
    private JButton yellowButton;
    private JButton blueButton;
    private JButton redButton;

    public ButtonFrame() {

        setTitle("ButtonTest");

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        panel = new JPanel();
        add(panel);


        // create buttons
        yellowButton = new JButton("Yellow");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        // add buttons to panel
        panel.add(yellowButton);
        panel.add(blueButton);
        panel.add(redButton);


        ActionListenerInstaller.processAnnotations(this);

    }

    @ActionListenerFor(source = "yellowButton")
    public void yellowBackground() {

        panel.setBackground(Color.YELLOW);

    }

    @ActionListenerFor(source = "blueButton")
    public void blueBackground() {

        panel.setBackground(Color.BLUE);

    }

    @ActionListenerFor(source = "redButton")
    public void redBackground() {

        panel.setBackground(Color.RED);

    }
}