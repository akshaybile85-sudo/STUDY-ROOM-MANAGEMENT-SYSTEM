import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DisplayAllRecord {
	
	static String rows[][]=new String[100][8];
	static int row=0;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			Dbconnect db=new Dbconnect();
			Connection conn=db.getConnection();
			String selectQuery="select * from registeredstudent";
			PreparedStatement preparedStatement=conn.prepareStatement(selectQuery);
			ResultSet result=preparedStatement.executeQuery();
			while(result.next())
			{
				for(int i=0;i<8;i++)
				{
					rows[row][i]=result.getString(i+1);
					
				}
				row++;
				
			}
			ViewCustomer.populateArray(rows);
			//ViewOneUser.populateArray();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
