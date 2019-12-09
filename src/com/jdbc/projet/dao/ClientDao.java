package com.jdbc.projet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.projet.entity.Client;

import com.jdbc.projet.dao.JDBCUtil;

public class ClientDao extends JDBCUtil implements InterfaceDao {

	@Override
	public void save(Client client) {
		Connection connect = null;
		PreparedStatement pStatement = null;
		
		try {
			connect = JDBCUtil.seConnecter();
			
			System.out.println(client);
			
			// Création d'un statement
			
			String sql = "INSERT INTO client (nom, prenom, adresse, telephone, email) VALUES (?, ?, ?, ?, ?)";
			pStatement = connect.prepareStatement(sql);
			
			pStatement.setString(1, client.getNom());
			pStatement.setString(2, client.getPrenom());
			pStatement.setString(3, client.getAdresse());
			pStatement.setString(4, client.getTelephone());
			pStatement.setString(5, client.getEmail());
			
			// Execution requete
			pStatement.execute();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connect.close();
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Client findById(int id) {
		
		Connection connect = null;
		PreparedStatement pStatement = null;
		ResultSet result = null;
		Client client = new Client();
		
		try {
			connect = JDBCUtil.seConnecter();
			// Création d'un statement
			
			String sql = "SELECT nom, prenom, adresse, telephone, email FROM client WHERE idclient = (?)";
			pStatement = connect.prepareStatement(sql);
			pStatement.setInt(1, id);
			
			result = pStatement.executeQuery();
			
			while (result.next()) {
				client.setNom(result.getString("nom"));
				client.setPrenom(result.getString("prenom"));
				client.setAdresse(result.getString("adresse"));
				client.setTelephone(result.getString("telephone"));
				client.setEmail(result.getString("email"));
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connect.close();
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return client;
	}

	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
//		Client daniel = new Client("CESAIRE", "Daniel", "3, rue des alouettes", "0745362737", "daniel.cesaire@gmail.com");
		ClientDao cdo = new ClientDao();
//		cdo.save(daniel);
		
		Client client2 = cdo.findById(1);
		
		System.out.println(client2);
	}

}
