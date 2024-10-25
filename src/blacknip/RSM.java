package blacknip;

import javax.swing.ImageIcon;

public class RSM  implements PanelComponents{
	static ImageIcon[] slotImage;
	static ImageIcon[] firstChar;
	
	static ImageIcon normalButton = new ImageIcon(RSM.class.getClassLoader().getResource("赤ボタン.png"));
	//static ImageIcon lampButton = new ImageIcon(RSM.class.getClassLoader().getResource("赤点灯ボタン.png"));
	
	public RSM(){
		slotImage = new ImageIcon[16];
		firstChar = new ImageIcon[3];
	}
	
	public void prepareComponents(){
		for(int i=0; i < slotImage.length; i++) {
			slotImage[i] = new ImageIcon(RSM.class.getClassLoader().getResource(i + ".png"));
		}
		firstChar[0] = new ImageIcon(RSM.class.getClassLoader().getResource("黒.png"));
		firstChar[1] = new ImageIcon(RSM.class.getClassLoader().getResource("ミルク.png"));
		firstChar[2] = new ImageIcon(RSM.class.getClassLoader().getResource("首.png"));
	}
}
