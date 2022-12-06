<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.foto.dao.FotoDAO, br.com.WallpaperNext.model.foto" %>
<%
	String ContentTitle = (String)request.getAttribute("nome-pasta");
	List<foto> lista = (List<foto>)request.getAttribute("fotos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= ContentTitle  %></title>
<link rel="stylesheet" href="css/style.css">
</head>
<body style="padding: 0; margin: 0; width: 100vw; height: 100vh">
	<div class="side-menu" style="width: 0px; display: none; opacity: 0;">
		<div class="head-side-menu">
			<div class="botao-icon botao-main" onclick="closeMenu()">
				<img class="icon" src="img/white-menu-icon.png" alt="menu icon">
			</div>
		</div>
		<nav>
			<ul>
				<li><a>Mais aplicativos</a></li>
				<li><a>Avaliar aplicativo</a></li>
				<li><a>Remover Propaganda</a></li>
				<li><a>Sobre nós</a></li>
			</ul>
		</nav>
	</div>
	<header>
		<div class="head-content">
			<div class="botao-icon botao-main"
				onclick="window.location.href = window.location.origin+'/WallpaperNext_web/listar-pastas-prontas'">
				<img class="icon" src="img/go-back-icon.png" alt="menu icon">
			</div>
			<h1 class="title" style="font-size: 3rem;">WallpaperNext</h1>
			<div class="botao-icon botao-out">
				<img class="icon" src="img/logout_icon.png" alt="logout icon">
			</div>
		</div>
	</header>
	<main>
		<div class="menu-options" style="padding:20px; display:flex; flex-wrap:wrap">
		
			<%
			for(foto f : lista) {
			 %>
			<div style="width: 48%" onclick="">
				<img class="" style="width:100%" src=<%= f.getLink() %> alt="wallpaper"/>
			</div>
			<% } %>
			
		</div>

	</main>
	<footer class="rodape">
		<div class="propaganda-pra-ficar-rico"></div>
	</footer>


	<script>
		function openMenu() {
			document.body.querySelector('.side-menu').style.display = 'block';
			setTimeout(()=>{
				document.body.querySelector('.side-menu').style.width = '70vw';
				document.body.querySelector('.side-menu').style.opacity = '1';
			}, 20);
		}

		function closeMenu() {
			document.body.querySelector('.side-menu').style.width = '0';
			document.body.querySelector('.side-menu').style.opacity = '0';
			setTimeout(()=>{
				document.body.querySelector('.side-menu').style.display = 'none';
			}, 400);
		}
	</script>
</body>
</html>