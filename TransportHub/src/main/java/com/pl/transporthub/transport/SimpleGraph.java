/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.pl.transporthub.transport;

import java.awt.*;
import javax.swing.*;

public class SimpleGraph extends JFrame {
	
	 private final int WIDTH = 330;
	    private final int HEIGHT = 500;
	    private Container drawable;
	    private JPanel canvas;
	    public SimpleGraph(double[] someData) {
	        super("SimpleGraph");
	        drawable = getContentPane();
	        canvas = new GraphCanvas(someData);
	        drawable.add(canvas);
	        setSize(WIDTH, HEIGHT);
	    }
	    public class GraphCanvas extends JPanel {
	        private double[] data;
	        private int points;
	        private double[] XData;
	        private double[] YData;
	        public GraphCanvas(double[] someData) {
	            super();
	            data = someData;
	            points = data.length / 2;
	            XData = new double[points];
	            YData = new double[points];
	            for(int i = 0; i < points; i++) {
	                XData[i] = data[i * 2];
	                YData[i] = data[i * 2 + 1];
	            }
	        }
	        public void paint(Graphics g) {
	            Graphics2D g2 = (Graphics2D) g;
	            for(int i = 0; i < points - 1; i++) {
	            	
	                int x0 = (int) (XData[i] + 0.5);
	                int x1 = (int) (XData[i + 1] + 0.5);
	                int y0 = (int) (YData[i] +0.5);
	                int y1 = (int) (YData[i + 1] + 0.5);
	                g2.drawLine(x0, y0, x1, y1);
	                if (i == 0)
	                  g2.drawString(("" + x0 + ", " + y0), x0 - 20, y0 + 10);
	                if (i == points - 2)
	                  g2.drawString(("" + x1 + ", " + y1), x1, y1);
	            }
	        }
	    }
	

	    @SuppressWarnings("deprecation")
		public static void main(String[] args) {
	        double[] d = { 30.0, 150.0,
	                       33.0, 145.0,
	                       36.0, 162.0,
	                       39.0, 128.0,
	                       48.0, 114.0,
	                       70.0, 240.0,
	                       81.0, 400.0,
	                      130.0, 450.0,
	                      230.0,  85.0,
	                      255.0,  30.0 };
	        Frame f = new SimpleGraph(d);
	        f.show();
	    }

}
