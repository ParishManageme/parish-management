package com.coop.parish.core.service;

import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;

public interface LoginService extends BaseService{
	
	/**
	 * This Method authenticate and authorizes the user, throws Parish Exception if fails
	 * @param identifier  Unique identifier of the user, may be email, username etc, not null
	 * @param password  Password to login to the system, not null
	 * @return UserBean  The User which corresponds to the identifier
	 * @throws ParishException  If the corresponding user is not Present or the Password does not match
	 */
	public UserBean validateLogin(String identifier, String pasword) throws ParishException;
}
