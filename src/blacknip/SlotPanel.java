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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

public class SlotPanel  extends JPanel implements PanelComponents{
	JButton[] sb = new JButton[3];
	JLabel[][] panel = new JLabel[3][3];
	JLabel lever;
	Timer timer1, timer2, timer3;
	int[] s = new int[3];
	int[] position = new int[3];
	int t1, t2, t3;
	
	private Random random;
	
	Border slotframe = BorderFactory.createLineBorder(Color.BLACK, 2);
	
	SlotPanel(){
		this.setLayout(null);
		this.setBackground(Color.white);
		random = new Random();
		position[0] = 10;
		position[1] = 0;
		position[2] = 10;
	}
	
	public void prepareComponents() {
		for(int i=0; i < panel.length; i++) {
			s[i] = 1;
			sb[i] = new JButton();
			sb[i].setIcon(RSM.normalButton);
			sb[i].setContentAreaFilled(false);
			sb[i].setBorderPainted(false);
			sb[i].setFocusPainted(false);
			this.add(sb[i]);
			for(int j=0; j < panel.length; j++) {
				panel[i][j] = new JLabel();
				panel[i][j].setText(Integer.toString((s[i] - 1 + i) % 10));
				panel[i][j].setVerticalTextPosition(SwingConstants.CENTER);
				this.add(panel[i][j]);
			}
		}
		lever = new JLabel();
		
		sb[0].setBounds(x_pos(RSM.normalButton.getIconWidth()) - 60, 360, 60, 60);
		sb[1].setBounds(x_pos(RSM.normalButton.getIconWidth()), 360, 60, 60);
		sb[2].setBounds(x_pos(RSM.normalButton.getIconWidth()) + 60, 360, 60, 60);
		
		panel[1][0].setBounds(330, 250, 40, 80);
		panel[1][1].setBounds(380, 250, 40, 80); 
		panel[1][2].setBounds(430, 250, 40, 80);
		panel[0][0].setBounds(332, 260, 20, 20);
		panel[0][1].setBounds(382, 260, 20, 20);
		panel[0][2].setBounds(432, 260, 20, 20);
		panel[2][0].setBounds(332, 300, 20, 20);
		panel[2][1].setBounds(382, 300, 20, 20);
		panel[2][2].setBounds(432, 300, 20, 20);
		
		panel[1][0].setBorder(slotframe);
		panel[1][1].setBorder(slotframe);
		panel[1][2].setBorder(slotframe);
		
		sb[0].addActionListener(new LeftButtonListener());
		sb[1].addActionListener(new MiddleButtonListener());
		sb[2].addActionListener(new RightButtonListener());
		
		addMouseListener(new LeverMouseListener());
		
		do {
			t1 = 100 + (random.nextInt(5) - 2) * 10;
			t2 = 100 + (random.nextInt(5) - 2) * 10;
			t3 = 100 + (random.nextInt(5) - 2) * 10;
		} while ((t1 == t2) || (t2 == t3) || (t1 == t3));
		timer1 = new Timer(t1 , new Timer1ActionListener());
		timer2 = new Timer(t2, new Timer2ActionListener());
		timer3 = new Timer(t3, new Timer3ActionListener());
	}
	
	private class LeftButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			timer1.stop();
		}
	}
	
	private class MiddleButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			timer2.stop();
		}
	}
	
	private class RightButtonListener implements ActionListener{
		@Override
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
			s[0]++;
			panel[0][0].setText(Integer.toString((s[0] - 1) % 10));
			panel[0][1].setText(Integer.toString(s[0] % 10));
			panel[0][2].setText(Integer.toString((s[0] + 1) % 10));
		}
	}
	
	private class Timer2ActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			s[1]++;
			panel[1][0].setText(Integer.toString((s[1] - 1) % 10));
			panel[1][1].setText(Integer.toString(s[1] % 10));
			panel[1][2].setText(Integer.toString((s[1] + 1) % 10));
		}
	}
	
	private class Timer3ActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			s[2]++;
			panel[2][0].setText(Integer.toString((s[2] - 1) % 10));
			panel[2][1].setText(Integer.toString(s[2] % 10));
			panel[2][2].setText(Integer.toString((s[2] + 1) % 10));
		}
	}
	
	public static int x_pos(int comwid) {
		return ((SlotBlackNip.WIDTH - comwid) / 2) ;
	}
}
