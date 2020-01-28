package tw_samples;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
public class TicTacToe implements ActionListener{
	int chance_for_player=0;
	JFrame frame = new JFrame("GridLayout Demo");
	JButton button[]=new JButton[9];
	public  TicTacToe()
	{
		for(int button_no=0;button_no<9;button_no++)
		{
			button[button_no]=new JButton(" ");
			button[button_no].setForeground(Color.RED);
		    button[button_no].setBorder(BorderFactory.createLineBorder(Color.black, 5));
		    button[button_no].addActionListener(this);
		}
		JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));
		for(int button_no=0;button_no<9;button_no++)
			panel.add(button[button_no]);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    frame.setSize(300, 150); 
	    frame.getContentPane().add(panel); 
	    frame.setVisible(true); 
	}
	
	//static method cannot hide action listener
	public void actionPerformed(ActionEvent e)
	{
			JButton source=(JButton)e.getSource();
			boolean is_occupied=(source.getText()!="X" && source.getText()!="O");
			if(chance_for_player%2==0 && is_occupied)
			{
				source.setText("X");
				chance_for_player+=1;
			}
			else if(chance_for_player%2==1 && is_occupied)
			{
				source.setText("O");
				chance_for_player+=1;
			}
			if(chance_for_player==9)
			{
				JOptionPane.showConfirmDialog(null, "Game Over.");
				close_window();
			} 
			if(check() == true)
            {
				String s="Game Over, player "+(chance_for_player%2)+" Won!";
                JOptionPane.showConfirmDialog(null,s);
                close_window();
            }
	}
	
	
	public void close_window()
	{
		frame.setVisible(false);
        frame.dispose();
	}
	
	
	public boolean check()
	{
		for (int button_no=0; button_no<3; button_no+=3) 
	    { 
	        if (button[button_no+0].getText().equals(button[button_no+1].getText()) && 
	            button[button_no+1].getText().equals(button[button_no+2].getText()) &&  
	            !(button[button_no+0].getText().equals(" "))) 
	            return (true); 
	    }
		for (int button_no=0; button_no<3; button_no+=3) 
	    { 
	        if (button[button_no+0].getText().equals(button[button_no+3].getText()) && 
	        		button[button_no+3].getText().equals(button[button_no+6].getText()) &&  
	            !(button[button_no+0].getText().equals(" "))) 
	            return (true); 
	    } 
		if(button[0].getText().equals(button[4].getText()) && button[4].getText().equals(button[8].getText()) && (!button[4].getText().contentEquals(" ")))
			return true;
		if(button[2].getText().equals(button[4].getText()) && button[4].getText().equals(button[6].getText()) && (!button[4].getText().contentEquals(" ")))
			return true;
	    return(false); 
	}
	public static void main(String[] args) {
		TicTacToe t=new TicTacToe();
	}

}

