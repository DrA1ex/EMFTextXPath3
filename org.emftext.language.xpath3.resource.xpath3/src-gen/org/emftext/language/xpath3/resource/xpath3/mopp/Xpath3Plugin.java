/**
 * Copyright (c) 2013, 2015 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath3.resource.xpath3.mopp;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * A singleton class for the text resource plug-in.
 */
public class Xpath3Plugin extends Plugin {
	
	public static final String PLUGIN_ID = "org.emftext.language.xpath3.resource.xpath3";
	/**
	 * The version of EMFText that was used to generate this plug-in.
	 */
	public static final String EMFTEXT_SDK_VERSION = "1.4.1";
	/**
	 * The ID of the extension point to register default options to be used when
	 * loading resources with this plug-in.
	 */
	public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + ".default_load_options";
	public static final String EP_ADDITIONAL_EXTENSION_PARSER_ID = PLUGIN_ID + ".additional_extension_parser";
	public static final String DEBUG_MODEL_ID = PLUGIN_ID + ".debugModel";
	
	private static Xpath3Plugin plugin;
	
	public Xpath3Plugin() {
		super();
	}
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}
	
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public static Xpath3Plugin getDefault() {
		return plugin;
	}
	
	/**
	 * <p>
	 * Helper method for error logging.
	 * </p>
	 * 
	 * @param message the error message to log
	 * @param throwable the exception that describes the error in detail (can be null)
	 * 
	 * @return the status object describing the error
	 */
	public static IStatus logError(String message, Throwable throwable) {
		return log(IStatus.ERROR, message, throwable);
	}
	
	/**
	 * <p>
	 * Helper method for logging warnings.
	 * </p>
	 * 
	 * @param message the warning message to log
	 * @param throwable the exception that describes the warning in detail (can be
	 * null)
	 * 
	 * @return the status object describing the warning
	 */
	public static IStatus logWarning(String message, Throwable throwable) {
		return log(IStatus.WARNING, message, throwable);
	}
	
	/**
	 * <p>
	 * Helper method for logging infos.
	 * </p>
	 * 
	 * @param message the info message to log
	 * @param throwable the exception that describes the info in detail (can be null)
	 * 
	 * @return the status object describing the info
	 */
	public static IStatus logInfo(String message, Throwable throwable) {
		return log(IStatus.INFO, message, throwable);
	}
	
	/**
	 * <p>
	 * Helper method for logging.
	 * </p>
	 * 
	 * @param type the type of the message to log
	 * @param message the message to log
	 * @param throwable the exception that describes the error in detail (can be null)
	 * 
	 * @return the status object describing the error
	 */
	protected static IStatus log(int type, String message, Throwable throwable) {
		IStatus status;
		if (throwable != null) {
			status = new Status(type, Xpath3Plugin.PLUGIN_ID, 0, message, throwable);
		} else {
			status = new Status(type, Xpath3Plugin.PLUGIN_ID, message);
		}
		final Xpath3Plugin pluginInstance = Xpath3Plugin.getDefault();
		if (pluginInstance == null) {
			System.err.println(message);
			if (throwable != null) {
				throwable.printStackTrace();
			}
		} else {
			pluginInstance.getLog().log(status);
		}
		return status;
	}
	
}
