package EmpJoin.dto;

public class EmpjoinDto {
	private int empno;
	private String ename;
	private String dname;
	private String loc;
	
	public void EmpjoinDto() {
		
	}

	public EmpjoinDto(int empno, String ename, String dname, String loc) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.dname = dname;
		this.loc = loc;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
