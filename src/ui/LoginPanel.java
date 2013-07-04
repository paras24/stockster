package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.crs.toolkit.layout.SWTGridData;
import com.crs.toolkit.layout.SWTGridLayout;


@SuppressWarnings("serial")
public class LoginPanel extends JFrame{
public LoginPanel() {
	super("JCHAT- Login");
	setSize(500,300);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	JPanel body = new JPanel(new SWTGridLayout(2, false));
	body.add(new JLabel("User Name:"));
	JTextField username = new JTextField();
	username.setSize(5, HEIGHT);
	SWTGridData data = new SWTGridData();
	data.grabExcessHorizontalSpace = true;
	data.horizontalAlignment = SWTGridData.FILL;
	body.add(username, data);

	setVisible(true);
	add(body);
}

public static void main(String[] args) {
	new LoginPanel();
	
}
}
