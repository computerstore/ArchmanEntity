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
package it.archiworld.common.protocol;

import it.archiworld.common.Address;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="t_entry_address")
public class EntryAddress implements Serializable{

	private static final long serialVersionUID = -3237788565572805651L;
	protected Address address;
	protected Long entity_id;
	protected String street;
	protected String zip;
	protected String city;
	protected String state;
	protected String country;

	public EntryAddress(){};
	
	public EntryAddress(Address address, String street, String zip, String city, String state, String country){
		setAddress(address);
		setStreet(street);
		setZip(zip);
		setCity(city);
		setState(state);
		setCountry(country);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getEntity_id()
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getEntity_id() {
		return entity_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setEntity_id(java.lang.Integer)
	 */
	public void setEntity_id(Long entity_id) {
		this.entity_id = entity_id;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getState()
	 */
	public String getState() {
		return state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setState(java.lang.String)
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getStreet()
	 */
	public String getStreet() {
		return street;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setStreet(java.lang.String)
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getZip()
	 */
	public String getZip() {
		return zip;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setZip(java.lang.String)
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getCity()
	 */
	public String getCity() {
		return city;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setCity(java.lang.String)
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getCountry()
	 */
	public String getCountry() {
		return country;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setCountry(java.lang.String)
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="address_id")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return getStreet() + ", " + getZip() + " " + getCity() + "("
				+ getCountry() + ")";
	}
	
}
