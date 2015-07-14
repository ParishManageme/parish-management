package com.coop.parish.data.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@DynamicUpdate(true)
@Table(name="church_info")
public class Church 
{
	@Id
	@GeneratedValue
	@Column(name="church_id")
	private int id;
	
	@Column(name="church_name", nullable=false)
	private String name;
	
	@Column(name="church_door_no", nullable=false)
	private String doorNo ;
	
	@Column(name="church_street", nullable=false)
	private String street;
	
	@Column(name="church_village", nullable=false)
	private String village;
	
	@Column(name="church_taluk")
	private String taluk;
	
	@Column(name="church_district", nullable=false)
	private String district;
	
	@Column(name="church_state", nullable=false)
	private String state;
	
	@Column(name="church_country", nullable=false)
	private String country;
	
	@Column(name="church_pincode", nullable=false)
	private Integer pincode;
	
	@Column(name="church_telephone_no")
	private Long telephoneNo;
	
	@Column(name="church_mobile_no", nullable=false)
	private Long mobileNo;
	
	@Column(name="church_email_id", nullable=false)
	private String emailId;
	
	@Column(name="church_diocese", nullable=false)
	private String diocese;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive;

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false, mappedBy="church",targetEntity=ChurchAdditionalInfo.class)
	private ChurchAdditionalInfo additionalInfo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="church")
	private List<Priest> priests;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="church")
	private List<Events> events;
	
	@Embedded
	private Audit audit;
	
	public Church(){
		
	}
	
	public Church(Integer churchId) {
		this.id = churchId;
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

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Long getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(Long telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDiocese() {
		return diocese;
	}

	public void setDiocese(String diocese) {
		this.diocese = diocese;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public ChurchAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(ChurchAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
		additionalInfo.setChurch(this);
	}

	public List<Priest> getPriests() {
		return priests;
	}

	public void setPriests(List<Priest> priests) {
		this.priests = priests;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
}
