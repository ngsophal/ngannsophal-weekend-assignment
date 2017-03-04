/**
 * 
 */
package edu.rupp.repo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


import edu.rupp.repo.domain.TestDomain;

/**
 * @author sopheamak
 *
 */
public class TestDaoImpl {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
 
    public TestDaoImpl() {
        
    }
    
    //delete sql
    public void deleteRecord(int id) throws SQLException {
        try {
            // get Connection from datasource
            connection = DBCP2DataSourceUtils.getConnection();

            // insert sql using prepared statement
            preparedStatement = connection.prepareStatement("Delete From td_customer where cus_id=?");
            // set parameter
            preparedStatement.setInt(1, id); //set id
            preparedStatement.executeUpdate();
        }
        finally {
            close();
        }
    }
    //Insert SQL          
    public void writeData(String firstName,String lastName,String gender,String email,String phone,String address,Date dobStr) throws Exception {
        try {
            connection = DBCP2DataSourceUtils.getConnection();
            // insert sql using prepared statement
            preparedStatement = connection.prepareStatement("insert into td_customer(cus_first_name,cus_last_name,cus_gender,cus_email_address,cus_phoneNumber,cus_address,cus_DOB) values (?,?,?,?,?,?,?)");
            // set parameter
            preparedStatement.setString(1, firstName); //set firstName
            preparedStatement.setString(2, lastName); //set lastName
            preparedStatement.setString(3, gender); //set gender
            preparedStatement.setString(4, email); //set email
            preparedStatement.setString(5, phone); //set phone
            preparedStatement.setString(6, address); //set address
            preparedStatement.setDate(7,  (java.sql.Date) dobStr); //set dob
            preparedStatement.execute();//Update();
            System.out.println("Insert record successfully -" + firstName + " " + lastName);
        }
        finally {
            close();
        }
    }
    
    /***
     * update record table
     * @param id
     * @param message
     * @throws Exception
     */
    public void upateData(Integer id, String firstName,String lastName,String gender,String email,String phone,String address,Date dobStr) throws Exception {
        try {
            // connection
            connection = DBCP2DataSourceUtils.getConnection();
            String sql = "update td_customer set cus_first_name=?,cus_last_name=?,cus_gender=?,cus_email_address=?,cus_phoneNumber=?,cus_address=?,cus_DOB=?,date_updated=? where cus_id=?";
            preparedStatement = connection.prepareStatement(sql);
            // set param message
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, address);
            preparedStatement.setDate(7, (java.sql.Date) dobStr);
            //START add modify date
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);
            preparedStatement.setString(8, currentTime);
            //END add modify date
            // set param id
            preparedStatement.setInt(9, id);
            boolean result = preparedStatement.execute();
            System.out.println("update record : " + result);
        }
        finally {
            close();
        }
    }
    // SQL Select
    public TestDomain readDataById(Integer id) throws Exception {
        if (id == null) {
            return null;
        }
        TestDomain result = null;
        try {
            // get Connection from datasource
            connection = DBCP2DataSourceUtils.getConnection();
            // execute select statement
            preparedStatement = connection.prepareStatement("SELECT * FROM td_customer WHERE cus_id=? ORDER BY cus_id DESC");
            preparedStatement.setInt(1, id);
            
            resultSet = preparedStatement.executeQuery();
            
            // get result
            if (resultSet.next()) {
            	Integer cus_id = resultSet.getInt("cus_id");
                String cus_first_name = resultSet.getString("cus_first_name");
                String cus_last_name = resultSet.getString("cus_last_name");
                String cus_gender = resultSet.getString("cus_gender");
                String cus_email_address = resultSet.getString("cus_email_address");
                String cus_phoneNumber = resultSet.getString("cus_phoneNumber");
                String cus_address = resultSet.getString("cus_address");
                java.sql.Date dob = resultSet.getDate("cus_DOB");
                //System.out.println("id:" + id + ", message:" + message);
                //add TestDomain to List
                result = new TestDomain(cus_id,cus_first_name,cus_last_name,cus_gender,cus_email_address,dob,cus_address,cus_phoneNumber);
            }
            //DBCP2DataSourceUtils.printDataSourceState();
        } 
        finally {
            close();
        }
        return result;
    }
    
    // SQL Select
    public List<TestDomain> readData() throws Exception {
        final List<TestDomain> list = new ArrayList<>();
        try {
            // get Connection from datasource
            connection = DBCP2DataSourceUtils.getConnection();
            // create statement
            statement = connection.createStatement();
            // execute select statement
            resultSet = statement.executeQuery("SELECT * FROM td_customer ORDER BY cus_id DESC");

            // get result
            while (resultSet.next()) {
                Integer cus_id = resultSet.getInt("cus_id");
                String cus_first_name = resultSet.getString("cus_first_name");
                String cus_last_name = resultSet.getString("lastName");
                String cus_gender = resultSet.getString("cus_gender");
                String cus_email_address = resultSet.getString("cus_email_address");
                String cus_phoneNumber = resultSet.getString("cus_phoneNumber");
                String cus_address = resultSet.getString("cus_address");
                java.sql.Date dob = resultSet.getDate("dob");
                //System.out.println("id:" + id + ", message:" + message);
                //add TestDomain to List
                						
                list.add(new TestDomain(cus_id,cus_first_name,cus_last_name,cus_gender,cus_email_address,dob,cus_address,cus_phoneNumber));
                
                
            }
            //DBCP2DataSourceUtils.printDataSourceState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            close();
        }
        return list;
    }
 
    private void close(){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
