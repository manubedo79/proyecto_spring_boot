package com.springbootjpacrud.retor1.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.springbootjpacrud.retor1.models.entity.Productos;

public interface IProductosRepository extends JpaRepository<Productos, Long>{
	@Transactional
	@Modifying
	@Query("Update Productos p Set p.estado = ?1 where p.id=?2")
	public void updateEstadoProductos(boolean estado, Long id);
	
	@Query("Select count(*) from Productos")
	public int contarTotalProductos();
	
	@Query("Select sum(p.precio) from Productos p")
	public float sumadeprecio();
}
