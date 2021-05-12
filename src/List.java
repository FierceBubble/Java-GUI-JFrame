import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class List extends JFrame{

	public List(){

		super("Police DataBase");
		setLayout (new FlowLayout());

		//add(one);
		setSize(450,450);
		setVisible(false);
		setLocationRelativeTo(null);

		//Create Tabbed pane
		JTabbedPane jtp=new JTabbedPane();
		jtp.addTab("Case", new CasePanel());
		jtp.addTab("Crime", new CrimePanel());
		jtp.addTab("FIR",new FIRPanel());
		jtp.addTab("Complaint",new ComplaintPanel());
		jtp.addTab("User",new UserPanel());
		add(jtp);


	}

	class CasePanel extends JPanel implements ActionListener{
		public JButton choose;
		public CasePanel(){
			choose=new JButton("On-Going");
			choose.addActionListener(this);
			add(choose);
			choose=new JButton("Past");
			choose.addActionListener(this);
			add(choose);
			choose=new JButton("Records");
			choose.addActionListener(this);
			add(choose);
			choose=new JButton("New");
			choose.addActionListener(this);
			add(choose);
			choose=new JButton("Add");
			choose.addActionListener(this);
			add(choose);

		}
		public void actionPerformed(ActionEvent ae){

			String string =ae.getActionCommand();
			if(string.equals("On-Going")){
				Case_DB record=new Case_DB();
				record.setTitle("On-Going Case");
				record.setVisible(true);
				record.setSize(480,480);
				record.setLocationRelativeTo(null);
			}else if(string.equals("Past")){
				Case_DB record=new Case_DB();
				record.setTitle("Past Case");
				record.setVisible(true);
				record.setSize(480,480);
				record.setLocationRelativeTo(null);
			}else if(string.equals("Records")){
				Case_DB record=new Case_DB();
				record.setTitle("Curent Case Records");
				record.setVisible(true);
				record.setSize(480,480);
				record.setLocationRelativeTo(null);
			}else if(string.equals("New")){
				Case_DB New=new Case_DB();
				New.setTitle("New Case");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Add")){
				addCase_DB add=new addCase_DB();
				add.setTitle("Add Case");
				add.setSize(480,480);
				add.setVisible(true);
				add.setLocationRelativeTo(null);
			}
		}

	}
	class CrimePanel extends JPanel implements ActionListener{
		public JButton b1;
		public CrimePanel(){
			b1=new JButton("On-Going");
			b1.addActionListener(this);
			add(b1);
			b1=new JButton("Past");
			b1.addActionListener(this);
			add(b1);
			b1=new JButton("Records");
			b1.addActionListener(this);
			add(b1);
			b1=new JButton("New");
			b1.addActionListener(this);
			add(b1);
			JButton b1=new JButton("Add");
			b1.addActionListener(this);
			add(b1);
		}
		public void actionPerformed(ActionEvent ae){
			String string =ae.getActionCommand();
			if(string.equals("On-Going")){
				Crime_DB New=new Crime_DB();
				New.setTitle("On-Going Crime");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Past")){
				Crime_DB New=new Crime_DB();
				New.setTitle("Past Crime");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Records")){
				Crime_DB New=new Crime_DB();
				New.setTitle("Current Crime Records");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("New")){
				Crime_DB New=new Crime_DB();
				New.setTitle("New Crime");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Add")){
				addCrime_DB add=new addCrime_DB();
				add.setTitle("Add Case");
				add.setSize(480,480);
				add.setVisible(true);
				add.setLocationRelativeTo(null);
			}
		}

	}
	class FIRPanel extends JPanel implements ActionListener{
		public JButton b1;
		public FIRPanel(){
			b1=new JButton("On-Going");
			b1.addActionListener(this);
			add(b1);
			b1=new JButton("Past");
			b1.addActionListener(this);
			add(b1);
			b1=new JButton("Records");
			b1.addActionListener(this);
			add(b1);
			b1=new JButton("New");
			b1.addActionListener(this);
			add(b1);
			JButton b1=new JButton("Add");
			b1.addActionListener(this);
			add(b1);

		}
		public void actionPerformed(ActionEvent ae){
			String string =ae.getActionCommand();
			if(string.equals("On-Going")){
				FIR_DB New=new FIR_DB();
				New.setTitle("On-Going FIR");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Past")){
				FIR_DB New=new FIR_DB();
				New.setTitle("Past FIR");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Records")){
				FIR_DB New=new FIR_DB();
				New.setTitle("Current FIR Records");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("New")){
				FIR_DB New=new FIR_DB();
				New.setTitle("New FIR");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Add")){
				addFIR_DB add=new addFIR_DB();
				add.setTitle("Add FIR");
				add.setSize(480,480);
				add.setVisible(true);
				add.setLocationRelativeTo(null);
			}
		}

	}
	class ComplaintPanel extends JPanel implements ActionListener{
		public JButton b1;
		public ComplaintPanel(){
			b1=new JButton("On-Going");
			b1.addActionListener(this);
			add(b1);
			b1=new JButton("Past");
			b1.addActionListener(this);
			add(b1);
			b1=new JButton("Records");
			b1.addActionListener(this);
			add(b1);
			b1=new JButton("New");
			b1.addActionListener(this);
			add(b1);
			JButton b1=new JButton("Add");
			b1.addActionListener(this);
			add(b1);

		}
		public void actionPerformed(ActionEvent ae){
			String string =ae.getActionCommand();
			if(string.equals("On-Going")){
				Complaints_DB New=new Complaints_DB();
				New.setTitle("On-Going Complaints");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Past")){
				Complaints_DB New=new Complaints_DB();
				New.setTitle("Past Complaints");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Records")){
				Complaints_DB New=new Complaints_DB();
				New.setTitle("Curronts Complaints Records");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("New")){
				Complaints_DB New=new Complaints_DB();
				New.setTitle("New Complaints");
				New.setVisible(true);
				New.setSize(480,480);
				New.setLocationRelativeTo(null);
			}else if(string.equals("Add")){
				addComplaints_DB add=new addComplaints_DB();
				add.setTitle("Add Complaints");
				add.setSize(480,480);
				add.setVisible(true);
				add.setLocationRelativeTo(null);
			}
		}

	}
	class UserPanel extends JPanel implements ActionListener{
		public JButton choose;

		public UserPanel (){
			choose=new JButton("List");
			choose.addActionListener(this);
			add(choose);
			choose=new JButton("Add");
			choose.addActionListener(this);
			add(choose);
			choose=new JButton("Check");
			choose.addActionListener(this);
			add(choose);


		}
		public void actionPerformed(ActionEvent ae){

			String string =ae.getActionCommand();
			if(string.equals("Add")){
				NewUser newu=new NewUser();
				newu.setSize(450,450);
				newu.setVisible(true);

			}else if (string.equals("List")){
				ListofUser f=new ListofUser();

				f.setVisible(true);
				f.setSize(480,480);
				f.setLocationRelativeTo(null);
			}else if(string.equals("Check")){


			}

		}

	}


}

