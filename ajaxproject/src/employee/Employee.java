package employee;

public class Employee {
	int employeeId;
	String firstName;
	String email;
	int Salary;
	public Employee(String firstName, String lastName, String email, String jobId, String hireDate,
			int salary) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.jobId = jobId;
		this.hireDate = hireDate;
		Salary = salary;
	}
	String hireDate,lastName,jobId;
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public Employee(String email, String hireDate, String lastName, String jobId) {
		super();
		this.email = email;
		this.hireDate = hireDate;
		this.lastName = lastName;
		this.jobId = jobId;
	}
	public Employee(int employeeId, String firstName, String email, int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.email = email;
		Salary = salary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	
}
