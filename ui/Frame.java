package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

	private javax.swing.JFrame frame;
	private javax.swing.JTextArea textArea;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenu menu1;
	private javax.swing.JMenuItem item1, item2, item3, item4;

	public Frame() {
		this.setFrame();
		this.setMenu();
		this.addListener();
		frame.setVisible(true);
	}

	private void setMenu() {
		menuBar = new javax.swing.JMenuBar();
		menu1 = new javax.swing.JMenu("文件");

		item1 = new javax.swing.JMenuItem("打开文件");
		item2 = new javax.swing.JMenuItem("保存文件");
		item3 = new javax.swing.JMenuItem("另存为文件");
		item4 = new javax.swing.JMenuItem("退出");

		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);

		menuBar.add(menu1);
		frame.setJMenuBar(menuBar);
	}

	private void setFrame() {
		frame = new javax.swing.JFrame();
		frame.setSize(700, 500);
		frame.setTitle("文本编辑器");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		textArea =new javax.swing.JTextArea();
		textArea.setFont(new Font("宋体",0,20));
		
		scrollPane=new javax.swing.JScrollPane(textArea);
		scrollPane.setBounds(10,10,680,490);
		frame.add(scrollPane);
	}

	private void addListener() {

		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				javax.swing.JFileChooser chooser =new javax.swing.JFileChooser();
				if(chooser.showOpenDialog(null)==0){
					textArea.setText(action.Base.readFromFile(chooser.getSelectedFile().getAbsolutePath()));
				}
			}
		});

		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		item3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		//退出事件
		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

	}

	public static void main(String[] args) {
		new Frame();
	}

}
