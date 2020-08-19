package newpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import newpackage.Game.ChoiceHandler;


public class UI {
    
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    JButton startButton, choice1, choice2, choice3, choice4;
    Font myFont, myFont2;
    JTextArea mainTextArea;

    
    public void createUI(ChoiceHandler cHandler){
        
        
        try{
                 myFont = Font.createFont(Font.TRUETYPE_FONT, new File("dpcomic.ttf")).deriveFont(120f);
                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
                    ge.registerFont(myFont);
                    
                    myFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("dpcomic.ttf")).deriveFont(30f);
                    GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
                    ge.registerFont(myFont2);
                    
            }
            
            catch (IOException|FontFormatException e){
                System.out.println("Error");
            } 
        
        window = new JFrame();
	window.setSize(800, 600);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.getContentPane().setBackground(Color.black);
	window.setLayout(null);
        
        
		
        
        titleNamePanel = new JPanel();
	titleNamePanel.setBounds(100, 100, 600, 150);
	titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("STYX");
	titleNameLabel.setForeground(Color.white);
	titleNameLabel.setFont(myFont);	
        titleNamePanel.add(titleNameLabel);
        
        startButtonPanel = new JPanel();
	startButtonPanel.setBounds(300, 400, 200, 100);
	startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
	startButton.setBackground(Color.black);
	startButton.setForeground(Color.black);
	startButton.setFont(myFont2);
	startButton.setFocusPainted(false);
        startButton.setActionCommand("start");
        startButton.addActionListener(cHandler);
        startButtonPanel.add(startButton);
        
        window.add(titleNamePanel);
	window.add(startButtonPanel);
      
        
        // game screen
        
        mainTextPanel = new JPanel();
	mainTextPanel.setBounds(100, 100, 600, 250);
	mainTextPanel.setBackground(Color.black);
	window.add(mainTextPanel);
        
        mainTextArea = new JTextArea("Welcome to Styx");
	mainTextArea.setBounds(100, 100, 600, 250);
	mainTextArea.setBackground(Color.black);
	mainTextArea.setForeground(Color.white);
	mainTextArea.setFont(myFont2);
	mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(true);
	mainTextPanel.add(mainTextArea);
        
        choiceButtonPanel = new JPanel();
	choiceButtonPanel.setBounds(250, 350, 300, 150);
	choiceButtonPanel.setBackground(Color.black);
	choiceButtonPanel.setLayout(new GridLayout(4,1));
	window.add(choiceButtonPanel);
        
        choice1 = new JButton("choice1");
	choice1.setBackground(Color.black);
	choice1.setForeground(Color.black);
	choice1.setFont(myFont2);
	choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
	choiceButtonPanel.add(choice1);
       
	choice2 = new JButton("choice2");
	choice2.setBackground(Color.black);
	choice2.setForeground(Color.black);
	choice2.setFont(myFont2);
	choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
	choiceButtonPanel.add(choice2);
		
	choice3 = new JButton("choice3");
	choice3.setBackground(Color.black);
	choice3.setForeground(Color.black);
	choice3.setFont(myFont2);
	choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
	choiceButtonPanel.add(choice3);
		
	
	choice4 = new JButton("choice4");
	choice4.setBackground(Color.black);
	choice4.setForeground(Color.black);
	choice4.setFont(myFont2);
	choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
	choiceButtonPanel.add(choice4);
        
        playerPanel = new JPanel();
	playerPanel.setBounds(100, 15, 600, 50);
	playerPanel.setBackground(Color.black);
	playerPanel.setLayout(new GridLayout(1,4));
	window.add(playerPanel);
        
	hpLabel = new JLabel("HP:");
	hpLabel.setFont(myFont2);
	hpLabel.setForeground(Color.white);
	playerPanel.add(hpLabel);
	hpLabelNumber = new JLabel();
	hpLabelNumber.setFont(myFont2);
	hpLabelNumber.setForeground(Color.white);
	playerPanel.add(hpLabelNumber);
	weaponLabel = new JLabel("Weapon:");
	weaponLabel.setFont(myFont2);
	weaponLabel.setForeground(Color.white);
	playerPanel.add(weaponLabel);
	weaponLabelName = new JLabel();
	weaponLabelName.setFont(myFont2);
	weaponLabelName.setForeground(Color.white);
	playerPanel.add(weaponLabelName);

		
	window.setVisible(true);
    }

   
    }

