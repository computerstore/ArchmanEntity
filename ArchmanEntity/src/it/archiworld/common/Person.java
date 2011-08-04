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

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import org.hibernate.envers.Audited;

@Entity
@Audited
@DiscriminatorValue("Person")
public class Person extends Address {

	private static final long serialVersionUID = 5935805522681418252L;
	protected String firstname;
	protected String lastname;
	protected String title;

	public Person() {
		super();
	}

	public Person(Long entity_id, String firstname, String lastname) {
		this.entity_id = entity_id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getFirstname()
	 */
	@Basic(fetch = FetchType.EAGER, optional = false)
	public String getFirstname() {
		return firstname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setFirstname(java.lang.String)
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getLastname()
	 */
	@Basic(fetch = FetchType.EAGER, optional = false)
	public String getLastname() {
		return lastname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setLastname(java.lang.String)
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#getTitle()
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.address#setTitle(java.lang.String)
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		String result = new String();
		if (getLastname() != null)
			result += getLastname();
		if (getFirstname() != null)
			result += ", " + getFirstname();
		return result;
	}


}
