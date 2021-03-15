/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.dao;

import ec.bus.delinieve.reserva.generico.GenericoDao;
import ec.bus.delinieve.reserva.modelo.CaracteristicaProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marcos
 */
@Stateless
public class CaracteristicaProductoDao extends GenericoDao<CaracteristicaProducto> {

    public CaracteristicaProductoDao() {
        super(CaracteristicaProducto.class);
    }

    public List<CaracteristicaProducto> buscarCaracteristicaProducto() {
        Query query = getEntityManager().createQuery("SELECT cp FROM CaracteristicaProducto cp WHERE cp.estadoCaracteristicaProducto=true");
        List<CaracteristicaProducto> listaCaracteristicaProducto = query.getResultList();
        return listaCaracteristicaProducto;
    }
    
}
