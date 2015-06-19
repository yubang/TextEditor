package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FindUi extends JFrame{
	
	private JTextArea t;
	private JLabel label1=new JLabel("要寻找的字符串");
	private JTextField text1=new JTextField();
	private JButton button =new JButton("查找");
	
	public FindUi(JTextArea textArea){
		t=textArea;
		
		this.setSize(300,150);
		this.setTitle("查找");
		this.setLocationRelativeTo(null);
		
		label1.setBounds(10,10,100,20);
		text1.setBounds(120,10,150,20);
		button.setBounds(100,100,100,20);
		
		this.setLayout(null);
		this.add(label1);
		this.add(text1);
		this.add(button);
		
		button.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int start=t.getSelectionEnd();
				if(start<0){start=0;}
				String text=t.getText();
				text=text.substring(start,text.length());
				int index=text.indexOf(text1.getText());
				if(index==-1){
					javax.swing.JOptionPane.showMessageDialog(null,"已经寻找到文档结尾，但没有找到！");
					t.select(0,0);
				}else{
					t.setSelectionStart(start+index);
					t.setSelectionEnd(start+index+text1.getText().length());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		this.setResizable(false);
		
	}
	
}
