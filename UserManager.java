import java.awt.event.*;
import javax.swing.*;

public class UserManager extends JPanel{
	private JLabel username,money;
	private JButton logout,deposit,withdraw;
	private ConnectToTC cttc;
	public UserManager(String un) {
		//setLayout(null);
		cttc = new ConnectToTC(un);
		username = new JLabel(un);
		username.setBounds(100,100,username.getWidth(),username.getHeight());
		logout = new JButton("Log Out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.mf.setPanel(new LoginOrRegister());
			}
		});
		logout.setLocation(100, 250);
		deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				money.setText("Money: " + cttc.addMoney(Integer.parseInt(JOptionPane.showInputDialog("How much money to deposit?"))));
			}
		});
		withdraw = new JButton("Withdraw");
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				money.setText("Money: " + (cttc.removeMoney(Integer.parseInt(JOptionPane.showInputDialog("How much money to withdraw?")))));
			}
		});
		money = new JLabel("Money: " + cttc.getMoney());
		add(username);
		add(logout);
		add(deposit);
		add(withdraw);
		add(money);
	}
}