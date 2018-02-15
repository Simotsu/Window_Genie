package Database;

import javafx.beans.property.SimpleStringProperty;

public class Employee{
	 /*
	 Variables are created to enable the referencing of a particular data element.
	 When the data model is outlined in the Customer class, you can create an
	 ObservableList array and define as many data rows as you would like to show in your table
	 */
    private final SimpleStringProperty emFName;
    private final SimpleStringProperty emLName;
    private final SimpleStringProperty emCellNum;
    private final SimpleStringProperty emSecNum;
    private final SimpleStringProperty emEmail;
    private final SimpleStringProperty emAddress;
    private final SimpleStringProperty emCity;
    private final SimpleStringProperty emSalary;
    private final SimpleStringProperty emPosition;

    // Creates a Residential Customer

    public Employee(String fName, String lName,  String cellNum, String secNum, String email, String address, String city,
    		String salary, String position) {
        this.emFName = new SimpleStringProperty(fName);
        this.emLName = new SimpleStringProperty(lName);
        this.emCellNum = new SimpleStringProperty(cellNum);
        this.emSecNum = new SimpleStringProperty(secNum);
        this.emEmail = new SimpleStringProperty(email);
        this.emAddress = new SimpleStringProperty(address);
        this.emCity = new SimpleStringProperty(city);
        this.emSalary = new SimpleStringProperty(salary);
        this.emPosition = new SimpleStringProperty(position);
    }
    
//getters/setters.
    public String getFName() {
        return emFName.get();
    }

    public void setFName(String fName) {
        emFName.set(fName);
    }

    public String getLName() {
        return emLName.get();
    }

    public void setLName(String lName) {
    	emLName.set(lName);
    }
    
    public String getCellNum() {
        return emCellNum.get();
    }

    public void setCellNum(String cellNum) {
    	emCellNum.set(cellNum);
    }

    public String getSecNum() {
        return emSecNum.get();
    }

    public void setSecNum(String secNum) {
    	emSecNum.set(secNum);
    }
    
    public String getEmail() {
        return emEmail.get();
    }

    public void setEmail(String email) {
        emEmail.set(email);
    }
    
    public String getAddress() {
        return emAddress.get();
    }

    public void setAddress(String address) {
    	emAddress.set(address);
    }
    
    public String getCity() {
        return emCity.get();
    }

    public void setCity(String city) {
    	emCity.set(city);
    }
    
    
    public String getSalary() {
        return emSalary.get();
    }

    public void setSalary(String salary) {
    	emSalary.set(salary);
    }
    
    public String getPosition() {
        return emPosition.get();
    }

    public void setPosition(String position) {
    	emPosition.set(position);
    }

	
	//override the toString to show whatever
	public String toString() { 
		return getFName() + " " + getLName() + " " + getAddress() + " " + getCity() + " " + getCellNum();
	}
    
}
