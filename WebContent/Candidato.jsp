<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Candidato</title>
</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #DA232B"
			<div>
				<img style="width: 100px; height: 100px;" src="https://upload.wikimedia.org/wikipedia/commons/0/03/UFPS_Logo.png" alt="jpg">
				<a href="#" class="navbar-brand">inscribir Candidato</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> Candidatos </a></li>
			</ul>
		</nav>
	</header>

	<br>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${candidato != null}">
					<form action="update" method="get">
				</c:if>
				<c:if test="${candidato == null}">
					<form action="insert" method="get">
				</c:if>
				<caption>
					<h2>
						<c:if test="${candidato != null}">Editar Candidato</c:if>
						<c:if test="${candidato == null}">Agregar Candidato</c:if>
					</h2>
				</caption>
				<fieldset class="form-group">
					<label>ID</label> <input type="text"
						value="<c:out value='${candidato.id}'/>" class="form-control"
						name="id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Documento</label> <input type="text"
						value="<c:out value='${candidato.documento}'/>"
						class="form-control" name="documento" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Nombre</label> <input type="text"
						value="<c:out value='${candidato.nombre}'/>" class="form-control"
						name="nombre" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Apellido</label> <input type="text"
						value="<c:out value='${candidato.apellido}'/>"
						class="form-control" name="apellido" required="required">
				</fieldset>


				<fieldset class="form-group">
					<label>Eleccion</label> <select class="form-select" name="eleccion">
						<option selected>Seleccione Una</option>
						<c:forEach var="dd" items="${listEleccion}">
							<option value='${dd.id}'>"${dd.nombre}"</option>
						</c:forEach>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Numero</label> <input type="text"
						value="<c:out value='${candidato.numero}'/>" class="form-control"
						name="numero">
				</fieldset>

				<button type="submit" class="btn btn-success">Enviar</button>

				</form>

			</div>

		</div>

	</div>
	<footer style="background-color:#DA232B" >
	  <p style="text-align:center">votaciones ufps</p>
	</footer>
</body>
</html>