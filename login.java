import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class login extends JFrame implements ActionListener {
    
    JPanel loginframe;
    JLabel userLabel, passLabel, title;
    JTextField userText;
    JPasswordField passText;
    JButton loginButton, cancelButton;
    
    login() {
        loginframe = new JPanel();
        
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLocation(0, 0);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Font font = new Font("Arial", Font.BOLD, 18);
        Font titleFont = new Font("Arial", Font.BOLD, 30);
        
        int width = screenSize.width;
        int height = screenSize.height;
        int centerX = width / 2;
        int centerY = height / 2;

        title = new JLabel("Vivekanand Study Centre - Login");
        title.setFont(titleFont);
        title.setBounds(centerX - 250, centerY - 150, 500, 40);
        loginframe.add(title);
        
        userLabel = new JLabel("Username:");
        userLabel.setFont(font);
        userLabel.setBounds(centerX - 150, centerY - 50, 100, 30);
        loginframe.add(userLabel);
        
        userText = new JTextField();
        userText.setFont(font);
        userText.setBounds(centerX, centerY - 50, 250, 30);
        loginframe.add(userText);
        
        passLabel = new JLabel("Password:");
        passLabel.setFont(font);
        passLabel.setBounds(centerX - 150, centerY + 30, 100, 30);
        loginframe.add(passLabel);
        
        passText = new JPasswordField();
        passText.setFont(font);
        passText.setBounds(centerX, centerY + 30, 250, 30);
        loginframe.add(passText);
        
        loginButton = new JButton("Login");
        loginButton.setFont(font);
        loginButton.setBounds(centerX - 100, centerY + 130, 120, 40);
        loginButton.setBackground(Color.decode("#75E6DA"));
        loginButton.addActionListener(this);
        loginframe.add(loginButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(font);
        cancelButton.setBounds(centerX + 50, centerY + 130, 120, 40);
        cancelButton.setBackground(Color.decode("#75E6DA"));
        cancelButton.addActionListener(this);
        loginframe.add(cancelButton);
        
        loginframe.setSize(width, height); // Fills background
        loginframe.setBackground(Color.decode("#D4F1F4"));
        loginframe.setLayout(null);
        this.add(loginframe);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userText.getText();
            String pass = new String(passText.getPassword());
            
            // Hardcoded check for simplicity (username: admin, password: admin)
            if (user.equals("admin") && pass.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                this.dispose(); // Close login window
                
                // Open Main Window
                new mainWindowcp(); 
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new login();
    }
}
