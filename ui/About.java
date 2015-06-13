package ui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame{
	
	public About(){
		
		this.setSize(300,100);
		this.setTitle("关于");
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(2,1));
		JLabel l1=new JLabel("作者：small girl");
		JLabel l2 =new JLabel("时间：2015-06-13");
		this.add(l1);
		this.add(l2);
	}
	
}
