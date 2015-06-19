package ui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Frame {

	private javax.swing.JFrame frame;
	private javax.swing.JTextArea textArea;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenu menu1, menu2, menu3, menu4;
	private javax.swing.JMenuItem item1, item2, item3, item4, item5, item6,
			item7, item8, item9, item10, item11, item12,item13;
	private FontFrame fontFrame;
	private About about;
	private FindUi findUi;
	
	public Frame() {
		this.setFrame();
		this.setMenu();
		this.addListener();
		frame.setVisible(true);

		fontFrame = new FontFrame(textArea);
		about = new About();
		findUi=new FindUi(textArea);
	}

	private void setMenu() {

		menuBar = new javax.swing.JMenuBar();
		menu1 = new javax.swing.JMenu("文件");
		menu2 = new javax.swing.JMenu("编辑");
		menu3 = new javax.swing.JMenu("格式");
		menu4 = new javax.swing.JMenu("帮助");

		item1 = new javax.swing.JMenuItem("打开文件");
		item2 = new javax.swing.JMenuItem("保存文件");
		item3 = new javax.swing.JMenuItem("另存为文件");
		item4 = new javax.swing.JMenuItem("退出");

		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);

		item5 = new javax.swing.JMenuItem("自动换行");
		item6 = new javax.swing.JMenuItem("字体");
		menu3.add(item5);
		menu3.add(item6);

		item7 = new javax.swing.JMenuItem("关于");
		menu4.add(item7);

		item8 = new javax.swing.JMenuItem("剪切");
		item9 = new javax.swing.JMenuItem("复制");
		item10 = new javax.swing.JMenuItem("粘贴");
		item11 = new javax.swing.JMenuItem("删除");
		item12 = new javax.swing.JMenuItem("全选");
		item13 = new javax.swing.JMenuItem("查找");
		menu2.add(item8);
		menu2.add(item9);
		menu2.add(item10);
		menu2.add(item11);
		menu2.add(item12);
		menu2.add(item13);

		
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
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
				if (action.Base.openFilePath == null) {
					javax.swing.JOptionPane.showMessageDialog(null, "还没有打开文件！");
				} else {

					if (action.Base.writeToFile(action.Base.openFilePath,
							textArea.getText())) {
						javax.swing.JOptionPane
								.showMessageDialog(null, "保存成功！");
					} else {
						javax.swing.JOptionPane
								.showMessageDialog(null, "保存失败！");
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

		// 换行事件
		item5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (item5.getText().equals("自动换行")) {
					item5.setText("不自动换行");
					textArea.setLineWrap(true);
					textArea.setWrapStyleWord(true);
				} else {
					item5.setText("自动换行");
					textArea.setLineWrap(false);
					textArea.setWrapStyleWord(false);
				}
			}

		});

		// 设置字体事件
		item6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fontFrame.setVisible(true);
			}
		});

		// 关于
		item7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				about.setVisible(true);
			}
		});

		// 剪切
		item8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = textArea.getSelectedText();

				// 写入剪贴板
				Clipboard clip = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				Transferable tText = new StringSelection(text);
				clip.setContents(tText, null);

				// 删除选中文本
				textArea.replaceSelection("");
			}
		});

		// 复制
		item9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = textArea.getSelectedText();

				// 写入剪贴板
				Clipboard clip = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				Transferable tText = new StringSelection(text);
				clip.setContents(tText, null);
			}
		});

		// 粘贴
		item10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ret = "";
				Clipboard sysClip = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				// 获取剪切板中的内容
				Transferable clipTf = sysClip.getContents(null);

				if (clipTf != null) {
					// 检查内容是否是文本类型
					if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
						try {
							ret = (String) clipTf
									.getTransferData(DataFlavor.stringFlavor);
						} catch (Exception error) {
							// error.printStackTrace();
						}
					}
				}

				textArea.replaceSelection(ret);
			}
		});

		// 删除
		item11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.replaceSelection("");
			}
		});

		// 全选
		item12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.select(0, textArea.getText().length());
			}
		});
		
		// 查找
				item13.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						findUi.setVisible(true);
					}
				});
		
	}

	public static void main(String[] args) {
		new Frame();
	}

}
