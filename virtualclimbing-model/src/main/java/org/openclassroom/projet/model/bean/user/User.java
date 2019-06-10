package org.openclassroom.projet.model.bean.user;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

public class User {

	// ==================== Attributes ====================
    @NotNull
    @Size(min = 1)
    private String pseudo;
    
    @NotNull
    private String firstName;
    
    @NotNull
    private String lastName;
    
    @NotNull
    private String password;
    
    @NotNull
    private Date registrationDate;


    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public User() {
    }


    /**
     * Constructor.
     *
     * @param pPseudo -
     * @param pFirstName -
     * @param pLastName -
     * @param pPassword -
     * @param pRegistrationDate -
     */
    public User(String pPseudo, String pFirstName, String pLastName, String pPassword, Date pRegistrationDate) {
        pseudo = pPseudo;
        firstName = pFirstName;
        lastName = pLastName;
        password = pPassword;
        registrationDate = pRegistrationDate;
    }


    // ==================== Getters/Setters ====================
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pPseudo) {
        pseudo = pPseudo;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String pLastName) {
        lastName = pLastName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pPassword) {
        password = pPassword;
    }
    public Date getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Date pRegistrationDate) {
        registrationDate = pRegistrationDate;
    }


    // ==================== Methods ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        vStB.append(" {")
            .append("pseudo=").append(pseudo)
            .append("}");
        return vStB.toString();
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj)
            || (obj instanceof User && StringUtils.equals(((User) obj).getPseudo(), pseudo));
    }


    @Override
    public int hashCode() {
        return this.pseudo != null ? this.pseudo.hashCode() : super.hashCode();
    }
	
}