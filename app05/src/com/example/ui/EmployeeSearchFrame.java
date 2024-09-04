package com.example.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.example.pojo.Employee;
import com.example.service.EmployeeService;

public class EmployeeSearchFrame extends Frame implements ActionListener {

	Label l;
	TextField tf;
	Button b;
	Employee emp;
	EmployeeService empService;
	public EmployeeSearchFrame() {
		this.setVisible(true);
		this.setSize(500,500);
		this.setTitle("EMployee Search Frame");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.green);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		l=new Label("Employee Number");
		tf=new TextField(20);
		b=new Button("Search");
		Font font=new Font("consolas", Font.BOLD,20);
		l.setFont(font);
		tf.setFont(font);
		b.setFont(font);
		this.add(l);
		this.add(b);
		this.add(tf);
		empService=new EmployeeService();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    System.out.println("Button clicked"); // Debug print
	    try {
	        int eno = Integer.parseInt(tf.getText());
	        System.out.println("Employee Number Entered: " + eno); // Debug print
	        emp = empService.search(eno);
	        revalidate(); // Ensure the layout is updated

	        repaint(); // Trigger repaint to update UI
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	}

	@Override
	public void paint(Graphics g) {
		Font font=new Font("consolas",Font.BOLD,25);
		g.setFont(font);
		if(emp==null) {
			g.drawString("Employee not existed",50,250);
		}else {
			g.drawString("Employee Number :"+ emp.getEno(), 50, 200);
			g.drawString("Employee Name :"+ emp.getEname(), 50, 200);
			g.drawString("Employee Salary :"+ emp.getEsal(), 50, 200);
			g.drawString("Employee Address :"+ emp.getEaddr(), 50, 200);

		}
	}

}
