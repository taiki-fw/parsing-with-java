package key;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

interface FrameConstant {
	int WIDTH = 300;
	int HEIGHT = 200;
	String TITLE = "例";
}

class MyFrame extends JFrame {
	public void setCloseActionListener(ActionListener a) {
		closeActionList.add(a);
	}

	private final LinkedList<ActionListener> closeActionList = new LinkedList<ActionListener>();

	class MyWindowListener extends WindowAdapter {
		@Override
		public void windowClosed(WindowEvent e) {
			for (ActionListener listener : closeActionList) {
				listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "close"));
			}
		}
	}

	public MyFrame() {
		super();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new MyWindowListener());
		setSize(FrameConstant.WIDTH, FrameConstant.HEIGHT);
		setTitle(FrameConstant.TITLE);
	}
}
