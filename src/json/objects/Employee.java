package json.objects;

public class Employee {

	Integer eId;
	String eName;
	Double eSal;

	public Employee() {
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public Double geteSal() {
		return eSal;
	}

	public void seteSal(Double eSal) {
		this.eSal = eSal;
	}
}