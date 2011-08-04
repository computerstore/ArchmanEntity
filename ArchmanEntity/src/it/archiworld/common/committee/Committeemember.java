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

import it.archiworld.common.Member;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Committeemember implements Serializable {

	private static final long serialVersionUID = -2629034735131967348L;
	protected Long committeemember_id;
	protected Member member;
	protected Timestamp start;
	protected Timestamp stop;
	protected String role;
	protected String nomination_type;
	protected Committee committee;
	
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#getBegin()
	 */
	public Timestamp getStart() {
		return start;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#setBegin(java.sql.Timestamp)
	 */
	public void setStart(Timestamp start) {
		this.start = start;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#getEnd()
	 */
	public Timestamp getStop() {
		return stop;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#setEnd(java.sql.Timestamp)
	 */
	public void setStop(Timestamp stop) {
		this.stop = stop;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#getMember()
	 */
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="entity_id")
	@IndexColumn(name="entity_id")
	public Member getMember() {
		return member;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#setMember(it.archiworld.common.Member)
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="committee_id")
	@IndexColumn(name="committee_id")
	public Committee getCommittee() {
		return committee;
	}
	public void setCommittee(Committee committee) {
		this.committee = committee;
	}	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getCommitteemember_id() {
		return committeemember_id;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#setMember_id(java.lang.Integer)
	 */
	public void setCommitteemember_id(Long member_id) {
		this.committeemember_id = member_id;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#getNomination_type()
	 */
	public String getNomination_type() {
		return nomination_type;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#setNomination_type(java.lang.String)
	 */
	public void setNomination_type(String nomination_type) {
		this.nomination_type = nomination_type;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#getRole()
	 */
	public String getRole() {
		return role;
	}
	/* (non-Javadoc)
	 * @see it.archiworld.common.Committeemember#setRole(java.lang.String)
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return member.toString();
	}
		
}
