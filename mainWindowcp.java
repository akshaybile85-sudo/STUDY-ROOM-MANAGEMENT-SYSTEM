import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class mainWindowcp implements ActionListener {

	JFrame frame;
	JPanel westpanel, centrepanel, add, update, dlt, search, contentBox;
	JButton addb, updateb, dltb, searchb;
	JTable studentTable;
	DefaultTableModel tableModel;

	mainWindowcp() {

		frame = new JFrame("Vivekanand Study Centre");

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		frame.setSize(screenWidth, screenHeight);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font panelButton = new Font("", Font.BOLD, 16);

		// Sidebar
		westpanel = new JPanel();
		westpanel.setBounds(0, 0, 250, screenHeight);
		westpanel.setBackground(Color.decode("#189AB4"));
		westpanel.setLayout(null);
		frame.add(westpanel);







		// Center panel
		centrepanel = new JPanel();
		centrepanel.setBounds(250, 0, screenWidth - 250, screenHeight);
		centrepanel.setBackground(Color.decode("#05445E"));
		centrepanel.setLayout(null);
		frame.add(centrepanel);

		// Dynamic layout calculation
		int boxWidth = 200;
		int boxHeight = 120;
		int gap = 60;

		int totalWidth = (4 * boxWidth) + (3 * gap);
		int startX = (screenWidth - 250 - totalWidth) / 2;
		int yTop = 50;

		// ===== PANEL CREATOR METHOD =====
		add = createPanel();
		add.setBounds(startX, yTop, boxWidth, boxHeight);
		centrepanel.add(add);

		addb = createButton("Add", panelButton, "add_icon.png");
		addb.addActionListener(this);
		add.add(addb);



		update = createPanel();
		update.setBounds(startX + (boxWidth + gap), yTop, boxWidth, boxHeight);
		centrepanel.add(update);

		updateb = createButton("Update", panelButton, "update_icon.png");
		updateb.addActionListener(this);
		update.add(updateb);



		dlt = createPanel();
		dlt.setBounds(startX + 2 * (boxWidth + gap), yTop, boxWidth, boxHeight);
		centrepanel.add(dlt);

		dltb = createButton("Delete", panelButton, "delete_icon.png");
		dltb.addActionListener(this);
		dlt.add(dltb);



		search = createPanel();
		search.setBounds(startX + 3 * (boxWidth + gap), yTop, boxWidth, boxHeight);
		centrepanel.add(search);

		searchb = createButton("Search", panelButton, "search_icon.png");
		searchb.addActionListener(this);
		search.add(searchb);





		// Content box
		contentBox = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(Color.decode("#D4F1F4"));
				g.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
			}
		};
		contentBox.setLayout(null);
		contentBox.setBounds(
				50,
				yTop + boxHeight + 40,
				screenWidth - 250 - 100,
				screenHeight - (yTop + boxHeight + 120));
		// Table inside content box
		String[] columns = {"ID", "Name", "Mobile No", "Email", "Parent Contact", "College", "Education", "Slot"};
		tableModel = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int row, int col) { return false; }
		};
		studentTable = new JTable(tableModel);
		studentTable.setFont(new Font("Arial", Font.PLAIN, 14));
		studentTable.setRowHeight(30);
		studentTable.setBackground(Color.decode("#D4F1F4"));
		studentTable.setGridColor(Color.decode("#189AB4"));
		studentTable.setSelectionBackground(Color.decode("#75E6DA"));
		studentTable.setSelectionForeground(Color.decode("#05445E"));

		// Header styling
		JTableHeader header = studentTable.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 15));
		header.setBackground(Color.decode("#189AB4"));
		header.setForeground(Color.WHITE);
		header.setPreferredSize(new java.awt.Dimension(header.getWidth(), 35));

		// Center align all cells
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < columns.length; i++) {
			studentTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		JScrollPane scrollPane = new JScrollPane(studentTable);
		int tableW = screenWidth - 250 - 140;
		int tableH = screenHeight - (yTop + boxHeight + 160);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setBackground(Color.decode("#D4F1F4"));

		// Refresh button
		JButton refreshBtn = new JButton("⟳ Refresh Table");
		refreshBtn.setFont(new Font("Arial", Font.BOLD, 14));
		refreshBtn.setBounds(tableW - 150, 15, 170, 35);
		refreshBtn.setBackground(Color.decode("#189AB4"));
		refreshBtn.setForeground(Color.WHITE);
		refreshBtn.setBorder(null);
		refreshBtn.setFocusPainted(false);
		refreshBtn.addActionListener(ev -> loadTableData());
		contentBox.add(refreshBtn);

		JLabel tableTitle = new JLabel("Student Records");
		tableTitle.setFont(new Font("Arial", Font.BOLD, 18));
		tableTitle.setForeground(Color.decode("#05445E"));
		tableTitle.setBounds(20, 18, 250, 30);
		contentBox.add(tableTitle);

		scrollPane.setBounds(20, 60, tableW, tableH - 50);
		contentBox.add(scrollPane);
		centrepanel.add(contentBox);

		// Load data from database
		loadTableData();

		frame.setVisible(true);
	}

	// Panel Design
	JPanel createPanel() {
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(Color.decode("#75E6DA"));
				g.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
			}
		};
		panel.setLayout(null);
		panel.setBackground(Color.decode("#05445E"));
		return panel;
	}

	// Button Design with Icon
	JButton createButton(String text, Font font, String iconPath) {
		ImageIcon rawIcon = new ImageIcon(iconPath);
		Image scaled = rawIcon.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		JButton btn = new JButton(text, new ImageIcon(scaled));
		btn.setFont(font);
		btn.setBounds(20, 40, 160, 50);
		btn.setBackground(Color.decode("#75E6DA"));
		btn.setForeground(Color.decode("#05445E"));
		btn.setBorder(null);
		btn.setHorizontalTextPosition(SwingConstants.RIGHT);
		btn.setIconTextGap(8);
		return btn;
	}

	// Load student data from database into the table
	void loadTableData() {
		tableModel.setRowCount(0); // Clear existing rows
		try {
			Dbconnect db = new Dbconnect();
			Connection conn = db.getConnection();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM registeredstudent");
				while (rs.next()) {
					Object[] row = {
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("mobile_no"),
						rs.getString("email"),
						rs.getString("parentmob"),
						rs.getString("college"),
						rs.getString("edu"),
						rs.getString("slot")
					};
					tableModel.addRow(row);
				}
				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception ex) {
			System.out.println("Error loading data: " + ex);
		}
	}

	public static void main(String[] args) {
		new mainWindowcp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		Adperson ap = new Adperson();
		dltperson dp = new dltperson();
		SearchPerson sp = new SearchPerson();
		updateperson up = new updateperson();

		if (obj == addb) {
			ap.setVisible(true);
			dp.dispose();
			sp.dispose();
			up.dispose();
		} else if (obj == dltb) {
			dp.setVisible(true);
			ap.dispose();
			sp.dispose();
			up.dispose();
		} else if (obj == updateb) {
			up.setVisible(true);
			dp.dispose();
			ap.dispose();
			sp.dispose();
		} else if (obj == searchb) {
			sp.setVisible(true);
			dp.dispose();
			ap.dispose();
			up.dispose();
		}
	}
}