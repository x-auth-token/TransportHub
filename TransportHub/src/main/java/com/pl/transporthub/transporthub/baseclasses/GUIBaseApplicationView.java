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
package com.pl.transporthub.transporthub.baseclasses;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.pl.transporthub.transporthub.buttons.GUIRoundButton;
import com.pl.transporthub.transporthub.buttons.GUIRoundButtonFactory;

public class GUIBaseApplicationView extends GUIAbstractApplicationView {

	private static final long serialVersionUID = 1L;
	private GUIRoundButton btnBus, btnStation, btnRoute,  btnMap;
	
	private DefaultTableModel tblBusesModel;
	private JTable tblBuses;
	private JScrollPane scrollPane;
	private DefaultTableCellRenderer tblCellRenderer;



	/**
	 * Create the frame.
	 */
	public GUIBaseApplicationView() {

		super();
		//initFrame();
		//initInnerPanel();
		initScrollPane();
		//initContentPane();
		setUpMainWindowView();

	}

	
	@Override
	public void initComponents() {
		
		super.initComponents();
		btnBus = GUIRoundButtonFactory.getRoundButton("Bus", "BusButton");
		btnStation = GUIRoundButtonFactory.getRoundButton("Station", "StationButton");
		btnRoute = GUIRoundButtonFactory.getRoundButton("Route", "RouteButton");
		btnMap = GUIRoundButtonFactory.getRoundButton("Map", "MapButton");
		
		//tblBusesModel = new DefaultTableModel(10, 10);

		tblBuses = new JTable(tblBusesModel);
		tblBuses.setEnabled(false);
		tblBuses.getTableHeader().setReorderingAllowed(false);
		tblCellRenderer = (DefaultTableCellRenderer) tblBuses.getDefaultRenderer(Object.class);
		tblCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	}

	
	
	@Override
	public void initScrollPane() {
		scrollPane = new JScrollPane(tblBuses);
	}
	
	
	
	@Override
	public void setUpMainWindowView() {
		//innerPanel.add(lblLogoLabel, "cell 0 0,alignx left,aligny center");
		super.setUpMainWindowView();
		getInnerPanel().add(btnBus, "flowx,cell 1 0,alignx center,aligny center");
		getInnerPanel().add(btnStation, "cell 1 0,alignx center,aligny center");
		getInnerPanel().add(btnRoute, "cell 1 0,alignx center,aligny center");
		getInnerPanel().add(btnMap, "cell 1 0,alignx center");
		//innerPanel.add(btnLogin, "cell 2 0, align center");
		getContentPane().add(getInnerPanel(), BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getAppFrame().setContentPane(getContentPane());
	

	}


	public GUIRoundButton getBtnBus() {
		return btnBus;
	}


	public GUIRoundButton getBtnStation() {
		return btnStation;
	}


	public GUIRoundButton getBtnRoute() {
		return btnRoute;
	}


	public GUIRoundButton getBtnMap() {
		return btnMap;
	}

	
	/**
	 * @return the tblBusesModel
	 */
	public DefaultTableModel getTblBusesModel() {
		return tblBusesModel;
	}


	/**
	 * @return the tblBuses
	 */
	public JTable getTblBuses() {
		return tblBuses;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}


