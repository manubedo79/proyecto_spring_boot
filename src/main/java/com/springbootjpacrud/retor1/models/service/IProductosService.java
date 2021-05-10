package com.springbootjpacrud.retor1.models.service;

import java.util.List;

import com.springbootjpacrud.retor1.models.entity.Productos;

public interface IProductosService {
public List<Productos> findAllProductos();
public Productos findProductos(Long id);
public void saveProductos(Productos productos);
public void updateEstadoProductos(boolean  estado, Long id);
public int contarProductos();
public float contarprecio();
}
