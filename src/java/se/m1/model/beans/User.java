package se.m1.model.beans;

/**
 *
 * A Java bean that describes an application user
 */
public class User {
    
    /**
     * The user's username
     */
    private String username;
    /**
     * The user's password
     */
    private String pwd;
    /**
     * The user's rank
     * Can be admin or employee
     */
    private String rank;

    /**
     *
     * @return The user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     *      The user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return The user's password
     */
    public String getPassword() {
        return pwd;
    }

    /**
     *
     * @param pwd
     *      The user's password
     */
    public void setPassword(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return The user's rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank The user's rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

   
    
}