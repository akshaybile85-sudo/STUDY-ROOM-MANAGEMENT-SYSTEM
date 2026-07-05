
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;


import javax.swing.JTextField;


@SuppressWarnings("serial")
public class updateperson extends JFrame implements ActionListener{
	
	
	
	JPanel updateframe;
	String selectedSlot;
	JButton image,save, cancel,idb;
	JLabel  id, name, email, mob, parent, clg, slot, edu; 
	JTextField  idtf, nametf, emailtf, mobtf, parenttf, clgtf, edutf, slottf; 
	JRadioButton mrng,aft;
	ButtonGroup bg;

	
	updateperson()
	{
		updateframe=new JPanel();
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width, screenSize.height);
		this.setLocation(0, 0);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setLocation(520,260);
		this.setBackground(Color.decode("#9300C7"));
		//this.setLayout(null);
		//this.setAlwaysOnTop(true);
		//this.setUndecorated(true);
		
		
		//Font
		Font font=new Font("",Font.BOLD,18);
		
		
		ImageIcon addIcon1=new ImageIcon("C://internship/StudyCentre/add12.png");
		image=new JButton(addIcon1);
		image.addActionListener(this);
		image.setBounds(120, 50, 150, 180);
		updateframe.add(image);
		
		id =new JLabel("ID:");
		id.setFont(font);
		id.setBounds(110,280, 100, 30);
		updateframe.add(id);
		
		idtf=new JTextField();
		idtf.addActionListener(this);
		idtf.setFont(font);
		idtf.setBounds(200, 280,270 , 30);
		updateframe.add(idtf);
		
		
		
		ImageIcon searchicon=new ImageIcon("C://internship/StudyCentre/searchb.png");
		idb=new JButton(searchicon);
		idb.addActionListener(this);
		idb.setBounds(470, 280, 30, 30);
		updateframe.add(idb);
		
		
		
		name =new JLabel("Name:");
		name.setFont(font);
		name.setBounds(600, 280, 100, 30);
		updateframe.add(name);
		
		nametf=new JTextField();
		nametf.addActionListener(this);
		nametf.setFont(font);
		nametf.setBounds(700, 280, 300 , 30);
		updateframe.add(nametf);
		
		
		
		
		
		email =new JLabel("E-Mail:");
		email.setFont(font);
		email.setBounds(100, 350, 100, 30);
		updateframe.add(email);
		
		emailtf=new JTextField();
		emailtf.addActionListener(this);
		emailtf.setFont(font);
		emailtf.setBounds(200, 350, 300 , 30);
		updateframe.add(emailtf);
		
		
		
		
		
		
		mob =new JLabel("Moblie:");
		mob.setFont(font);
		mob.setBounds(600, 350, 100, 30);
		updateframe.add(mob);
		
		mobtf=new JTextField();
		mobtf.addActionListener(this);
		mobtf.setFont(font);
		//mobtf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		mobtf.setBounds(700, 350, 300 , 30);
		updateframe.add(mobtf);
		
		
		
		
		
		
		parent =new JLabel("Parent Contact:");
		parent.setFont(font);
		parent.setBounds(50, 420, 150, 30);
		updateframe.add(parent);
		
		parenttf=new JTextField();
		parenttf.addActionListener(this);
		parenttf.setFont(font);
	//	parenttf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		parenttf.setBounds(200, 420, 300 , 30);
		updateframe.add(parenttf);
		
		
		
		
		
		
		clg =new JLabel("College:");
		clg.setFont(font);
		clg.setBounds(600, 420, 150, 30);
		updateframe.add(clg);
		
		clgtf=new JTextField();
		clgtf.addActionListener(this);
		clgtf.setFont(font);
		//clgtf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		clgtf.setBounds(700, 420, 300 , 30);
		updateframe.add(clgtf);
		
		
		
		
		
		
		edu =new JLabel("Education:");
		edu.setFont(font);
		edu.setBounds(85, 490, 150, 30);
		updateframe.add(edu);
		
		edutf=new JTextField();
		edutf.addActionListener(this);
		edutf.setFont(font);
		//edutf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		edutf.setBounds(200, 490, 300 , 30);
		updateframe.add(edutf);
		
		
		
		
		slot =new JLabel("slot:");
		slot.setFont(font);
		slot.setBounds(600, 490, 100, 30);
		updateframe.add(slot);
		
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
		updateframe.add(mrng);
		updateframe.add(aft);
		
		
		
		
		
		save=new JButton("Save");
		//save.setEnabled(false);
		save.addActionListener(this);
		save.setFont(font);
		save.setBounds(420,670,110,30);
		updateframe.add(save);
		
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setFont(font);
		cancel.setBounds(620,670,110,30);
		updateframe.add(cancel);
		updateframe.setSize(1200,720);
		updateframe.setBackground(Color.decode("#D4F1F4"));
		updateframe.setLayout(null);
		this.add(updateframe);
		this.setVisible(true);
		
		//this.add(this);
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==idb){
			
			
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
    				@SuppressWarnings("unused")
					String slot=results.getString(8);
    				
    				
    				
    				nametf.setText(name);
    				mobtf.setText(mob);
    				emailtf.setText(email);
    				parenttf.setText(parentmob);
    				clgtf.setText(college);
    				edutf.setText(edu);
    				//slottf.setText(slot);
    				
    			}
    			System.out.println("Data successfully fetched");
    			save.setEnabled(true);
    			
    		}
    		catch(Exception ae)
    		{
    			System.out.println(ae);
    		}
			
		}
		else if(e.getSource()==save)
		{
		   	
			 try
			  {
				Dbconnect db=new Dbconnect();
				Connection conn=db.getConnection();
						
		 	    
			   
			    int id=Integer.parseInt(idtf.getText());
			   	   
			    
			   	   
				String selectquery = "update registeredstudent set name=?, mobile_no=?, email=?, parentmob=?, college=?, edu=?, slot=?  where id=?";

				PreparedStatement pstmt = null;
				pstmt = conn.prepareStatement(selectquery);

				pstmt.setString(1, nametf.getText());
				
				pstmt.setString(2,mobtf.getText());

				pstmt.setString(3,emailtf.getText());
				
				pstmt.setString(4, parenttf.getText());
				
				pstmt.setString(5,clgtf.getText());

				pstmt.setString(6,edutf.getText());
				
				if(mrng.isSelected())
    				selectedSlot=mrng.getText();
    			else
    				selectedSlot=aft.getText();
    			
				
				pstmt.setString(7,selectedSlot);

				pstmt.setInt(8, id);
						
				int count = pstmt.executeUpdate();
				
				if(count==0) {
		   		   System.out.println("No Record Found with ID= "+id);
		   		   JOptionPane.showMessageDialog(updateframe, "No Record Found with ID: "+id, "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println("Record Id "+id+ " Data Successfully Updated !!!");
					JOptionPane.showMessageDialog(updateframe, "Record ID "+id+" Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
			 }
			 catch(Exception ae)
			 {
				 System.out.println(ae);
				 JOptionPane.showMessageDialog(updateframe, "Error: "+ae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			 }
		  
		}
		else if(e.getSource()==cancel)
			this.dispose();
		
	}

}
