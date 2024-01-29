package hr_emp_portal;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Label label = new Label("Update Panel");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 137, 548, 418);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		TextField nametf = new TextField();
		nametf.setBounds(237, 84, 214, 21);
		panel_1.add(nametf);
		
		TextField emailtf = new TextField();
		emailtf.setBounds(237, 135, 214, 21);
		panel_1.add(emailtf);
		
		TextField citytf = new TextField();
		citytf.setBounds(237, 181, 214, 21);
		panel_1.add(citytf);
		
		TextField empid = new TextField();
		empid.setBounds(237, 28, 111, 21);
		panel_1.add(empid);
		
		TextField salarytf = new TextField();
		salarytf.setBounds(237, 223, 214, 21);
		panel_1.add(salarytf);
		
		
		Button button_1 = new Button("Find");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            String empid2 = empid.getText();
			            Connection con;
			            Statement st;
			            ResultSet rs1,rs2,rs3,rs4;
			            

			            String url = "jdbc:mysql://localhost:3306/boat";
			            String driver = "com.mysql.cj.jdbc.Driver";
			            String uname = "root";
			            String password = "847235";
			            Class.forName(driver);
			            con = DriverManager.getConnection(url,uname,password);
			            
			            
			            //Name query
			            String queryname = "select user_name from myuser where user_id='"+empid2+"'";
			            st = con.createStatement();
			            rs1 = st.executeQuery(queryname);
			            
			            String userName = null;
			            
			            if(rs1.next()) {
			            	
			            	userName = rs1.getString("user_name");
			            	nametf.setText(userName);
			            }
			            
			            //Email Query
			            String queryemail = "select user_email from myuser where user_id='"+empid2+"'";
			            st = con.createStatement();
			            rs2 = st.executeQuery(queryemail);
			            
			            String userEmail = null;
			            
			            if(rs2.next()) {
			            	
			            	userEmail = rs2.getString("user_email");
			            	emailtf.setText(userEmail);
			            }
			            
			            //city query
			            String querycity = "select user_city from myuser where user_id='"+empid2+"'";
			            st = con.createStatement();
			            rs3 = st.executeQuery(querycity);
			            
			            String userCity = null;
			            
			            if(rs3.next()) {
			            	
			            	userCity = rs3.getString("user_city");
			            	citytf.setText(userCity);
			            }
			            
			            String querysalary = "select user_salary from myuser where user_id='" + empid2 + "'";
			            rs4 = st.executeQuery(querysalary);

			            int userSalary = 0;
			            
			            if (rs4.next()) {
			                userSalary = rs4.getInt("user_salary");
			                salarytf.setText(String.valueOf(userSalary));
			            }

			            // Close the ResultSet, Statement, and Connection
			            
			            rs1.close();
			            rs2.close();
			            rs3.close();
			            rs4.close();
			            st.close();
			            con.close();

			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			}
		});
		
		button_1.setBackground(SystemColor.activeCaptionBorder);
		button_1.setBounds(384, 28, 67, 21);
		panel_1.add(button_1);
		
		Label label_1 = new Label("Enter ID:");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(86, 26, 77, 21);
		panel_1.add(label_1);
		
		Label label_1_1 = new Label("Name:");
		label_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_1.setBounds(86, 84, 77, 21);
		panel_1.add(label_1_1);
		
		Label label_1_2 = new Label("Email:");
		label_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_2.setBounds(86, 135, 77, 21);
		panel_1.add(label_1_2);
		
		Label label_1_3 = new Label("City:");
		label_1_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_3.setBounds(86, 181, 77, 21);
		panel_1.add(label_1_3);
		
		Label label_1_4 = new Label("Salary:");
		label_1_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_4.setBounds(86, 223, 77, 21);
		panel_1.add(label_1_4);
		
		Button button_2 = new Button("Cancal");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new Home().setVisible(true);
				dispose();
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Dialog", Font.BOLD, 12));
		button_2.setBackground(SystemColor.textHighlight);
		button_2.setBounds(194, 342, 134, 31);
		panel_1.add(button_2);
		
		Button button = new Button("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				String ename , ecity ,email, empid2 ;
				int esalary;
				
	            Connection conn;
	            Statement stt;
	            
	                empid2 = empid.getText(); 
		            ename = nametf.getText();
		            ecity = citytf.getText();
		            email = emailtf.getText();
		            esalary = Integer.parseInt(salarytf.getText());
		            
		            String url = "jdbc:mysql://localhost:3306/boat";
		            String driver = "com.mysql.cj.jdbc.Driver";
		            String uname = "root";
		            String password = "847235";
		            Class.forName(driver);
		            conn = DriverManager.getConnection(url,uname,password);
		            
                    String query = "update myuser set user_name='"+ename+"', user_city='"+ecity+"', user_email='"+email+"', user_salary='"+esalary+"' where user_id='"+empid2+"'";
		            stt = conn.createStatement();
		            int i = stt.executeUpdate(query);
		            
		            if(i>0)
		            {
		                JOptionPane.showMessageDialog(null, "Account Updated...!!!");
		                new Home().setVisible(true);
		                dispose();
		            }
		            else
		            {
		                JOptionPane.showMessageDialog(null, "Bad Request...!!!");
		            }
		            

		            // Close the ResultSet, Statement, and Connection
		            
		   
		            stt.close();
		            conn.close();
		            
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, ex.getMessage());
				}
		            
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(194, 283, 134, 31);
		panel_1.add(button);
		
		
		
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 10, 548, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(181, 0, 191, 62);
		panel.add(label);
	}
}
