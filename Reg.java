
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	public class Reg{
		public boolean registerdetails(RegBean b){
			boolean status=false;
			String firstname=b.getFirstname();
			String lastname=b.getLastname();
			String username=b.getUsername();
			String password=b.getPassword();
			Connection con =null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			try{
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","irf","irf"); 
				Statement s=con.createStatement();
				ResultSet r=s.executeQuery("select * from emp where username='"+username+"'and password='"+password+"'");
				
				if(r.next()){
					status=false;
				}else{
					int i=s.executeUpdate("insert into emp(Firstname,Lastname,username,password)values('"+firstname+"','"+lastname+"','"+username+"','"+password+"')");
					if(i>0){
						status=true;
					}
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return status;
			}
				
			
		}




