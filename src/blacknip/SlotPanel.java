package blacknip;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SlotPanel  extends JPanel implements PanelComponents{
	JButton left, middle, right;
	JPanel lever;
	
	
	SlotPanel(){
		this.setLayout(null);
		this.setBackground(Color.white);
	}
	
	public void prepareComponents() {
		left = new JButton(); middle = new JButton(); right = new JButton();
		lever = new JPanel();
		
		left.setIcon(RSM.normalButton);
		middle.setIcon(RSM.normalButton);
		right.setIcon(RSM.normalButton);
		
		
		
		left.setContentAreaFilled(false);
		middle.setContentAreaFilled(false);
		right.setContentAreaFilled(false);
		
		left.setBorderPainted(false);
		middle.setBorderPainted(false);
		right.setBorderPainted(false);
		
		left.setFocusPainted(false);
		middle.setFocusPainted(false);
		right.setFocusPainted(false);
		
		left.setBounds(x_pos(RSM.normalButton.getIconWidth()) - 60, 380, 20, 20);
		middle.setBounds(x_pos(RSM.normalButton.getIconWidth()), 380, 20, 20);
		right.setBounds(x_pos(RSM.normalButton.getIconWidth()) + 60, 380, 20, 20);
		
		this.add(left);
		this.add(middle);
		this.add(right);
		
		left.addActionListener(new LeftButtonListener());
		middle.addActionListener(new MiddleButtonListener());
		right.addActionListener(new RightButtonListener());
		}
	
	private class LeftButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class MiddleButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class RightButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public static int x_pos(int comwid) {
		return ((SlotBlackNip.WIDTH - comwid) / 2) ;
	}
}
