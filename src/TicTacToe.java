import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9]; 
    boolean player1_turn;

    TicTacToe () {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.GREEN);
        textfield.setOpaque(true);  
        textfield.setFont(new Font("Arial", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100); 

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.GRAY);
        for (int i=0; i<9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        firstTurn();



        
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<9; i++){
            if (e.getSource() ==)   
        }    
    }

    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
        

    }

    public void check(){

    }

    public void xWins(int a, int b, int c){

    }

    public void oWins(int a, int b, int c){

    }

}