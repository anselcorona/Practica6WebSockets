package modelo.dao.Implementations;

import encapsulacion.Articulo;
import modelo.dao.interfaces.ArticuloDAO;
import modelo.servicios.Utils.CRUD;
import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAOImpl extends CRUD<Articulo> implements ArticuloDAO  {

    public ArticuloDAOImpl(Class<Articulo> articuloClass) {
        super(articuloClass);
    }

    @Override
    public void insert(Articulo e){
       crear(e);
    }

    @Override
    public void update(Articulo e) {

      editar(e);

    }


    @Override
    public void delete(Articulo e) {
        eliminar(e.getId());
    }

    @Override
    public List<Articulo> getAll() {

        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Articulo.findAllArticulo");
        return (List<Articulo>) query.getResultList();
    }

    @Override
    public List<Articulo> getbyAutor(long id) {


        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Articulo.findArticulobyAuthorId");
            query.setParameter("id", id);
            return (List<Articulo>) query.getResultList();
        }catch (Exception e){
            return null;
        }finally {
            em.close();
        }

    }

    @Override
    public List<Articulo> getPagination(int pag) {
        EntityManager em = getEntityManager();

        try {
            Query query = em.createQuery("select a from Articulo a order by a.id desc");

            query.setFirstResult((pag-1)*5);
            query.setMaxResults(5);

            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }


    @Override
    public Articulo getById(long id) {

       return find(id);
    }

    @Override
    public List<Articulo> getAllByEtiqueta(String etiqueta) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Articulo.findArticulobyEtiqueta");
        query.setParameter("etiqueta", etiqueta);
        return (List<Articulo>) query.getResultList();
    }

    @Override
    public int cantPaginas() {

        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Articulo.findAllArticulo");
            return  query.getResultList().size();
        }catch (Exception e){
            return -1;
        }finally {
            em.close();
        }


    }


}
