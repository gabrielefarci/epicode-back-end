package com.epicode.gestioneDispositivi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestioneDispositivi.security.entity.User;

@Repository
public interface IUtenteRepository extends CrudRepository<User, Long> {

}
