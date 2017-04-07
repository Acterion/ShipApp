package App;

import java.awt.EventQueue;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class ShipWindow {
	protected String ThirdScreen = " ";
	protected int ScreenSizeX = 1000;
	protected int ScreenSizeY = 1000;
	protected int Xcoor = 154; //|
	protected int Ycoor = 154;//Write coordinates 
	protected int Zcoor = 154;//|
	private JFrame frame;
	Boolean fukupS =true ;// ���������� �������
	Boolean fukupT = true ; // ���������� �����
	
	private JTextField coorX;//���� ���������	
	private JTextField coorY;//���������� � Xcoor ��� 
	private JTextField coorZ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipWindow window = new ShipWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShipWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, ScreenSizeX, ScreenSizeY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel SecondScreen = new JPanel();
		frame.getContentPane().add(SecondScreen, "SecondScreen");
		SecondScreen.setLayout(null);
		
	

		
		
		coorX = new JTextField();
		coorX.setEditable(false);
		coorX.setText("0.0");
		coorX.setBounds(295, 561, 86, 20);
		SecondScreen.add(coorX);
		coorX.setColumns(10);
		
		coorY = new JTextField();
		coorY.setText("0.0");
		coorY.setEditable(false);
		coorY.setBounds(445, 561, 86, 20);
		SecondScreen.add(coorY);
		coorY.setColumns(10);
		
		coorZ = new JTextField();
		coorZ.setText("0.0");
		coorZ.setEditable(false);
		coorZ.setBounds(606, 561, 86, 20);
		SecondScreen.add(coorZ);
		coorZ.setColumns(10);
		
		JMenuBar Towers = new JMenuBar();
		Towers.setBounds(440, 5, 47, 21);
		SecondScreen.add(Towers);
		Towers.setBounds(ScreenSizeX/2, ScreenSizeY/2, 80, 20);//������� ��� �������� �������������� ������� ������
		JMenu towers = new JMenu("           ");
		towers.setHorizontalAlignment(SwingConstants.CENTER);
		towers.setEnabled(false);
		Towers.add(towers);
	
		
		JMenuItem t1 = new JMenuItem("Tower1");
		towers.add(t1);
		t1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				towers.setText(t1.getText());
			}
		});
		
		JMenuItem t2 = new JMenuItem("Tower2");
		towers.add(t2);
		t2.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				towers.setText(t2.getText());
			}
		});
		
		JMenuItem t3 = new JMenuItem("Tower3");
		towers.add(t3);
		t3.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				towers.setText(t3.getText());
			}
		});
		
		JMenuItem t4 = new JMenuItem("Tower4");		//correct Tower
		towers.add(t4);
		t4.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				fukupT=false;
				towers.setText(t4.getText());
			}
		});
		
		JMenuItem t5 = new JMenuItem("Tower5");
		towers.add(t5);
		t5.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				towers.setText(t5.getText());
			}
		});
		
		JMenuItem t6 = new JMenuItem("Tower6");
		towers.add(t6);
		t6.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				towers.setText(t6.getText());
			}
		});
		
		JMenuBar Systems = new JMenuBar();
		Systems.setBounds(492, 5, 51, 21);
		SecondScreen.add(Systems);
		Systems.setBounds(ScreenSizeX/2, ScreenSizeY/2-30, 80, 20); //�������������� ������� ������!!!
		
		JMenu systems = new JMenu("systems");
		Systems.add(systems);
		
	
		JMenuItem s1 = new JMenuItem("System1"); //If system incorrect
		systems.add(s1)	;
		s1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				systems.setText(s1.getText());
				towers.setEnabled(true);
			}
			
			
			
		});
		
		JMenuItem s2 = new JMenuItem("System2"); //If system incorrect
		systems.add(s2);
		s2.addActionListener(new ActionListener() {
			
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				systems.setText(s2.getText());
				towers.setEnabled(true);
			}
		
	});
		
		
		JMenuItem s3 = new JMenuItem("System3"); //If system correct
		systems.add(s3);
		s3.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			fukupS=false;
			systems.setText(s3.getText());
			towers.setEnabled(true);
			}
		
				});	
		
		
		
		JButton nextScreen = new JButton("Conect");
		nextScreen.setEnabled(false);
		nextScreen.setBounds(728, 560, 89, 23);
		SecondScreen.add(nextScreen); 
		nextScreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(coorX.getText())==Xcoor&&Integer.parseInt(coorY.getText())==Ycoor)
				{	
					
					CardLayout kk = (CardLayout)frame.getContentPane().getLayout();
					kk.show(frame.getContentPane(), ThirdScreen);
					
				}
				
			}
		});
		
		JButton ifNotFukup = new JButton("Enter");
		ifNotFukup.setBounds(603, 500, 89, 23);
		SecondScreen.add(ifNotFukup);
		
		
		ifNotFukup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(fukupS||fukupT))
				{
					coorX.setEditable(true);
					coorY.setEditable(true);
					coorZ.setEditable(true);	
					nextScreen.setEnabled(true);
				}
				
			}
		}
			
			);
		
		
	}
}