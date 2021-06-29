package project;

import java.util.Objects;

public class User {
	private String CID;
	private String fullname;
	private String username;
	private String password;
	private String gender;
	private String address;
	private String email;
	private String phone;

    public User(String CID, String fullname, String username, String password, String gender, String address, String email, String phone) {
    	this.CID = CID;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    public String getCID() {
        return CID;
    }
    public void setIID(String CID) {
        this.CID = CID;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return CID.equals(user.CID) && fullname.equals(user.fullname) && username.equals(user.username) && password.equals(user.password) && gender.equals(user.gender) && address.equals(user.address) && email.equals(user.email) && phone.equals(user.phone);
    }
    @Override
    public int hashCode() {
        return Objects.hash(CID, fullname, username, password, gender, address, email, phone);
    }
}
