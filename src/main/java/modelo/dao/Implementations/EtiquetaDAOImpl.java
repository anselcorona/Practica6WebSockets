package modelo.dao.Implementations;

import encapsulacion.Etiqueta;
import encapsulacion.Usuario;
import modelo.dao.interfaces.EtiquetaDAO;
import modelo.servicios.EntityServices.ArticuloService;
import modelo.servicios.EntityServices.EtiquetaService;
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

public class EtiquetaDAOImpl extends CRUD<Etiqueta> implements EtiquetaDAO {

    public EtiquetaDAOImpl(Class<Etiqueta> etiquetaClass) {
        super(etiquetaClass);
    }

    @Override
    public void insert(Etiqueta e){
        crear(e);
    }

    @Override
    public void update(Etiqueta e) {

        editar(e);
    }

    @Override
    public void delete(Etiqueta e) {
        eliminar(e);
    }

    @Override
    public List<Etiqueta> getAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Etiqueta.findAllEtiqueta");
        return (List<Etiqueta>) query.getResultList();
    }

    @Override
    public Etiqueta getById(long id) {

        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Etiqueta.findEtiquetaById");
        query.setParameter("id", id);
        return (Etiqueta) query.getSingleResult();
    }


    @Override
    public List<Etiqueta> getByArticulo(long id) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Etiqueta.findAllEtiquetaByArticuloId");
        query.setParameter("id", id);
        return (List<Etiqueta>) query.getResultList();
    }
}
