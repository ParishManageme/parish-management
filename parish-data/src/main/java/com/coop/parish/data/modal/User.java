package com.coop.parish.data.modal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;

	@Column(name="user_identifier", nullable=false)
	private String identifier;
	
	@Column(name="user_password", nullable=false)
	private String password;
	
	@Column(name="user_type", nullable=false)
	private Character type;
	
	@Column(name="priest_id", insertable=false, updatable=false)
	private Integer priestId;
	
	@OneToOne(fetch=FetchType.LAZY, targetEntity=Priest.class)
	@JoinColumn(name="priest_id")
	private Priest priest;
	
	@Column(name="church_is_set", nullable=false)
	private boolean churchIsSet;
		
	@Column(name="is_active", nullable=false)
	private boolean isActive;
	
	@Embedded
	private Audit audit;
	
	public User(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Priest getPriest() {
		return priest;
	}

	public void setPriest(Priest priest) {
		this.priest = priest;
	}

	public boolean isChurchIsSet() {
		return churchIsSet;
	}

	public void setChurchIsSet(boolean churchIsSet) {
		this.churchIsSet = churchIsSet;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	public Integer getPriestId() {
		return priestId;
	}

	public void setPriestId(Integer priestId) {
		this.priestId = priestId;
	}
}
