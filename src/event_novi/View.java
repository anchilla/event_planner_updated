package event_novi;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class View implements ActionListener {

	private JFrame frame;

	private JTextField textFD;
	private Panel jPanel;
	private JButton button;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel labelNorth;
	
	private JLabel typeL;
	private JTextField type;
	private JPanel panelButton2;
	private JButton buttonToGo;
	
	private JComboBox<String> comboDay;
	private JComboBox<String> comboMonth;
	private JComboBox<String> comboYear;
	
	public void createGui() {
		frame=new JFrame();
		
		label1=new JLabel();
		label1.setText("<html><br/> Day:</html");
		label1.setFont(new Font("Serif", Font.ITALIC, 20));
		
		label2=new JLabel();
		label2.setText("<html><br/> Month:</html>");
		label2.setFont(new Font("Serif", Font.ITALIC, 20));
		
		label3=new JLabel();
		label3.setText("<html><br/> Year:</html>");
		label3.setFont(new Font("Serif", Font.ITALIC, 20));
		
		Color c2=new Color(78,78,78);
		labelNorth=new JLabel();
		labelNorth.setText("    Your event reminder:");
		labelNorth.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 26));
		labelNorth.setForeground (c2);
		 EmptyBorder border = new EmptyBorder(20, 20, 5, 20);
		    labelNorth.setBorder(border);
		    
		textFD=new JTextField();
		textFD.setFont(new Font("Serif", Font.PLAIN, 16));
		
		String[] days= {"01", "02", "03", "04", "05","06","07","08","09","10","11","12",
				"13","14","15","16","17","18","19","20","21","22","23","24","25","26",
				"27","29","30","31"};
		comboDay=new JComboBox<>(days);
		comboDay.setSelectedIndex(2);
		
		String[] months= {"01", "02", "03", "04", "05","06","07","08","09","10","11","12"};
		comboMonth=new JComboBox<>(months);
		comboMonth.setSelectedIndex(2);
		comboMonth.setPreferredSize(new Dimension(30, 60));
		
		int y=2021;
		String[] year= {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", 
				"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029",
				"2030"};
		
		comboYear=new JComboBox<>(year);
		comboYear.setSelectedIndex(11);
		
		
		
		typeL=new JLabel();
		typeL.setText("   Type of event:");
		typeL.setFont(new Font("Serif", Font.ITALIC, 20));
		type=new JTextField();
		type.setFont(new Font("Serif", Font.PLAIN, 16));
		buttonToGo=new JButton("See Your Dates");
		buttonToGo.addActionListener(new ButtonListListener());
	
		Color c=new Color(105, 242, 250);
		
		jPanel=new Panel();
		jPanel.setLayout(new GridLayout(3,3,4,4));
		jPanel.add(label1);
		jPanel.add(label2);
		jPanel.add(label3);
		jPanel.add(comboDay);
		jPanel.add(comboMonth);
		jPanel.add(comboYear);
		
		jPanel.add(typeL);
		jPanel.add(type);
		
		button = new JButton("Save Event");
        button.addActionListener(this);
        jPanel.setBorder(new EmptyBorder(10, 10, 50, 10));
		
		Color col=new Color(177, 100, 255);
		panelButton2=new JPanel();
		panelButton2.add(button);
		panelButton2.add(buttonToGo);
		panelButton2.setBackground(col);

		frame.getContentPane().setBackground(c);
		
		frame.add(BorderLayout.NORTH, labelNorth);
		frame.getContentPane().add(BorderLayout.CENTER, jPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, panelButton2);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(550, 350);
        frame.setVisible(true);
	}
	
	List <Events1> events1=new ArrayList<Events1>();
	@SuppressWarnings("unchecked")
	public void fillInList() {
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session=sessionFactory.getCurrentSession();
			session.beginTransaction();
		    
		    String hql = "from Events1";
			Query<Events1> query = session.createQuery(hql);
			events1 = query.list(); 
			
			System.out.println("ispisi listu: fillInList metoda");
			for(int i=0; i<events1.size(); i++) {
				System.out.println(events1.get(i));
			}
			session.getTransaction().commit();
		    
	}
	
	int brojac=0;
	public void poredjenje() {
		System.out.println("METODA poredjenje iz View\n");
		fillInList();
		converttoString();
		
		LocalDate currentDate=LocalDate.now();
		String currentString=currentDate.toString();
		System.out.println(currentDate);
		System.out.println(currentString);
		for(int i=0; i<stringDates.size(); i++) {
			int dveTacke=stringDates.get(i).lastIndexOf(':')+2;
			String samoDatum=stringDates.get(i).substring(dveTacke);
			System.out.println("Samo datum je: "+ samoDatum);
			
			if(samoDatum.equals(currentString) & brojac==0) {
		JOptionPane.showMessageDialog(frame,
			    "You have a an event reminder today! "+stringDates.get(i));
		brojac++;
			}else System.out.println("nisu jednaki");
		}
	}
	
	ArrayList <String> stringDates;
	public void converttoString() {
		System.out.println("METODA convertToString iz View");
		System.out.println("String lista:\n ");
		stringDates=new ArrayList <String>();
		for(int i=0; i<events1.size(); i++) {
			String noviString=events1.get(i).toString();
			stringDates.add(noviString);		
				System.out.println(stringDates.get(i));
			}
	}
	
	public void actionPerformed(ActionEvent event) {
		System.out.println("METODA actionPerformed(save) iz View");
	
		EventsTest et=new EventsTest();
		String boxDay=(String)comboDay.getSelectedItem();
		String boxMonth=(String)comboMonth.getSelectedItem();
		String boxYear=(String)comboYear.getSelectedItem();
		String getType=type.getText();
	
		Events1 e=new Events1(boxDay, boxMonth, boxYear, getType);
		System.out.println("Novi objekat je: "+e);
		
		events1.add(e);
		et.hibernate(boxDay, boxMonth, boxYear, getType);
		
		JOptionPane.showMessageDialog(frame,
			    "Saved!");
		if(brojac==0) {
			poredjenje();
		}
	}

	private Panel panelList;
	private JPanel buttonPanel;
	private JList list;
	private JButton buttonDelete;
	private JButton backButton;
	private JButton calendarClick;
	List<Events1> tableEvents;
	
	@SuppressWarnings("unchecked")
	public void createNewWindow() {
		System.out.println("CREATE NEW WINDOW METODA");
		panelList=new Panel();
		buttonPanel=new JPanel();
		buttonDelete=new JButton();
		buttonDelete.setText("Delete");
		buttonDelete.addActionListener(new ButtonDeleteListener());
		backButton=new JButton();
		backButton.setText("Back");
		backButton.addActionListener(new BackButtonListener());
		calendarClick=new JButton();
		calendarClick.setText("See your calendar");
		calendarClick.addActionListener(new CalendarListener());

	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		
	    String hql = "from Events1";
		Query<Events1> query = session.createQuery(hql);
		tableEvents = query.list(); 
		
		Color c2=new Color(105, 242, 250);
		list=new JList(tableEvents.toArray());
	    list.setSelectedIndex(2);
	    list.setBackground(c2);
	    list.setFont(new Font("ARIAL BLACK", Font.PLAIN, 16));
		
		System.out.println("Size liste je: "+ tableEvents.size());

	    Color col2=new Color(177, 100, 255);
		panelList.add(new JScrollPane(list));
		buttonPanel.add(backButton);
		buttonPanel.add(buttonDelete);
		buttonPanel.add(calendarClick);
		buttonPanel.setBackground(col2);
		
		frame.remove(jPanel);
		frame.remove(panelButton2);
		frame.add(panelList);
		frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
		frame.repaint();
		frame.revalidate();
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Done");
	    
	}

	class ButtonListListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			createNewWindow(); 
		}
	}
	
	class BackButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.remove(panelList);
			frame.remove(buttonPanel);
			frame.getContentPane().add(BorderLayout.CENTER, jPanel);
			frame.getContentPane().add(BorderLayout.SOUTH, panelButton2);
			frame.repaint();
			frame.revalidate();
		}
	}
	
	@SuppressWarnings("unchecked")
	class ButtonDeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("DELETE METODA");
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    session.getTransaction().begin();
		    
		    Events1 e;
		    int index = list.getSelectedIndex();
		    System.out.println("Index Selected: " + index);
		    
		    e = (Events1) list.getSelectedValue();
            System.out.println("Value Selected: " + e);
		    e=(Events1)session.get(Events1.class, e.getId());
		    
		    session.delete(e);
		    
		    //nova lista
		    frame.remove(panelList);
		    panelList=new Panel();
			 String hql = "from Events1";
				Query<Events1> query = session.createQuery(hql);
				tableEvents = query.list(); 
				
				Color c2=new Color(105, 242, 250);
				list=new JList(tableEvents.toArray());
			    list.setSelectedIndex(2);
			    list.setBackground(c2);
			    list.setFont(new Font("ARIAL BLACK", Font.PLAIN, 16));
			    
			    panelList.add(new JScrollPane(list));
			    
				frame.add(panelList);
				frame.repaint();
				frame.revalidate();
		    
		    session.getTransaction().commit();
		    session.close();
		 
		    System.out.println("id od e je: "+e.getId());
		    
		}
	}
	class CalendarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Calendar c=new Calendar();
			c.makeCalendar();
		}
	}
}


