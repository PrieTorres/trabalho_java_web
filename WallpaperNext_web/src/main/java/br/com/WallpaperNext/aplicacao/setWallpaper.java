package br.com.WallpaperNext.aplicacao;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

public class setWallpaper {
	
	static public String downloadImage(String url) {
		
		String urlToDownload = url;
		System.out.println("nome: "+urlToDownload+" index: "+ urlToDownload.lastIndexOf("/"));
		
		urlToDownload = urlToDownload.substring(urlToDownload.lastIndexOf("/")+1, urlToDownload.length());
		System.out.println("nome: "+urlToDownload);
		String download_path = "C:\\Downloads\\"+urlToDownload;
		
		try (InputStream in = new URL(url).openStream()){
			
			Files.copy(in, Paths.get(download_path));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return download_path;
		
	}
	
	public static interface User32 extends Library {
	     @SuppressWarnings("deprecation")
		User32 INSTANCE = (User32) Native.loadLibrary("user32",User32.class,W32APIOptions.DEFAULT_OPTIONS);        
	     boolean SystemParametersInfo (int one, int two, String s ,int three);         
	 }
	
	public static void setWithUrl(String url) {
		String urlToDownload = downloadImage(url);
		User32.INSTANCE.SystemParametersInfo(0x0014, 0, urlToDownload , 1);
	}
	
	/*public static void main(String[] args) {   
	   //User32.INSTANCE.SystemParametersInfo(0x0014, 0, "https://i.pinimg.com/564x/da/00/9f/da009f9550a0016ad1f63523243fdba9.jpg" , 1);
		setWithUrl("https://i.pinimg.com/564x/83/d1/7e/83d17e2e182a3e469bb1050c57d9d8af.jpg");
	}*/
	 

}
