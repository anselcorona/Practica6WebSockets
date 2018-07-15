<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="/inicio">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/agregarPost">Agregar Post</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/agregarUsuario">Agregar Usuario</a>
                    </li>

                    <#if (usuario??)>
                        <#if (usuario.administrador??)>
                          <li class="nav-item">
                             <a class="nav-link" href="/mensajesAdmin">Mensajes</a>
                         </li>
                        </#if>
                         <li class="nav-item">
                             <a class="nav-link" href="/logOut">Salir</a>
                         </li>
                    <#else>
                     <li class="nav-item">
                         <a class="nav-link" href="/">Log In</a>
                     </li>
                    </#if>


                </ul>
            </div>
        </div>
    </nav>
