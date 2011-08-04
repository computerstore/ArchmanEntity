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
@Table(name = "t_rinuovi")
public class Renewal implements Serializable {

	private static final long serialVersionUID = -2681560423923260983L;
	protected Integer renewal_id;
//	protected Member member;
	protected Timestamp renewal_date;
	protected String year;
	protected String paymenttype;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#getPaymenttype()
	 */
	public String getPaymenttype() {
		return paymenttype;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#setPaymenttype(java.lang.String)
	 */
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#getEntity_id()
	 */
//	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
//	@JoinColumn(name="entity_id")
//	public Member getMember() {
//		return member;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#setEntity_id(java.lang.Integer)
	 */
//	public void setMember(Member member) {
//		this.member = member;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#getRenewal_date()
	 */
	public Timestamp getRenewal_date() {
		return renewal_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#setRenewal_date(java.lang.Long)
	 */
	public void setRenewal_date(Timestamp renewal_date) {
		this.renewal_date = renewal_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#getYear()
	 */
	public String getYear() {
		return year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#setYear(java.lang.String)
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#getRenewal_id()
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getRenewal_id() {
		return renewal_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.member.Renewal#setRenewal_id(java.lang.Integer)
	 */
	public void setRenewal_id(Integer renewal_id) {
		this.renewal_id = renewal_id;
	}

}
