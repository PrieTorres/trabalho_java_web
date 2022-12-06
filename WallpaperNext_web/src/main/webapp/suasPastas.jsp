<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.pasta.dao.PastaDAO, br.com.WallpaperNext.model.pasta" %>
<% 
PastaDAO pastaDAO = new PastaDAO(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>suas pastas</title>
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
				onclick="window.location.href = window.location.origin+'/WallpaperNext_web/bem-vindo.html'">
				<img class="icon" src="img/go-back-icon.png" alt="menu icon">
			</div>
			<h1 class="title" style="font-size: 3rem;">WallpaperNext</h1>
			<div class="botao-icon botao-out">
				<img class="icon" src="img/logout_icon.png" alt="logout icon">
			</div>
		</div>
	</header>
	<main>
		<div class="menu-options" onload="">
		
			<%
			List<pasta> listaPastas = (List<pasta>)request.getAttribute("pastas-usuario");
			for(pasta p : pastaDAO.listarPastasUsuario()) {
				String url_foto = "fotos-user?FK_pasta="+p.getId()+"&&nome-pasta="+p.getNome();
			 %>
			<div class="option" onclick = "
				window.location.href = '<%= url_foto %>'
			">
				<div class="icon-cntainer">
					<img class="menu-icon" src="img/suas-pastas.png" alt="pastas icon">
					<p class="text-icon"><%= p.getNome() %></p>
				</div>
			</div>
			<% } %>
			
			<div class="option">
				<div class="icon-cntainer"
					onclick="
					document.body.querySelector(`.modal-new-pasta`).style = 'block';
				">
					<img class="menu-icon" src="img/add-pasta.png" alt="new pasta icon">
					<p class="text-icon">Criar nova pasta</p>
				</div>
			</div>

		</div>

		<div class="modal-new-pasta" style="display: none;">
			<div class="close" onclick="closeModal('modal-new-pasta')">X</div>
			<form action="criar-pasta" method="post"
				class="form-new-pasta">
				<label class="label-input"> Informe o nome da sua pasta: <input
					type="text" name="name" class="input input-nome-pasta">
				</label> <label class="label-input"> Descrição: <input type="text"
					name="descricao" class="input input-nome-pasta">
				</label>
				<input type="text" value="user" name="criador" style="display: none;">
				<button type="submit" class="botao-form">Criar pasta</button>
			</form>
		</div>
	</main>
	<footer class="rodape">
		<div class="propaganda-pra-ficar-rico"></div>
	</footer>


	<script>
		function closeModal(classe){
			const container = document.body.querySelector(`.${classe}`);
			container.style.display = 'none';
		}

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