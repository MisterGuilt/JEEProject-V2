package se.m1.model.beans;

/**
 *
 * A Java bean that describes an employee
 */
public class Employee {

    /**
     * The employee's ID in the database
     * Cannot be modified by application users
     */
    private int id;
    private String name;
    private String firstname;
    private String homePhone;
    private String mobilePhone;
    private String proPhone;
    private String address;
    private String postalCode;
    private String city;
    private String mail;

    /**
     *
     * @return The employee's database ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     *      The employee's database ID
     * 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return The employee's last name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *      The employee's last name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The employee's first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     *      The employee's first name
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return The employee's home phone number
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     *
     * @param homePhone
     *      The employee's home phone number
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     *
     * @return The employee's mobile phone number
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     *
     * @param mobilePhone
     *      The employee's mobile phone number
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     *
     * @return The employee's work phone number
     */
    public String getProPhone() {
        return proPhone;
    }

    /**
     *
     * @param proPhone
     *      The employee's work phone number
     */
    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    /**
     *
     * @return The employee's home address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     *      The employee's home address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return The employee's postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     *      The employee's postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return The employee's city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     *      The employee's city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return The employee's mail address
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail
     *      The employee's mail address
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    
    
}