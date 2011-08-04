/*******************************************************************************
 * Copyright (C) 2008  CS-Computer.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     CS-Computer - initial API and implementation
 ******************************************************************************/
package it.archiworld.common;

import it.archiworld.common.committee.Committeemember;
import it.archiworld.common.member.Formation;
import it.archiworld.common.member.Renewal;
import it.archiworld.common.member.Specialization;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.envers.Audited;

@Entity
@Audited
@DiscriminatorValue("Member")
//@SecondaryTables({
//	@SecondaryTable(name = "member_address", pkJoinColumns = {@PrimaryKeyJoinColumn(name = "entity_id")}),
//})
public class Member extends Person {

	private static final long serialVersionUID = 1524574121229733080L;
	protected String gender;
	protected String homestreet;
	protected String homezip;
	protected String homecity;
	protected String homestate;
	protected String homecountry;
	protected String homestreet_de;
	protected String homecity_de;
	protected String homestate_de;
	protected String homecountry_de;
	protected String homephone;
	protected String homefax;
	protected String nationality;
	protected String profession;
	protected String street_de;
	protected String city_de;
	protected String state_de;
	protected String country_de;
	protected String stdaddress;
	protected String sector;
	protected Timestamp sector_date;
	protected String sector_habilitation;
	protected String sector_exemption;
	protected Timestamp registration_date;
	protected String registration_exemption;
	protected Timestamp graduation_date;
	protected String graduation_institute;
	protected Timestamp graduation_approval_date;
	protected String habilitation;
	protected String state_exam_year;
	protected Integer registration_number;
	protected Timestamp deregister_date;
	protected String deregister_reason;
	protected String deregister_exemption;
	protected Timestamp last_change_date;
	protected String birthplace_de;
	protected String birthplace;
	protected Timestamp birthdate;
	protected String register_address;
	protected Boolean newsletter;
	protected Boolean culturenewsletter;
	protected Boolean directory_homephone;
	protected Boolean directory_homefax;
	protected Boolean directory_phone;
	protected Boolean directory_fax;
	protected Boolean directory_mobile;
	protected Boolean directory_email;
	protected Boolean directory_website;
	protected Boolean directory_officeaddress;
	protected Set<Formation> formations;
	protected Set<Specialization> specializations;
	protected Set<Renewal> renewal;
	protected Set<Committeemember> committeemembers; 
	
	public Member() {
		super();
		this.formations = new HashSet<Formation>();
		this.specializations = new HashSet<Specialization>();
		this.renewal = new HashSet<Renewal>();
	}

	public Member(Long entity_id, String firstname, String lastname, String gender, Integer registration_number) {
		super();
		this.entity_id = entity_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.registration_number = registration_number;
		this.formations = new HashSet<Formation>();
		this.specializations = new HashSet<Specialization>();
		this.renewal = new HashSet<Renewal>();
	}

	public Member(Address address) {
		super();
		this.formations = new HashSet<Formation>();
		this.specializations = new HashSet<Specialization>();
		this.renewal = new HashSet<Renewal>();

		account_nr = address.getAccount_nr();
		bank_nr = address.getBank_nr();
		bic = address.getBic();
		homecity = address.getCity();
		homecountry = address.getCountry();
		email = address.getEmail();
		entity_id = address.getEntity_id();
		fax = address.getFax();
		iban = address.getIban();
		marker = address.getMarker();
		mobilephone = address.getMobilephone();
		note = address.getNote();
		parent = address.getParent();
		phone = address.getPhone();
		homestate = address.getState();
		homestreet = address.getStreet();
		tax_code = address.getTax_code();
		type = address.getType();
		version = address.getVersion();
		website = address.getWebsite();
		homezip = address.getZip();

		if (address instanceof Person) {
			Person person = (Person) address;
			firstname = person.getFirstname();
			lastname = person.getLastname();
			title = person.getTitle();
			fiscal_code = person.getFiscal_code();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getHomecity()
	 */
// @Column(name = "indirizzopostalecomunecasa", table = "member_address")
	public String getHomecity() {
		return homecity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setHomecity(java.lang.String)
	 */
	public void setHomecity(String homecity) {
		this.homecity = homecity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getHomecityted()
	 */
// @Column(name = "indirizzopostalecomunecasated", table = "member_address")
	public String getHomecity_de() {
		return homecity_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setHomecityted(java.lang.String)
	 */
	public void setHomecity_de(String homecity_de) {
		this.homecity_de = homecity_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getHomecountry()
	 */
// @Column(name = "indirizzopostalestatocasa", table = "member_address")
	public String getHomecountry() {
		return homecountry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setHomecountry(java.lang.String)
	 */
	public void setHomecountry(String homecountry) {
		this.homecountry = homecountry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getHomecountryted()
	 */
// @Column(name = "indirizzopostalestatocasated", table = "member_address")
	public String getHomecountry_de() {
		return homecountry_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setHomecountryted(java.lang.String)
	 */
	public void setHomecountry_de(String homecountry_de) {
		this.homecountry_de = homecountry_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getHomestate()
	 */
// @Column(name = "indirizzopostaleprovinciacasa", table = "member_address")
	public String getHomestate() {
		return homestate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setHomestate(java.lang.String)
	 */
	public void setHomestate(String homestate) {
		this.homestate = homestate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getHomestateted()
	 */
// @Column(name = "indirizzopostaleprovinciacasated", table = "member_address")
	public String getHomestate_de() {
		return homestate_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setHomestateted(java.lang.String)
	 */
	public void setHomestate_de(String homestate_de) {
		this.homestate_de = homestate_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getHomestreet()
	 */
// @Column(name = "indirizzopostaletoponimocasa", table = "member_address")
	public String getHomestreet() {
		return homestreet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setHomestreet(java.lang.String)
	 */
	public void setHomestreet(String homestreet) {
		this.homestreet = homestreet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getHomestreetted()
	 */
// @Column(name = "indirizzopostaletoponimocasated", table = "member_address")
	public String getHomestreet_de() {
		return homestreet_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setHomestreetted(java.lang.String)
	 */
	public void setHomestreet_de(String homestreet_de) {
		this.homestreet_de = homestreet_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getHomezip()
	 */
// @Column(name = "indirizzopostalecapcasa", table = "member_address")
	public String getHomezip() {
		return homezip;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setHomezip(java.lang.String)
	 */
	public void setHomezip(String homezip) {
		this.homezip = homezip;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getCityted()
	 */
// @Column(name = "indirizzopostalecomuneted", table = "member_address")
	public String getCity_de() {
		return city_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setCityted(java.lang.String)
	 */
	public void setCity_de(String city_de) {
		this.city_de = city_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getCountryted()
	 */
// @Column(name = "indirizzopostalestatoted", table = "member_address")
	public String getCountry_de() {
		return country_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setCountryted(java.lang.String)
	 */
	public void setCountry_de(String country_de) {
		this.country_de = country_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getStateted()
	 */
// @Column(name = "indirizzopostaleprovinciated", table = "member_address")
	public String getState_de() {
		return state_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setStateted(java.lang.String)
	 */
	public void setState_de(String state_de) {
		this.state_de = state_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getStdaddress()
	 */
// @Column(name = "indirizzopostalestandard", table = "member_address")
	public String getStdaddress() {
		return stdaddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setStdaddress(java.lang.String)
	 */
	public void setStdaddress(String stdaddress) {
		this.stdaddress = stdaddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getStreetted()
	 */
// @Column(name = "indirizzopostaletoponimoted", table = "member_address")
	public String getStreet_de() {
		return street_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setStreetted(java.lang.String)
	 */
	public void setStreet_de(String street_de) {
		this.street_de = street_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getBirthdate()
	 */
	public Timestamp getBirthdate() {
		return birthdate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setBirthdate(java.lang.Long)
	 */
	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getBirthplace_de()
	 */
	public String getBirthplace_de() {
		return birthplace_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setBirthplace_de(java.lang.String)
	 */
	public void setBirthplace_de(String birthplace_de) {
		this.birthplace_de = birthplace_de;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getBirthplace_it()
	 */
	public String getBirthplace() {
		return birthplace;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setBirthplace_it(java.lang.String)
	 */
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getDeregister_date()
	 */
	public Timestamp getDeregister_date() {
		return deregister_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setDeregister_date(java.lang.Long)
	 */
	public void setDeregister_date(Timestamp deregister_date) {
		this.deregister_date = deregister_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getDeregister_exemption()
	 */
	public String getDeregister_exemption() {
		return deregister_exemption;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setDeregister_exemption(java.lang.String)
	 */
	public void setDeregister_exemption(String deregister_exemption) {
		this.deregister_exemption = deregister_exemption;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getDeregister_reason()
	 */
	public String getDeregister_reason() {
		return deregister_reason;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setDeregister_reason(java.lang.String)
	 */
	public void setDeregister_reason(String deregister_reason) {
		this.deregister_reason = deregister_reason;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getGraduation_approval_date()
	 */
	public Timestamp getGraduation_approval_date() {
		return graduation_approval_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setGraduation_approval_date(java.lang.Long)
	 */
	public void setGraduation_approval_date(Timestamp graduation_approval_date) {
		this.graduation_approval_date = graduation_approval_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getGraduation_date()
	 */
	public Timestamp getGraduation_date() {
		return graduation_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setGraduation_date(java.lang.Long)
	 */
	public void setGraduation_date(Timestamp graduation_date) {
		this.graduation_date = graduation_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getGraduation_institute()
	 */
	public String getGraduation_institute() {
		return graduation_institute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setGraduation_institute(java.lang.String)
	 */
	public void setGraduation_institute(String graduation_institute) {
		this.graduation_institute = graduation_institute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getHabilitation()
	 */
	public String getHabilitation() {
		return habilitation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setHabilitation(java.lang.String)
	 */
	public void setHabilitation(String habilitation) {
		this.habilitation = habilitation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getLast_change_date()
	 */
	public Timestamp getLast_change_date() {
		return last_change_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setLast_change_date(java.lang.Long)
	 */
	public void setLast_change_date(Timestamp last_change_date) {
		this.last_change_date = last_change_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getNewsletter()
	 */
	public Boolean getNewsletter() {
		return newsletter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setNewsletter(java.lang.Boolean)
	 */
	public void setNewsletter(Boolean newsletter) {
		this.newsletter = newsletter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getProfession()
	 */
	public String getProfession() {
		return profession;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setProfession(java.lang.String)
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getRegister_address()
	 */
	public String getRegister_address() {
		return register_address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setRegister_address(java.lang.String)
	 */
	public void setRegister_address(String register_address) {
		this.register_address = register_address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getRegistration_date()
	 */
	public Timestamp getRegistration_date() {
		return registration_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setRegistration_date(java.lang.Long)
	 */
	public void setRegistration_date(Timestamp registration_date) {
		this.registration_date = registration_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getRegistration_exemption()
	 */
	public String getRegistration_exemption() {
		return registration_exemption;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setRegistration_exemption(java.lang.String)
	 */
	public void setRegistration_exemption(String registration_exemption) {
		this.registration_exemption = registration_exemption;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getRegistration_number()
	 */
	public Integer getRegistration_number() {
		return registration_number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setRegistration_number(java.lang.Integer)
	 */
	public void setRegistration_number(Integer registration_number) {
		this.registration_number = registration_number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getRenewal()
	 */
	@Cascade(value=org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="member_id")
	public Set<Renewal> getRenewal() {
		return renewal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setRenewal(java.util.List)
	 */
	public void setRenewal(Set<Renewal> renewal) {
		this.renewal = renewal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getSpecializations()
	 */
	@Cascade(value=org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="member_id")
	public Set<Specialization> getSpecializations() {
		return specializations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setSpecializations(java.util.List)
	 */
	public void setSpecializations(Set<Specialization> specializations) {
		this.specializations = specializations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#getState_exam_year()
	 */
	public String getState_exam_year() {
		return state_exam_year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Member#setState_exam_year(java.lang.String)
	 */
	public void setState_exam_year(String state_exam_year) {
		this.state_exam_year = state_exam_year;
	}

	@Cascade(value=org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="member_id")
	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public String getHomefax() {
		return homefax;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getNationality() {
		return nationality;
	}

	public void setHomefax(String homefax) {
		this.homefax = homefax;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector=sector;
	}

	public Timestamp getSector_date() {
		return sector_date;
	}

	public void setSector_date(Timestamp sector_date) {
		this.sector_date=sector_date;
		
	}

	public String getSector_habilitation() {
		return sector_habilitation;
	}

	public void setSector_habilitation(String sector_habilitation) {
		this.sector_habilitation = sector_habilitation;
	}

	public String getSector_exemption() {
		return sector_exemption;
	}

	public void setSector_exemption(String sector_exemption) {
		this.sector_exemption = sector_exemption;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getCulturenewsletter() {
		return culturenewsletter;
	}

	public void setCulturenewsletter(Boolean culturenewsletter) {
		this.culturenewsletter = culturenewsletter;
	}

	public Boolean getDirectory_homephone() {
		return directory_homephone;
	}

	public void setDirectory_homephone(Boolean directory_homephone) {
		this.directory_homephone = directory_homephone;
	}

	public Boolean getDirectory_homefax() {
		return directory_homefax;
	}

	public void setDirectory_homefax(Boolean directory_homefax) {
		this.directory_homefax = directory_homefax;
	}

	public Boolean getDirectory_phone() {
		return directory_phone;
	}

	public void setDirectory_phone(Boolean directory_phone) {
		this.directory_phone = directory_phone;
	}

	public Boolean getDirectory_fax() {
		return directory_fax;
	}

	public void setDirectory_fax(Boolean directory_fax) {
		this.directory_fax = directory_fax;
	}

	public Boolean getDirectory_mobile() {
		return directory_mobile;
	}

	public void setDirectory_mobile(Boolean directory_mobile) {
		this.directory_mobile = directory_mobile;
	}

	public Boolean getDirectory_email() {
		return directory_email;
	}

	public void setDirectory_email(Boolean directory_email) {
		this.directory_email = directory_email;
	}

	public Boolean getDirectory_website() {
		return directory_website;
	}

	public void setDirectory_website(Boolean directory_website) {
		this.directory_website = directory_website;
	}

	public Boolean getDirectory_officeaddress() {
		return directory_officeaddress;
	}

	public void setDirectory_officeaddress(Boolean directory_officeaddress) {
		this.directory_officeaddress = directory_officeaddress;
	}

	@OneToMany(mappedBy="member", fetch=FetchType.EAGER)
//	@JoinColumn(name="entity_id")
	public Set<Committeemember> getCommitteemembers() {
		return committeemembers;
	}

	public void setCommitteemembers(Set<Committeemember> committeemembers) {
		this.committeemembers = committeemembers;
	}

	@Override
	public String toString(){
		String result = new String();
		if (getLastname() != null)
			result += getLastname();
		if (getFirstname() != null)
			result += ", " + getFirstname();
		if (getRegistration_number() !=null)
			result += " (" + getRegistration_number() + ")";
		return result;
	}
}
