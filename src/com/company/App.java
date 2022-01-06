package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * @author Azamat akan
 */
public class App extends JFrame {
    public int res = 0;

    public App() {
        setTitle(" Calculation ");
        JPanel panel = new JPanel();
        JButton plus = new JButton(" + ");
        JButton minus = new JButton(" - ");
        JButton multiplay = new JButton(" * ");
        JButton divide = new JButton(" / ");
        JLabel result = new JLabel(" result ");
        JTextField x1 = new JTextField("1");
        JTextField x2 = new JTextField("2");
        ActionListener listenerPlus = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int x_1 = Integer.parseInt(x1.getText());
                int x_2 = Integer.parseInt(x2.getText());
                res = x_1 + x_2;
                result.setText(String.valueOf(res));
            }
        };
        ActionListener listenerMinus = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int x_1 = Integer.parseInt(x1.getText());
                int x_2 = Integer.parseInt(x2.getText());
                res = x_1 - x_2;
                result.setText(String.valueOf(res));
            }
        };
        ActionListener listenerMultiplay = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int x_1 = Integer.parseInt(x1.getText());
                int x_2 = Integer.parseInt(x2.getText());
                res = x_1 * x_2;
                result.setText(String.valueOf(res));
            }
        };
        ActionListener listenerDivide = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int x_1 = Integer.parseInt(x1.getText());
                int x_2 = Integer.parseInt(x2.getText());
                res = x_1 / x_2;
                result.setText(String.valueOf(res));
            }
        };

        plus.addActionListener(listenerPlus);
        minus.addActionListener(listenerMinus);
        multiplay.addActionListener(listenerMultiplay);
        divide.addActionListener(listenerDivide);
        panel.setSize(new Dimension(500, 500));
        panel.add(x1);
        panel.add(x2);
        add(panel);
        panel.add(plus);
        panel.add(minus);
        panel.add(multiplay);
        panel.add(divide);
        panel.add(result);
        setPreferredSize(new Dimension(500, 500));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
}