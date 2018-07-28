package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> cbStartPoint;
	private JComboBox<String> cbDestination;
	private JComboBox<String> cbAlgorithm;
	
	public void setComboBoxes(String[] destinations, String[] Algorithms) {
		
		cbStartPoint.setModel(new DefaultComboBoxModel<String>(destinations));				//sp�ter gegen Knoten Klasse von Julius tauschen
		cbDestination.setModel(new DefaultComboBoxModel<String>(destinations));	
		cbAlgorithm.setModel(new DefaultComboBoxModel<String>(Algorithms)); 
	}
	
	private PictureFrame DrawCanvas;
	private JTextArea textArea;
	
	public void displayResults(ArrayList<Integer> resultList, int minDistance) {								//sp�ter gegen Knoten Klasse tauschen.
		String resultDescription = DrawCanvas.DrawResultRoute(resultList, minDistance);
		textArea.setText(resultDescription);
	}
	
	private JProgressBar prgBar;
	public void displayProgressBar() {
		prgBar.setVisible(true);
	}
	public void stopProgressBar() {
		prgBar.setVisible(false);
	}
	private JTextField TimeNeeded;
	public void setTimeNeeded(int timeNeeded) {
		this.TimeNeeded.setText(String.valueOf(timeNeeded));
	}
	
	private Presenter presenter;
	
	public MainWindow(Presenter presenter) {
		initializeWindow();
		initializeComponents();
		this.presenter = presenter;
	}
	
	private void initializeWindow() {
		this.setTitle("Hierarchischer Routenplaner");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	private void initializeComponents() {
		Container pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
		
		//North:
		JPanel North = new JPanel();
		North.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(BorderLayout.NORTH, North);
		
		cbStartPoint = new JComboBox<String>();
		Dimension cbDim = new Dimension(150, 20);
		cbStartPoint.setPreferredSize(cbDim);
		North.add(cbStartPoint);
		
		cbDestination = new JComboBox<String>();
		cbDestination.setPreferredSize(cbDim);
		North.add(cbDestination);
		
		cbAlgorithm = new JComboBox<String>();
		cbAlgorithm.setPreferredSize(cbDim);
		North.add(cbAlgorithm);
		
		JButton buStart = new JButton("Calculate Route");
		buStart.setPreferredSize(new Dimension(100, 20));
		buStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.StartCalculation((String)cbStartPoint.getSelectedItem(), (String)cbDestination.getSelectedItem(), (String)cbAlgorithm.getSelectedItem());
			}
		});
		North.add(buStart);
		
		//Center:
		JPanel Center = new JPanel();
		GridLayout CenterGrid = new GridLayout(1,2);
		Center.setLayout(CenterGrid);
		pane.add(BorderLayout.CENTER, Center);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("Please Select Your Route");
		JScrollPane scrollPane = new JScrollPane(textArea);
		Center.add(scrollPane);
		
		DrawCanvas =  new PictureFrame("image/Deutschland.png");
		Center.add(DrawCanvas);
		
		
		//South:
		JPanel South = new JPanel();
		South.setLayout(new FlowLayout(2));
		pane.add(BorderLayout.SOUTH, South);
		
		JTextField TimeNeeded = new JTextField();
		Dimension Dim2 = new Dimension(50, 20);
		TimeNeeded.setPreferredSize(Dim2);
		TimeNeeded.setEditable(false);
		TimeNeeded.setText("Empty");
		South.add(TimeNeeded);
		
		prgBar = new JProgressBar();
		prgBar.setIndeterminate(true);
		prgBar.setPreferredSize(cbDim);
		prgBar.setForeground(Color.ORANGE);
		prgBar.setVisible(false);
		South.add(prgBar);
		
		
	}
	
}
