/**
 * 
 */
package edu.rupp.repo.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.rupp.repo.domain.TestDomain;
import edu.rupp.repo.jdbc.DBCP2DataSourceUtils;

/**
 * @author sopheamak
 *
 */
public class SampleSqlSelect {

    private final String jdbcDriverStr ="com.mysql.jdbc.Driver";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/test";
    private final String username = "root";
    private final String pwd = "";
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
 
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        /**
         * create new database name : test
         * run the following sql in console
         * 
         DROP DATABASE IF EXISTS test;
         CREATE DATABASE test;
         USE test;
         
         DROP TABLE IF EXISTS test_table;
         CREATE TABLE test_table (
             id INT NOT NULL AUTO_INCREMENT,
             message VARCHAR(400) NOT NULL,
             PRIMARY KEY (ID)
         ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 
         INSERT INTO test_table values (default, 'test text message');
         */
        SampleSqlSelect jdbc = new SampleSqlSelect();
        jdbc.readData();
        
        //jdbc.writeData("my test message");
        
    }
 // SQL Select
    public List<TestDomain> readData() throws Exception {
        final List<TestDomain> list = new ArrayList<>();
        try {
            // load jdbc driver
            Class.forName(jdbcDriverStr);
            // load connection driver
            connection = DriverManager.getConnection(jdbcURL, username, pwd);
            // create statement
            statement = connection.createStatement();
            // execute select statement
            resultSet = statement.executeQuery("SELECT * FROM td_customer ORDER BY cus_id DESC LIMIT 500 ");

            // get result
            while (resultSet.next()) {
                Integer cus_id = resultSet.getInt("cus_id");
                String cus_first_name = resultSet.getString("cus_first_name");
                
                String cus_last_name = resultSet.getString("cus_last_name");
                String cus_gender = resultSet.getString("cus_gender");
                String cus_email_address = resultSet.getString("cus_email_address");
               // String cus_DOB = resultSet.getString("cus_DOB");
                String cus_address = resultSet.getString("cus_address");
                String cus_phoneNumber = resultSet.getString("cus_phoneNumber");
                System.out.println("id:" + cus_id + ", FirstName:" + cus_first_name);
                
                String dobDateStr = resultSet.getString("cus_DOB");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
                Date dobStr = null;
        		try {
        			dobStr = (Date) sdf.parse(dobDateStr);
        			//LOG.info("dopStr= "+dobStr);
        		} catch (ParseException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        		java.sql.Date sqlDate = new java.sql.Date(dobStr.getTime());
                
                //add TestDomain to List
                list.add(new TestDomain(cus_id, cus_first_name, cus_last_name, cus_gender, cus_email_address, sqlDate, cus_address, cus_phoneNumber));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            close();
        }
        return list;
    }

    // SQL Select
    public List<TestDomain> readDataFromDataSource() throws Exception {
        final List<TestDomain> list = new ArrayList<>();
        try {
            // get Connection from datasource
            connection = DBCP2DataSourceUtils.getConnection();
            // create statement
            statement = connection.createStatement();
            // execute select statement
            resultSet = statement.executeQuery("select * from td_customer order by cus_id desc limit 100 ;");

            // get result
            while (resultSet.next()) {
                
                Integer cus_id = resultSet.getInt("cus_id");
                String cus_first_name = resultSet.getString("cus_first_name");
                
                String cus_last_name = resultSet.getString("cus_last_name");
                String cus_gender = resultSet.getString("cus_gender");
                String cus_email_address = resultSet.getString("cus_email_address");
               // String cus_DOB = resultSet.getString("cus_DOB");
                String cus_address = resultSet.getString("cus_address");
                String cus_phoneNumber = resultSet.getString("cus_phoneNumber");
                System.out.println("id:" + cus_id + ", FirstName:" + cus_first_name);
                
                String dobDateStr = resultSet.getString("cus_DOB");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
                Date dobStr = null;
        		try {
        			dobStr = (Date) sdf.parse(dobDateStr);
        			//LOG.info("dopStr= "+dobStr);
        		} catch (ParseException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        		java.sql.Date sqlDate = new java.sql.Date(dobStr.getTime());
                
                //add TestDomain to List
                list.add(new TestDomain(cus_id, cus_first_name, cus_last_name, cus_gender, cus_email_address, sqlDate, cus_address, cus_phoneNumber));
            }
            DBCP2DataSourceUtils.printDataSourceState();
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
            if (connection != null) {
                connection.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
