package blacknip;

import javax.swing.ImageIcon;

public class RSM {
	static ImageIcon[] slotImage;
	
	static ImageIcon normalButton = new ImageIcon(RSM.class.getClassLoader().getResource("赤ボタン.jpg"));
	//static ImageIcon lampButton = new ImageIcon(RSM.class.getClassLoader().getResource("赤点灯ボタン.png"));
	
	public RSM(){
		slotImage = new ImageIcon[16];
	}
	
	public void prepareSlotImage() {
		for(int i=0; i < slotImage.length; i++) {
			slotImage[i] = new ImageIcon(RSM.class.getClassLoader().getResource(i + ".png"));
		}
	}
}
