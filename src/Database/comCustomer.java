package Database;

import javafx.beans.property.SimpleStringProperty;

public class comCustomer {
	 /*
	 Variables are created to enable the referencing of a particular data element.
	 When the data model is outlined in the Customer class, you can create an
	 ObservableList array and define as many data rows as you would like to show in your table
	 */
    private final SimpleStringProperty comFName;
    private final SimpleStringProperty comLName;
    private final SimpleStringProperty comBusiName;
    private final SimpleStringProperty comCellNum;
    private final SimpleStringProperty comSecNum;
    private final SimpleStringProperty comEmail;
    private final SimpleStringProperty comAddress;
    private final SimpleStringProperty comCity;
    private final SimpleStringProperty comPrice;
    private final SimpleStringProperty comMisc;
    //creates a Commercial Customer
    comCustomer(String fName, String lName, String busiName, String cellNum, String secNum, String email, String address, String city, String price, String misc) {
        this.comFName = new SimpleStringProperty(fName);
        this.comLName = new SimpleStringProperty(lName);
        this.comBusiName = new SimpleStringProperty(busiName);
        this.comCellNum = new SimpleStringProperty(cellNum);
        this.comSecNum = new SimpleStringProperty(secNum);
        this.comEmail = new SimpleStringProperty(email);
        this.comAddress = new SimpleStringProperty(address);
        this.comCity = new SimpleStringProperty(city);
        this.comPrice = new SimpleStringProperty(price);
        this.comMisc = new SimpleStringProperty(misc);
    }
//getters/setters.
    public String getFName() {
        return comFName.get();
    }

    public void setFName(String fName) {
    	comFName.set(fName);
    }

    public String getLName() {
        return comLName.get();
    }

    public void setLName(String lName) {
    	comLName.set(lName);
    }
    
    public String getBusiName() {
        return comBusiName.get();
    }

    public void setBusiName(String busiName) {
    	comBusiName.set(busiName);
    }
    
    
    public String getCellNum() {
        return comCellNum.get();
    }

    public void setCellNum(String cellNum) {
    	comCellNum.set(cellNum);
    }

    public String getSecNum() {
        return comSecNum.get();
    }

    public void setSecNum(String secNum) {
    	comSecNum.set(secNum);
    }
    
    public String getEmail() {
        return comEmail.get();
    }

    public void setEmail(String email) {
    	comEmail.set(email);
    }
    
    public String getAddress() {
        return comAddress.get();
    }

    public void setAddress(String address) {
    	comAddress.set(address);
    }
    
    public String getCity() {
        return comCity.get();
    }

    public void setCity(String city) {
    	comCity.set(city);
    }
    
    
    public String getPrice() {
        return comPrice.get();
    }

    public void setPrice(String price) {
    	comPrice.set(price);
    }
    
    public String getMisc() {
        return comMisc.get();
    }

    public void setMisc(String misc) {
    	comMisc.set(misc);
    }
	
    
    //override the toString to show whatever
	public String toString() { 
		return getFName() + ", " + getLName()  + ", " +  getBusiName();
	}
    
}

