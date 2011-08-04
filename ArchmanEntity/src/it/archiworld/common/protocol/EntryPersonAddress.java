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

import it.archiworld.common.Member;
import it.archiworld.common.Person;

import javax.persistence.Entity;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class EntryPersonAddress extends EntryAddress {

	private static final long serialVersionUID = -2424916850152104820L;
	protected String title; 
	protected String firstname;
	protected String lastname;
	
	public EntryPersonAddress(){};
	
	public EntryPersonAddress(Person person){
		this.title=person.getTitle();
		this.firstname=person.getFirstname();
		this.lastname=person.getLastname();
		this.address=person;
		if(person instanceof Member){
			Member member = (Member)person;
			if (member.getStdaddress().equals("address")){//$NON-NLS-1$
				street=member.getStreet();
				zip=member.getZip();
				city=member.getCity();
				state=member.getState();
				country=member.getCountry();
			}
			if (member.getStdaddress().equals("address_de")){//$NON-NLS-1$
				street=member.getStreet_de();
				zip=member.getZip();
				city=member.getCity_de();
				state=member.getState_de();
				country=member.getCountry_de();
			}
			if (member.getStdaddress().equals("homeaddress")){//$NON-NLS-1$
				street=member.getHomestreet();
				zip=member.getHomezip();
				city=member.getHomecity();
				state=member.getHomestate();
				country=member.getHomecountry();
			}
			if (member.getStdaddress().equals("homeaddress_de")){//$NON-NLS-1$
				street=member.getHomestreet_de();
				zip=member.getHomezip();
				city=member.getHomecity_de();
				state=member.getHomestate_de();
				country=member.getHomecountry_de();
			}
		} else {
			this.street=person.getStreet();
			this.zip=person.getZip();
			this.city=person.getCity();
			this.state=person.getState();
			this.country=person.getCountry();
		}
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		String result = new String();
		if (getLastname() != null)
			result += getLastname();
		if (getFirstname() != null)
			result += ", " + getFirstname();
		result += " - " + super.toString();
		return result;
	}
}
