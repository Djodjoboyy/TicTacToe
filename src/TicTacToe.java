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
    JButton resetButton = new JButton("Reset");
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
        resetButton.setFont(new Font("Arial", Font.BOLD, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        frame.add(resetButton, BorderLayout.SOUTH);
        firstTurn();   
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<9; i++){
            if (e.getSource() == buttons[i]){
                if (player1_turn){
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }   
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
        if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X"){
            xWins(0,1,2);
        } else if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X"){
            xWins(3,4,5);
        } else if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X"){
            xWins(6,7,8);
        } else if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X"){
            xWins(0,3,6);
        } else if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X"){
            xWins(1,4,7);
        } else if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X"){
            xWins(2,5,8);
        } else if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X"){
            xWins(0,4,8);
        } else if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X"){
            xWins(2,4,6);
        } else if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O"){
            oWins(0,1,2);
        } else if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O"){
            oWins(3,4,5);
        } else if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O"){
            oWins(6,7,8);
        } else if (buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O"){
            oWins(0,3,6);
        } else if (buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O"){
            oWins(1,4,7);
        } else if (buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O"){
            oWins(2,5,8);
        } else if (buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O"){
            oWins(0,4,8);
        } else if (buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O"){
            oWins(2,4,6);
        } else {
            boolean tie = true;
            for (int i=0; i<9; i++){
                if (buttons[i].getText() == ""){
                    tie = false;
                    break;
                }
            }
            if (tie){
                for (int i=0; i<9; i++){
                    buttons[i].setEnabled(false);
                }
                textfield.setText("It's a tie!");
            }
        }

    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        textfield.setText("O wins");
        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
    }

    public void resetGame(){
        for (int i=0; i<9; i++){
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(null);
        }
        textfield.setText("Tic-Tac-Toe");
        firstTurn();
    }

}