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
package it.archiworld.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "t_preferences")
public class EJBPreferenceObject implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String name;
	protected String svalue;
	protected Float fvalue;
	protected Double dvalue;
	protected Integer ivalue;
	protected Long lvalue;
	protected Boolean bvalue;
	protected String lsvalue;

	public EJBPreferenceObject(){
	}

	public EJBPreferenceObject(String name, List<String> lsvalue){
		this.name=name;
		setLsvalue(lsvalue);
	}
	
	public EJBPreferenceObject(String name, String svalue){
		this.name=name;
		this.svalue=svalue;
	}
	
	public EJBPreferenceObject(String name, Float fvalue){
		this.name=name;
		this.fvalue=fvalue;
	}
	
	public EJBPreferenceObject(String name, Double dvalue){
		this.name=name;
		this.dvalue=dvalue;
	}
	
	public EJBPreferenceObject(String name, Integer ivalue){
		this.name=name;
		this.ivalue=ivalue;
	}
	
	public EJBPreferenceObject(String name, Boolean bvalue){
		this.name=name;
		this.bvalue=bvalue;
	}

	public EJBPreferenceObject(String name, Long lvalue){
		this.name=name;
		this.lvalue=lvalue;
	}
	
	@Transient
	protected List<String> getListString(){
		List<String> arr = new ArrayList<String>();
		if(lsvalue!=null)
			for (String value : lsvalue.split(";"))
				arr.add(value);
		return arr;
	}
	
	@Transient
	protected String getString(){
		return svalue;
	}
	
	@Transient
	protected Float getFloat(){
		return fvalue;
	}
	
	@Transient
	protected Double getDouble(){
		return dvalue;
	}
	
	@Transient
	protected Integer getInteger(){
		return ivalue;
	}

	@Transient
	protected Integer getLong(){
		return ivalue;
	}

	@Transient
	protected Boolean getBoolean(){
		return bvalue;
	}
	
	@Id 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSvalue() {
		return svalue;
	}

	public void setSvalue(String svalue) {
		this.svalue = svalue;
	}

	public Float getFvalue() {
		return fvalue;
	}

	public void setFvalue(Float fvalue) {
		this.fvalue = fvalue;
	}

	public Double getDvalue() {
		return dvalue;
	}

	public void setDvalue(Double dvalue) {
		this.dvalue = dvalue;
	}

	public Integer getIvalue() {
		return ivalue;
	}

	public void setIvalue(Integer ivalue) {
		this.ivalue = ivalue;
	}

	public Long getLvalue() {
		return lvalue;
	}

	public void setLvalue(Long lvalue) {
		this.lvalue = lvalue;
	}

	public Boolean getBvalue() {
		return bvalue;
	}

	public void setBvalue(Boolean bvalue) {
		this.bvalue = bvalue;
	}

	public String getLsvalue() {
		return lsvalue;
	}

	public void setLsvalue(List<String> lsvalue) {
		this.lsvalue="";
		if(lsvalue!=null)
			for (String value : lsvalue)
				this.lsvalue+=(value+";");
	}
	
	public void setLsvalue(String lsvalue) {
		this.lsvalue=lsvalue;
	}
	
}
