<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.pasta.dao.PastaDAO, br.com.WallpaperNext.model.pasta, br.com.config.*, java.util.ArrayList" %>
<%
	PastaDAO pastaDAO = new PastaDAO();
	configDAO configDao = new configDAO();
	
	List<pasta> lista = (List<pasta>)request.getAttribute("all-pastas");
	List<Integer> lista_fk_ = new ArrayList<Integer>();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajustes</title>
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
                <li><a>Sobre n�s</a></li>
            </ul>
        </nav>
    </div>
    <header>
        <div class="head-content">
            <div class="botao-icon botao-main" onclick="openMenu()">
                <img class="icon" src="img/menu.png" alt="menu icon">
            </div>
            <h1 class="title" style="font-size: 3rem;">Defini��es</h1>
            <div class="botao-icon botao-out">
                <img class="icon" src="img/logout_icon.png" alt="logout icon">
            </div>
        </div>
    </header>
    <main>
 
        <div class="menu-options">
            <div class="ajuste">
                <img class="icon-ajustes" src="img/reloginho.png" alt="clock icon">
                <p class="paragrafo">Intervalo de tempo de troca de tela : <input style="font-size: 2rem; font-family: monospace; padding: 0.5rem; width: 4rem" id="input-interval" type="number" name="intervalo"
                onchange=""
                > sec</p>
            </div>
        </div>
 
        <div class="menu-options">
            <div class="ajuste">
                <img onclick="openList()" class="icon-ajustes" src="img/add floder white.png" alt="clock icon">
                <p class="paragrafo">Definir pastas que ser�o inclusas no slide de imagens</p>
                
                <ul id="lista-pastas" style="display: none; list-style: none; background: #000000a6; width: 50vw">
                <%
                	for(pasta p : lista){
                %>
                	<% 
                	String checked = "";
                	if(lista_fk_.size() > 0){
                		if(lista_fk_.indexOf(p.getId()) != -1){
        					
        				}else{
        					checked="checked";
        				}
                	}
                	%>
                	<%!
                		void handleCheck(){
                			System.out.println("teste");
                		}
                	
                	%>
                	<li style="border-bottom: 1px solid #eee; padding: 20px; color: #eee" >
                		<label onclick="
                		<% 
                		System.out.println("listaaa - "+lista_fk_);
            			
       					if(lista_fk_.indexOf(p.getId()) < 0){
       						lista_fk_.add(p.getId());
       						configDao.setLista_FK_alowed(p.getId());
       					}else{
           					lista_fk_.remove(lista_fk_.indexOf(p.getId()));
           					configDao.remove_from_lidt_fk(p.getId());
       					}
                	 %> return false;">
                			<input <%=checked %> type="checkbox" style="width: 2rem; height: 2rem; padding: 0.1rem" value=<%= p.getId() %>  /> <%= p.getNome() %>
                		</label>
                	</li>
                	
                <% } %>
                </ul>
            </div>
        </div>
        
        <button style="font-size: 2.5rem; padding: .5rem; color: #eee; background: #000000a6; border: 1px solid #eee" onclick="redirectTo('set-configurations')">Configurar</button>
 
     
    </main>
    <footer class="rodape">
        <div class="propaganda-pra-ficar-rico"></div>
    </footer>
    
    <script>
    //&&list_allow=<%= lista_fk_ %>
    
    
    	function redirectTo(url){
    		let list = JSON.stringify(<%= lista_fk_ %>);
    		console.log(list);
    		localStorage.setItem("teste", list);
    		window.location.href = url+"?config=<%= configDao %>&&list_allow="+`${list}`;
    	}
    	function openList() {
    		document.body.querySelector('#lista-pastas').style.display = (document.body.querySelector('#lista-pastas').style.display=='block'? 'none': 'block');
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