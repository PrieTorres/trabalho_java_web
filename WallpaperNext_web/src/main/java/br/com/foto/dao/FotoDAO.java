package br.com.foto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.WallpaperNext.factory.ConnectionFactory;
import br.com.WallpaperNext.model.foto;
import br.com.WallpaperNext.model.pasta;

public class FotoDAO {
	
public void save(foto foto) {
		
		String sql = "INSERT INTO foto (link, descricao, FK_pasta) values (?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ptsm = null;
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			ptsm = (PreparedStatement) con.prepareStatement(sql);
			
			ptsm.setString(1, foto.getLink());
			ptsm.setString(2, foto.getDescricao());
			ptsm.setInt(3, foto.getFK_pasta());
			
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

	public List<foto> listarFotos(int FK_pasta) {
		String sql = "SELECT * FROM foto where FK_pasta = "+FK_pasta+";";
		
		List<foto> fotos = new ArrayList<foto>();
		
		Connection con = null;
		PreparedStatement ptsm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			ptsm = (PreparedStatement) con.prepareStatement(sql);
			
			rset = ptsm.executeQuery();
			
			while(rset.next()) {
				foto foto = new foto();
				
				foto.setId(rset.getInt("id"));
				foto.setFK_pasta(rset.getInt("FK_pasta"));
				foto.setDescricao(rset.getString("descricao"));
				foto.setLink(rset.getString("link"));
				
				fotos.add(foto);
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
		
		return fotos;
	}

}
