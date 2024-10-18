package blacknip;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

public class SlotPanel  extends JPanel implements PanelComponents{
	JButton left, middle, right;
	JLabel leftP, middleP, rightP;
	JLabel lever;
	Timer timer1, timer2, timer3;
	private Random random;
	
	Border slotframe = BorderFactory.createLineBorder(Color.BLACK, 2);
	
	SlotPanel(){
		this.setLayout(null);
		this.setBackground(Color.white);
		random = new Random();
	}
	
	public void prepareComponents() {
		left = new JButton(); middle = new JButton(); right = new JButton();
		leftP = new JLabel(); middleP = new JLabel(); rightP = new JLabel();
		lever = new JLabel();
		
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
		
		leftP.setBorder(slotframe);
		middleP.setBorder(slotframe);
		rightP.setBorder(slotframe);
		
		leftP.setText("1");
		middleP.setText("2");
		rightP.setText("3");
		
		left.setBounds(x_pos(RSM.normalButton.getIconWidth()) - 60, 360, 60, 60);
		middle.setBounds(x_pos(RSM.normalButton.getIconWidth()), 360, 60, 60);
		right.setBounds(x_pos(RSM.normalButton.getIconWidth()) + 60, 360, 60, 60);
		
		leftP.setBounds(330, 250, 40, 80);
		middleP.setBounds(380, 250, 40, 80); 
		rightP.setBounds(430, 250, 40, 80);
		
		this.add(left);
		this.add(middle);
		this.add(right);
		this.add(leftP);
		this.add(middleP);
		this.add(rightP);
		
		left.addActionListener(new LeftButtonListener());
		middle.addActionListener(new MiddleButtonListener());
		right.addActionListener(new RightButtonListener());
		
		addMouseListener(new LeverMouseListener());
		
		timer1 = new Timer(100, new Timer1ActionListener());
		timer2 = new Timer(100, new Timer2ActionListener());
		timer3 = new Timer(100, new Timer3ActionListener());
		}
	
	private class LeftButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			timer1.stop();
		}
	}
	
	private class MiddleButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			timer2.stop();
		}
	}
	
	private class RightButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			timer3.stop();
		}
	}
	
	private class LeverMouseListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			if(SwingUtilities.isRightMouseButton(e)) {
				timer1.start();
				timer2.start();
				timer3.start();
			}
		}
		
	}
	
	private class Timer1ActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			leftP.setText(String.valueOf(random.nextInt(9) + 1));
		}
	}
	
	private class Timer2ActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			middleP.setText(String.valueOf(random.nextInt(9) + 1));}
	}
	
	private class Timer3ActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			rightP.setText(String.valueOf(random.nextInt(9) + 1));
		}
	}
	
	public static int x_pos(int comwid) {
		return ((SlotBlackNip.WIDTH - comwid) / 2) ;
	}
}
