package modelo.dao.Implementations;

import encapsulacion.Comentario;
import encapsulacion.Usuario;
import modelo.dao.interfaces.ComentarioDAO;
import modelo.servicios.EntityServices.ComentarioService;
import modelo.servicios.EntityServices.UsuarioService;
import modelo.servicios.Utils.CRUD;
import modelo.servicios.Utils.DBService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComentarioDAOImpl extends CRUD<Comentario> implements ComentarioDAO {

    public ComentarioDAOImpl(Class<Comentario> comentarioClass) {
        super(comentarioClass);
    }

    @Override
    public void insert(Comentario e) {
        crear(e);

    }

    @Override
    public void update(Comentario e) {
        editar(e);


    }

    @Override
    public void delete(Comentario e) {
        eliminar(e);
    }

    @Override
    public List<Comentario> getAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Comentario.findAllComentario");
        return (List<Comentario>) query.getSingleResult();
    }

    @Override
    public Comentario getById(long id) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Comentario.findComentarioById");
        query.setParameter("id", id);
        return (Comentario) query.getSingleResult();
    }

    @Override
    public List<Comentario> getByArticulo(long id) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Comentario.findAllComentarioByArticulo");
        query.setParameter("id", id);
        return (List<Comentario>) query.getResultList();
    }
}
