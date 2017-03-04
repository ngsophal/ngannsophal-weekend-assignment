package edu.rupp.repo.servlet;

public class User {
	private long id;
	private String username;
	private String password;

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
     }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * @return the username
     */
    public String getUserName() {
        return username;
    }

    /**
     * @param id the username to set
     */
    public void setUserName(String username) {
        this.username = username;
    }
    
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param id the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }  
    
   
}
