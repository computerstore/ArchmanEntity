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
package it.archiworld.common.committee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name="t_committee")
public class Committee implements Serializable {

	private static final long serialVersionUID = -7389588182849234755L;
	protected Long committee_id;
	protected String name;
	protected String street;
	protected String zip;
	protected String city;
	protected String state;
	protected String country;
	protected String note;
	protected List<Committeemember> member;

	public Committee() {
		super();
		member = new ArrayList<Committeemember>();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy="committee")
//	@JoinColumn(name="committee_id")	
//	@IndexColumn(name="committee_id")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
          org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<Committeemember> getMember() {
		return member;
	}

	public void setMember(List<Committeemember> member) {
		this.member = member;
	}


	@Basic(fetch = FetchType.EAGER, optional = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCommittee_id() {
		return committee_id;
	}

	public void setCommittee_id(Long committee_id) {
		this.committee_id = committee_id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return getName();
	}
}
