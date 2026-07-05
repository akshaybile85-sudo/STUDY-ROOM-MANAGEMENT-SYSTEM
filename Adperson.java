import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


@SuppressWarnings("serial")
public class Adperson extends JFrame implements ActionListener  {

	
	
	JPanel ad;
	JButton image,save, cancel;
	JLabel  id, name, email, mob, parent, clg, edu, slot;
	String selectedSlot; 
	JTextField  idtf, nametf, emailtf, mobtf, parenttf, clgtf, edutf; 
	JRadioButton mrng,aft;
	ButtonGroup bg;
	
	Adperson()
	{
		ad=new JPanel();
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width, screenSize.height);
		this.setLocation(0, 0);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setLayout(null);
		//this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Font
		Font font=new Font("",Font.BOLD,18);
		
		
		ImageIcon addIcon1=new ImageIcon("C://internship/StudyCentre/add12.png");
		image=new JButton(addIcon1);
		image.addActionListener(this);
		image.setBounds(120, 50, 150, 180);
		ad.add(image);
		
		id =new JLabel("ID:");
		id.setFont(font);
		id.setBounds(110,280, 100, 30);
		ad.add(id);
		
		idtf=new JTextField();
		idtf.addActionListener(this);
		idtf.setFont(font);
		idtf.setBounds(200, 280,300 , 30);
		ad.add(idtf);
		
		
		
		
		
		
		
		name =new JLabel("Name:");
		name.setFont(font);
		name.setBounds(600, 280, 100, 30);
		ad.add(name);
		
		nametf=new JTextField();
		nametf.addActionListener(this);
		nametf.setFont(font);
		nametf.setBounds(700, 280, 300 , 30);
		ad.add(nametf);
		
		
		
		
		
		email =new JLabel("E-Mail:");
		email.setFont(font);
		email.setBounds(100, 350, 100, 30);
		ad.add(email);
		
		emailtf=new JTextField();
		emailtf.addActionListener(this);
		emailtf.setFont(font);
		emailtf.setBounds(200, 350, 300 , 30);
		ad.add(emailtf);
		
		
		
		
		
		
		mob =new JLabel("Moblie:");
		mob.setFont(font);
		mob.setBounds(600, 350, 100, 30);
		ad.add(mob);
		
		mobtf=new JTextField();
		mobtf.addActionListener(this);
		mobtf.setFont(font);
		//mobtf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		mobtf.setBounds(700, 350, 300 , 30);
		ad.add(mobtf);
		
		
		
		
		
		
		parent =new JLabel("Parent Contact:");
		parent.setFont(font);
		parent.setBounds(50, 420, 150, 30);
		ad.add(parent);
		
		parenttf=new JTextField();
		parenttf.addActionListener(this);
		parenttf.setFont(font);
	//	parenttf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		parenttf.setBounds(200, 420, 300 , 30);
		ad.add(parenttf);
		
		
		
		
		
		
		clg =new JLabel("College:");
		clg.setFont(font);
		clg.setBounds(600, 420, 150, 30);
		ad.add(clg);
		
		clgtf=new JTextField();
		clgtf.addActionListener(this);
		clgtf.setFont(font);
		//clgtf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		clgtf.setBounds(700, 420, 300 , 30);
		ad.add(clgtf);
		
		
		
		
		
		
		edu =new JLabel("Education:");
		edu.setFont(font);
		edu.setBounds(85, 490, 150, 30);
		ad.add(edu);
		
		edutf=new JTextField();
		edutf.addActionListener(this);
		edutf.setFont(font);
		//edutf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		edutf.setBounds(200, 490, 300 , 30);
		ad.add(edutf);
		
		
		
		
		slot =new JLabel("slot:");
		slot.setFont(font);
		slot.setBounds(600, 490, 100, 30);
		ad.add(slot);
		
		mrng=new JRadioButton("Morning");
		mrng.setBackground(Color.decode("#D4F1F4"));
		mrng.setBounds(700, 490, 100, 30);
		mrng.setFont(font);
		aft=new JRadioButton("Afternoon");
		aft.setBackground(Color.decode("#D4F1F4"));
		aft.addActionListener(this);
		aft.setBounds(820, 490, 150, 30);
		aft.setFont(font);
		bg=new ButtonGroup();
		bg.add(mrng);
		bg.add(aft);
		ad.add(mrng);
		ad.add(aft);
		
		
		
		
		
		save=new JButton("Save");
		//save.setEnabled(false);
		save.addActionListener(this);
		save.setFont(font);
		save.setBounds(420,670,110,30);
		ad.add(save);
		
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setFont(font);
		cancel.setBounds(620,670,110,30);
		ad.add(cancel);
		ad.setSize(1200,720);
		ad.setBackground(Color.decode("#D4F1F4"));
		ad.setLayout(null);
		this.add(ad);
		this.setVisible(true);
		
		//this.add(this);
		
		
		//return ad;
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		Pattern idPattern=Pattern.compile("^\\d+$");
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Pattern phonePattern = Pattern.compile("^[789]\\d{9}$");
	
       
        Matcher idMatcher=idPattern.matcher(idtf.getText());
        Matcher emailMatcher = emailPattern.matcher(emailtf.getText());
        Matcher phoneMatcher = phonePattern.matcher(mobtf.getText());
        
        
      
        if(e.getSource()==save)
		{
        	System.out.println(bg.getSelection());
        	if(!idMatcher.matches())
        	{
        		JOptionPane.showMessageDialog(ad, "Entervalid ID");
	   	 	     
        	}
        	else if (!phoneMatcher.matches()) {
        		
        		JOptionPane.showMessageDialog(ad, "Enter valid Mobile no.", "Invalid Mobile No.!", JOptionPane.WARNING_MESSAGE);
   	 	     
 	            
 	        }
        	else if (!emailMatcher.matches()) {
	 	        	
	 	        	JOptionPane.showMessageDialog(ad, "Enter valid emial", "Invalid Email!", JOptionPane.WARNING_MESSAGE);
	 	    }
        	else{
        		

        		// TODO Auto-generated method stub
        		
        		try{
        			Dbconnect db=new Dbconnect();
        			Connection conn=db.getConnection();
        			
        			
        			String insertQuery="insert into registeredstudent values(?,?,?,?,?,?,?,?)";
        			PreparedStatement preparedStatement;
        			
        			preparedStatement=conn.prepareStatement(insertQuery);
        			preparedStatement.setString(1, Integer.parseInt(idtf.getText())+"");
        			preparedStatement.setString(2, nametf.getText());
        			preparedStatement.setString(3, mobtf.getText());
        			preparedStatement.setString(4, emailtf.getText());
        			preparedStatement.setString(5, parenttf.getText());
        			preparedStatement.setString(6, clgtf.getText());
        			preparedStatement.setString(7, edutf.getText());
        			
        			if(mrng.isSelected())
        				selectedSlot=mrng.getText();
        			else
        				selectedSlot=aft.getText();
        			
        			preparedStatement.setString(8,selectedSlot);
        			
        			
        			
        			
        			preparedStatement.executeUpdate();
        			System.out.println("Data successfully inserted");
        			
        			
        		}
        		catch(Exception ae)
        		{
        			System.out.println(ae);
        		}

        	
        		
        		JOptionPane.showMessageDialog(ad, "Data Saved", "", JOptionPane.INFORMATION_MESSAGE);
	   	 	     
        	}
		}
			
       

       

      

     
        
	
	
        if(e.getSource()==image)
        {
        	System.out.println("hi imageEvent");
        	JFileChooser gc=new JFileChooser();
        	FileNameExtensionFilter filter=new FileNameExtensionFilter("Image Files", "jpg", "jpej", "png");
        	gc.setFileFilter(filter);
        	int i= gc.showOpenDialog(ad);
        	if(i==JFileChooser.APPROVE_OPTION)
        	{
        		String imagepath=gc.getSelectedFile().getAbsolutePath();
        		ImageIcon selectedAddIcon=new ImageIcon(imagepath);
        		image.setIcon(selectedAddIcon);				
			
        	}
		
        }
	    
        if(e.getSource()==cancel)
        	this.dispose();
	
	}

}
