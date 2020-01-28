package tw_samples;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
public class TicTacToe implements ActionListener{
	int chance=0;
	JFrame frame = new JFrame("GridLayout Demo"); //creating frame
	//build labels
	JButton btn[]=new JButton[9];
	public  TicTacToe()
	{
		for(int i=0;i<9;i++)
		{
			btn[i]=new JButton(" ");
		    btn[i].setForeground(Color.RED);
		    btn[i].setBorder(BorderFactory.createLineBorder(Color.black, 5));
		    btn[i].addActionListener(this);
		}
		JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));
		for(int i=0;i<9;i++)
			panel.add(btn[i]);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    frame.setSize(300, 150); 
	    frame.getContentPane().add(panel); 
	    frame.setVisible(true); 
	}
	//static method cannot hide action listener
	public void actionPerformed(ActionEvent e)
	{
			//player 1 will always take X
			JButton btn=(JButton)e.getSource();
			if(chance%2==0 && (btn.getText()!="X" && btn.getText()!="O"))
			{
				btn.setText("X");
				chance+=1;
			}
			else if(chance%2==1 && (btn.getText()!="X" && btn.getText()!="O"))
			{
				btn.setText("O");
				chance+=1;
			}
			if(chance==9)
			{
				JOptionPane.showConfirmDialog(null, "Game Over.");
				close_window();
			} 
			if(check() == true)
            {
				String s="Game Over, player "+(chance%2)+" Won!";
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
		//row
		for (int i=0; i<3; i+=3) 
	    { 
	        if (btn[i+0].getText().equals(btn[i+1].getText()) && 
	            btn[i+1].getText().equals(btn[i+2].getText()) &&  
	            !(btn[i+0].getText().equals(" "))) 
	            return (true); 
	    }
		//col
		for (int i=0; i<3; i+=3) 
	    { 
	        if (btn[i+0].getText().equals(btn[i+3].getText()) && 
	            btn[i+3].getText().equals(btn[i+6].getText()) &&  
	            !(btn[i+0].getText().equals(" "))) 
	            return (true); 
	    } 
	    //dia
		if(btn[0].getText().equals(btn[4].getText()) && btn[4].getText().equals(btn[8].getText()) && (!btn[4].getText().contentEquals(" ")))
			return true;
		if(btn[2].getText().equals(btn[4].getText()) && btn[4].getText().equals(btn[6].getText()) && (!btn[4].getText().contentEquals(" ")))
			return true;
	    return(false); 
	}
	public static void main(String[] args) {
		TicTacToe t=new TicTacToe();
	}

}

