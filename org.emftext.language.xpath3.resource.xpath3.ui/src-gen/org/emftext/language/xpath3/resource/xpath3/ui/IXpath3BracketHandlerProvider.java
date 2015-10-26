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
package org.emftext.language.xpath3.resource.xpath3.ui;


/**
 * A provider for BracketHandler objects.
 */
public interface IXpath3BracketHandlerProvider {
	
	/**
	 * Returns the bracket handler.
	 */
	public org.emftext.language.xpath3.resource.xpath3.ui.IXpath3BracketHandler getBracketHandler();
	
}
