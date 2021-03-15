/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.servicio;

import ec.bus.delinieve.reserva.dao.CaracteristicaProductoDao;
import ec.bus.delinieve.reserva.modelo.CaracteristicaProducto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Marcos
 */
@Stateless
@LocalBean
public class CaracteristicaProductoServicio {

    @EJB
    private CaracteristicaProductoDao caracteristicaProductoDao;
    
    public void guardar(CaracteristicaProducto caracteristicaProducto){
        caracteristicaProductoDao.create(caracteristicaProducto);
    }

    public List<CaracteristicaProducto> buscarCaracteristicaProducto() {
        List<CaracteristicaProducto> listaCaracteristicaProducto = caracteristicaProductoDao.buscarCaracteristicaProducto();
        return listaCaracteristicaProducto;
    }
    
}
