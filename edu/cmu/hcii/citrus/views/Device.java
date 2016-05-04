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
package edu.cmu.hcii.citrus.views;

import edu.cmu.hcii.citrus.*;

// A device, which is capable of a set of discrete actions, and may
// also have other devices.
public class Device extends BaseElement<Device> {

	public static final Dec<List<Device>> devices = new Dec<List<Device>>(new NewList()); 
	
	// The name of the device
	public static final Dec<Text> name = new Dec<Text>(new Text("unnamed device"));
	
	public Device() {}
	public Device(ArgumentList args) { super(args); }
	public Device(String newName) {

		set(name, new Text(newName));

	}
	
	public void addDevice(Device d) { get(devices).append(d); }
	
	public String toString() { return text(name); }
	
}