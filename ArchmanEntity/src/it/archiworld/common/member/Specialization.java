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
@Table(name = "t_specializzazione")
public class Specialization implements Serializable {


	private static final long serialVersionUID = 1153688078544583501L;
	protected Integer specialization_id;
//	protected Member member;
	protected String specialization;
	protected Timestamp registration_date;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Specialization#getRegistration_date()
	 */
	public Timestamp getRegistration_date() {
		return registration_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Specialization#setRegistration_date(java.lang.Long)
	 */
	public void setRegistration_date(Timestamp registration_date) {
		this.registration_date = registration_date;
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see it.archiworld.common.member.Specialization#getEntity_id()
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
//	 * @see it.archiworld.common.member.Specialization#setEntity_id(java.lang.Integer)
//	 */
//	public void setMember(Member member) {
//		this.member = member;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Specialization#getSpecialization()
	 */
	public String getSpecialization() {
		return specialization;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Specialization#setSpecialization(java.lang.String)
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Specialization#getSpecialization_id()
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getSpecialization_id() {
		return specialization_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Specialization#setSpecialization_id(java.lang.Integer)
	 */
	public void setSpecialization_id(Integer specialization_id) {
		this.specialization_id = specialization_id;
	}
}
