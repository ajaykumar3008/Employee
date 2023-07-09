
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class MyFrame extends Frame {

    ArrayList<Employee> employeeList=new ArrayList<>();
    int currentIndex;
    TextField nameField = new TextField();
    TextField rollField = new TextField();
    TextField salaryField = new TextField();
    TextField departmentField = new TextField();
    TextField jobField = new TextField();
    TextField searchField=new TextField("Enter Id");
    

    public MyFrame() {
        setTitle("Employee Details");
        setSize(500, 400);
        setLayout(null);
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ae){
                System.exit(0);
            }
        });

    
        Label nameLabel = new Label("Name:");
        Label rollLabel = new Label("Roll:");
        Label salaryLabel = new Label("Salary:");
        Label departmentLabel = new Label("Department:");
        Label jobLabel = new Label("Job:");

        nameLabel.setBounds(100, 90, 70, 20);
        rollLabel.setBounds(100, 120, 70, 20);
        salaryLabel.setBounds(100, 150, 70, 20);
        departmentLabel.setBounds(100, 180, 70, 20);
        jobLabel.setBounds(100, 210, 70, 20);
        add(nameLabel);
        add(rollLabel);
        add(salaryLabel);
        add(departmentLabel);
        add(jobLabel);

        nameField.setBounds(180, 90, 150, 20);
        rollField.setBounds(180, 120, 150, 20);
        salaryField.setBounds(180, 150, 150, 20);
        departmentField.setBounds(180, 180, 150, 20);
        jobField.setBounds(180, 210, 150, 20);
        searchField.setBounds(180,50,150,20);
        add(nameField);
        add(rollField);
        add(salaryField);
        add(departmentField);
        add(jobField);
        add(searchField);

	Choice ch=new Choice();
	ch.add("Read");
	ch.add("Write");
	ch.setBounds(30, 45, 70, 30);
	add(ch);
	
	

        Button clearButton = new Button("Clear");
        clearButton.setBounds(320, 290, 70, 30);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                rollField.setText("");
                salaryField.setText("");
                departmentField.setText("");
                jobField.setText("");
		searchField.setText("");
            }
        });
        add(clearButton);

        Button exitButton = new Button("Exit");
        exitButton.setBounds(240, 290, 70, 30);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

        Button nextButton = new Button("Next");
        nextButton.setBounds(160, 250, 70, 30);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		
                if (currentIndex < employeeList.size() - 1) {
                    currentIndex++;
                    displayEmployeeDetails();
                }
            }
        });
        add(nextButton);
	
        Button searchButton = new Button("Search");
        searchButton.setBounds(330, 45, 70, 30);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id=searchField.getText();
		boolean temp=false;
		for(Employee e:employeeList){
			if(id.equals(e.getRoll())){
			     nameField.setText(e.getName());
                	     rollField.setText(e.getRoll());
                 	     salaryField.setText(String.valueOf(e.getSalary()));
                	     departmentField.setText(e.getDepartment());
                	     jobField.setText(e.getJob());
			     temp=true;
			}
			if(temp==false){
				JOptionPane.showMessageDialog(null,"you don't have Access");
			}
            }
	}
        });
        add(searchButton);

        Button addButton = new Button("Add");
        addButton.setBounds(80, 290, 70, 30);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		if((ch.getSelectedItem()).equals("Write")){
                nameField.setText("");
                rollField.setText("");
                salaryField.setText("");
                departmentField.setText("");
                jobField.setText("");
		searchField.setText("");
		}
		else{
			JOptionPane.showMessageDialog(null,"you don't have Access");
		}
            }
        });
        add(addButton);

        Button deleteButton = new Button("Delete");
        deleteButton.setBounds(160, 290, 70, 30);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		
		if((ch.getSelectedItem()).equals("Write")){
                employeeList.remove((currentIndex));
		try {
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Ajay kumar\\newone.txt", false));
        for(Employee emp:employeeList){
        pw.println(emp.getName() + "," + emp.getRoll() + "," + emp.getSalary() + "," + emp.getDepartment() + "," + emp.getJob());
	}
        pw.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
       }
	else{
		JOptionPane.showMessageDialog(null,"you don't have Access");
	}
		
        }
        });
        add(deleteButton);

        Button previousButton = new Button("Previous");
        previousButton.setBounds(240, 250, 70, 30);
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    displayEmployeeDetails();
                }
		
            }
        });
        add(previousButton);

        Button lastButton = new Button("Last");
        lastButton.setBounds(320, 250, 70, 30);
        lastButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = employeeList.size() - 1;
                displayEmployeeDetails();
            }
        });
        add(lastButton);

        Button firstButton = new Button("First");
        firstButton.setBounds(80, 250, 70, 30);
        firstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = 0;
                displayEmployeeDetails();
            }
        });
        add(firstButton);

        Button editButton=new Button("Edit");
        editButton.setBounds(80,330,70,30);
        editButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
	if((ch.getSelectedItem()).equals("Write")){
		Employee e=employeeList.get(0);
		e.setName(nameField.getText());
		e.setRoll(rollField.getText());
		e.setSalary(Double.parseDouble(salaryField.getText()));
		e.setDepartment(departmentField.getText());
		e.setJob(jobField.getText());
		try {
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Ajay kumar\\newone.txt", false));
        for(Employee emp:employeeList){
        pw.println(emp.getName() + "," + emp.getRoll() + "," + emp.getSalary() + "," + emp.getDepartment() + "," + emp.getJob());
	}
        pw.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
	clearForm();
	}
	else{
		JOptionPane.showMessageDialog(null,"you don't have Access");
	}
            }
        });
        add(editButton);

        Button saveButton =new Button("Save");
        saveButton.setBounds(160,330,70,30);
        saveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
	if((ch.getSelectedItem()).equals("Write")){
		double sal=Double.parseDouble(salaryField.getText());
		Employee e=new Employee(nameField.getText(),rollField.getText(),sal,departmentField.getText(),jobField.getText());
		employeeList.add(e);
    try {
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Ajay kumar\\newone.txt", true));
        Employee emp = employeeList.get(employeeList.size() - 1);
        pw.println(emp.getName() + "," + emp.getRoll() + "," + emp.getSalary() + "," + emp.getDepartment() + "," + emp.getJob());
        pw.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
	clearForm();
	JOptionPane.showMessageDialog(null,"Items saved");
	}
	else{
		JOptionPane.showMessageDialog(null,"you don't have Access");
	}
}
        });
        add(saveButton);

    }

    public void loadEmployeeData() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Ajay kumar\\newone.txt"));
        String s;
        while((s=br.readLine())!=null){
            StringTokenizer st=new StringTokenizer(s,",");
            String name=st.nextToken();
            String roll=st.nextToken();
            double salary=Double.parseDouble(st.nextToken());
            String department=st.nextToken();
            String job=st.nextToken();
            Employee emp=new Employee(name,roll,salary,department,job);
            employeeList.add(emp);
        }

    }
	public void clearForm(){
		nameField.setText("");
                rollField.setText("");
                salaryField.setText("");
                departmentField.setText("");
                jobField.setText("");
		searchField.setText("");
	}

    public void displayEmployeeDetails(){
	if(employeeList!=null){
		Employee e=employeeList.get(currentIndex);
		nameField.setText(e.getName());
		rollField.setText(e.getRoll());
		salaryField.setText(String.valueOf(e.getSalary()));
		departmentField.setText(e.getDepartment());
		jobField.setText(e.getJob());
	}
    }


    public static void main(String[] args) throws IOException {
        MyFrame f=new MyFrame();
	f.loadEmployeeData();

    }
}

class Employee {
    private String name;
    private String roll;
    private double salary;
    private String department;
    private String job;

    public Employee(String name, String roll, double salary, String department, String job) {
        this.name = name;
        this.roll = roll;
        this.salary = salary;
        this.department = department;
        this.job = job;
    }

    // Getters 

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getJob() {
        return job;
    }
	public void setName(String name){
		this.name=name;
	}
	public void setRoll(String roll){
		this.roll=roll;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public void setDepartment(String department){
		this.department=department;
	}
	public void setJob(String job){
		this.job=job;
	}

}