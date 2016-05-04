/*
 * 
 * Citrus - A object-oriented, interpreted language that is designed to simplify 
 * the creation of dynamic, immediate feedback graphical desktop applications.
 * 
 * Copyright (c) 2005 Andrew Jensen Ko
 * All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 */
package edu.cmu.hcii.citrus;

public interface DecInterface<ValueType extends Element> extends Element<DecInterface> {
	
	// NAME
	public Text getName();

	// MODIFIERS
	public boolean isStatic();
	public boolean isOverridable();
	public boolean isReferenceOnly();

	// TYPE
	public TypeExpression getTypeExpression();

	// RESTRICTIONS
	public void is(PropertyRestriction<ValueType> newValueSet);
	public Element validate(Property<ValueType> property, ValueType value);
	public Set<ValueType> getValidValues(Property<ValueType> property, Set<ValueType> values);

	// DEFAULT
	public ValueType getDefaultValue(Element newElement);
	public boolean valueIsRecoverable(ValueType value);
	public boolean isParameterized();
	public boolean isConstant();
	public boolean isUndoable();
	public boolean functionIsConstraint();

	// CONSTRAINT
	public Element<ValueType> getValueFunction();	

	// OVERRIDING
	public void setDeclarationOverriden(DecInterface<ValueType> pd);
	public DecInterface<ValueType> getDeclarationOverridden();

	// 
	public Property<ValueType> make(Element owner);
	
}