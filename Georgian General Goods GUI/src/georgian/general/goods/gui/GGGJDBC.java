package georgian.general.goods.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class GGGJDBC extends JFrame {
    private String userName, passWord;
    private Boolean DBauth;
    
    public GGGJDBC(){
        super();
        final JPanel loginPanel = new JPanel();
        JLabel userNameLabel = new JLabel("Username: "), 
                passWordLabel = new JLabel("Password: ");
        final JTextField userNameTextField = new JTextField(10);
        final JPasswordField passWordField = new JPasswordField(10);
        JButton loginButton = new JButton();
        loginPanel.add(userNameLabel);
        loginPanel.add(userNameTextField);
        loginPanel.add(passWordLabel);
        loginPanel.add(passWordField);
        userName = userNameTextField.getText(); 
        passWord = new String(passWordField.getPassword());
    }
    
    public void insert(){
        Statement stat = null;
        Connection conn = null;
        final String db_url = "jdbc:mysql://sql.computerstudi.es:3306/gc200330143";
        try{
            conn = DriverManager.getConnection(db_url, userName, passWord);
            stat = conn.createStatement();
            String sql = "INSERT INTO 'gc200330143'.'Names'"
                    + "('firstname','lastname') VALUES (" 
                    + "'Jack', 'Jackson')";
            stat.executeUpdate(sql);
            
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }
}
