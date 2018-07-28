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
	private JTextField  TimeNeeded;
	
	public void displayResults(ArrayList<Integer> resultList, int minDistance, double timeNeedForCalc) {								//sp�ter gegen Knoten Klasse tauschen.
		String resultDescription = DrawCanvas.DrawResultRoute(resultList, minDistance);
		textArea.setText(resultDescription);
		this.TimeNeeded.setText(timeNeedForCalc + " Seconds");
		
	}
	
	private JProgressBar prgBar;
	public void displayProgressBar() {
		prgBar.setVisible(true);
	}
	public void stopProgressBar() {
		prgBar.setVisible(false);
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
		
		JLabel laStartP = new JLabel("Select your Start:");
		Dimension dim = new Dimension(170, 20);
		North.add(laStartP);
		cbStartPoint = new JComboBox<String>();
		cbStartPoint.setPreferredSize(dim);
		North.add(cbStartPoint);
		
		JLabel laDest= new JLabel("Select your Destination:");
		North.add(laDest);
		cbDestination = new JComboBox<String>();
		cbDestination.setPreferredSize(dim);
		North.add(cbDestination);
		
		JLabel laAlgo = new JLabel("Select Algorithm to calculate:");
		North.add(laAlgo);
		cbAlgorithm = new JComboBox<String>();
		cbAlgorithm.setPreferredSize(dim);
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
		
		//inner Box:
		Box innerBox = Box.createVerticalBox();
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("Please Select Your Route");
		Dimension ScrollPaneDim = new Dimension(585, 600);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(ScrollPaneDim);
		innerBox.add(scrollPane);
		
		PictureFrame test = new PictureFrame("image/six-Werbung.png");
		Dimension TestDim = new Dimension(585, 100);
		test.setPreferredSize(TestDim);
		innerBox.add(test);
		
		Center.add(innerBox);
		//end inner Box
		
		DrawCanvas =  new PictureFrame("image/Deutschland.png");
		Center.add(DrawCanvas);
		//end Center
		
		//South:
		JPanel South = new JPanel();
		South.setLayout(new FlowLayout(2));
		pane.add(BorderLayout.SOUTH, South);
		
		JLabel laTimeNeeded = new JLabel("Calculation lasted: ");
		South.add(laTimeNeeded);
		
		TimeNeeded = new JTextField();
		Dimension Dim2 = new Dimension(100, 20);
		TimeNeeded.setPreferredSize(Dim2);
		TimeNeeded.setEditable(false);
		TimeNeeded.setText("Empty");
		South.add(TimeNeeded);
		
		prgBar = new JProgressBar();
		prgBar.setIndeterminate(true);
		prgBar.setPreferredSize(dim);
		prgBar.setForeground(Color.ORANGE);
		prgBar.setVisible(false);
		South.add(prgBar);
		
		
	}
	
}
