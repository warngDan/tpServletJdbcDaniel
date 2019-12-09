package com.jdbc.projet.dao;

import com.jdbc.projet.entity.Client;

public interface InterfaceDao {
	
	public void save(Client client);
	
	public Client findById(int id);
	
	public void update(Client client);
	
	public void delete(Client client);

}
