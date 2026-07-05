import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewCustomer
{
	static JFrame f=new JFrame("Database Records");
	static DefaultTableModel dtmCustomer;
	static JTable tbCustomer;
	static JScrollPane jspTable;

	static void populateArray (String rows[][])
	{
		JPanel jpShow = new JPanel ();

		int row = 0;
		int total = 0;

		f.setSize (1200,720);
		f.setLocation(200,200);

		tbCustomer = makeTable (rows);
		jspTable = new JScrollPane (tbCustomer);
		jspTable.setBounds (0, 0,1200,720);

		jpShow.add (jspTable);
		jpShow.setLayout (null);

		f.getContentPane().add (jpShow);
        f.setAlwaysOnTop(true);
        f.setUndecorated(true);
		//f.setVisible (true);
	}

	private static JTable makeTable (String rowData[][])
	{
		String cols[] = {"ID.", "Name", "Mobile No.","E-Mail","Parent No.","College","Education","slot"};

		dtmCustomer  = new DefaultTableModel (rowData, cols);

		tbCustomer = new JTable(dtmCustomer)
		{
			public boolean isCellEditable (int iRow, int iCol)
			{
				return false;	//Disable All Columns of Table.
			}
		};
		
		(tbCustomer.getColumnModel().
		getColumn(0)).setPreferredWidth (80);
		

		(tbCustomer.getColumnModel().getColumn(1)).setPreferredWidth (100);
		(tbCustomer.getColumnModel().getColumn(2)).setPreferredWidth (100);
		tbCustomer.setRowHeight (25);
		tbCustomer.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		return tbCustomer;
	}

}