package com.vlm.samples;

public class Employee {
	public static final Employee DEFAULT_EMPLOYEE = new Employee("No Name", 0);

    private int id;
    private String name;

	public Employee(String name, int id) {
    	this.setId(id);
    	this.name = name;
	}
	//Bad practice!
	public Employee(int id, String name) {
    	this.setId(id);
    	this.name = name;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return name +" "+id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
