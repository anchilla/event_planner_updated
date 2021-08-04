package event_novi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Calendar {

	private JTable table;
	private JLabel lblMonth, lblYear, lblEventText;
	private JButton btnPrev, btnNext;
	private JComboBox<String> cmbYear;
	private JFrame frame;
	private DefaultTableModel dtModel;
	private JPanel calendar;
	private int nowDay, nowMonth, nowYear, currentMonth, currentYear;
	
	public void makeCalendar() {
		dateFromDatabase();
		
		frame= new JFrame("Calendar application");
		lblMonth = new JLabel ("January");
		lblYear = new JLabel ("Change year:");
		lblEventText=new JLabel ();
		cmbYear = new JComboBox<>();
		cmbYear.addActionListener(new Combo());
		btnPrev = new JButton ("<<");
		btnPrev.addActionListener(new ButtonPrev());
		btnNext = new JButton (">>");
		btnNext.addActionListener(new ButtonNext());
		

		String[] header={"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		dtModel = new DefaultTableModel();
		dtModel.setColumnCount(7);
		dtModel.setRowCount(6);
		 for(int i=0; i<7; i++) {
		dtModel.setValueAt(header[i], 0, i);
		 }
	
	        
	        GregorianCalendar gregDate=new GregorianCalendar();
	        nowYear=gregDate.get(GregorianCalendar.YEAR);
	        nowMonth=gregDate.get(GregorianCalendar.MONTH);
	        nowDay=gregDate.get(GregorianCalendar.DAY_OF_MONTH);
	        currentMonth=nowMonth;
	        currentYear=nowYear;

		table = new JTable(dtModel);
		table.setColumnSelectionAllowed(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(38);
		table.setBorder(BorderFactory.createLineBorder(Color.GRAY)); 

		 newCalendar(nowMonth, nowYear);
		 
		 for(int i=nowYear-100; i<nowYear+100; i++) {
	    	  cmbYear.addItem(String.valueOf(i));
	    	  
	      }
		 cmbYear.setEditable(true);
		 cmbYear.setSelectedItem(nowYear);
		 cmbYear.setEditable(false);
		
		calendar = new JPanel(null); 
		calendar.setBorder(BorderFactory.createTitledBorder("Calendar")); 
		calendar.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
		calendar.add(lblMonth);
		calendar.add(lblYear);
	     calendar.add(cmbYear);
		calendar.add(table);
		 calendar.add(btnPrev);
		 calendar.add(btnNext);
		 calendar.add(lblEventText);
		 
		frame.getContentPane().add(BorderLayout.CENTER, calendar);
        frame.setSize(620, 450);
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

	}
	
	public class ButtonPrev implements ActionListener{
		
	//povecavanje meseca
	public void actionPerformed(ActionEvent e) {
		
		   if (currentMonth == 0){ 
			               currentMonth = 11;
			               currentYear -= 1;
			           }
			           else{ 
			               currentMonth -= 1;
			           }
			        
		   System.out.println("current month: "+currentMonth +" godina: "+currentYear);
		   newCalendar(currentMonth, currentYear);
		   cmbYear.setEditable(true);
			 cmbYear.setSelectedItem(currentYear);
			 cmbYear.setEditable(false);
	}
	}
	
	public class ButtonNext implements ActionListener{
		
	
	//povecavanje meseca
	public void actionPerformed(ActionEvent e) {

		   if (currentMonth == 11){ 
			               currentMonth = 0;
			               currentYear += 1;
			           }
			           else{ 
			               currentMonth += 1;
			           }

		   System.out.println("current month: "+currentMonth +" godina: "+currentYear);
		   newCalendar(currentMonth, currentYear);
		   cmbYear.setEditable(true);
			 cmbYear.setSelectedItem(currentYear);
			 cmbYear.setEditable(false);
	}
	}

	public class Combo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			 if (cmbYear.getSelectedItem() != null){

			String a=cmbYear.getSelectedItem().toString();
			currentYear=Integer.parseInt(a);
			newCalendar(currentMonth, currentYear);
		}
	}
	}
	public void newCalendar(int month, int year) {
		
		String[] months= {"January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December"};
		lblMonth.setText(months[month]);
		
		//isprazni kalendar
		for (int k=1; k<6; k++){
			    for (int j=0; j<7; j++){
			        dtModel.setValueAt(null, k, j);
			    }
	 
		//punjenje kalendara
		 GregorianCalendar gregD=new GregorianCalendar(year, month, 1);
	        int daysInMonth=gregD.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		  int row=1;
	        int column=0;
	        int[] prim={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,
	        		28,29,30,31};
	        for(int i=0; i<daysInMonth; i++) {
	        	if(column>6) {
	        		column=0;
	        		row++;
	        	}
	        	
	        	dtModel.setValueAt(Integer.toString(prim[i]), row, column);
	        	column++;
	        }
	}
		table.setDefaultRenderer(table.getColumnClass(0), new Rendererr()); 

}
	
	public class Rendererr extends DefaultTableCellRenderer{

	
		private static final long serialVersionUID = 1L;

		 public Component getTableCellRendererComponent (JTable table,
				 Object value, boolean selected, boolean focused, int row, int column){
			 
			 super.getTableCellRendererComponent(table, value, selected, focused, row, column);
			             if (column == 6 || column == 5){ 
			                 setBackground(new Color(252, 152, 182));
			                 if(selected) lblEventText.setText("");
			                 		
			             }
			             else{ 
			                 setBackground(new Color(255, 255, 255));
			                 if(selected) lblEventText.setText("");
			             }
			             if (value != null && row>=1){
			                 if (Integer.parseInt(value.toString()) == nowDay && currentMonth == nowMonth && 
			                		 currentYear == nowYear){ 
			                     setBackground(new Color(220, 220, 255));
			                     if(selected) lblEventText.setText("today");
			                     
			                 }
			                 for(int i=0; i<onlyDate.size(); i++) {
					 				String dans=onlyDate.get(i).substring(8);
					 				int dan=Integer.parseInt(dans);
					 				String mesecS=onlyDate.get(i).substring(5, 7);
					 				int mesec=Integer.parseInt(mesecS)-1;
					 				String godinaS=onlyDate.get(i).substring(0, 4);
					 				int godina=Integer.parseInt(godinaS);
					 				if(Integer.parseInt(value.toString()) == dan &&
					 						mesec==currentMonth && godina==currentYear)
					 				{
					 					 setBackground(new Color(99, 215, 96));
					 					 //uzmi iz opisaE
					 					 String o=opisiE.get(i);
					 					 if(selected) lblEventText.setText(o);
					 				}
					 			}
			             }
			             table.setRowSelectionAllowed(true);
			 return this;
		 }
	}
	
	 ArrayList <String> onlyDate=new ArrayList<String>();
	 List <Events1> events1=new ArrayList<Events1>();
	 List <String> opisiE=new ArrayList<String>();
	 
	@SuppressWarnings("unchecked")
	public void dateFromDatabase() {
		String samoDatum= new String();
		String opis=new String();
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session=sessionFactory.getCurrentSession();
			session.beginTransaction();
		    
		    String hql = "from Events1";
			Query<Events1> query = session.createQuery(hql);
			events1 = query.list(); 
			
			System.out.println("ispisi listu: dateFromDatabase metoda");
			for(int i=0; i<events1.size(); i++) {
		
				String d=events1.get(i).toString();
					int dveTacke=d.lastIndexOf(':')+2;
					samoDatum=d.substring(dveTacke);
					onlyDate.add(samoDatum);
					opis=d.substring(0, dveTacke-2);
					opisiE.add(opis);
					System.out.println("Samo opis: "+ opis);
					System.out.println("Samo datum je: "+ samoDatum);
					System.out.println("Only date lista je: "+ onlyDate.get(i));
			}
			session.getTransaction().commit();
			
			}
			
	}
