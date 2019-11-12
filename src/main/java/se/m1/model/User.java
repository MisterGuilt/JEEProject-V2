/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * An entity class that represents the User table in the database
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
    @NamedQuery(name = "User.findByPwd", query = "SELECT u FROM User u WHERE u.pwd = :pwd"),
    @NamedQuery(name = "User.findByRank", query = "SELECT u FROM User u WHERE u.rank = :rank")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    //List of attributes used in the User table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PWD")
    private String pwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "RANK")
    private String rank;

    /**
     *  Empty constructor, required in an Entity class
     */
    public User() {
    }

    /**
     *Constructor with specific ID
     * @param id
     *      ID of the new user
     */
    public User(Integer id) {
        this.id = id;
    }

    /**
     * Constructor with a complete set of data
     * @param id
     * @param login
     * @param pwd
     * @param rank
     */
    public User(Integer id, String login, String pwd, String rank) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
        this.rank = rank;
    }

    /**
     * Returns the user's ID
     * @return
     *      The user's ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets a new ID for the user
     * @param id
     *      The ID to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the user's username
     * @return
     *      The user's username
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets a new username for the user
     * @param login
     *      The username to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns the user's password
     * @return
     *      The user's password
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Sets a new password for the user
     * @param pwd
     *      The password to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Returns the user's rank
     * @return
     *      The user's rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Sets a new rank for the user
     * @param rank
     *      The rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares two User objects for equality
     * @param object The object to compare
     * @return If the objects are equal or not
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Provides a string representation of a User object
     * @return
     *      A string representation of a User object
     */
    @Override
    public String toString() {
        return "se.m1.model.User[ id=" + id + " ]";
    }
    
}
