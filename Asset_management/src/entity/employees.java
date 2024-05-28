package entity;

public class employees {
	
	private int employee_id;
	private String name;
	private String department;
	private String email;
	private String password;
	
	public employees(){} // default constructor
	
	public employees(int employee_id, String name , String department,String email,String password) {
		
		this.employee_id=employee_id;
		this.name=name;
		this.department=department;
		this.email=email;
		this.password=password;
	}
	
	//getter setter method
	
	public int getemployee_id(){
		return employee_id;
	}
	
	public void setemployee_id(int employee_id) {
		this.employee_id=employee_id;
	}
	
	
	public String getname(){
		return name;
	}
	
	public void setname(String name) {
		this.name=name;
	}
	
	public String getdepartment(){
		return department;
	}
	
	public void department(String department) {
		this.department=department;
	}
	
	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
	
	
	
	

}
