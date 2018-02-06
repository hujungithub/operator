package cn.com.start.DPF.entity.car;

public class CarStateType {
	private Integer id;
	private String desp;
	
	
	@Override
	public String toString() {
		return "CarStateType [id=" + id + ", desp=" + desp + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	
	
}
