/***/
package edu.rupp.repo.domain;

import java.sql.Date;

/**
 * map to table test_table (id, message)
 * @author Sophea <a href='mailto:smak@dminc.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2017
 */
public class TestDomain {
	public Integer cus_id;
	public String cus_first_name;
	public String cus_last_name;
	public String cus_gender;
	public String cus_email_address;
	public String cus_phoneNumber;
	public String cus_address;
	public Date cus_DOB;
	public Date date_created;
	public Date date_updated;
	
	//TestDomain(cus_id, cus_first_name, cus_last_name, cus_gender, cus_email_address, cus_DOB, cus_address, cus_phoneNumber)
	public TestDomain(Integer cus_id, String cus_first_name, String cus_last_name, String cus_gender, String cus_email_address, Date cus_DOB,
			String cus_address, String cus_phoneNumber) {
		this.cus_id = cus_id;
		this.cus_first_name = cus_first_name;
		this.cus_last_name = cus_last_name;
		this.cus_gender = cus_gender;
		this.cus_email_address = cus_email_address;
		this.cus_phoneNumber = cus_phoneNumber;
		this.cus_address = cus_address;
		this.cus_DOB = cus_DOB;
		
		// TODO Auto-generated constructor stub
	}

	public Integer getCus_id() {
		return cus_id;
	}

	public void setCus_id(Integer cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_first_name() {
		return cus_first_name;
	}

	public void setCus_first_name(String cus_first_name) {
		this.cus_first_name = cus_first_name;
	}

	public String getCus_last_name() {
		return cus_last_name;
	}

	public void setCus_last_name(String cus_last_name) {
		this.cus_last_name = cus_last_name;
	}

	public String getCus_gender() {
		return cus_gender;
	}

	public void setCus_gender(String cus_gender) {
		this.cus_gender = cus_gender;
	}

	public String getCus_email_address() {
		return cus_email_address;
	}

	public void setCus_email_address(String cus_email_address) {
		this.cus_email_address = cus_email_address;
	}

	public String getCus_phoneNumber() {
		return cus_phoneNumber;
	}

	public void setCus_phoneNumber(String cus_phoneNumber) {
		this.cus_phoneNumber = cus_phoneNumber;
	}

	public String getCus_address() {
		return cus_address;
	}

	public void setCus_address(String cus_address) {
		this.cus_address = cus_address;
	}

	public Date getCus_DOB() {
		return cus_DOB;
	}

	public void setCus_DOB(Date cus_DOB) {
		this.cus_DOB = cus_DOB;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Date getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}
	    
    /*public String toString() {
        return String.format("id : %s, message : %s", id, message);
    }*/
 
    
}
