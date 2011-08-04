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

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface EJBPreferenceStore {

	public abstract boolean contains(String name);

	public abstract boolean getBoolean(String name);

	public abstract boolean getDefaultBoolean(String name);

	public abstract double getDefaultDouble(String name);

	public abstract float getDefaultFloat(String name);

	public abstract int getDefaultInt(String name);

	public abstract long getDefaultLong(String name);

	public abstract String getDefaultString(String name);

	public abstract double getDouble(String name);

	public abstract float getFloat(String name);

	public abstract int getInt(String name);

	public abstract long getLong(String name);

	public abstract String getString(String name);

	public abstract List<String> getStringList(String name, Timestamp timestamp);

	public abstract void putValue(String name, String value);

	public abstract void setDefault(String name, double value);

	public abstract void setDefault(String name, float value);

	public abstract void setDefault(String name, int value);

	public abstract void setDefault(String name, long value);

	public abstract void setDefault(String name, String defaultObject);

	public abstract void setDefault(String name, boolean value);

	public abstract void setToDefault(String name);

	public abstract void setValue(String name, double value);

	public abstract void setValue(String name, float value);

	public abstract void setValue(String name, int value);

	public abstract void setValue(String name, long value);

	public abstract void setValue(String name, String value);

	public abstract void setValue(String name, boolean value);

	public abstract void setValue(String name, List<String> value);

}
