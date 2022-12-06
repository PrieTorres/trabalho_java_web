package br.com.pasta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.WallpaperNext.factory.ConnectionFactory;
import br.com.WallpaperNext.model.pasta;

public class PastaDAO {
	
	public void save(pasta pasta) {
		
		String sql = "INSERT INTO pasta (nome, criador, descricao) values (?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ptsm = null;
		
		System.out.println("salvand0...");
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			ptsm = (PreparedStatement) con.prepareStatement(sql);
			
			ptsm.setString(1, pasta.getNome());
			ptsm.setString(2, pasta.getCriador());
			ptsm.setString(3, pasta.getDescricao());
			
			ptsm.execute();
		}
		catch (Exception e){
			System.out.println("erro"+ e);
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ptsm != null) {
					ptsm.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<pasta> listarPastasProntas() {
		String sql = "SELECT * FROM pasta where criador = 'origin';";
		List<pasta> pastas = new ArrayList<pasta>();
		
		Connection con = null;
		PreparedStatement ptsm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			ptsm = (PreparedStatement) con.prepareStatement(sql);
			
			rset = ptsm.executeQuery();
			
			while(rset.next()) {
				pasta pasta = new pasta();
				
				pasta.setId(rset.getInt("id"));
				pasta.setCriador(rset.getString("criador"));
				pasta.setDescricao(rset.getString("descricao"));
				pasta.setNome(rset.getString("nome"));
				
				pastas.add(pasta);
			}
			
		} catch (Exception e){
			System.out.println("erro"+ e);
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ptsm != null) {
					ptsm.close();
				}
				if(rset!=null) {
					rset.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return pastas;
	}
	
	public List<pasta> listarTodasPastas() {
		String sql = "SELECT * FROM pasta;";
		List<pasta> pastas = new ArrayList<pasta>();
		
		Connection con = null;
		PreparedStatement ptsm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			ptsm = (PreparedStatement) con.prepareStatement(sql);
			
			rset = ptsm.executeQuery();
			
			while(rset.next()) {
				pasta pasta = new pasta();
				
				pasta.setId(rset.getInt("id"));
				pasta.setCriador(rset.getString("criador"));
				pasta.setDescricao(rset.getString("descricao"));
				pasta.setNome(rset.getString("nome"));
				
				pastas.add(pasta);
			}
			
		} catch (Exception e){
			System.out.println("erro"+ e);
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ptsm != null) {
					ptsm.close();
				}
				if(rset!=null) {
					rset.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return pastas;
	}
	
	
	public List<pasta> listarPastasUsuario() {
		String sql = "SELECT * FROM pasta where criador = 'user';";
		List<pasta> pastas = new ArrayList<pasta>();
		
		Connection con = null;
		PreparedStatement ptsm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			ptsm = (PreparedStatement) con.prepareStatement(sql);
			
			rset = ptsm.executeQuery();
			
			while(rset.next()) {
				pasta pasta = new pasta();
				
				pasta.setId(rset.getInt("id"));
				pasta.setCriador(rset.getString("criador"));
				pasta.setDescricao(rset.getString("descricao"));
				pasta.setNome(rset.getString("nome"));
				
				pastas.add(pasta);
			}
			
		} catch (Exception e){
			System.out.println("erro"+ e);
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ptsm != null) {
					ptsm.close();
				}
				if(rset!=null) {
					rset.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return pastas;
	}
}
