package entity;

import java.io.Serializable;

public class Expert implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4998935456575114043L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Expert [name=" + name + "]";
	}
}
