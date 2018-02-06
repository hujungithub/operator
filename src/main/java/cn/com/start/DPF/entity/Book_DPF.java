package cn.com.start.DPF.entity;

import java.io.Serializable;

public class Book_DPF implements Serializable {

	private static final long serialVersionUID = 623211699192863247L;
	private int id;
	private String name;
	private double price;

	public Book_DPF(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "TestBool [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
