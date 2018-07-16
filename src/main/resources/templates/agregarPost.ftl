<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <title>Blog Post - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../css/blog-post.css" rel="stylesheet">

</head>

<body>


  <!-- Navigation -->
  <#include "menu.ftl">

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

          <div class="lead">
            <!-- Title -->
            <form method="post" action="/guardarPost">

              <div class="form-group">
                <h1 class="mt-4">Agregar Post</h1>
                <hr>
                <input type="text" class="form-control" placeholder="Titulo" aria-label="Username" aria-describedby="basic-addon1" name="titulo">
              </div>

              <div class="form-group">
                <h4 class="mt-4">Contenido</h4>
                <textarea class="form-control" rows="3" placeholder="Cuerpo del post" name="cuerpo"></textarea>
              </div>

              <div class="form-group">
                <h4 class="mt-4">Etiquetas</h4>
                <input type="text" class="form-control" placeholder="etiqueta1, etiqueta2,..." name="etiquetas">
              </div>
              <button style="float: right" type="submit" class="btn btn-primary">Guardar</button>
            </form>
          </div>


        </div>
        <#if (usuario??)>

        <#if (!usuario.administrator)>
          <#include "hablar.ftl">

        </#if>
      </#if>
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <br>

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="../vendor/vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>