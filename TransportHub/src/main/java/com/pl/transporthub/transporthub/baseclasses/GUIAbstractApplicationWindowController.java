package com.pl.transporthub.transporthub.baseclasses;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

public abstract class GUIAbstractApplicationWindowController {
	protected GUIBaseApplicationView baseWindowView;

	protected GUICustomCloseApplication closeApplication;

	public GUIAbstractApplicationWindowController() {
		baseWindowView = new GUIBaseApplicationView();
		setActionListeners();
	}
	
	public void initAppView() {
		
	}
	
	public void setActionListeners() {
		closeApplication = new GUICustomCloseApplication();
		
		  baseWindowView.getContentPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW
		  ).put(KeyStroke.getKeyStroke("shift ctrl pressed E"),"Exit");
		  baseWindowView.getContentPane().getActionMap().put("Exit", closeApplication);
		 
		
	}

	public void setMouseListeners() {


		baseWindowView.getBtnBus().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		baseWindowView.getBtnStation().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		baseWindowView.getBtnRoute().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		baseWindowView.getBtnMap().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}



	/**
	 * @return the mainWindowView
	 */
	public GUIBaseApplicationView getBaseApplicationView() {
		return baseWindowView;
	}


	public void start() {
		baseWindowView.showAppWindowView();
	}

}
