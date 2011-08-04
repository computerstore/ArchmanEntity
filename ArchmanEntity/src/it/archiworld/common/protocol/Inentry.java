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

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Inentry extends Entry {

	private static final long serialVersionUID = 4961318962500259005L;
	protected Timestamp recived_date;
	protected EntryAddress sender;
	protected String receive_type;
	protected String referenceprotocol_id;
	protected String referenceprotocol_date; 

	public Inentry(){
		super();
	}

	public Inentry(Long entry_id, Integer year, Integer protocol_id, String subject, Date registration_date, Date protocol_date, Date last_change_date, Boolean emergency) {
		super(entry_id, year, protocol_id, subject,registration_date, protocol_date, last_change_date, emergency);
	}
							
	public Inentry(Long entry_id, Integer year, Integer protocol_id, String subject, Date registration_date, Date protocol_date, Date last_change_date, Boolean emergency, EntryAddress sender) {
		super(entry_id, year, protocol_id, subject, registration_date, protocol_date, last_change_date, emergency);
		this.sender = sender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Inentry#getRecived_date()
	 */
	@Basic(fetch = FetchType.EAGER, optional = false)
	public Timestamp getRecived_date() {
		return recived_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Inentry#setRecived_date(java.sql.Timestamp)
	 */
	public void setRecived_date(Timestamp recived_date) {
		this.recived_date = recived_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Inentry#getSender()
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sender_id")
	@Basic(fetch = FetchType.EAGER, optional = false)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	public EntryAddress getSender() {
		return sender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Inentry#setSender(it.archiworld.common.Address)
	 */
	public void setSender(EntryAddress sender) {
		this.sender = sender;
	}

	@Basic(fetch=FetchType.EAGER,optional=true)
	public String getReferenceprotocol_id() {
		return referenceprotocol_id;
	}

	public void setReferenceprotocol_id(String referenceprotocol_id) {
		this.referenceprotocol_id = referenceprotocol_id;
	}

	@Basic(fetch=FetchType.EAGER,optional=true)
	public String getReferenceprotocol_date() {
		return referenceprotocol_date;
	}

	public void setReferenceprotocol_date(String referenceprotocol_date) {
		this.referenceprotocol_date = referenceprotocol_date;
	}

	@Override
	public String toString() {
		String output="";
		if(getProtocol()!=null)
			for(int i=getProtocol().toString().length();i<4;i++)
				output+=" ";
		output+="("+getProtocol()+"/"+getYear()+")";
		if(getSender()!=null)
			output+=" "+getSender();
		return output+" "+getSubject();
	}
}
