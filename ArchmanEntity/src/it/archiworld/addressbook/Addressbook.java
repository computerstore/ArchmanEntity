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
package it.archiworld.addressbook;

import it.archiworld.common.Address;
import it.archiworld.common.Company;
import it.archiworld.common.Member;
import it.archiworld.common.Person;
import it.archiworld.common.ServiceMember;

import java.util.List;

import javax.ejb.Remote;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

@Remote
public interface Addressbook {
	public Address getAddress(Address address) throws Throwable;

	public void removeAddress(Address address) throws Throwable;

	public Address saveAddress(Address address) throws Throwable;

	public List<Person> searchPersonList(String pattern) throws Throwable;

	public List<Company> searchCompanyList(String company) throws Throwable;

	public List<Member> searchMemberList(String member) throws Throwable;

	public List<Member> searchDeletedMemberList(String member) throws Throwable;

	public List<ServiceMember> searchServiceMemberList(String servicemember)
			throws Throwable;

	public List<Address> getAddresslist() throws Throwable;

	public List<Address> searchAddress(Address address) throws Throwable;

	@SuppressWarnings("unchecked")
	public List<Address> searchAddress(Class entityClass, Criterion criterion,
			List<Order> orders) throws Throwable;

	public Member savePersonAsMember(Person person) throws Throwable;

	public ServiceMember savePersonAsServiceMember(Person person)
			throws Throwable;

}
