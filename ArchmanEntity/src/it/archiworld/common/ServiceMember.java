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

import it.archiworld.common.servicemember.Service;

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
@DiscriminatorValue("ServiceMember")
public class ServiceMember extends Person {
	
	private static final long serialVersionUID = 4616438993684087307L;
	protected String originstate;
	protected String birthplace;
	protected Timestamp birthdate;
	protected String chamber;
	protected String nationality;
	protected String title_approval_exemption;
	protected String exemption;
	protected Integer servicemember_number;
	protected Set<Service> services;
	
	
	public ServiceMember() {
	}

	public ServiceMember(Long entity_id, String firstname, String lastname, Integer servicemember_number) {
		super(entity_id, firstname, lastname);
		this.servicemember_number=servicemember_number;
	}

	public ServiceMember(Address address) {
		super();
		this.services = new HashSet<Service>();

		account_nr = address.getAccount_nr();
		bank_nr = address.getBank_nr();
		bic = address.getBic();
		city = address.getCity();
		country = address.getCountry();
		email = address.getEmail();
		entity_id = address.getEntity_id();
		fax = address.getFax();
		iban = address.getIban();
		marker = address.getMarker();
		mobilephone = address.getMobilephone();
		note = address.getNote();
		parent = address.getParent();
		phone = address.getPhone();
		state = address.getState();
		street = address.getStreet();
		tax_code = address.getTax_code();
		type = address.getType();
		version = address.getVersion();
		website = address.getWebsite();
		zip = address.getZip();

		if (address instanceof Person) {
			Person person = (Person) address;
			firstname = person.getFirstname();
			lastname = person.getLastname();
			title = person.getTitle();
			fiscal_code = person.getFiscal_code();
		}

	}
	
	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#getOriginstate()
	 */
	public String getOriginstate() {
		return originstate;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#setOriginstate(java.lang.String)
	 */
	public void setOriginstate(String originstate) {
		this.originstate = originstate;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#getBirthplace()
	 */
	public String getBirthplace() {
		return birthplace;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#setBirthplace(java.lang.String)
	 */
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#getBirthdate()
	 */
	public Timestamp getBirthdate() {
		return birthdate;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#setBirthdate(java.sql.Timestamp)
	 */
	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#getChamber()
	 */
	public String getChamber() {
		return chamber;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#setChamber(java.lang.String)
	 */
	public void setChamber(String chamber) {
		this.chamber = chamber;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#getNationality()
	 */
	public String getNationality() {
		return nationality;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#setNationality(java.lang.String)
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#getTitle_approval_exemption()
	 */
	public String getTitle_approval_exemption() {
		return title_approval_exemption;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#setTitle_approval_exemption(java.lang.String)
	 */
	public void setTitle_approval_exemption(String title_approval_exemption) {
		this.title_approval_exemption = title_approval_exemption;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#getServices()
	 */
	public String getExemption() {
		return exemption;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#getServices()
	 */
	public void setExemption(String exemption) {
		this.exemption = exemption;
	}
	
	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#getServices()
	 */
	@Cascade(value=org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="servicemember_id")
	public Set<Service> getServices() {
		return services;
	}

	/* (non-Javadoc)
	 * @see it.archiworld.common.IServc#setServices(java.util.List)
	 */
	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public Integer getServicemember_number() {
		return servicemember_number;
	}

	public void setServicemember_number(Integer servicemember_number) {
		this.servicemember_number = servicemember_number;
	}

	@Override
	public String toString(){
		String result = new String();
		if (getLastname() != null)
			result += getLastname();
		if (getFirstname() != null)
			result += ", " + getFirstname();
		if (getServicemember_number() !=null)
			result += " (" + getServicemember_number() + ")";
		return result;
	}

}
