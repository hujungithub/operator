package cn.com.start.webBack.entity;


public class Permission{
    private int id;

    private String name;

    private String parentid;
    
    private boolean state=false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission bean = (Permission) o;

        if (id != bean.id) return false;
        if (!name.equals(bean.name)) return false;
        if (!parentid.equals(bean.parentid)) return false;
        return state==bean.state;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result;
        return result;
    }

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", parentid="
				+ parentid + ", state=" + state + "]";
	}
}


