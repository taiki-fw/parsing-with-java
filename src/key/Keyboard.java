package key;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

interface KeyboardConstant {
	char[] keys = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '=' };
	long INTERVAL = 100;
}

public class Keyboard extends InputStream {
	final private JPanel panel = new JPanel();

	public Keyboard() {
		super();
		for (char c : KeyboardConstant.keys) {
			JButton button = new JButton(String.valueOf(c));
			button.addActionListener((event) -> queue.addLast((int) (event.getActionCommand().charAt(0))));
			panel.add(button);
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public ActionListener getCloseAction() {
		return (e) -> queue.addLast(-1);
	}

	private LinkedList<Integer> queue = new LinkedList<Integer>();

	@Override
	public int read() throws IOException {
		try {
			while (queue.isEmpty()) {
				Thread.sleep(KeyboardConstant.INTERVAL);
			}
		} catch (InterruptedException e) {
		}
		return queue.remove();
	}

	@Override
	public int available() throws IOException {
		return 0;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		if (len == 0)
			return 0;
		int c = read();
		if (c == -1)
			return -1;
		b[off] = (byte) c;
		return 1;
	}
}
