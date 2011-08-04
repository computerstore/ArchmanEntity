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

import it.archiworld.aaa.User;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "t_entry")
public class Entry  implements Serializable{

	private static final long serialVersionUID = 7049765355030888605L;
	protected Long entry_id;
	protected Integer protocol;
	protected Integer year;
	protected Timestamp protocol_date;
	protected String subject;
	protected Timestamp registration_date;
	protected Timestamp last_change_date;
	protected Registry registry;
	protected User owner;
	protected Office office;
	protected String note;
	protected Set<Document> documents;
	protected Set<Entry> references;
// protected Set<Entry> followups;
	protected String state;
	protected String archive;
	protected Boolean emergency=false;
	
	public Entry() {
		super();
		documents = new HashSet<Document>();
		references = new HashSet<Entry>();
// followups = new HashSet<Entry>();
	}
	
	public Entry(Long entry_id, Integer year, Integer protocol, String subject, Date registration_date, Date protocol_date, Date last_change_date, Boolean emergency) {
		super();
		this.entry_id = entry_id;
		this.year = year;
		this.protocol = protocol;
		this.subject=subject;
		this.registration_date=new Timestamp(registration_date.getTime());
		this.protocol_date=new Timestamp(protocol_date.getTime());
		documents = new HashSet<Document>();
		references = new HashSet<Entry>();
		if(last_change_date!=null)
			this.last_change_date = new Timestamp(last_change_date.getTime());
		this.emergency=emergency;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#getState()
	 */
	@Basic(fetch=FetchType.EAGER,optional=true)
	public String getState() {
		return state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#setState(String)
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#getDocumenti()
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="entry_id")
//	@CollectionOfElements(fetch=FetchType.EAGER)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
       org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<Document> getDocuments() {
		return documents;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#setDocumenti(java.util.List)
	 */
	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#getImission_date()
	 */
	@Basic(fetch=FetchType.EAGER,optional=false)
	public Timestamp getProtocol_date() {
		return protocol_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#setImission_date(java.sql.Timestamp)
	 */
	public void setProtocol_date(Timestamp protocol_date) {
		this.protocol_date = protocol_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#getNote()
	 */
	@Basic(fetch=FetchType.EAGER,optional=true)
	public String getNote() {
		return note;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#setNote(java.lang.String)
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#getOwner_id()
	 */
	@OneToOne
	public User getOwner() {
		return owner;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#setOwner_id(java.lang.Integer)
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#getProtocol_id()
	 */
	public Integer getProtocol() {
		return protocol;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#setProtocol_id(java.lang.Integer)
	 */
	public void setProtocol(Integer protocol) {
		this.protocol = protocol;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#getRegistration_date()
	 */
	@Basic(fetch=FetchType.EAGER,optional=false)
	public Timestamp getRegistration_date() {
		return registration_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#setRegistration_date(java.sql.Timestamp)
	 */
	public void setRegistration_date(Timestamp registration_date) {
		this.registration_date = registration_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#getSubject()
	 */
	@Basic(fetch = FetchType.EAGER, optional = false)
	public String getSubject() {
		return subject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Entry#setSubject(java.lang.String)
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, targetEntity = Entry.class)
	public Set<Entry> getReferences() {
		return references;
	}

	public void setReferences(Set<Entry> references) {
		this.references = references;
	}

/*
 * @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER,
 * targetEntity=Entry.class) public Set<Entry> getFollowups() { return
 * followups; }
 * 
 * public void setFollowups(Set<Entry> followups) { this.followups = followups; }
 */
	@Override
	public String toString() {
		String output="";
		for(int i=getProtocol().toString().length();i<4;i++)
			output+=" ";
		output+="("+getProtocol()+"/"+getYear()+")";
		return output+" "+getSubject();
	}
	@Basic(fetch=FetchType.EAGER,optional=true)
	public String getArchive() {
		return archive;
	}

	public void setArchive(String archive) {
		this.archive = archive;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	public int compareTo(Object o) {
		if (o instanceof Entry) {
			if (this.getEntry_id()==((Entry)o).getEntry_id()) return 0;
			if (this.getYear() != null && ((Entry)o).getYear() != null) {
				if (this.getYear().intValue()<((Entry)o).getYear().intValue()) return -1;
				if (this.getYear().intValue()>((Entry)o).getYear().intValue()) return 1;
			}
			if (this.getProtocol() != null && ((Entry)o).getProtocol() !=null) {
				if (this.getProtocol().intValue()<((Entry)o).getProtocol().intValue()) return -1;
				if (this.getProtocol().intValue()>((Entry)o).getProtocol().intValue()) return 1;
			}
		}
		return 0;
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(Long entry_id) {
		this.entry_id = entry_id;
	}

	public Timestamp getLast_change_date() {
		return last_change_date;
	}

	public void setLast_change_date(Timestamp lastChangeDate) {
		last_change_date = lastChangeDate;
	}

	@OneToOne
	public Registry getRegistry() {
		return registry;
	}

	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	@OneToOne
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Boolean getEmergency() {
		return emergency;
	}

	public void setEmergency(Boolean emergency) {
		this.emergency = emergency;
	}

}
