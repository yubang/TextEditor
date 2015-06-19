package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReplaceUi extends JFrame {

	private JTextArea t;
	private JLabel label1 = new JLabel("字符串");
	private JTextField text1 = new JTextField();
	private JLabel label2 = new JLabel("目标字符串");
	private JTextField text2 = new JTextField();
	private JButton button = new JButton("替换");
	private JButton button2 = new JButton("全部替换");

	public ReplaceUi(JTextArea textArea) {
		t = textArea;

		this.setSize(300, 150);
		this.setTitle("替换");
		this.setLocationRelativeTo(null);

		label1.setBounds(10, 10, 100, 20);
		text1.setBounds(120, 10, 150, 20);
		label2.setBounds(10, 50, 100, 20);
		text2.setBounds(120, 50, 150, 20);
		button.setBounds(10, 100, 100, 20);
		button2.setBounds(180, 100, 100, 20);

		this.setLayout(null);
		this.add(label1);
		this.add(text1);
		this.add(label2);
		this.add(text2);
		this.add(button);
		this.add(button2);

		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int start = t.getSelectionEnd();
				if (start < 0) {
					start = 0;
				}
				String text = t.getText();
				text = text.substring(start, text.length());
				int index = text.indexOf(text1.getText());
				if (index == -1) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"已经替换到文档结尾，但没有找到！");
					t.select(0, 0);
				} else {
					text = t.getText();
					String t1 = text.substring(0, start + index);
					String t2 = text.substring(start + index
							+ text1.getText().length(), text.length());
					t.setText(t1 + text2.getText() + t2);
					t.setSelectionStart(start + index);
					t.setSelectionEnd(start + index + text1.getText().length());
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

			}
		});

		button2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String text = t.getText().replace(text1.getText(),
						text2.getText());
				t.setText(text);
				javax.swing.JOptionPane.showMessageDialog(null, "已经全部替换！");
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

			}
		});

		this.setResizable(false);

	}

}
