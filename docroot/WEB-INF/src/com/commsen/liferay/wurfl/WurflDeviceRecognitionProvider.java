package com.commsen.liferay.wurfl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import net.sourceforge.wurfl.core.WURFLHolder;

import com.commsen.liferay.multidevice.DeviceRecognitionProvider;
import com.commsen.liferay.multidevice.KnownDevices;
import com.commsen.liferay.multidevice.Device; 

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
