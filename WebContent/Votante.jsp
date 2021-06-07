
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>votante</title>
</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #DA232B"
			<div>
				<img style="width: 100px; height: 100px;" src="https://upload.wikimedia.org/wikipedia/commons/0/03/UFPS_Logo.png" alt="jpg">
		</nav>
	</header>

	<br>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<caption>
					<h2>
					  validacion proceso de votacion
					</h2>
				</caption>

				<fieldset class="form-group">
					<label>nombre</label> <input type="text"
						value="<c:out value='${votante.nombre}'/>" class="form-control"
						name="nombre" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>email</label> <input type="email"
						value="<c:out value='${votante.email}'/>"
						class="form-control" name="email" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Numero de documento</label> <input type="text"
						value="<c:out value='${votante.documento}'/>" class="form-control"
						name="documento">
				</fieldset>

        <fieldset class="form-group">
          <label>Tipo de documento</label> <input type="text"
						value="<c:out value='${votante.tipo_documento}'/>" class="form-control"
						name="tipo_documento">
				</fieldset>
				<button type="submit" class="btn btn-success">confirmo mis datos</button>

			</div>

		</div>

	</div>

	<footer style="background-color:#DA232B">
	  <p style="text-align:center">votaciones ufps</p>
	</footer>
</body>
</html>
