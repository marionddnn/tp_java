package lecteur_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class fenetre extends JFrame {
	protected JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	protected JLabel text;
	private JToolBar toolBar = new JToolBar();
	private JPanel textPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	protected GridBagConstraints gr = new GridBagConstraints();
	
	
	/* 
	 * initial creation of components.
	*/
	public fenetre() {
		setFrame();
		setgPanel();
		setTextPanel();
		this.gr = new GridBagConstraints();
		this.gr.fill = GridBagConstraints.BOTH;
		setContentPane();
	}
	
	/*
	 * main panel creation.
	 */
	public void setgPanel() {
		setColor(this.panel, Color.white, Color.DARK_GRAY);
		this.panel.setLayout(new GridBagLayout());
		this.panel.setSize(getMaximumSize());
	}
	
	/*
	 * set the location and the size of the frame.
	 */
	
	public void setFrame() {
		this.frame.setLocation(0, 0);
		this.frame.setSize(getMaximumSize());
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * set the content pane.
	 */
	
	public void setContentPane() {
		this.frame.setContentPane(this.panel);
	}
	
	/*
	 * set the panel which will contains the text.
	 */
	public void setTextPanel() {
		this.textPanel = new JPanel();
		this.textPanel.setLayout(new GridLayout(0, 1));
		setColor(textPanel, Color.white, Color.DARK_GRAY);
	}
	
	/*
	 * Set the colors of a component.
	 */
	
	public void setColor(Component component, Color color, Color secondColor) {
		component.setBackground(color);
		component.setForeground(secondColor);
	}
	
	/* 
	 * Set the grid for GridBagConstraints 
	 * @weigthy : height that can be possibly take by a component
	 * @weigthx : width that can be possibly take by a component
	 * @i : set the margins of the grid
	 * @gridy : set the place of the component on the y axe.
	 */
	
	public void setGrid(int weighty, int weigthx, int i, int gridy) {
		this.gr.weighty = weighty;
		this.gr.weightx = weigthx;
		this.gr.insets = new Insets(i,i,i,i);
		this.gr.gridy = gridy;
	}
	
	/*
	 * Take a line and separate it in parts in function of the maxCharacters.
	 */
	public void splitLine(String line, int maxCharacters) {
		while(line.length() >= maxCharacters) {
			String lineSplit = line.substring(0, maxCharacters);
			line = line.replace(lineSplit, "");
			addText(lineSplit);
		}
		addText(line);
	}
	
	public void addText(String line) {
		Font Font = frame.getFont();
		int charSize = Font.getSize();
		int maxCharacters =  this.panel.getWidth()/(charSize/2);

		if (line.length() <= maxCharacters) {
			text = new JLabel();
			text.setText(line);
			this.textPanel.add(text);
			setGrid(49, 1, 5, 1);
			addToPanel(this.textPanel);
			setContentPane();
		}
		else {
			splitLine(line, maxCharacters);
		}
	}
	
	public void removeText() {
		if(this.textPanel != null) {
		this.textPanel.removeAll();
		this.frame.getContentPane().remove(this.textPanel);
		}
	}
	
	public void addToolbar() {
		this.buttonPanel.add(this.toolBar);
		this.gr.anchor = GridBagConstraints.PAGE_START;
		setGrid(1, 1, 0, 0);
		addToPanel(this.buttonPanel);
		setContentPane();
	}
	
	public void addButton(JButton nomButton) {
		setColor(nomButton, Color.DARK_GRAY, Color.white);
		this.toolBar.add(nomButton);
	}
	
	public void addToPanel(Component component) {
		this.panel.add(component, this.gr);
	}
	
	public void voirFenetre() {
		
		this.frame.setVisible(true);
	}
}
