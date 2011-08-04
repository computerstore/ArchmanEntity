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
@DiscriminatorValue("Company")
public class Company extends Address {

	private static final long serialVersionUID = -8124273306751089162L;
	protected String denomination;
	protected String contact_firstname;
	protected String contact_lastname;
	protected String contact_title;

	public Company() {
		super();
	}

	public Company(Long entity_id, String denomination) {
		this.entity_id = entity_id;
		this.denomination = denomination;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Company#getDenomination()
	 */
	@Basic(fetch = FetchType.EAGER, optional = false)
	public String getDenomination() {
		return denomination;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.Company#setDenomination(java.lang.String)
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getContact_firstname() {
		return contact_firstname;
	}

	public void setContact_firstname(String contact_firstname) {
		this.contact_firstname = contact_firstname;
	}

	public String getContact_lastname() {
		return contact_lastname;
	}

	public void setContact_lastname(String contact_lastname) {
		this.contact_lastname = contact_lastname;
	}

	public String getContact_title() {
		return contact_title;
	}

	public void setContact_title(String contact_title) {
		this.contact_title = contact_title;
	}

	@Override
	public String toString() {
		String text = new String();
		if (getDenomination() != null)
			text += getDenomination();
		return text;
	}
}
