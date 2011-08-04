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
package it.archiworld.committee;

import it.archiworld.common.committee.Committee;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Committees {

	public abstract Committee getCommittee(Committee committee)
			throws Throwable;

	public abstract List<Committee> searchCommitteeList(String pattern)
			throws Throwable;

	public abstract Committee saveCommittee(Committee committee)
			throws Throwable;

}
