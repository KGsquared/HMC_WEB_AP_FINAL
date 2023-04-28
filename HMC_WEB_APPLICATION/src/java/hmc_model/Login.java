/*
* 
* Aunthenticate users to gain access into the systems
*/

package hmc_model;
/**
 *
 * @author k_gsquared
 * 23-04-2023
*/
public class Login {
    private String username;
    private String password;
    private Occupation occupation;
    
    public Login() {
        this.username   = "";
        this.password   = "";
        this.occupation = new Occupation(); 
    }

    public Login(String username, String password, Occupation occupation) {
        this.username   = username;
        this.password   = password;
        this.occupation = occupation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }
    
    @Override
    public String toString() {
        return "login{" + "username=" + username + 
               ", password=" + password + "}";
    }
} 
