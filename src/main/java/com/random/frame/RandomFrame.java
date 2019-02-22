package com.random.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.random.util.RandomUtil;

public class RandomFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private String title;
	private JPanel panel;

	private static final String UNIQUE = "唯一";

	public static void main(String[] args) {
		new RandomFrame("Random digit tool").setVisible(true);
	}

	public RandomFrame(String title) {

		this.title = title;

		int windowWidth = 500;
		int windowHeight = 400;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width; // get screen width
		int screenHeight = screenSize.height; // get screen height
		setBounds((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2, windowWidth, windowHeight);

		// initialization frame
		init();
	}

	private void init() {

		panel = new JPanel();
		panel.setLayout(null);

		JLabel lableTip = new JLabel("确定产生随机数的数目，最大值和最小值");
		lableTip.setBounds(20, 10, 300, 26);
		panel.add(lableTip);

		JLabel lableNum = new JLabel("数目：");
		lableNum.setBounds(20, 40, 60, 26);
		panel.add(lableNum);
		JTextField textNum = new JTextField(60);
		textNum.setBounds(80, 40, 120, 26);
		panel.add(textNum);

		JLabel lableMin = new JLabel("最小值：");
		lableMin.setBounds(20, 70, 60, 26);
		panel.add(lableMin);
		JTextField textMin = new JTextField(60);
		textMin.setBounds(80, 70, 120, 26);
		panel.add(textMin);

		JLabel lableMax = new JLabel("最大值：");
		lableMax.setBounds(220, 70, 60, 26);
		panel.add(lableMax);
		JTextField textMax = new JTextField(60);
		textMax.setBounds(280, 70, 120, 26);
		panel.add(textMax);

		JLabel lableUnique = new JLabel("选择是否为唯一随机数");
		lableUnique.setBounds(20, 100, 200, 26);
		panel.add(lableUnique);

		JLabel lableSelect = new JLabel("选择：");
		lableSelect.setBounds(20, 130, 60, 26);
		panel.add(lableSelect);
		JComboBox<String> unique = new JComboBox<>();
		unique.addItem("唯一");
		unique.addItem("不唯一");
		unique.setBounds(80, 130, 120, 26);
		panel.add(unique);

		JLabel lableClick = new JLabel("点击生成随机数");
		lableClick.setBounds(20, 160, 200, 26);
		panel.add(lableClick);

		JButton but = new JButton("生成");
		but.setBounds(180, 190, 100, 26);
		panel.add(but);

		JLabel lableResult = new JLabel("得到你想要的随机数");
		lableResult.setBounds(20, 220, 200, 26);
		panel.add(lableResult);

		JTextArea areaResult = new JTextArea();
		areaResult.setBounds(20, 250, 420, 60);
		areaResult.setBackground(new Color(10, 102, 187));
		areaResult.setEditable(false);
		areaResult.setFont(new Font("微软雅黑", Font.BOLD, 26));
		areaResult.setForeground(Color.WHITE);
		panel.add(areaResult);

		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String strNum = textNum.getText();
				if (!isDigit(strNum)) {
					JOptionPane.showMessageDialog(null, "数目要为数字");
					return;
				}
				String strMin = textMin.getText();
				if (!isDigit(strMin)) {
					JOptionPane.showMessageDialog(null, "最小值要为数字");
					return;
				}
				String strMax = textMax.getText();
				if (!isDigit(strMax)) {
					JOptionPane.showMessageDialog(null, "最大值要为数字");
					return;
				}
				boolean isUnique = false;
				String item = (String) unique.getSelectedItem();
				if (UNIQUE.equals(item)) {
					isUnique = true;
				}

				int min = Integer.parseInt(strMin);
				int max = Integer.parseInt(strMax);
				int num = Integer.parseInt(strNum);

				if (min > max) {
					JOptionPane.showMessageDialog(null, "最小值大于最大值了 ");
					return;
				}

				if ((max - min) < num && isUnique) {
					JOptionPane.showMessageDialog(null, "生成不了这么些唯一数字");
					return;
				}

				List<Integer> randomMany = RandomUtil.randomMany(min, max, num, isUnique);

				String result = "";
				for (int i = 0; i < randomMany.size(); i++) {
					result += randomMany.get(i) + ",";
				}

				areaResult.setText(result.substring(0, result.length() - 1));
			}
		});

		add(panel);
	}

	public boolean isDigit(String str) {
		return str.matches("[0-9]+");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
