import javax.swing.*;

public class MainFrame extends JFrame{
	public static MainFrame mf;
	
	public MainFrame() {
		setTitle("bank");
		add(new LoginOrRegister());
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setPanel(JPanel panel) {
		setVisible(false);
		getContentPane().removeAll();
		getContentPane().add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		mf = new MainFrame();
	}

}
