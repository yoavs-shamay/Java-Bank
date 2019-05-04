import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginOrRegister extends JPanel{
	private JLabel ll,username,password,uopi,rl,u2,p2,ue;
	private JTextField utf,ui2;
	private JPasswordField ppf,pi2;
	private JButton login,register;
	public static ConnectToUPT ctupt;
	
	public LoginOrRegister() {
		ctupt = new ConnectToUPT();
		setLayout(new GridLayout(15,15));
		ll = new JLabel("Login");
		username = new JLabel("username: ");
		password = new JLabel("password: ");
		uopi = new JLabel("username or password incorrect");
		uopi.setVisible(false);
		utf = new JTextField(10);
		ppf = new JPasswordField(10);
		login = new JButton("login");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean isUser = ctupt.isUser(utf.getText(),ppf.getText());
				if(isUser) {
					MainFrame.mf.setPanel(new UserManager(utf.getText()));
				} else {
					uopi.setVisible(true);
					validate();
					repaint();
				}
				
			}
		});
		rl = new JLabel("Register");
		u2 = new JLabel("username: ");
		ui2 = new JTextField(10);
		p2 = new JLabel("password: ");
		pi2 = new JPasswordField(10);
		register = new JButton("register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean b = ctupt.addUser(ui2.getText(), pi2.getText());
				if(!b) {
					ue.setVisible(true);
				} else {
					MainFrame.mf.setPanel(new UserManager(ui2.getText()));
				}
			}
		});
		ue = new JLabel("username exists");
		ue.setVisible(false);
		add(ll);
		add(username);
		add(utf);
		add(password);
		add(ppf);
		add(login);
		add(uopi);
		add(rl);
		add(u2);
		add(ui2);
		add(p2);
		add(pi2);
		add(register);
		add(ue);
	}
}