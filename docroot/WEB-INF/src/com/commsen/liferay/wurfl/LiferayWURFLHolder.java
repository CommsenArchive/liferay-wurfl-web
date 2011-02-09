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

import net.sourceforge.wurfl.core.CustomWURFLHolder;
import net.sourceforge.wurfl.core.WURFLHolder;
import net.sourceforge.wurfl.core.WURFLManager;
import net.sourceforge.wurfl.core.WURFLUtils;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * This class is responsible for initializing WURFL with database files specified in
 * <code>portal.properties</code>
 * 
 * @author Milen Dyankov
 * 
 */
public class LiferayWURFLHolder implements WURFLHolder {

	private WURFLHolder wurflHolder;


	public void init() {
		String mainFile = PropsUtil.get(WURFL_MAIN);
		String[] patchFiles = PropsUtil.getArray(WURFL_PATCHES);

		if (StringUtils.isBlank(mainFile)) {
			_log.warn("Wurfl NOT initialised! Plase set '" + WURFL_MAIN + "' property!");
			return;
		}

		wurflHolder = new CustomWURFLHolder(mainFile, patchFiles);
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
