package ui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FontFrame extends JFrame{
	
	private JTextArea textArea;
	private JList<String> list1,list2,list3;
	private DefaultListModel<String> m1,m2,m3;
	private JScrollPane s1,s2,s3;
	
	public FontFrame(JTextArea textArea){
		
		this.textArea=textArea;
		
		this.setTitle("字体设置");
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new GridLayout(1,3));
		this.addLists();
		this.addListener();
		
	}
	
	private void addLists(){
		m1= new DefaultListModel<String>();
		m2= new DefaultListModel<String>();
		m3= new DefaultListModel<String>();
		list1=new JList<String>(m1);
		list2=new JList<String>(m2);
		list3=new JList<String>(m3);
		s1=new JScrollPane(list1);
		s2=new JScrollPane(list2);
		s3=new JScrollPane(list3);
		
		m1.addElement("12");
		m1.addElement("14");
		m1.addElement("16");
		m1.addElement("18");
		m1.addElement("20");
		m1.addElement("22");
		m1.addElement("24");
		m1.addElement("26");
		m1.addElement("28");
		m1.addElement("30");
		m1.addElement("32");
		
		m2.addElement("正常");
		m2.addElement("粗体");
		
		m3.addElement("宋体");
		m3.addElement("楷体");
		m3.addElement("黑体");
		
		list1.setSelectedIndex(0);
		list2.setSelectedIndex(0);
		list3.setSelectedIndex(0);
		
		this.add(s1);
		this.add(s2);
		this.add(s3);
	}
	
	public void addListener(){
		list1.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				textArea.setFont(new Font(m3.get(list3.getSelectedIndex()),list2.getSelectedIndex(),Integer.parseInt(m1.get(list1.getSelectedIndex()))));
				
			}});
		list2.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				textArea.setFont(new Font(m3.get(list3.getSelectedIndex()),list2.getSelectedIndex(),Integer.parseInt(m1.get(list1.getSelectedIndex()))));
				
			}});
		list3.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				textArea.setFont(new Font(m3.get(list3.getSelectedIndex()),list2.getSelectedIndex(),Integer.parseInt(m1.get(list1.getSelectedIndex()))));
				
			}});
	}
	
}
