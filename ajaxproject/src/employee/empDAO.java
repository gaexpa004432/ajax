package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class empDAO {
		
	
	Connection conn = null;
public Connection getConnect() {
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();

	}
	return conn;
}

public List<Employee> getEmpList(){
	conn = getConnect();
	String sql = "select employee_id, first_name ,email , salary from employees";
	
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet r = pstmt.executeQuery();
		List<Employee> list = new ArrayList<>();
		
		while(r.next()) {
			Employee emp = new Employee(
					r.getInt("employee_id"),r.getString("first_name"),r.getString("email"),r.getInt("salary"));
			list.add(emp);
			
		}
		return list;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public void insertEmp(Employee emp){
	conn = getConnect();
	String sql = "insert into employees(employee_id,last_name,email,hire_date,job_id) values(employees_seq.nextval,?,?,?,?)";
	
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,emp.getLastName());
		pstmt.setString(2,emp.getEmail());
		pstmt.setString(3,emp.getHireDate());
		pstmt.setString(4,emp.getJobId());
		int r = pstmt.executeUpdate();
		System.out.println(r);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
	public Map<String,String> getJobCode(){
		conn = getConnect();
		Map<String,String> map = new HashMap<>();
		String sql = "select job_id,job_title from jobs order by 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet r = pstmt.executeQuery();
			while(r.next()) {
				map.put(r.getString("job_id"),r.getString("job_title"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return map;
	}
	public void deleteEmp(String empId){
		conn = getConnect();
		String sql = "delete from employees where employee_id = "+empId;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int r = pstmt.executeUpdate();
			System.out.println(r);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	public void updateEmp(String empId,String salary){
		conn = getConnect();
		String sql = "update employees set salary ="+salary+" where employee_id ="+empId;
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int r = pstmt.executeUpdate();
			System.out.println(r);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	public List<Employee> getSelect(){
		conn = getConnect();
		String sql = "select employee_id, first_name,last_name ,email ,job_id ,hire_date, salary from employees";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet r = pstmt.executeQuery();
			List<Employee> list = new ArrayList<>();
			
			while(r.next()) {
				Employee emp = new Employee(
						r.getString("first_name"),r.getString("last_name"),r.getString("email"),r.getString("job_id"),r.getString("hire_date"),r.getInt("salary"));
				list.add(emp);
				
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
