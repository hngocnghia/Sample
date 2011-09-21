import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CL extends JFrame implements ItemListener {
	final static String BUTTONPANEL = "Card with JButton";
	final static String TEXTPANEL = "Card with JTextField";
	JPanel cards;
	public CL() {
	super("Demo CardLayout");
	init(getContentPane());
	pack();
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void init(Container pane) {
		JPanel card1 = new JPanel();
		card1.add(new JButton("Button1"));
				
		JPanel card2 = new JPanel();
		card2.add(new JTextField(20));
		
		cards = new JPanel(new CardLayout());		
		cards.add(card1, BUTTONPANEL);
		cards.add(card2, TEXTPANEL);
		
		JPanel comboBoxPane = new JPanel();
		String comboBoxItems[] = {BUTTONPANEL, TEXTPANEL};
		JComboBox cb = new JComboBox(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);
		
		pane.add(comboBoxPane, BorderLayout.PAGE_START);
		pane.add(cards, BorderLayout.CENTER);
	}
	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, (String)evt.getItem());
	}
	public static void main(String[]argv) {		
		CL c = new CL();
	}
}