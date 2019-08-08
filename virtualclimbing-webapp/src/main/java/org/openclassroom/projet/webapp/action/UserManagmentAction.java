package org.openclassroom.projet.webapp.action;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.openclassroom.projet.model.exception.TechnicalException;

import com.opensymphony.xwork2.ActionSupport;

public class UserManagmentAction extends AbstractAction implements SessionAware, ServletRequestAware {

	// ==================== Attributes ====================
	// ----- Input parameter
	private String confirmPassword;
	
	// ----- Output elements
	private User user;
	
	
	// ----- Struts elements
	private Map<String, Object> session;
	private HttpServletRequest servletRequest;
	
	
	
	// ==================== Getters/Setters ====================
	public User getUser() {
		return user;
	}
	public void setUser(User vUser) {
		user = vUser;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String vConfirmPassword) {
		confirmPassword = vConfirmPassword;
	}
	@Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }
	@Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }
	
	
	
	// ==================== Methods ====================		
	/**
	 * Get information on login form and test the Pseudo/Password couple
	 * If its the good couple, it put the {@link User} in session
	 * 
	 * @return input / success
	 */
	public String doLogin() {
		String vResult = ActionSupport.INPUT;
		
		if (this.user != null) {
            if (!this.hasErrors()) {
                try {
                	user = getManagerFactory().getUserManager().connectUser(user.getPseudo(), user.getPassword());
                	this.session.put("user", user);
                    vResult = ActionSupport.SUCCESS;
                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());
                }
            }
        }
		
		return vResult;
	}
	
	/**
	 * Invalidate the {@link User} session on logout
	 * 
	 * @return success
	 */
	public String doLogout() {
		user = (User)session.get("user");
		logger.info(getText("action.logout", Collections.singletonList(user.getPseudo())));
		this.servletRequest.getSession().invalidate();
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Get information on sign up form and test it.
	 * If no error is returned, a new {@link User} is created. 
	 * 
	 * @return input / success / error
	 */
	public String doSignin() {
		String vResult = ActionSupport.INPUT;
		
		if (this.user != null) {
            if (!this.hasErrors()) {
                try {
                	Date newDate = new Date();
        	    	user.setRegistrationDate(new java.sql.Date(newDate.getTime()));
                    getManagerFactory().getUserManager().addUser(user);
                    
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage(getText("action.user.signin.success"));

                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());
                } catch (TechnicalException pEx) {
                    this.addActionError(pEx.getMessage());
                    vResult = ActionSupport.ERROR;
                }
            }
        }
		
		return vResult;
	}
	
	/**
	 * Get information on form and test the 2 password.
	 * If no error is returned, the password of the {@link User} is changed
	 * 
	 * @return input / success
	 */
	public String doChangePassword() {
		String vResult = ActionSupport.INPUT;
		
		if (this.user != null) {
			User vUser = (User)session.get("user");
			user.setPseudo(vUser.getPseudo());
            if (!this.hasErrors()) {
                try {
                    getManagerFactory().getUserManager().changePassword(user, confirmPassword);
                    
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage(getText("action.user.changePassword.success"));

                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());
                }
            }
        }
		
		return vResult;
	}

}
