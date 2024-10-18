package blacknip;

public class Main{
	
	static SlotBlackNip slotBN;
	public static void main(String[] args) {
		slotBN = new SlotBlackNip();
		slotBN.preparePanels();
		slotBN.prepareComponents();
		slotBN.setFrontFocus(ScreenMode.GAME);
		slotBN.setVisible(true);

	}

}
