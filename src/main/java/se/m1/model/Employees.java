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
 * An entity class that represents the Employees table in the database
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findById", query = "SELECT e FROM Employees e WHERE e.id = :id")
    , @NamedQuery(name = "Employees.findByName", query = "SELECT e FROM Employees e WHERE e.name = :name")
    , @NamedQuery(name = "Employees.findByFirstname", query = "SELECT e FROM Employees e WHERE e.firstname = :firstname")
    , @NamedQuery(name = "Employees.findByTelhome", query = "SELECT e FROM Employees e WHERE e.telhome = :telhome")
    , @NamedQuery(name = "Employees.findByTelmob", query = "SELECT e FROM Employees e WHERE e.telmob = :telmob")
    , @NamedQuery(name = "Employees.findByTelpro", query = "SELECT e FROM Employees e WHERE e.telpro = :telpro")
    , @NamedQuery(name = "Employees.findByAdress", query = "SELECT e FROM Employees e WHERE e.adress = :adress")
    , @NamedQuery(name = "Employees.findByPostalcode", query = "SELECT e FROM Employees e WHERE e.postalcode = :postalcode")
    , @NamedQuery(name = "Employees.findByCity", query = "SELECT e FROM Employees e WHERE e.city = :city")
    , @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    //List of attributes used in the Employees table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELHOME")
    private String telhome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELMOB")
    private String telmob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELPRO")
    private String telpro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ADRESS")
    private String adress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "POSTALCODE")
    private String postalcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CITY")
    private String city;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "EMAIL")
    private String email;

    /**
     * Empty constructor, required in an Entity class
     */
    public Employees() {
    }

    /**
     * Constructor with specific ID
     * @param id
     *      ID of the new employee
     */
    public Employees(Integer id) {
        this.id = id;
    }
    
    /**
     * Constructor with a complete set of data
     * @param id Employee ID
     * @param name Employee's last name
     * @param firstname Employee's first name
     * @param telhome Employee's home phone
     * @param telmob Employee's mobile phone
     * @param telpro Employee's work phone
     * @param adress Employee's address
     * @param postalcode Employee's postal code
     * @param city Employee's city
     * @param email Employee's email
     */
    public Employees(Integer id, String name, String firstname, String telhome, String telmob, String telpro, String adress, String postalcode, String city, String email) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.telhome = telhome;
        this.telmob = telmob;
        this.telpro = telpro;
        this.adress = adress;
        this.postalcode = postalcode;
        this.city = city;
        this.email = email;
    }

    /**
     * Returns the employee's ID
     * @return
     *      The employee's ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets a new ID for the employee
     * @param id
     *      The ID to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the employee's last name
     * @return
     *      The employee's last name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new last name for the employee
     * @param name
     *      The last name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the employee's first name
     * @return
     *      The employee's first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets a new first name for the employee
     * @param firstname
     *      The first name to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the employee's home phone number
     * @return
     *      The employee's home phone number
     */
    public String getTelhome() {
        return telhome;
    }

    /**
     * Sets a new home phone number for the employee
     * @param telhome
     *      The phone number to set
     */
    public void setTelhome(String telhome) {
        this.telhome = telhome;
    }

    /**
     * Returns the employee's mobile phone number
     * @return
     *      The employee's mobile phone number
     */
    public String getTelmob() {
        return telmob;
    }

    /**
     * Sets a new mobile phone number for the employee
     * @param telmob
     *      The phone number to set
     */
    public void setTelmob(String telmob) {
        this.telmob = telmob;
    }

    /**
     * Returns the employee's work phone number
     * @return
     *      The employee's work phone number
     */
    public String getTelpro() {
        return telpro;
    }

    /**
     * Sets a new work phone number for the employee
     * @param telpro
     *      The phone number to set
     */
    public void setTelpro(String telpro) {
        this.telpro = telpro;
    }

    /**
     * Returns the employee's home address
     * @return
     *      The employee's home address
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Sets a new home address for the employee
     * @param adress
     *      The address to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Returns the employee's postal code
     * @return
     *      The employee's postal code
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     * Sets a new postal code for the employee
     * @param postalcode
     *      The postal code to set
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     * Returns the employee's city
     * @return
     *      The employee's city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets a new city for the employee
     * @param city
     *      The city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the employee's email address
     * @return
     *      The employee's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets a new email address for the employee
     * @param email
     *      The email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares two Employees objects for equality
     * @param object The object to compare
     * @return If the objects are equal or not
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Provides a string representation of an Employees object
     * @return
     *      A string representation of an Employees object
     */
    @Override
    public String toString() {
        return "se.m1.model.Employees[ id=" + id + " ]";
    }
    
}
