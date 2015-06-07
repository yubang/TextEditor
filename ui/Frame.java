package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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

		textArea = new javax.swing.JTextArea();
		textArea.setFont(new Font("宋体", 0, 20));

		scrollPane = new javax.swing.JScrollPane(textArea);
		scrollPane.setBounds(10, 10, 680, 490);
		frame.add(scrollPane);
	}

	private void addListener() {
		// 打开文件
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
				if (chooser.showOpenDialog(null) == 0) {
					action.Base.openFilePath = chooser.getSelectedFile()
							.getAbsolutePath();
					frame.setTitle("文本编辑器(" + action.Base.openFilePath + ")");
					textArea.setText(action.Base
							.readFromFile(action.Base.openFilePath));
				}
			}
		});
		// 保存文件
		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(action.Base.openFilePath==null){
					javax.swing.JOptionPane.showMessageDialog(null,
							"还没有打开文件！");
				}else{
					
					if (action.Base.writeToFile(action.Base.openFilePath, textArea.getText())) {
						javax.swing.JOptionPane.showMessageDialog(null,
								"保存成功！");
					} else {
						javax.swing.JOptionPane.showMessageDialog(null,
								"保存失败！");
					}
				}
			}
		});

		// 另存为
		item3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
				if (chooser.showSaveDialog(null) == 0) {
					if (chooser.getSelectedFile().exists()) {
						javax.swing.JOptionPane.showMessageDialog(null,
								"文件已经存在，不能覆盖！");
					} else {
						if (action.Base.writeToFile(chooser.getSelectedFile()
								.getAbsolutePath(), textArea.getText())) {
							javax.swing.JOptionPane.showMessageDialog(null,
									"保存成功！");
						} else {
							javax.swing.JOptionPane.showMessageDialog(null,
									"保存失败！");
						}
					}
				}

			}
		});

		// 退出事件
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
