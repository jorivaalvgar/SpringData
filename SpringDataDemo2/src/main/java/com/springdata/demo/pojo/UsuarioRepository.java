package com.springdata.demo.pojo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

  List<Usuario> findByNombre(String nombre);

  Usuario findById(long idUsuario);
}