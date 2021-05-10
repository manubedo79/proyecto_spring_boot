package com.springbootjpacrud.retor1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootjpacrud.retor1.models.entity.Productos;
import com.springbootjpacrud.retor1.models.service.IProductosService;

@Controller
public class ProductosController {
@Autowired
private IProductosService proser;


@GetMapping("/listarproductos")
public String listarproductos(Model model) {
	model.addAttribute("productos", proser.findAllProductos());
	model.addAttribute("totalproducto", proser.contarProductos());
	model.addAttribute("totalprecio", proser.contarprecio());
	return "listar";
}
@GetMapping("/detalleproductos/{id}")
public String detalle(@PathVariable(name="id") Long id, Model model) {
	Productos productos = null;
	if(id>0) {
		productos =proser.findProductos(id);
	}
	model.addAttribute("producto", productos);
	return "detalle";
}
@GetMapping("/formularioproducto")
public String formulario(Model model) {
	model.addAttribute("producto", new Productos());
	return "formulario";
}
@PostMapping("/guardarproducto")
public String guardar(Productos productos) {
	proser.saveProductos(productos);
	return "redirect:/listarproductos";
}
@GetMapping("/editarproducto/{id}")
public String editar(@PathVariable(name="id") Long id,Model model) {
	Productos productos = null;
	if(id>0) {
		productos =proser.findProductos(id);
	}
	model.addAttribute("producto", productos);
	return "formulario";	
}
@GetMapping("/cambioestado/{estado}/{id}")
public String cambiarestado(@PathVariable(name="estado") boolean estado,
		@PathVariable(name="id") Long id) {
	if(id>0) {
		proser.updateEstadoProductos(estado, id);
	}
	return "redirect:/listarproductos";
}
}
