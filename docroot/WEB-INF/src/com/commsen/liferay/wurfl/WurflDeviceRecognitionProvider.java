/**
 * Copyright (c) COMMSEN International. All rights reserved.
 *	
 * This library is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library.  If not, see http://www.gnu.org/licenses/lgpl.html.
 */
package com.commsen.liferay.wurfl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.wurfl.core.WURFLHolder;

import com.commsen.liferay.multidevice.DeviceRecognitionProvider;
import com.commsen.liferay.multidevice.KnownDevices;
import com.commsen.liferay.multidevice.Device;

/**
 * This implementation of {@link DeviceRecognitionProvider} uses WURFL for device recognition
 * 
 * @author Milen Dyankov
 * 
 */
public class WurflDeviceRecognitionProvider implements DeviceRecognitionProvider {

	private WURFLHolder wurflHolder;

	private KnownDevices knownDevices;


	@Override
	public Device getDeviceFromRequest(HttpServletRequest request) {
		com.commsen.liferay.multidevice.Device device = null;
		net.sourceforge.wurfl.core.Device wurflDevice = wurflHolder.getWURFLManager().getDeviceForRequest(request);
		if (wurflDevice != null) {
			@SuppressWarnings("unchecked")
			Map<String, String> capabilities = wurflDevice.getCapabilities();
			if (capabilities != null) device = new WurflDevice(capabilities);
		}
		return device;
	}


	@Override
	public KnownDevices getKnownDevices() {
		return knownDevices;
	}


	public void setWurflHolder(WURFLHolder wurflHolder) {
		this.wurflHolder = wurflHolder;
	}


	public void setKnownDevices(KnownDevices knownDevices) {
		this.knownDevices = knownDevices;
	}

}
