package model;

import java.util.Objects;

public class Account {
	private String idACcount ;
	private String userName ;
	private String passWord;
	
	
	public Account(String idACcount, String userName, String passWord) {
		super();
		this.idACcount = idACcount;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public String getIdACcount() {
		return idACcount;
	}
	public void setIdACcount(String idACcount) {
		this.idACcount = idACcount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idACcount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(idACcount, other.idACcount);
	}
	
}
