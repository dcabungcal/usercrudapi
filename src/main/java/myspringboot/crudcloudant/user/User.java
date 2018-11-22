package myspringboot.crudcloudant.user;

public class User {
	
	private String _id;
	private String _rev;
	
	private String userid;
	private String firstname;
	private String lastname;
	private String email;
	
	public User() {
		
	}
	
	public User(String userid, String firstname, String lastname, String email) {
		super();
		this._id = userid;
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
		
	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
		this._id = userid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
