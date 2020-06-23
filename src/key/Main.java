package key;

import java.awt.BorderLayout;
import java.awt.Container;

class Main {
	public static void main(String[] arg) throws ParseException {

		final MyFrame frame = new MyFrame();
		final Keyboard keyboard = new Keyboard();

		frame.setCloseActionListener(keyboard.getCloseAction());

		final Container container = frame.getContentPane();
		container.add(keyboard.getPanel(), BorderLayout.CENTER);
		final MyLabel label = new MyLabel();
		container.add(label, BorderLayout.NORTH);
		frame.setVisible(true);
		Parser parser = new Parser(keyboard);
		parser.setActionListener(label.getActionListener());
		parser.start();
	}
}
