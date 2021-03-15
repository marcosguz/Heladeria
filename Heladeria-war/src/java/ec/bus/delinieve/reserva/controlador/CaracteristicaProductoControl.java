/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.bus.delinieve.reserva.controlador;

import ec.bus.delinieve.reserva.modelo.Caracteristica;
import ec.bus.delinieve.reserva.modelo.CaracteristicaProducto;
import ec.bus.delinieve.reserva.servicio.CaracteristicaProductoServicio;
import ec.bus.delinieve.reserva.servicio.CaracteristicaServicio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Marcos
 */
@Named(value = "caracteristicaProductoControl")
@ViewScoped
public class CaracteristicaProductoControl {

    private CaracteristicaProducto caracteristicaProducto;
    private List<CaracteristicaProducto> listaCaracteristicaProducto;
    private List<SelectItem> selectItemCaracteristica;
    private Integer idCaracteristica;
    private Map<Integer, Caracteristica> mapaCaracteristica;
    
    @EJB
    private CaracteristicaServicio caracteristicaServicio;
    
    @EJB
    private CaracteristicaProductoServicio caracteristicaProductoServicio;
    
    @PostConstruct
    public void init(){
        caracteristicaProducto = new CaracteristicaProducto();
        crearSelectItemCaracteristica(buscarCaracteristica());
        buscarCaracteristicaProducto();
    }
    
    private void buscarCaracteristicaProducto(){
        listaCaracteristicaProducto = caracteristicaProductoServicio.buscarCaracteristicaProducto();
    }
    
    private List<Caracteristica> buscarCaracteristica(){
        List<Caracteristica> listaCaracteristica = caracteristicaServicio.buscarCaracteristica();
        mapaCaracteristica = new HashMap<>();
        for (Caracteristica caracteristica : listaCaracteristica) {
            mapaCaracteristica.put(caracteristica.getIdCaracteristica(), caracteristica);
        }
        return listaCaracteristica;
    }
    
    private void crearSelectItemCaracteristica(List<Caracteristica> listaCaracteristica){
        selectItemCaracteristica = new ArrayList<>();
        for (Caracteristica caracteristica : listaCaracteristica) {
            SelectItem itemCaracteristica = new SelectItem(caracteristica.getIdCaracteristica(), caracteristica.getNombreCaracteristica());
            selectItemCaracteristica.add(itemCaracteristica);
        }
    }
    
    public void guardar(){
        Caracteristica caracteristica = mapaCaracteristica.get(idCaracteristica);
        caracteristicaProducto.setIdCaracteristica(caracteristica);
        caracteristicaProductoServicio.guardar(caracteristicaProducto);
        limpiar();
        buscarCaracteristicaProducto();
    }
    
    public void limpiar(){
        this.caracteristicaProducto = new CaracteristicaProducto();
        idCaracteristica = null;
    }
    
    public void actualizar(CaracteristicaProducto caracteristicaProducto){
        this.caracteristicaProducto = caracteristicaProducto;
        this.idCaracteristica = caracteristicaProducto.getIdCaracteristica().getIdCaracteristica();
    }
    

    public CaracteristicaProducto getCaracteristicaProducto() {
        return caracteristicaProducto;
    }

    public void setCaracteristicaProducto(CaracteristicaProducto caracteristicaProducto) {
        this.caracteristicaProducto = caracteristicaProducto;
    }

    public List<CaracteristicaProducto> getListaCaracteristicaProducto() {
        return listaCaracteristicaProducto;
    }

    public void setListaCaracteristicaProducto(List<CaracteristicaProducto> listaCaracteristicaProducto) {
        this.listaCaracteristicaProducto = listaCaracteristicaProducto;
    }

    public List<SelectItem> getSelectItemCaracteristica() {
        return selectItemCaracteristica;
    }

    public void setSelectItemCaracteristica(List<SelectItem> selectItemCaracteristica) {
        this.selectItemCaracteristica = selectItemCaracteristica;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }
    
    
    
}
