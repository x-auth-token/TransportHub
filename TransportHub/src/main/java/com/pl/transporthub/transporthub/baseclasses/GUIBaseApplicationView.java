package com.pl.transporthub.transporthub.baseclasses;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pl.transporthub.transporthub.buttons.GUIRoundButton;
import com.pl.transporthub.transporthub.buttons.GUIRoundButtonFactory;

public class GUIBaseApplicationView extends GUIAbstractApplicationView {

	private static final long serialVersionUID = 1L;
	private GUIRoundButton btnBus, btnStation, btnRoute,  btnMap;
	
	private DefaultTableModel tblBusesModel;
	private JTable tblBuses;
	private JScrollPane scrollPane;



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


	/*
	 * public void initFrame() { appFrame = new JFrame();
	 * appFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	 * appFrame.setBounds(100, 100, 655, 442);
	 * appFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	 * appFrame.setUndecorated(true); }
	 */

	/*
	 * public void initContentPaneLayout() { getbrl_contentPane = new
	 * BorderLayout(0, 0); }
	 */
	
	@Override
	public void initComponents() {
		/*
		 * lblLogoLabel = new JLabel("");
		 * lblLogoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		 * lblLogoLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		 * lblLogoLabel.setIcon(new ImageIcon(GUIMainWindowView.class.getResource(
		 * "/images/TransportHubTransparentLogoBWSmall2.png")));
		 */
		super.initComponents();
		btnBus = GUIRoundButtonFactory.getRoundButton("Bus", "BusButton");
		btnStation = GUIRoundButtonFactory.getRoundButton("Station", "StationButton");
		btnRoute = GUIRoundButtonFactory.getRoundButton("Route", "RouteButton");
		btnMap = GUIRoundButtonFactory.getRoundButton("Map", "MapButton");
		
		tblBusesModel = new DefaultTableModel(10, 10);

		tblBuses = new JTable(tblBusesModel);
		tblBuses.setEnabled(false);
		tblBuses.getTableHeader().setReorderingAllowed(false);
	}

	/*
	 * public void initInnerPanel() { innerPanel = new JPanel();
	 * innerPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(51, 102,
	 * 255))); innerPanel.setBackground(new Color(0, 59, 77));
	 * innerPanel.setLayout(new MigLayout("", "[][287px,grow][][][][][][][][][]",
	 * "[]"));
	 * 
	 * initComponents(); }
	 */
	
	@Override
	public void initScrollPane() {
		scrollPane = new JScrollPane(tblBuses);
	}
	
	
	/*
	 * public void initContentPane() { contentPane = new JPanel();
	 * contentPane.setBackground(new Color(222, 224, 224));
	 * contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));
	 * 
	 * initContentPaneLayout(); //initContentPaneConstraints();
	 * 
	 * contentPane.setLayout(brl_contentPane);
	 * 
	 * }
	 */
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

	/*
	 * public void showMainWindowView() { appFrame.setVisible(true); }
	 * 
	 * public JPanel getContentPane() { return contentPane; }
	 */

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
	 * @return the innerPanel
	 */
	/*
	 * public JPanel getInnerPanel() { return innerPanel; }
	 */

	/**
	 * @return the lblLogoLabel
	 */
	/*
	 * public JLabel getLblLogoLabel() { return lblLogoLabel; }
	 */

	/**
	 * @return the brl_contentPane
	 */
	/*
	 * public BorderLayout getBrl_contentPane() { return brl_contentPane; }
	 */

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


	/**
	 * @return the scrollPane
	 */
	/*
	 * public JScrollPane getScrollPane() { return scrollPane; }
	 */

	/**
	 * @return the mapPanel
	 */
	/*
	 * public JPanel getMapPanel() { return mapPanel; }
	 * 
	 * public JFrame getAppFrame() { return appFrame; }
	 */

}


