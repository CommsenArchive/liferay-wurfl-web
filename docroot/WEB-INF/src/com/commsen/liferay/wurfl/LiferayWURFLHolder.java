package com.commsen.liferay.wurfl;

import net.sourceforge.wurfl.core.CustomWURFLHolder;
import net.sourceforge.wurfl.core.WURFLHolder;
import net.sourceforge.wurfl.core.WURFLManager;
import net.sourceforge.wurfl.core.WURFLUtils;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;


public class LiferayWURFLHolder implements WURFLHolder {

	private WURFLHolder wurflHolder;


	public void init() {
		String main_file = PropsUtil.get(WURFL_MAIN);
		String[] patchFiles = PropsUtil.getArray(WURFL_PATCHES);
		
		if (StringUtils.isBlank(main_file)) {
			_log.warn("Wurfl NOT initialised! Plase set '" + WURFL_MAIN + "' property!");
			return;
		}
		
		wurflHolder = new CustomWURFLHolder(main_file, patchFiles);
		_log.debug("Wurfl initialised!");
	}

	private static Log _log = LogFactoryUtil.getLog(LiferayWURFLHolder.class);

	private static final String WURFL_MAIN = "wurfl.main";
	private static final String WURFL_PATCHES = "wurfl.patches";


	@Override
	public WURFLManager getWURFLManager() {
		if (wurflHolder == null) init();
		return wurflHolder.getWURFLManager();
	}


	@Override
	public WURFLUtils getWURFLUtils() {
		if (wurflHolder == null) init();
		return wurflHolder.getWURFLUtils();
	}

}
