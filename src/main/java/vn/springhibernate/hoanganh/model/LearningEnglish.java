package vn.springhibernate.hoanganh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "learningenglish")
public class LearningEnglish {
	@Id  
    @Column(name = "id")
	private int id;

    @Column(name = "name")
	private String name;
    
    @Column(name = "vietnamese")
	private String vietnamese;
    
    @Column(name = "chaid")
	private String chaid;

    @Column(name = "vietnamesecopy")
	private String vietnamesecopy;
    
    @Column(name = "state")
	private int state;
    
	public LearningEnglish() {
		super();
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

	public String getVietnamese() {
		return vietnamese;
	}

	public void setVietnamese(String vietnamese) {
		this.vietnamese = vietnamese;
	}

	public String getChaid() {
		return chaid;
	}

	public void setChaid(String chaid) {
		this.chaid = chaid;
	}

	public String getVietnamesecopy() {
		return vietnamesecopy;
	}

	public void setVietnamesecopy(String vietnamesecopy) {
		this.vietnamesecopy = vietnamesecopy;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
    
}
