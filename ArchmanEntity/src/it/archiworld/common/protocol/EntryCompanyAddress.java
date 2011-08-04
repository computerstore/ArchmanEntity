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

import it.archiworld.common.Company;

import javax.persistence.Entity;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class EntryCompanyAddress extends EntryAddress {

	private static final long serialVersionUID = -830461471285726131L;
	protected String denomination;

	public EntryCompanyAddress(){	
	}
	
	public EntryCompanyAddress(Company company){
		super(company, company.getStreet(), company.getZip(), company.getCity(), company.getState(), company.getCountry());
		setDenomination(company.getDenomination());
	}
			
	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	@Override
	public String toString() {
		String text = new String();
		if (getDenomination() != null)
			text += getDenomination();
		text += " - " + getStreet() + ", " + getZip() + " " + getCity() + "("
		+ getCountry() + ")";
		return text;
	}
}
