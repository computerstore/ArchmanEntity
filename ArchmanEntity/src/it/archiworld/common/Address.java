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

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "t_entity")
@DiscriminatorColumn(name = "dtype")
@DiscriminatorValue("Address")
public class Address implements Serializable{

	private static final long serialVersionUID = 2143910736394284156L;
	protected Long entity_id;
	protected String street;
	protected String zip;
	protected String city;
	protected String state;
	protected String country;
	protected Integer parent;
	protected String type;
	protected Integer marker;
	protected String version;
	protected String email;
	protected String phone;
	protected String mobilephone;
	protected String fax;
	protected String website;
	protected String tax_code;
	protected String fiscal_code;
	protected String account_nr;
	protected String bank_nr;
	protected String iban;
	protected String bic;
	protected String note;
	protected String cod_amministration;
	protected String organizative_unit_type;
	protected String cod_aoo;
	
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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getEmail()
	 */
	public String getEmail() {
		return email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setEmail(java.lang.String)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getMarker()
	 */
	public Integer getMarker() {
		return marker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setMarker(java.lang.String)
	 */
	public void setMarker(Integer marker) {
		this.marker = marker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getParent()
	 */
	public Integer getParent() {
		return parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setParent(java.lang.Integer)
	 */
	public void setParent(Integer parent) {
		this.parent = parent;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getType()
	 */
// @Column(insertable=false, updatable=false)
	public String getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setType(java.lang.String)
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getVersion()
	 */
	public String getVersion() {
		return version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setVersion(java.lang.String)
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Company#getTax_code()
	 */
	public String getTax_code() {
		return tax_code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Company#setTax_code(java.lang.String)
	 */
	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}

	public String getFax() {
		return fax;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public String getPhone() {
		return phone;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAccount_nr() {
		return account_nr;
	}

	public void setAccount_nr(String account_nr) {
		this.account_nr = account_nr;
	}

	public String getBank_nr() {
		return bank_nr;
	}

	public void setBank_nr(String bank_nr) {
		this.bank_nr = bank_nr;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public String getFiscal_code() {
		return this.fiscal_code;
	}

	public void setFiscal_code(String fiscal_code) {
		this.fiscal_code = fiscal_code;
	}

	@Override
	public String toString() {
		return getStreet() + ", " + getZip() + " " + getCity() + "("
				+ getCountry() + ")";
	}

	@Override
    public boolean equals(Object other) {
		if (this == other) return true;
        if ( !(other instanceof Address) ) return false;

        return (getEntity_id()!=null ? !getEntity_id().equals(((Address) other).getEntity_id()) : ((Address) other) !=null);
    }
}
