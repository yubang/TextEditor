package ui;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

public class FontFrame extends JFrame{
	
	private JTextArea textArea;
	private JList<String> list1,list2,list3;
	private DefaultListModel<String> m1,m2,m3;
	
	public FontFrame(JTextArea textArea){
		
		this.textArea=textArea;
		
		this.setTitle("字体设置");
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new GridLayout(1,3));
		this.addLists();
		this.setVisible(true);
	}
	
	private void addLists(){
		m1= new DefaultListModel<String>();
		m2= new DefaultListModel<String>();
		m3= new DefaultListModel<String>();
		list1=new JList<String>(m1);
		list2=new JList<String>(m2);
		list3=new JList<String>(m3);
		
		m1.addElement("20");
		m1.addElement("26");
		m1.addElement("30");
		
		m2.addElement("正常");
		m2.addElement("粗体");
		
		m3.addElement("宋体");
		m3.addElement("宋体");
		m3.addElement("宋体");
		
		list1.setSelectedIndex(0);
		list2.setSelectedIndex(0);
		list3.setSelectedIndex(0);
		
		this.add(list1);
		this.add(list2);
		this.add(list3);
	}
	
}
