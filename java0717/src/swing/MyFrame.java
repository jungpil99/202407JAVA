package swing;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MyFrame {
	public static void main(String[] args) {
		new MouseListenerEx();
	}
}

class MouseListenerEx extends JFrame{
	JPanel jp = new JPanel(); //FlowLayout 기본
	JLabel la = new JLabel("No Mouse Event");
	
	MouseListenerEx() {
		this.setContentPane(jp); //판넬을 붙인다
		jp.add(la);
		this.setSize(700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x를 누르면 메모리에서 완전히 지워주는
		
		jp.addMouseListener(new MyMouseListener());
		jp.addMouseMotionListener(new MyMouseListener());
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			la.setText("click(" + e.getX() + "," + e.getY() + ")");
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("press(" + e.getX() + "," + e.getY() + ")");
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("release(" + e.getX() + "," + e.getY() + ")");
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jp.setBackground(Color.CYAN);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jp.setBackground(Color.BLUE);
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("drag(" + e.getX() + "," + e.getY() + ")");
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("move(" + e.getX() + "," + e.getY() + ")");
			
		}
		
	}
}


