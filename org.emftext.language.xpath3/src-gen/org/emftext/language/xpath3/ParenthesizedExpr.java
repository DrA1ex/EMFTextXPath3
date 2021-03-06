/**
 * Copyright (c) 2013, 2014 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parenthesized Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath3.ParenthesizedExpr#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath3.XPath3Package#getParenthesizedExpr()
 * @model
 * @generated
 */
public interface ParenthesizedExpr extends PrimaryExpr {
    /**
     * Returns the value of the '<em><b>Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expr</em>' containment reference.
     * @see #setExpr(ParenthesizedExprChild)
     * @see org.emftext.language.xpath3.XPath3Package#getParenthesizedExpr_Expr()
     * @model containment="true"
     * @generated
     */
    ParenthesizedExprChild getExpr();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath3.ParenthesizedExpr#getExpr <em>Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expr</em>' containment reference.
     * @see #getExpr()
     * @generated
     */
    void setExpr(ParenthesizedExprChild value);

} // ParenthesizedExpr
