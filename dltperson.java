import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import javax.swing.JTextField;


@SuppressWarnings("serial")
public class dltperson extends JFrame implements ActionListener{
	
	
	
	JPanel dltframe;
	JButton image,save, cancel,idb;
	JLabel  id, name, email, mob, parent, clg, slot, edu; 
	JTextField  idtf, nametf, emailtf, mobtf, parenttf, clgtf, edutf, slottf; 
	
	ButtonGroup bg;
	
	dltperson()
	{
		dltframe= new JPanel();
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
		dltframe.add(image1);
		
		
		id =new JLabel("ID:");
		id.setFont(font);
		id.setBounds(110,280, 100, 30);
		dltframe.add(id);
		
		idtf=new JTextField();
		idtf.setFont(font);
		idtf.setBounds(200, 280,270 , 30);
		dltframe.add(idtf);
		
		ImageIcon searchicon=new ImageIcon("C://internship/StudyCentre/searchb.png");
		idb=new JButton(searchicon);
		idb.addActionListener(this);
		idb.setBounds(470, 280, 30, 30);
		dltframe.add(idb);
		
		
		
		
		
		
		
		
		name =new JLabel("Name:");
		name.setFont(font);
		name.setBounds(600, 280, 100, 30);
		dltframe.add(name);
		
		nametf=new JTextField();
		nametf.setEditable(false);
		nametf.setFont(font);
		nametf.setBounds(700, 280, 300 , 30);
		dltframe.add(nametf);
		
		
		
		
		
		email =new JLabel("E-Mail:");
		email.setFont(font);
		email.setBounds(100, 350, 100, 30);
		dltframe.add(email);
		
		emailtf=new JTextField();
		emailtf.setEditable(false);
		emailtf.setFont(font);
		emailtf.setBounds(200, 350, 300 , 30);
		dltframe.add(emailtf);
		
		
		
		
		
		
		mob =new JLabel("Moblie:");
		mob.setFont(font);
		mob.setBounds(600, 350, 100, 30);
		dltframe.add(mob);
		
		mobtf=new JTextField();
		mobtf.setEditable(false);
		mobtf.setFont(font);
		//mobtf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		mobtf.setBounds(700, 350, 300 , 30);
		dltframe.add(mobtf);
		
		
		
		
		
		
		parent =new JLabel("Parent Contact:");
		parent.setFont(font);
		parent.setBounds(50, 420, 150, 30);
		dltframe.add(parent);
		
		parenttf=new JTextField();
		parenttf.setEditable(false);
		parenttf.setFont(font);
	//	parenttf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		parenttf.setBounds(200, 420, 300 , 30);
		dltframe.add(parenttf);
		
		
		
		
		
		
		clg =new JLabel("College:");
		clg.setFont(font);
		clg.setBounds(600, 420, 100, 30);
		dltframe.add(clg);
		
		clgtf=new JTextField();
		clgtf.setEditable(false);
		clgtf.setFont(font);
		//clgtf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		clgtf.setBounds(700, 420, 300 , 30);
		dltframe.add(clgtf);
		
		
		
		
		
		
		edu =new JLabel("Education:");
		edu.setFont(font);
		edu.setBounds(85, 490, 150, 30);
		dltframe.add(edu);
		
		edutf=new JTextField();
		edutf.setEditable(false);
		edutf.setFont(font);
		//edutf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		edutf.setBounds(200, 490, 300 , 30);
		dltframe.add(edutf);
		
		
		
		
		slot =new JLabel("slot:");
		slot.setFont(font);
		slot.setBounds(600, 490, 100, 30);
		dltframe.add(slot);
		
		slottf=new JTextField();
		slottf.setEditable(false);
		slottf.setFont(font);
		//edutf.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
		slottf.setBounds(700, 490, 300 , 30);
		dltframe.add(slottf);
		
		
		
		
		
		
		save=new JButton("Delete");
		save.addActionListener(this);
		save.setEnabled(false);
		save.setFont(font);
		save.setBounds(420,670,110,30);
		dltframe.add(save);
		
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setFont(font);
		cancel.setBounds(620,670,110,30);
		dltframe.add(cancel);
		
		
		
		dltframe.add(cancel);
		dltframe.setSize(1200,720);
		dltframe.setBackground(Color.decode("#D4F1F4"));
		dltframe.setLayout(null);
		this.add(dltframe);
		this.setVisible(true);
		
		
		
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
    			save.setEnabled(true);
    			
    		}
    		catch(Exception ae)
    		{
    			System.out.println(ae);
    		}
			
		}
		else if(e.getSource()==save)
		{
			try{
				Dbconnect db=new Dbconnect();
				Connection conn=db.getConnection();
				
				
				int id=Integer.parseInt(idtf.getText());
				String deleteQuery="delete from registeredstudent where id=?";
				PreparedStatement preparedStatement;
				
				preparedStatement=conn.prepareStatement(deleteQuery);
				preparedStatement.setString(1, id+"");
				
				int i=JOptionPane.showConfirmDialog(this, "Confirm delete", null, JOptionPane.YES_NO_OPTION);
				if(i==0)
				{
					if(preparedStatement.executeUpdate()==0)
						JOptionPane.showMessageDialog(this, "No record found", "No records", JOptionPane.WARNING_MESSAGE);
					else
						JOptionPane.showMessageDialog(this, "Record deleted Successfully", " Records Deleted", JOptionPane.INFORMATION_MESSAGE);
				
				}
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
