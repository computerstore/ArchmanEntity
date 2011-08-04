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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionOfElements;

@Entity
public class MemberFieldExportSelector implements Serializable {

	private static final long serialVersionUID = 1L;

	public PropertyChangeSupport changes = new PropertyChangeSupport(this);
	@CollectionOfElements
	protected List<String> properties;
	protected String name;

	public MemberFieldExportSelector() {
		properties = new ArrayList<String>();
	}

	@CollectionOfElements(fetch = FetchType.EAGER)
	public List<String> getProperties() {
		return properties;
	}

	public void setProperties(List<String> newproperties) {
		List<String> oldproperties = getProperties();
		this.properties = newproperties;
		changes.firePropertyChange("properties", oldproperties, newproperties);
		/*
		 * Iterator<String> iter = properties.iterator();
		 * Class<MemberFieldExportSelector> entityClass =
		 * (Class<MemberFieldExportSelector>) this.getClass(); Method[] methods
		 * = entityClass.getMethods(); for(int i=0;i<methods.length;i++)
		 * if(methods[i].getName().startsWith("set") &&
		 * properties.contains(methods
		 * [i].getName().substring(3).toLowerCase())){ try {
		 * System.out.println(methods[i].getName()); methods[i].invoke(this, new
		 * Object[]{true}); } catch (IllegalArgumentException e) {
		 * e.printStackTrace(); } catch (IllegalAccessException e) {
		 * e.printStackTrace(); } catch (InvocationTargetException e) {
		 * e.printStackTrace(); } }
		 */

	}

	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Transient
	public boolean getFirstname() {
		return properties.contains("firstname");
	}

	@Transient
	public void setFirstname(boolean firstname) {
		boolean oldfirstname = getFirstname();
		if (firstname)
			properties.add("firstname");
		else
			properties.remove("firstname");
		changes.firePropertyChange("firstname", oldfirstname, firstname);
	}

	@Transient
	public boolean getLastname() {
		return properties.contains("lastname");
	}

	@Transient
	public void setLastname(boolean lastname) {
		boolean oldlastname = getLastname();
		if (lastname)
			properties.add("lastname");
		else
			properties.remove("lastname");
		changes.firePropertyChange("lastname", oldlastname, lastname);
	}

	@Transient
	public boolean getTitle() {
		return properties.contains("title");
	}

	@Transient
	public void setTitle(boolean title) {
		boolean oldtitle = getTitle();
		if (title)
			properties.add("title");
		else
			properties.remove("title");
		changes.firePropertyChange("title", oldtitle, title);
	}

	@Transient
	public boolean getEmail() {
		return properties.contains("email");
	}

	@Transient
	public void setEmail(boolean email) {
		boolean oldemail = getEmail();
		if (email)
			properties.add("email");
		else
			properties.remove("email");
		changes.firePropertyChange("email", oldemail, email);
	}

	@Transient
	public boolean getPhone() {
		return properties.contains("phone");
	}

	@Transient
	public void setPhone(boolean phone) {
		boolean oldphone = getPhone();
		if (phone)
			properties.add("phone");
		else
			properties.remove("phone");
		changes.firePropertyChange("phone", oldphone, phone);
	}

	@Transient
	public boolean getMobilephone() {
		return properties.contains("mobilephone");
	}

	@Transient
	public void setMobilephone(boolean mobilephone) {
		boolean oldmobilephone = getMobilephone();
		if (mobilephone)
			properties.add("mobilephone");
		else
			properties.remove("mobilephone");
		changes.firePropertyChange("mobilephone", oldmobilephone, mobilephone);
	}

	@Transient
	public boolean getFax() {
		return properties.contains("fax");
	}

	@Transient
	public void setFax(boolean fax) {
		boolean oldfax = getFax();
		if (fax)
			properties.add("fax");
		else
			properties.remove("fax");
		changes.firePropertyChange("fax", oldfax, fax);
	}

	@Transient
	public boolean getWebsite() {
		return properties.contains("website");
	}

	@Transient
	public void setWebsite(boolean website) {
		boolean oldwebsite = getWebsite();
		if (website)
			properties.add("website");
		else
			properties.remove("website");
		changes.firePropertyChange("website", oldwebsite, website);
	}

	@Transient
	public boolean getStreet() {
		return properties.contains("street");
	}

	@Transient
	public void setStreet(boolean street) {
		boolean oldstreet = getStreet();
		if (street)
			properties.add("street");
		else
			properties.remove("street");
		changes.firePropertyChange("street", oldstreet, street);
	}

	@Transient
	public boolean getZip() {
		return properties.contains("zip");
	}

	@Transient
	public void setZip(boolean zip) {
		boolean oldzip = getZip();
		if (zip)
			properties.add("zip");
		else
			properties.remove("zip");
		changes.firePropertyChange("zip", oldzip, zip);
	}

	@Transient
	public boolean getCity() {
		return properties.contains("city");
	}

	@Transient
	public void setCity(boolean city) {
		boolean oldcity = getCity();
		if (city)
			properties.add("city");
		else
			properties.remove("city");
		changes.firePropertyChange("city", oldcity, city);
	}

	@Transient
	public boolean getState() {
		return properties.contains("state");
	}

	@Transient
	public void setState(boolean state) {
		boolean oldstate = getState();
		if (state)
			properties.add("state");
		else
			properties.remove("state");
		changes.firePropertyChange("state", oldstate, state);
	}

	@Transient
	public boolean getCountry() {
		return properties.contains("country");
	}

	@Transient
	public void setCountry(boolean country) {
		boolean oldcountry = getCountry();
		if (country)
			properties.add("country");
		else
			properties.remove("country");
		changes.firePropertyChange("country", oldcountry, country);
	}

	@Transient
	public boolean getTax_code() {
		return properties.contains("tax_code");
	}

	@Transient
	public void setTax_code(boolean tax_code) {
		boolean oldtax_code = getTax_code();
		if (tax_code)
			properties.add("tax_code");
		else
			properties.remove("tax_code");
		changes.firePropertyChange("tax_code", oldtax_code, tax_code);
	}

	@Transient
	public boolean getFiscal_code() {
		return properties.contains("fiscal_code");
	}

	@Transient
	public void setFiscal_code(boolean fiscal_code) {
		boolean oldfiscal_code = getFiscal_code();
		if (fiscal_code)
			properties.add("fiscal_code");
		else
			properties.remove("fiscal_code");
		changes.firePropertyChange("fiscal_code", oldfiscal_code, fiscal_code);
	}

	@Transient
	public boolean getAccount_nr() {
		return properties.contains("account_nr");
	}

	@Transient
	public void setAccount_nr(boolean account_nr) {
		boolean oldaccountnr = getAccount_nr();
		if (account_nr)
			properties.add("account_nr");
		else
			properties.remove("account_nr");
		changes.firePropertyChange("account_nr", oldaccountnr, account_nr);
	}

	@Transient
	public boolean getBank_nr() {
		return properties.contains("bank_nr");
	}

	@Transient
	public void setBank_nr(boolean bank_nr) {
		if (!getBank_nr())
			properties.add("bank_nr");
	}

	@Transient
	public boolean getIban() {
		return properties.contains("iban");
	}

	@Transient
	public void setIban(boolean iban) {
		if (!getIban())
			properties.add("iban");
	}

	@Transient
	public boolean getBic() {
		return properties.contains("bic");
	}

	@Transient
	public void setBic(boolean bic) {
		boolean oldbic = getBic(); 
		if(bic) 
		{ 
			properties.add("bic"); 
		} else 
		{
			properties.remove("bic"); 
		}
		changes.firePropertyChange("bic", oldbic, bic);
	}

	@Transient
	public boolean getNote() {
		return properties.contains("note");
	}

	@Transient
	public void setNote(boolean note) {
		boolean oldnote = getNote();
		if (note)
			properties.add("note");
		else
			properties.remove("note");
		changes.firePropertyChange("note", oldnote, note);
	}

	@Transient
	public boolean getGender() {
		return properties.contains("gender");
	}

	@Transient
	public void setGender(boolean gender) {
		boolean oldgender = getGender();
		if (gender)
			properties.add("gender");
		else
			properties.remove("gender");
		changes.firePropertyChange("gender", oldgender, gender);	
	}

	@Transient
	public boolean getHomestreet() {
		return properties.contains("homestreet");
	}

	@Transient
	public void setHomestreet(boolean homestreet) {
		boolean oldhomestreet = getHomestreet();
		if (homestreet)
			properties.add("homestreet");
		else
			properties.remove("homestreet");
		changes.firePropertyChange("homestreet", oldhomestreet, homestreet);	
	}

	@Transient
	public boolean getHomezip() {
		return properties.contains("homezip");
	}

	@Transient
	public void setHomezip(boolean homezip) {
		boolean oldhomezip = getHomezip();
		if (homezip)
			properties.add("homezip");
		else
			properties.remove("homezip");
		changes.firePropertyChange("homezip", oldhomezip, homezip);	
	}

	@Transient
	public boolean getHomecity() {
		return properties.contains("homecity");
	}

	@Transient
	public void setHomecity(boolean homecity) {
		boolean oldhomecity = getHomecity();
		if (homecity)
			properties.add("homecity");
		else
			properties.remove("homecity");
		changes.firePropertyChange("homecity", oldhomecity, homecity);	
	}

	@Transient
	public boolean getHomestate() {
		return properties.contains("homestate");
	}

	@Transient
	public void setHomestate(boolean homestate) {
		boolean oldhomestate = getHomestate();
		if (homestate)
			properties.add("homestate");
		else
			properties.remove("homestate");
		changes.firePropertyChange("homestate", oldhomestate, homestate);
	}

	@Transient
	public boolean getHomecountry() {
		return properties.contains("homecountry");
	}

	@Transient
	public void setHomecountry(boolean homecountry) {
		boolean oldhomecountry = getHomecountry();
		if (homecountry)
			properties.add("homecountry");
		else
			properties.remove("homecountry");
		changes.firePropertyChange("homecountry", oldhomecountry, homecountry);
	}

	@Transient
	public boolean getHomestreet_de() {
		return properties.contains("homestreet_de");
	}

	@Transient
	public void setHomestreet_de(boolean homestreet_de) {
		boolean oldhomestreet_de = getHomestreet_de();
		if (homestreet_de)
			properties.add("homestreet_de");
		else
			properties.remove("homestreet_de");
		changes.firePropertyChange("homestreet_de", oldhomestreet_de, homestreet_de);	
	}

	@Transient
	public boolean getHomecity_de() {
		return properties.contains("homecity_de");
	}

	@Transient
	public void setHomecity_de(boolean homecity_de) {
		boolean oldhomecity_de = getHomecity_de();
		if (homecity_de)
			properties.add("homecity_de");
		else
			properties.remove("homecity_de");
		changes.firePropertyChange("homecity_de", oldhomecity_de, homecity_de);
	}

	@Transient
	public boolean getHomestate_de() {
		return properties.contains("homestate_de");
	}

	@Transient
	public void setHomestate_de(boolean homestate_de) {
		boolean oldhomestate_de = getHomestate_de();
		if (homestate_de)
			properties.add("homestate_de");
		else
			properties.remove("homestate_de");
		changes.firePropertyChange("homestate_de", oldhomestate_de, homestate_de);
	}

	@Transient
	public boolean getHomecountry_de() {
		return properties.contains("homecountry_de");
	}

	@Transient
	public void setHomecountry_de(boolean homecountry_de) {
		boolean oldhomecountry_de = getHomecountry_de();
		if (homecountry_de)
			properties.add("homecountry_de");
		else
			properties.remove("homecountry_de");
		changes.firePropertyChange("homecountry_de", oldhomecountry_de, homecountry_de);	
	}

	@Transient
	public boolean getHomephone() {
		return properties.contains("homephone");
	}

	@Transient
	public void setHomephone(boolean homephone) {
		boolean oldhomephone = getHomephone();
		if (homephone)
			properties.add("homephone");
		else
			properties.remove("homephone");
		changes.firePropertyChange("homephone", oldhomephone, homephone);
	}

	@Transient
	public boolean getHomefax() {
		return properties.contains("homefax");
	}

	@Transient
	public void setHomefax(boolean homefax) {
		boolean oldhomefax = getHomefax();
		if (homefax)
			properties.add("homefax");
		else
			properties.remove("homefax");
		changes.firePropertyChange("homefax", oldhomefax, homefax);
	}

	@Transient
	public boolean getNationality() {
		return properties.contains("nationality");
	}

	@Transient
	public void setNationality(boolean nationality) {
		boolean oldnationality = getNationality();
		if (nationality)
			properties.add("nationality");
		else
			properties.remove("nationality");
		changes.firePropertyChange("nationality", oldnationality, nationality);
	}

	@Transient
	public boolean getProfession() {
		return properties.contains("profession");
	}

	@Transient
	public void setProfession(boolean profession) {
		boolean oldprofession = getProfession();
		if (profession)
			properties.add("profession");
		else
			properties.remove("profession");
		changes.firePropertyChange("profession", oldprofession, profession);
	}

	@Transient
	public boolean getStreet_de() {
		return properties.contains("street_de");
	}

	@Transient
	public void setStreet_de(boolean street_de) {
		boolean oldstreet_de = getStreet_de();
		if (street_de)
			properties.add("street_de");
		else
			properties.remove("street_de");
		changes.firePropertyChange("street_de", oldstreet_de, street_de);
	}

	@Transient
	public boolean getCity_de() {
		return properties.contains("city_de");
	}

	@Transient
	public void setCity_de(boolean city_de) {
		boolean oldcity_de = getCity_de();
		if (city_de)
			properties.add("city_de");
		else
			properties.remove("city_de");
		changes.firePropertyChange("city_de", oldcity_de, city_de);
	}

	@Transient
	public boolean getState_de() {
		return properties.contains("state_de");
	}

	@Transient
	public void setState_de(boolean state_de) {
		boolean oldstate_de = getState_de();
		if (state_de)
			properties.add("state_de");
		else
			properties.remove("state_de");
		changes.firePropertyChange("state_de", oldstate_de, state_de);
	}

	@Transient
	public boolean getCountry_de() {
		return properties.contains("country_de");
	}

	@Transient
	public void setCountry_de(boolean country_de) {
		boolean oldcountry_de = getCountry_de();
		if (country_de)
			properties.add("country_de");
		else
			properties.remove("country_de");
		changes.firePropertyChange("country_de", oldcountry_de, country_de);
	}

	@Transient
	public boolean getStdaddress() {
		return properties.contains("stdaddress");
	}

	@Transient
	public void setStdaddress(boolean stdaddress) {
		boolean oldstdaddress = getStdaddress();
		if (stdaddress)
			properties.add("stdaddress");
		else
			properties.remove("stdaddress");
		changes.firePropertyChange("stdaddress", oldstdaddress, stdaddress);
	}

	@Transient
	public boolean getSector() {
		return properties.contains("sector");
	}

	@Transient
	public void setSector(boolean sector) {
		boolean oldsector = getSector();
		if (sector)
			properties.add("sector");
		else
			properties.remove("sector");
		changes.firePropertyChange("sector", oldsector, sector);
	}

	@Transient
	public boolean getSector_date() {
		return properties.contains("sector_date");
	}

	@Transient
	public void setSector_date(boolean sector_date) {
		boolean oldsector_date = getSector_date();
		if (sector_date)
			properties.add("sector_date");
		else
			properties.remove("sector_date");
		changes.firePropertyChange("sector_date", oldsector_date, sector_date);
	}

	@Transient
	public boolean getSector_habilitation() {
		return properties.contains("sector_habilitation");
	}

	@Transient
	public void setSector_habilitation(boolean sector_habilitation) {
		boolean oldsector_habilitation = getSector_habilitation();
		if (sector_habilitation)
			properties.add("sector_habilitation");
		else
			properties.remove("sector_habilitation");
		changes.firePropertyChange("sector_habilitation", oldsector_habilitation, sector_habilitation);
	}

	@Transient
	public boolean getSector_exemption() {
		return properties.contains("sector_exemption");
	}

	@Transient
	public void setSector_exemption(boolean sector_exemption) {
		boolean oldsector_exemption = getSector_exemption();
		if (sector_exemption)
			properties.add("sector_exemption");
		else
			properties.remove("sector_exemption");
		changes.firePropertyChange("sector_exemption", oldsector_exemption, sector_exemption);
	}

	@Transient
	public boolean getRegistration_date() {
		return properties.contains("registration_date");
	}

	@Transient
	public void setRegistration_date(boolean registration_date) {
		boolean oldregistration_date = getRegistration_date();
		if (registration_date)
			properties.add("registration_date");
		else
			properties.remove("registration_date");
		changes.firePropertyChange("registration_date", oldregistration_date, registration_date);
	}

	@Transient
	public boolean getRegistration_exemption() {
		return properties.contains("registration_exemption");
	}

	@Transient
	public void setRegistration_exemption(boolean registration_exemption) {
		boolean oldregistration_exemption = getRegistration_exemption();
		if (registration_exemption)
			properties.add("registration_exemption");
		else
			properties.remove("registration_exemption");
		changes.firePropertyChange("registration_exemption", oldregistration_exemption, registration_exemption);
	}

	@Transient
	public boolean getGraduation_date() {
		return properties.contains("graduation_date");
	}

	@Transient
	public void setGraduation_date(boolean graduation_date) {
		boolean oldgraduation_date = getGraduation_date();
		if (graduation_date)
			properties.add("graduation_date");
		else
			properties.remove("graduation_date");
		changes.firePropertyChange("graduation_date", oldgraduation_date, graduation_date);
	}

	@Transient
	public boolean getGraduation_institute() {
		return properties.contains("graduation_institute");
	}

	@Transient
	public void setGraduation_institute(boolean graduation_institute) {
		boolean oldgraduation_institute = getGraduation_institute();
		if (graduation_institute)
			properties.add("graduation_institute");
		else
			properties.remove("graduation_institute");
		changes.firePropertyChange("graduation_institute", oldgraduation_institute, graduation_institute);
	}

	@Transient
	public boolean getGraduation_approval_date() {
		return properties.contains("graduation_approval_date");
	}

	@Transient
	public void setGraduation_approval_date(boolean graduation_approval_date) {
		boolean oldgraduation_approval_date = getGraduation_approval_date();
		if (graduation_approval_date)
			properties.add("graduation_approval_date");
		else
			properties.remove("graduation_approval_date");
		changes.firePropertyChange("graduation_approval_date", oldgraduation_approval_date, graduation_approval_date);
	}

	@Transient
	public boolean getHabilitation() {
		return properties.contains("habilitation");
	}

	@Transient
	public void setHabilitation(boolean habilitation) {
		boolean oldhabilitation = getHabilitation();
		if (habilitation)
			properties.add("habilitation");
		else
			properties.remove("habilitation");
		changes.firePropertyChange("habilitation", oldhabilitation, habilitation);
	}

	@Transient
	public boolean getState_exam_year() {
		return properties.contains("state_exam_year");
	}

	@Transient
	public void setState_exam_year(boolean state_exam_year) {
		boolean oldstate_exam_year = getState_exam_year();
		if (state_exam_year)
			properties.add("state_exam_year");
		else
			properties.remove("state_exam_year");
		changes.firePropertyChange("state_exam_year", oldstate_exam_year, state_exam_year);
	}

	@Transient
	public boolean getRegistration_number() {
		return properties.contains("registration_number");
	}

	@Transient
	public void setRegistration_number(boolean registration_number) {
		boolean oldregistration_number = getRegistration_number();
		if (registration_number)
			properties.add("registration_number");
		else
			properties.remove("registration_number");
		changes.firePropertyChange("registration_number", oldregistration_number, registration_number);
	}

	@Transient
	public boolean getDeregister_date() {
		return properties.contains("deregister_date");
	}

	@Transient
	public void setDeregister_date(boolean deregister_date) {
		boolean oldderegister_date = getDeregister_date();
		if (deregister_date)
			properties.add("deregister_date");
		else
			properties.remove("deregister_date");
		changes.firePropertyChange("deregister_date", oldderegister_date, deregister_date);
	}

	@Transient
	public boolean getDeregister_reason() {
		return properties.contains("deregister_reason");
	}

	@Transient
	public void setDeregister_reason(boolean deregister_reason) {
		boolean oldderegister_reason = getDeregister_reason();
		if (deregister_reason)
			properties.add("deregister_reason");
		else
			properties.remove("deregister_reason");
		changes.firePropertyChange("deregister_reason", oldderegister_reason, deregister_reason);
	}

	@Transient
	public boolean getDeregister_exemption() {
		return properties.contains("deregister_exemption");
	}

	@Transient
	public void setDeregister_exemption(boolean deregister_exemption) {
		boolean oldderegister_exemption = getDeregister_exemption();
		if (deregister_exemption)
			properties.add("deregister_exemption");
		else
			properties.remove("deregister_exemption");
		changes.firePropertyChange("deregister_exemption", oldderegister_exemption, deregister_exemption);
	}

	@Transient
	public boolean getLast_change_date() {
		return properties.contains("last_change_date");
	}

	@Transient
	public void setLast_change_date(boolean last_change_date) {
		boolean oldlast_change_date = getLast_change_date();
		if (last_change_date)
			properties.add("last_change_date");
		else
			properties.remove("last_change_date");
		changes.firePropertyChange("last_change_date", oldlast_change_date, last_change_date);
	}

	@Transient
	public boolean getBirthplace_de() {
		return properties.contains("birthplace_de");
	}

	@Transient
	public void setBirthplace_de(boolean birthplace_de) {
		boolean oldbirthplace_de = getBirthplace_de();
		if (birthplace_de)
			properties.add("birthplace_de");
		else
			properties.remove("birthplace_de");
		changes.firePropertyChange("birthplace_de", oldbirthplace_de, birthplace_de);
	}

	@Transient
	public boolean getBirthplace() {
		return properties.contains("birthplace");
	}

	@Transient
	public void setBirthplace(boolean birthplace) {
		boolean oldbirthplace = getBirthplace();
		if (birthplace)
			properties.add("birthplace");
		else
			properties.remove("birthplace");
		changes.firePropertyChange("birthplace", oldbirthplace, birthplace);
	}

	@Transient
	public boolean getBirthdate() {
		return properties.contains("birthdate");
	}

	@Transient
	public void setBirthdate(boolean birthdate) {
		boolean oldbirthdate = getBirthdate();
		if (birthdate)
			properties.add("birthdate");
		else
			properties.remove("birthdate");
		changes.firePropertyChange("birthdate", oldbirthdate, birthdate);
	}

	@Transient
	public boolean getRegister_address() {
		return properties.contains("register_address");
	}

	@Transient
	public void setRegister_address(boolean register_address) {
		boolean oldregister_address = getRegister_address();
		if (register_address)
			properties.add("register_address");
		else
			properties.remove("register_address");
		changes.firePropertyChange("register_address", oldregister_address, register_address);
	}

	@Transient
	public boolean getNewsletter() {
		return properties.contains("newsletter");
	}

	@Transient
	public void setNewsletter(boolean newsletter) {
		boolean oldnewsletter = getNewsletter();
		if (newsletter)
			properties.add("newsletter");
		else
			properties.remove("newsletter");
		changes.firePropertyChange("newsletter", oldnewsletter, newsletter);
	}

	@Transient
	public boolean getCulturenewsletter() {
		return properties.contains("culturenewsletter");
	}

	@Transient
	public void setCulturenewsletter(boolean culturenewsletter) {
		boolean oldculturenewsletter = getCulturenewsletter();
		if (culturenewsletter)
			properties.add("culturenewsletter");
		else
			properties.remove("culturenewsletter");
		changes.firePropertyChange("culturenewsletter", oldculturenewsletter, culturenewsletter);
	}

	@Transient
	public boolean getDirectory_homephone() {
		return properties.contains("directory_homephone");
	}

	@Transient
	public void setDirectory_homephone(boolean directory_homephone) {
		boolean olddirectory_homephone = getDirectory_homephone();
		if (directory_homephone)
			properties.add("directory_homephone");
		else
			properties.remove("directory_homephone");
		changes.firePropertyChange("directory_homephone", olddirectory_homephone, directory_homephone);
	}

	@Transient
	public boolean getDirectory_homefax() {
		return properties.contains("directory_homefax");
	}

	@Transient
	public void setDirectory_homefax(boolean directory_homefax) {
		boolean olddirectory_homefax = getDirectory_homefax();
		if (directory_homefax)
			properties.add("directory_homefax");
		else
			properties.remove("directory_homefax");
		changes.firePropertyChange("directory_homefax", olddirectory_homefax, directory_homefax);
	}

	@Transient
	public boolean getDirectory_phone() {
		return properties.contains("directory_phone");
	}

	@Transient
	public void setDirectory_phone(boolean directory_phone) {
		boolean olddirectory_phone = getDirectory_phone();
		if (directory_phone)
			properties.add("directory_phone");
		else
			properties.remove("directory_phone");
		changes.firePropertyChange("directory_phone", olddirectory_phone, directory_phone);
	}

	@Transient
	public boolean getDirectory_fax() {
		return properties.contains("directory_fax");
	}

	@Transient
	public void setDirectory_fax(boolean directory_fax) {
		boolean olddirectory_fax = getDirectory_fax();
		if (directory_fax)
			properties.add("directory_fax");
		else
			properties.remove("directory_fax");
		changes.firePropertyChange("directory_fax", olddirectory_fax, directory_fax);
	}

	@Transient
	public boolean getDirectory_mobile() {
		return properties.contains("directory_mobile");
	}

	@Transient
	public void setDirectory_mobile(boolean directory_mobile) {
		boolean olddirectory_mobile = getDirectory_mobile();
		if (directory_mobile)
			properties.add("directory_mobile");
		else
			properties.remove("directory_mobile");
		changes.firePropertyChange("directory_mobile", olddirectory_mobile, directory_mobile);
	}

	@Transient
	public boolean getDirectory_email() {
		return properties.contains("directory_email");
	}

	@Transient
	public void setDirectory_email(boolean directory_email) {
		boolean olddirectory_email = getDirectory_email();
		if (directory_email)
			properties.add("directory_email");
		else
			properties.remove("directory_email");
		changes.firePropertyChange("directory_email", olddirectory_email, directory_email);
	}

	@Transient
	public boolean getDirectory_website() {
		return properties.contains("directory_website");
	}

	@Transient
	public void setDirectory_website(boolean directory_website) {
		boolean olddirectory_website = getDirectory_website();
		if (directory_website)
			properties.add("directory_website");
		else
			properties.remove("directory_website");
		changes.firePropertyChange("directory_website", olddirectory_website, directory_website);
	}

	@Transient
	public boolean getDirectory_officeaddress() {
		return properties.contains("directory_officeaddress");
	}

	@Transient
	public void setDirectory_officeaddress(boolean directory_officeaddress) {
		boolean olddirectory_officeaddress = getDirectory_officeaddress();
		if (directory_officeaddress)
			properties.add("directory_officeaddress");
		else
			properties.remove("directory_officeaddress");
		changes.firePropertyChange("directory_officeaddress", olddirectory_officeaddress, directory_officeaddress);
	}
	
	@Transient
	public boolean getSection_de(){
		return properties.contains("section_de");
	}
	
	@Transient
	public void setSection_de(boolean section){
		helpSetter("section_de", section);
	}
	
	@Transient
	public boolean getSection_it(){
		return properties.contains("section_it");
	}
	
	@Transient
	public void setSection_it(boolean section){
		helpSetter("section_it", section);
	}
	
	@Transient
	public boolean getSection_ms(){
		return properties.contains("section_ms");
	}
	
	@Transient
	public void setSection_ms(boolean section){
		helpSetter("section_ms", section);
	}
	
	@Transient
	public boolean getGender_de(){
		return properties.contains("gender_de");
	}
	
	@Transient
	public void setGender_de(boolean gender){
		helpSetter("gender_de", gender);
	}
	
	@Transient
	public boolean getGender_it(){
		return properties.contains("gender_it");
	}
	
	@Transient
	public void setGender_it(boolean gender){
		helpSetter("gender_it", gender);
	}
	
	@Transient
	public boolean getGender_ms(){
		return properties.contains("gender_ms");
	}
	
	@Transient
	public void setGender_ms(boolean value){
		helpSetter("gender_ms",value);		
	}
	
	@Transient
	public boolean getBirthplace_ms(){
		return properties.contains("birthplace_ms");
	}
	
	@Transient
	public void setBirthplace_ms(boolean value){
		helpSetter("birthplace_ms", value);		
	}
	
	@Transient
	public boolean getHomeaddress_de(){
		return properties.contains("homeaddress_de");
	}
	
	@Transient
	public void setHomeaddress_de(boolean value){
		helpSetter("homeaddress_de", value);		
	}
	
	@Transient
	public boolean getHomeaddress_it(){
		return properties.contains("homeaddress_it");
	}
	
	@Transient
	public void setHomeaddress_it(boolean value){
		helpSetter("homeaddress_it", value);		
	}
	
	@Transient
	public boolean getHomeaddress_ms(){
		return properties.contains("homeaddress_ms");
	}
	
	@Transient
	public void setHomeaddress_ms(boolean value){
		helpSetter("homeaddress_ms",value);	
	}
	
	@Transient
	public boolean getAddress_de(){
		return properties.contains("address_de");
	}
	
	@Transient
	public void setAddress_de(boolean value){
		helpSetter("address_de",value);
	}
	
	@Transient
	public boolean getAddress_it(){
		return properties.contains("address_it");
	}
	
	@Transient
	public void setAddress_it(boolean value){
		helpSetter("address_it",value);	
	}
	
	@Transient
	public boolean getProfession_de(){
		return properties.contains("profession_de");
	}
	
	@Transient
	public void setProfession_de(boolean value){
		helpSetter("profession_de", value);
	}

	@Transient
	public boolean getProfession_it(){
		return properties.contains("profession_it");
	}
	
	@Transient
	public void setProfession_it(boolean value){
		helpSetter("profession_it",value);
	}
	
	@Transient
	public boolean getProfession_ms(){
		return properties.contains("profession_ms");
	}
	
	@Transient
	public void setProfession_ms(boolean value){
		helpSetter("profession_ms",value);
	}
	
	@Transient
	public boolean getAddress_ms(){
		return properties.contains("address_ms");
	}
	
	@Transient
	public void setAddress_ms(boolean value){
		helpSetter("address_ms",value);
	}
	
	@Transient
	public void helpSetter(String var, boolean new_value){
		boolean old_value = properties.contains(var);
		if (new_value)
			properties.add(var);
		else
			properties.remove(var);
		changes.firePropertyChange(var, old_value, new_value);						
	}
	
	@Transient
	public void addPropertyChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	@Transient
	public void removePropertyChangeListener(PropertyChangeListener l) {
		changes.removePropertyChangeListener(l);
	}
}
