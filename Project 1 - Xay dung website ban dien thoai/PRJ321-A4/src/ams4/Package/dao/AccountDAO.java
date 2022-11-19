package ams4.Package.dao;

import ams4.Package.model.Administrator;

public interface AccountDAO {

	public Administrator getAccount (String email, String pass);

	public Administrator get(String email, String pass);
}
