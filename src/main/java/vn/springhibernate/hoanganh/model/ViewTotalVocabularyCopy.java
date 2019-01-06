package vn.springhibernate.hoanganh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viewtotalvocabularycopy")
public class ViewTotalVocabularyCopy {
	@Id  
    @Column(name = "id")
	private int id;

    @Column(name = "name")
	private String name;
    
    @Column(name = "subtotal")
	private String subtotal;
    
    @Column(name = "total")
	private String total;

	public ViewTotalVocabularyCopy() {
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

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
