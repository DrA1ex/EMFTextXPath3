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
package org.emftext.language.xpath3.resource.xpath3.grammar;


public class Xpath3Choice extends org.emftext.language.xpath3.resource.xpath3.grammar.Xpath3SyntaxElement {
	
	public Xpath3Choice(org.emftext.language.xpath3.resource.xpath3.grammar.Xpath3Cardinality cardinality, org.emftext.language.xpath3.resource.xpath3.grammar.Xpath3SyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.language.xpath3.resource.xpath3.util.Xpath3StringUtil.explode(getChildren(), "|");
	}
	
}
