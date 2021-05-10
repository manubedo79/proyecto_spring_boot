package com.springbootjpacrud.retor1.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootjpacrud.retor1.models.entity.Productos;
import com.springbootjpacrud.retor1.models.repository.IProductosRepository;
@Service
public class ProductosServiceImp implements IProductosService{
	@Autowired
	private IProductosRepository prorepo;
	
	@Transactional(readOnly=true)
	@Override
	public List<Productos> findAllProductos() {
		// TODO Auto-generated method stub
		return prorepo.findAll();
	}

	@Override
	public Productos findProductos(Long id) {
		// TODO Auto-generated method stub
		return prorepo.findById(id).orElse(null);
	}

	@Override
	public void saveProductos(Productos productos) {
		productos.setEstado(true);
		prorepo.save(productos);
		
	}

	@Override
	public void updateEstadoProductos(boolean estado, Long id) {
		prorepo.updateEstadoProductos(estado, id);
		
	}

	@Override
	public int contarProductos() {
		// TODO Auto-generated method stub
		return prorepo.contarTotalProductos();
	}

	@Override
	public float contarprecio() {
		// TODO Auto-generated method stub
		return prorepo.sumadeprecio();
	}

}
