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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Outentry extends Entry {

	private static final long serialVersionUID = -6171814320246509345L;
	protected List<EntryAddress> destinations;
	protected String send_type;
	protected String responsible;

	public Outentry() {
		super();
		destinations = new ArrayList<EntryAddress>();
	}

	public Outentry(Long entry_id, Integer year, Integer protocol_id, String subject, Date registration_date, Date protocol_date, Date last_change_date, Boolean emergency) {
		super(entry_id, year, protocol_id, subject, registration_date, protocol_date, last_change_date, emergency);
		this.destinations = new ArrayList<EntryAddress>();
	}

	public Outentry(Long entry_id, Integer year, Integer protocol_id, String subject, Date registration_date, Date protocol_date, Date last_change_date, Boolean emergency, EntryAddress destination) {
		super(entry_id, year, protocol_id, subject, registration_date, protocol_date, last_change_date, emergency);
		this.destinations=new ArrayList<EntryAddress>();
		this.destinations.add(destination);
	}

	public Outentry(Long entry_id, Integer year, Integer protocol_id, String subject, Date registration_date, Date protocol_date, Date last_change_date, Boolean emergency, List<EntryAddress> destinations) {
		super(entry_id, year, protocol_id, subject, registration_date, protocol_date, last_change_date, emergency);
		this.destinations = destinations;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Outentry#getDestinations()
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="entry_id")
	@Basic(fetch = FetchType.EAGER, optional = false)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	public List<EntryAddress> getDestinations() {
		return destinations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Outentry#setDestinations(java.util.List)
	 */
	public void setDestinations(List<EntryAddress> destinations) {
		this.destinations = destinations;
	}

	@Basic(fetch=FetchType.EAGER,optional=false)
	public String getSend_type() {
		return send_type;
	}

	public void setSend_type(String send_type) {
		this.send_type = send_type;
	}
	
	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	
	@Override
	public String toString() {
		String output="";
		if(getProtocol()!=null)
			for(int i=getProtocol().toString().length();i<4;i++)
				output+=" ";
		output+="("+getProtocol()+"/"+getYear()+")";
		if(null!=getDestinations()&&!(getDestinations().isEmpty()))
			output+=" "+getDestinations().get(0);
		return output+" "+getSubject();
	}

	
}
