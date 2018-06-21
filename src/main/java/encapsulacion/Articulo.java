package encapsulacion;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({@NamedQuery(name = "Articulo.findAllArticulo", query = "select a from Articulo a"),
        @NamedQuery(name = "Articulo.findArticulobyAuthorId", query = "select a from Articulo a where a.autor = :id"),
        @NamedQuery(name = "Articulo.findArticulobyId", query = "select a from Articulo a where a.id = :id")})
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String titulo;
    @Column(columnDefinition = "text")
    private String cuerpo;
    @OneToOne
    private Usuario autor;
    @Column
    private Date fecha;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Comentario> listaComentarios;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Etiqueta> listaEtiquetas;

    public Articulo() {
    }

    public Articulo(String titulo, String cuerpo, Usuario autor, Date fecha) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public Articulo(long id, String titulo, String cuerpo, Usuario autor, Date fecha) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(Set<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public Set<Etiqueta> getListaEtiquetas() {
        return listaEtiquetas;
    }

    public void setListaEtiquetas(Set<Etiqueta> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }
}
