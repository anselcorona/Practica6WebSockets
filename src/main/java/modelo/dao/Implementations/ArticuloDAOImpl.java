package modelo.dao.Implementations;

import encapsulacion.Articulo;
import modelo.dao.interfaces.ArticuloDAO;
import modelo.servicios.Utils.CRUD;

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
        Query query = em.createNamedQuery("Articulo.findArticulobyAuthorId");
        query.setParameter("id", id);
        return (List<Articulo>) query.getResultList();
    }

    @Override
    public List<Articulo> getPagination(int pag) {
        EntityManager em = getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Articulo> criteriaQuery = builder.createQuery(Articulo.class);
        Root<Articulo> from = criteriaQuery.from(Articulo.class);
        CriteriaQuery<Articulo> select = criteriaQuery.select(from);
        List<javax.persistence.criteria.Order> orderList = new ArrayList();

        orderList.add(builder.asc(from.get("fecha")));
        criteriaQuery.orderBy(orderList);
        TypedQuery<Articulo> typedQuery = em.createQuery(select);
        typedQuery.setFirstResult((pag-1)*5);
        typedQuery.setMaxResults(5);


        return typedQuery.getResultList();
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


}
