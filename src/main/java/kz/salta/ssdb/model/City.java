package kz.salta.ssdb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="s_city")
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7102459266182398886L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="city_id_seq")
	@SequenceGenerator(name="city_id_seq", sequenceName="city_id_seq", allocationSize=1)
    private Long id;
	
	@Column(name = "name")
    private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
