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
package it.archiworld.common.member;

import it.archiworld.common.Member;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "t_formazione")
public class Formation implements Serializable {


	private static final long serialVersionUID = -8925561527370768827L;
	protected Integer formation_id;
//	protected Member member;
	protected String formation_type;
	protected Timestamp formation_date;

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see it.archiworld.common.member.Formation#getEntity_id()
//	 */
//	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
//	@JoinColumn(name="entity_id")
//	public Member getMember() {
//		return member;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see it.archiworld.common.member.Formation#setEntity_id(java.lang.Integer)
//	 */
//	public void setMember(Member member) {
//		this.member = member;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Formation#getFormation_date()
	 */
	public Timestamp getFormation_date() {
		return formation_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Formation#setFormation_date(java.lang.Integer)
	 */
	public void setFormation_date(Timestamp formation_date) {
		this.formation_date = formation_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Formation#getFormation_id()
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getFormation_id() {
		return formation_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Formation#setFormation_id(java.lang.Integer)
	 */
	public void setFormation_id(Integer formation_id) {
		this.formation_id = formation_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Formation#getFormation_type()
	 */
	public String getFormation_type() {
		return formation_type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Formation#setFormation_type(java.lang.Integer)
	 */
	public void setFormation_type(String formation_type) {
		this.formation_type = formation_type;
	}
}
