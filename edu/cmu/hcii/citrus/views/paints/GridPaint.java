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
package edu.cmu.hcii.citrus.views.paints;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

import edu.cmu.hcii.citrus.*;
import edu.cmu.hcii.citrus.views.*;


public class GridPaint extends Paint {
	
	public static final Dec<Real> step = new Dec<Real>(new Real(5.0));

	public GridPaint(ArgumentList arguments) { super(arguments); }
	public GridPaint(Color newColor, double newAlpha, double newStepSize) {

		super(newColor, newColor, newAlpha, 0, 0, 0, 0);
		set(step, new Real(newStepSize));
		
	}
		
	// Paints the tile's padded bounds
	public Rectangle getPaintBounds(double l, double t, double r, double b) { return new Rectangle((int)l, (int)t, (int)(r - l), (int)(b - r)); }
		
	public void paint(Graphics2D g, View v, double l, double t, double r, double b) {

		java.awt.Color oldColor = g.getColor();
		AlphaComposite oldComposite = (AlphaComposite)g.getComposite();
		Stroke oldStroke = g.getStroke();

		// Set the stroke
		g.setStroke(new BasicStroke(1.0f, java.awt.BasicStroke.CAP_BUTT, java.awt.BasicStroke.JOIN_MITER));
		g.setColor(get(primaryColor).getVisibleColor());
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)getVisible(alpha) * oldComposite.getAlpha()));

		int xOff = 0;//-(int)g.getTransform().getTranslateX();
		int yOff = 0;//(int)g.getTransform().getTranslateY();
		
		int top = (int)t + yOff;
		int bottom = (int)b + yOff;
		int left = (int)l + xOff;
		int right = (int)r + xOff;
		int stepInt = (int)getVisible(step);
		
		for(double x = left; x < right; x += stepInt)
			g.drawLine((int)x, top, (int)x, bottom);
		for(double y = top; y < bottom; y += stepInt)
			g.drawLine(left, (int)y, right, (int)y);		
		
		g.setComposite(oldComposite);
		g.setColor(oldColor);
		g.setStroke(oldStroke);
		
	}

	
}
