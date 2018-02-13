import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class A2_UI extends JFrame {
	JTextField hexa,deci,bina,rgb,spd;
	String a = "",b = "",c = "";
	JButton convert, dance;
	
	public A2_UI() {
		super("Dancing Finch: Jim");
		setLayout(new FlowLayout());		
		JLabel label1 = new JLabel("<html><body>2 digit Hexadecimal:&emsp <br>(e.g. “9A” or “F2”)</body></html>");
		add(label1);
		
		hexa = new JTextField(a, 5);
		hexa.setEditable(true);
		add(hexa);
		
		convert = new JButton("Convert");
		convert.setPreferredSize(new Dimension (80,25));
		add(convert);
		
		JLabel label2 = new JLabel("Decimal conversion: ");
		label2.setPreferredSize(new Dimension (120,20));
		add(label2);
		
		deci = new JTextField(b, 10);
		deci.setEditable(false);
		add(deci);
		
		JLabel label3 = new JLabel("Binary conversion: ");
		label3.setPreferredSize(new Dimension (120,20));
		add(label3);
		
		bina = new JTextField(c, 10);
		bina.setEditable(false);
		add(bina);

		JLabel label4 = new JLabel("Colour (R,G,B): ");
		label4.setPreferredSize(new Dimension (120,20));
		add(label4);
		
		rgb = new JTextField(c, 10);
		rgb.setEditable(false);
		add(rgb);

		JLabel label5 = new JLabel("Speed: ");
		label5.setPreferredSize(new Dimension (120,20));
		add(label5);
		
		spd = new JTextField(c, 10);
		spd.setEditable(false);
		add(spd);
		
		dance = new JButton("Dance");
		dance.setPreferredSize(new Dimension (100,30));
		add(dance);
		
		thehandler handler = new thehandler();
		hexa.addActionListener(handler);
		convert.addActionListener(handler);
		dance.addActionListener(handler);
	}
	private class thehandler implements ActionListener{		
		public void actionPerformed(ActionEvent event) {
			String pattern= "[0-9A-F][0-9A-F]";
			String string = hexa.getText();
			if (event.getSource()==hexa || event.getSource()==convert) {
				if (string.matches(pattern)){
					A2.run(hexa.getText());
					deci.setText(A2.dec);
					bina.setText(A2.bin);
					rgb.setText(A2.r + "," + A2.g + "," + A2.b);
					spd.setText(Integer.toString(A2.spdVal));
				}
				else{JOptionPane.showMessageDialog(null, "Please enter a valid input","Error", JOptionPane.ERROR_MESSAGE);}
			}
			else if (event.getSource()==dance){
				if (!A2.dec.equals("")){A2.danceFabulously();}
				else{JOptionPane.showMessageDialog(null, "No values to use. \nPlease convert your Hexadecimal first before dancing","Error", JOptionPane.ERROR_MESSAGE);}
			}
		}
	}
}

