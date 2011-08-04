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
package it.archiworld.common.servicemember;

import it.archiworld.common.ServiceMember;

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
@Table(name = "service")
public class Service implements Serializable{
	
	private static final long serialVersionUID = -290620085999872954L;
//	protected ServiceMember servicemember;
	protected Integer service_id;
	protected Integer service_nr;
	protected String servicetype;
	protected Timestamp start;
	protected Timestamp stop;
	protected String servicelocation;
	protected String meeting;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getService_id() {
		return service_id;
	}
	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}
	public Integer getService_nr() {
		return service_nr;
	}
	public void setService_nr(Integer service_nr) {
		this.service_nr = service_nr;
	}
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getServicelocation() {
		return servicelocation;
	}
	public void setServicelocation(String servicelocation) {
		this.servicelocation = servicelocation;
	}
	public String getMeeting() {
		return meeting;
	}
	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}
//	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
//	@JoinColumn(name="entity_id")
//	public ServiceMember getServiceMember() {
//		return servicemember;
//	}
//	public void setServiceMember(ServiceMember servicemember) {
//		this.servicemember = servicemember;
//	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getStop() {
		return stop;
	}
	public void setStop(Timestamp stop) {
		this.stop = stop;
	}
}
