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

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name="t_document")
public class Document implements Serializable {

	private static final long serialVersionUID = -4707753740123958770L;
	protected Integer document_id;
//	protected Entry entry;
	protected String type;
	protected String name;
	protected String suffix;
	protected String location;
	protected byte[] file;
	protected String filefingerprintSHA1;
	protected byte[] filefingerprintRIPEMD160;
	
	public Document(){
	}
	
	public Document(Integer document_id, String name){
		this.document_id=document_id;
		this.name=name;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Document#getLocation()
	 */
	public String getLocation() {
		return location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Document#setLocation(java.lang.String)
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Document#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Document#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Document#getDocument_id()
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "document_id")
	public Integer getDocument_id() {
		return document_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.archiworld.common.protocol.Document#setDocument_id(java.lang.Integer)
	 */
	public void setDocument_id(Integer document_id) {
		this.document_id = document_id;
	}

//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="entry_id")
//	@IndexColumn(name="entry_id")
//	public Entry getEntry() {
//		return entry;
//	}
//
//	public void setEntry(Entry entry) {
//		this.entry = entry;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Lob
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return getName() + "." + getSuffix() + " " + getFile().length / 1000
				+ "KB " + new String(getFilefingerprintSHA1());
	}

	public String getFilefingerprintSHA1() {
		return filefingerprintSHA1;
	}

	public void setFilefingerprintSHA1(String filefingerprintSHA1) {
		this.filefingerprintSHA1 = filefingerprintSHA1;
	}
	
	public String getFilefingerprintRIPEMD160() {
		return filefingerprintSHA1;
	}

	public void setFilefingerprintRIPEMD160(String filefingerprintSHA1) {
		this.filefingerprintSHA1 = filefingerprintSHA1;
	}

	public String calculateFingerprintSHA1(){
		try {
			//SHA1 Calculation
			MessageDigest digest = MessageDigest.getInstance("SHA-1"); //$NON-NLS-1$
			digest.update(getFile());
			byte[] messageDigest = digest.digest();
			String fingerprint=""; //$NON-NLS-1$
			 for (int j = 0; j < messageDigest.length; j++ )
			      fingerprint+=String.format("%02x", messageDigest[j]); //$NON-NLS-1$
			System.out.println(fingerprint);
			this.setFilefingerprintSHA1(fingerprint);
			return getFilefingerprintSHA1();
//			this.setFilefingerprintSHA1(MessageDigest.getInstance("SHA-1").digest(file));
//			return getFilefingerprintSHA1();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
