<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <!-- METADATA-->
  <!-- charset para caracteres especiales-->
  <meta charset="utf-8">

  <!-- author-->

  <meta name="author" content="Nombre Autor">

  <!-- description -->
  <meta name-="description" content="Esta debe ser la información que aparece en el párrafo que acompaña los resultados
 de una búsqueda en Internet.">
  <!-- keywords -->
  <meta name="keywords" content="registro de usuario, formulario de registro, crear cuenta, registro en línea">
  <!-- minimum responsive viewport -->
  <meta name="viewport" content="width-device-width, initial-scale=1">




  <!--Titulo -->
  <title>Registro nuevo usuario </title>
  <!--Favicon -->
  <link rel="icon " type="image/x-icon" href="./img/imagen_icono.png">
  <!-- CSS -->
  <!--BOOSTRAP-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <!--custom css -->
  <link rel="stylesheet" href="css/signin.css">
  <link rel="stylesheet" href="css/styles.css">


</head>
<body class="text-center">
<!--formulario login-->
<main class="form-signin w-100 m-auto">
  <form action="registerUser" method="post">
    <img class="mb-4" src="img/imagen_icono.png" alt="GAMES" width="300">
    <h4 class="text-secundary"> GAMES</h4>
    <h1 class="h5 mb-3 fw-normal">Registre sus datos  </h1>


    <div class="form-floating">
      <input type="text" class="form-control" name="user_firstname" id="floatingnombre"
             placeholder="Ingrese su nombre " required autofocus pattern="[A-Za-z0-5]{3,12}">
      <label for="floatingnombre">Nombres:</label>
    </div>

    <div class="form-floating">
      <input type="text" class="form-control" name="user_lastname" id="floatingapellido"
             placeholder="Ingrese su apellido " required  pattern="[A-Za-z0-5]{3,12}">
      <label for="floatingapellido">Apellido:</label>
    </div>

    <div class="form-floating">
      <input type="text" class="form-control" name="user_email" id="floatingemail"
             placeholder="Ingrese su nombre de usuario" required  pattern="^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$">
      <label for="floatingemail">Email:</label>
    </div>

    <div class="form-floating">
      <input type="password" class="form-control" name="user_password" id="floatingPassword"
             placeholder="Ingrese su Contraseña" required pattern="[A-Za-z0-9]{8,12}">
      <label for="floatingPassword">Contraseña:</label>
      <button class="w-100 btn btn-lg btn-primary" type="submit">Registrar</button>

    </div>
    <div id="register">
      <a href="index.jsp">Regresar</a>
    </div>
    <p class="mt-3 mb-3 text-muted"> Todos los derechos reservados @<%=displayDate()%>
    </p>


  </form>
</main>
</main>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

<%!
  public String displayDate(){
    SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY");
    Date date = Calendar.getInstance().getTime();
    return dateFormat.format(date);
  }
%>
</body>
</html>