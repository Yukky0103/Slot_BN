package blacknip;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class SlotBlackNip extends JFrame{
	ScreenMode screenMode = ScreenMode.GAME;
	
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	
	CardLayout layout = new CardLayout();
	
	//パネルの宣言
	SlotPanel slotPanel;
	
	public SlotBlackNip() {
		//タイトル・アイコン
		this.setTitle("黒築美スロット");
		//ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("ファイル名.拡張子"));
		//this.setIconImage(icon.getImage());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);  //画面サイズ
		this.getContentPane().setBackground(Color.white);  //背景色
		
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void preparePanels() {
		slotPanel = new SlotPanel();
		this.add(slotPanel, "ゲーム画面");
		this.pack();
	}
	
	public void prepareComponents() {
		//.prepareComponents();
		slotPanel.prepareComponents();
	}
	
	public void setFrontFocus(ScreenMode s) {
		screenMode = s;
		switch(screenMode) {
		case TITLE:
			layout.show(this.getContentPane(), "タイトル画面");
			
			break;
		case GAME:
			layout.show(this.getContentPane(), "ゲーム画面");
			slotPanel.requestFocus();
			break;
		}
	}
}
