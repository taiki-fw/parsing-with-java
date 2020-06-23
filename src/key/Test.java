package key;

import java.awt.*;
import javax.swing.*;
import java.io.*;

interface Constant {
	int WIDTH = 300;
	int HEIGHT = 200;
}

class Test {
	public static void main(String[] arg) throws IOException {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Constant.WIDTH, Constant.HEIGHT);
		final Keyboard key = new Keyboard();
		frame.getContentPane().add(key.getPanel());
		frame.setVisible(true);
		int c;
		while ((c = key.read()) != -1) {
			System.out.println((char) c);
		}
	}
}
