/**
 *	This file is part of wurfl-web Liferay plug-in.
 *	
 * Wurfl-web Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Wurfl-web Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with wurfl-web Liferay plug-in.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */
package com.commsen.liferay.wurfl;

import java.util.Map;

import com.commsen.liferay.multidevice.AbstractDevice;

/**
 * Class represents user's device as identified by WURFL
 * 
 * @author Milen Dyankov
 * 
 */
public class WurflDevice extends AbstractDevice {

	private Map<String, String> capabilities;


	public WurflDevice(Map<String, String> capabilities) {
		super();
		this.capabilities = capabilities;
	}


	@Override
	public Map<String, String> getCapabilities() {
		return capabilities;
	}


	@Override
	public String getCapability(String name) {
		if (capabilities == null) return null;
		return capabilities.get(name);
	}


	@Override
	public String getBrand() {
		if (capabilities == null) return null;
		return capabilities.get("brand_name");
	}


	@Override
	public String getModel() {
		if (capabilities == null) return null;
		return capabilities.get("model_name");
	}


	@Override
	public String getOS() {
		if (capabilities == null) return null;
		return capabilities.get("device_os");
	}


	@Override
	public String getOSVersion() {
		if (capabilities == null) return null;
		return capabilities.get("device_os_version");
	}


	@Override
	public String getBrowser() {
		if (capabilities == null) return null;
		return capabilities.get("mobile_browser");
	}


	@Override
	public String getBrowserVersion() {
		if (capabilities == null) return null;
		return capabilities.get("mobile_browser_version");
	}


	@Override
	public String getPointingMethod() {
		if (capabilities == null) return null;
		return capabilities.get("pointing_method");
	}


	@Override
	public boolean isTablet() {
		if (capabilities == null) return false;
		return Boolean.parseBoolean(capabilities.get("is_tablet"));
	}


	@Override
	public boolean hasQwertyKeyboard() {
		if (capabilities == null) return false;
		return Boolean.parseBoolean(capabilities.get("has_qwerty_keyboard"));
	}

}
