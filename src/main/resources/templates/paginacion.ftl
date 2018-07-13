  <script src="../vendor/js/ajax.js"></script>
    <script src="../vendor/jquery/jquery.min.js"></script>

<#list list as articulo>
              <!-- Blog Post -->
              <div class="card mb-4">
                  <div class="card-body">
                      <h2 class="card-title">${articulo.titulo}</h2>
                      <p class="card-text">${articulo.cuerpo}</p>
                      <a href="/verMas/${articulo.id}" style="float: right" class="btn btn-primary">Leer más &rarr;</a>
                  </div>
                  <div>

                      <#assign x = articulo.id>
                      <#list etiquetas as etiqueta>
                          <#assign y = etiqueta.articulo.id>
                          <#if (x == y?number) && etiqueta.articulo?? >
                              <a href="/articulos?etiqueta=${etiqueta.etiqueta}"
                                 class="badge badge-primary">${etiqueta.etiqueta}</a>
                          </#if>

                      </#list>
                  </div>
                  <div class="card-footer text-muted">
                      Publicado el ${articulo.fecha} por
                      <a href="/ver/${articulo.autor.id}">${articulo.autor.nombre}</a>

                  </div>
              </div>
</#list>

                <!-- Pagination -->
                <ul class="pagination justify-content-center mb-4">
                    <#if actual gt 1>
                        <li class="page-item">
                            <a id="atras" data-ruta="/inicio/${actual - 1}" class="page-link">&larr; Atras</a>
                        </li>

                    <#else>
                      <li class="page-item disabled">
                          <a class="page-link" href="#">Atras &larr;</a>
                      </li>

                    </#if>

                    <#if paginas gt actual>
                       <li class="page-item">
                           <a id="adelante" data-ruta="/inicio/${actual + 1}" class="page-link" >&rarr; Siguiente</a>
                       </li>
                    <#else>

                    <li class="page-item disabled">
                        <a class="page-link" href="#">Siguiente &rarr;</a>
                    </li>

                    </#if>

                </ul>