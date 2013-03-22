package lightOn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LightOn extends JPanel  implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private Lights lights = null;
	private JButton start = new JButton("Start");
	private JLabel explain = new JLabel("Try to turn all the squares blue.");
	private JComboBox diffPicker = new JComboBox(new String[]{"medium","easy","difficult"});
	private boolean started = false;
	private boolean locked = true;
	private int clicks = 0;
	private int diffMult = 2;
	private String diff = "medium";
	
	public static void main(String[] args) {
		JFrame jap = new JFrame();
		jap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jap.setPreferredSize(new Dimension(340, 300));
        LightOn game = new LightOn();
        jap.getContentPane().add(game);
        jap.setTitle("Light On 3");
        jap.pack();
        jap.setVisible(true);
        game.repaint();
	}
	
	public LightOn() {
		initGUI(); 
		lights = new Lights();
	}
	
	private void initGUI(){
		
		start.setActionCommand("start");
		start.addActionListener(this);
		this.add(start);
		diffPicker.setActionCommand("change");
		diffPicker.addActionListener(this);
		this.add(diffPicker);
		this.add(explain);
		this.addMouseListener(this);
	}
	
	private static final int X_OFFSET = 60;
	private static final int Y_OFFSET = 60;
	private static final int RECT_SIZE = 40;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("start")){
			if (diff.equals("easy")){
				lights = new Lights(3,3,RECT_SIZE,X_OFFSET,Y_OFFSET);
				diffMult = 1;
			}
			if (diff.equals("medium")){
				lights = new Lights(4,4,RECT_SIZE, X_OFFSET,Y_OFFSET);
				diffMult = 2;
			}
			if (diff.equals("difficult")){
				lights = new Lights(5,5,RECT_SIZE,X_OFFSET, Y_OFFSET);
				diffMult = 3;
			}
			started = true;
			locked = false;
			clicks = 0;
			repaint();
		}
		
		if (arg0.getActionCommand().equals("change")){
			diff = diffPicker.getSelectedItem().toString();
		}	
	}
	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (started){
        	lights.paintLights(g);
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
//		lights.flicker(e.getPoint());
//		this.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!locked){
			lights.flicker(e.getPoint());
			clicks++;
			if (lights.allOn()){
				explain.setText("YOU WIN! Clicks: " + clicks + " Score:" + (clicks * diffMult * 10));
				locked = true;
			}
			this.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}




}
