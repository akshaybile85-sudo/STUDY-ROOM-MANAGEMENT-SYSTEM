import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class SearchPerson extends JFrame implements ActionListener {

	
	JPanel searchframe;
	JButton image,save, cancel,idb;
	JLabel  id, name, email, mob, parent, clg, slot, edu; 
	JTextField  idtf, nametf, emailtf, mobtf, parenttf, clgtf, edutf, slottf; 
	
	SearchPerson()
	{
		searchframe= new JPanel();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width, screenSize.height);
		this.setLocation(0, 0);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setLocation(520,260);
		this.setLayout(null);
		//this.setAlwaysOnTop(true);
		//this.setUndecorated(true);
		
		
		//Font
		Font font=new Font("",Font.BOLD,18);
		
		ImageIcon imageIcon1=new ImageIcon("C://internship/StudyCentre/add12.png");
		JLabel image1=new JLabel(imageIcon1);
		image1.setBounds(120, 50, 150, 180);
		image1.setBorder(BorderFactory.createLineBorder(Color.black));
		image1.setBackground(Color.CYAN);
		searchframe.add(image1);
		
		
		id =new JLabel("ID:");
		id.setFont(font);
		id.setBounds(110,280, 100, 30);
		searchframe.add(id);
		
		idtf=new JTextField();
		idtf.setFont(font);
		idtf.setBounds(200, 280,300 , 30);
		searchframe.add(idtf);
		
		
		
		
		
		
		
		
		
		
		name =new JLabel("Name:");
		name.setFont(font);
		name.setBounds(600, 280, 100, 30);
		searchframe.add(name);
		
		nametf=new JTextField();
		nametf.setEditable(false);
		nametf.setFont(font);
		nametf.setBounds(700, 280, 300 , 30);
		searchframe.add(nametf);
		
		
		
		
		
		email =new JLabel("E-Mail:");
		email.setFont(font);
		email.setBounds(100, 350, 100, 30);
		searchframe.add(email);
		
		emailtf=new JTextField();
		emailtf.setEditable(false);
		emailtf.setFont(font);
		emailtf.setBounds(200, 350, 300 , 30);
		searchframe.add(emailtf);
		
		
		
		
		
		
		mob =new JLabel("Moblie:");
		mob.setFont(font);
		mob.setBounds(600, 350, 100, 30);
		searchframe.add(mob);
		
		mobtf=new JTextField();
		mobtf.setEditable(false);
		mobtf.setFont(font);
		//mobtf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		mobtf.setBounds(700, 350, 300 , 30);
		searchframe.add(mobtf);
		
		
		
		
		
		
		parent =new JLabel("Parent Contact:");
		parent.setFont(font);
		parent.setBounds(50, 420, 150, 30);
		searchframe.add(parent);
		
		parenttf=new JTextField();
		parenttf.setEditable(false);
		parenttf.setFont(font);
	//	parenttf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		parenttf.setBounds(200, 420, 300 , 30);
		searchframe.add(parenttf);
		
		
		
		
		
		
		clg =new JLabel("College:");
		clg.setFont(font);
		clg.setBounds(600, 420, 100, 30);
		searchframe.add(clg);
		
		clgtf=new JTextField();
		clgtf.setEditable(false);
		clgtf.setFont(font);
		//clgtf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		clgtf.setBounds(700, 420, 300 , 30);
		searchframe.add(clgtf);
		
		
		
		
		
		
		edu =new JLabel("Education:");
		edu.setFont(font);
		edu.setBounds(85, 490, 150, 30);
		searchframe.add(edu);
		
		edutf=new JTextField();
		edutf.setEditable(false);
		edutf.setFont(font);
		//edutf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		edutf.setBounds(200, 490, 300 , 30);
		searchframe.add(edutf);
		
		
		
		
		slot =new JLabel("slot:");
		slot.setFont(font);
		slot.setBounds(600, 490, 100, 30);
		searchframe.add(slot);
		
		slottf=new JTextField();
		slottf.setEditable(false);
		slottf.setFont(font);
		//edutf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		slottf.setBounds(700, 490, 300 , 30);
		searchframe.add(slottf);
		
		
		
		
		
		
		save=new JButton("Search");
		save.addActionListener(this);
		save.setFont(font);
		save.setBounds(420,670,110,30);
		searchframe.add(save);
		
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setFont(font);
		cancel.setBounds(620,670,110,30);
		searchframe.add(cancel);
		
		
		
		searchframe.add(cancel);
		searchframe.setSize(1200,720);
		searchframe.setBackground(Color.decode("#D4F1F4"));
		searchframe.setLayout(null);
		this.add(searchframe);
		this.setVisible(true);
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==save)
		{

			
			System.out.println("from idb");
			
			try{
    			Dbconnect db=new Dbconnect();
    			Connection conn=db.getConnection();
    			
    			
    			String insertQuery="select * from registeredstudent where id=?";
    			PreparedStatement preparedStatement;
    			
    			preparedStatement=conn.prepareStatement(insertQuery);
    			preparedStatement.setInt(1, Integer.parseInt(idtf.getText()));
    		
    			
    			ResultSet results=preparedStatement.executeQuery();
    			if(results.next())
    			{
    				String name=results.getString(2);
    				String mob=results.getString(3);
    				String email=results.getString(4);
    				String parentmob=results.getString(5);
    				String college=results.getString(6);
    				String edu=results.getString(7);
    				String slot=results.getString(8);
    				
    				
    				
    				nametf.setText(name);
    				mobtf.setText(mob);
    				emailtf.setText(email);
    				parenttf.setText(parentmob);
    				clgtf.setText(college);
    				edutf.setText(edu);
    				slottf.setText(slot);
    				
    			}
    			
    			
    			
    			System.out.println("Data successfully fetched");
    			
    		}
    		catch(Exception ae)
    		{
    			System.out.println(ae);
    		}
			
		}
		else if(e.getSource()==cancel)
			this.dispose();
	}

}
