package com.ccc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the graphical interface and construction of calculator
 * @author Johanna
 * @version 1.0
 */

public class Calcul implements ActionListener {

    JFrame frame;
    JTextField textField;

    JButton[] numberButton= new JButton[10];
    JButton[] operatorButton = new JButton[9];

    JButton addButton, subsButton, mulButton, divButton, decButton, equalButton, delButton, ctrButton, negButton;
    JPanel panel;

    Font fontFamily = new Font("Arial", Font.BOLD, 24);
    double nbr1 = 0;
    double nbr2 = 0;
    double result=0;

    char operator;

    /**
     * Construction graphical interface and buttons
     * set up layout
     */
    Calcul() {
        frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(fontFamily);
        textField.setEditable(false);

        addButton = new JButton("+");
        subsButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        ctrButton = new JButton("Ctr");
        negButton = new JButton("(-)");

        operatorButton[0]= addButton;
        operatorButton[1]= subsButton;
        operatorButton[2]= mulButton;
        operatorButton[3]= divButton;
        operatorButton[4]= decButton;
        operatorButton[5] = equalButton;
        operatorButton[6]= delButton;
        operatorButton[7]= ctrButton;
        operatorButton[8]= negButton;

        for(int i = 0; i < 9; i++ ) {
            operatorButton[i].addActionListener(this);
            operatorButton[i].setFont(fontFamily);
            operatorButton[i].setFocusable(false);
        }

        for (int i =0; i<10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        ctrButton.setBounds(250, 430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subsButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(ctrButton);
        frame.add(delButton);
        frame.add(textField);

        frame.setVisible(true);

    }

    /**
     * set up eventListener
     * set up calculation
     */
    public void actionPerformed (ActionEvent event){

    for (int i =0; i<10; i++){
        if(event.getSource() == numberButton[i]){
            textField.setText(textField.getText().concat(String.valueOf(i)));
        }
    }

    if(event.getSource()== decButton){
        textField.setText(textField.getText().concat("."));
    }

    if(event.getSource()== addButton){
        nbr1 = Double.parseDouble(textField.getText());
        operator = '+';
        textField.setText("");
    }

    if(event.getSource()== subsButton){
        nbr1 = Double.parseDouble(textField.getText());
        operator = '-';
        textField.setText("");
    }

    if(event.getSource()== mulButton){
        nbr1 = Double.parseDouble(textField.getText());
        operator = '*';
        textField.setText("");
    }

    if(event.getSource()== divButton){
        nbr1 = Double.parseDouble(textField.getText());
        operator = '/';
        textField.setText("");
    }

    if(event.getSource()== equalButton){
        nbr2 = Double.parseDouble(textField.getText());

        switch (operator){
            case '+':
                result = nbr1 + nbr2;
                break;
            case '-':
                result = nbr1-nbr2;
                break;
            case '*':
                result = nbr1 * nbr2;
                break;
            case '/':
                result = nbr1/nbr2;
                break;
        }

        textField.setText(String.valueOf(result));
        nbr1= result;
    }

    if(event.getSource() == ctrButton){
        textField.setText("");

    }

    if(event.getSource() == delButton){
        String nbrArray = textField.getText();
        textField.setText("");

        for(int i = 0; i<nbrArray.length()-1; i++){
            textField.setText(textField.getText()+nbrArray.charAt(i));
        }
    }

    if(event.getSource() == negButton){
        double nbNeg = Double.parseDouble(textField.getText());
        nbNeg *= -1;
        textField.setText(String.valueOf(nbNeg));
    }


    }




}
