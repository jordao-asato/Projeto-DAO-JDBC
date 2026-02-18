package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	// exposes a interface type method but instantiates an implementation
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
	
}
