package Database;

import javafx.beans.property.SimpleStringProperty;

public class resCustomer{
	 /*
	 Variables are created to enable the referencing of a particular data element.
	 When the data model is outlined in the Customer class, you can create an
	 ObservableList array and define as many data rows as you would like to show in your table
	 */
    private final SimpleStringProperty resFName;
    private final SimpleStringProperty resLName;
    private final SimpleStringProperty resCellNum;
    private final SimpleStringProperty resSecNum;
    private final SimpleStringProperty resEmail;
    private final SimpleStringProperty resAddress;
    private final SimpleStringProperty resCity;
    private final SimpleStringProperty resWndwCnt;
    private final SimpleStringProperty resPrice;
    private final SimpleStringProperty resMisc;

    // Creates a Residential Customer

    resCustomer(String fName, String lName,  String cellNum, String secNum, String email, String address, String city,
    		String wndwCnt, String price, String misc) {
        this.resFName = new SimpleStringProperty(fName);
        this.resLName = new SimpleStringProperty(lName);
        this.resCellNum = new SimpleStringProperty(cellNum);
        this.resSecNum = new SimpleStringProperty(secNum);
        this.resEmail = new SimpleStringProperty(email);
        this.resAddress = new SimpleStringProperty(address);
        this.resCity = new SimpleStringProperty(city);
        this.resWndwCnt = new SimpleStringProperty(wndwCnt);
        this.resPrice = new SimpleStringProperty(price);
        this.resMisc = new SimpleStringProperty(misc);
    }
    
//getters/setters.
    public String getFName() {
        return resFName.get();
    }

    public void setFName(String fName) {
        resFName.set(fName);
    }

    public String getLName() {
        return resLName.get();
    }

    public void setLName(String lName) {
    	resLName.set(lName);
    }
    
    public String getCellNum() {
        return resCellNum.get();
    }

    public void setCellNum(String cellNum) {
    	resCellNum.set(cellNum);
    }

    public String getSecNum() {
        return resSecNum.get();
    }

    public void setSecNum(String secNum) {
    	resSecNum.set(secNum);
    }
    
    public String getEmail() {
        return resEmail.get();
    }

    public void setEmail(String email) {
        resEmail.set(email);
    }
    
    public String getAddress() {
        return resAddress.get();
    }

    public void setAddress(String address) {
    	resAddress.set(address);
    }
    
    public String getCity() {
        return resCity.get();
    }

    public void setCity(String city) {
    	resCity.set(city);
    }
    
    
    public String getPrice() {
        return resPrice.get();
    }

    public void setPrice(String price) {
    	resPrice.set(price);
    }
    
    public String getMisc() {
        return resMisc.get();
    }

    public void setMisc(String misc) {
    	resMisc.set(misc);
    }

	public String getResWndwCnt() {
		return resWndwCnt.get();
	}

	public void setResWndwCnt(String wndwCnt) {
		resWndwCnt.set(wndwCnt);
	}
	
	//override the toString to show whatever
	public String toString() { 
		return getFName() + " " + getLName() + " " + getAddress() + " " + getCity() + " " + getCellNum();
	}
    
}
