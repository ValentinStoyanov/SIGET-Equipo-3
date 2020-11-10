package es.uclm.esi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.uclm.esi.model.Reunion;

public interface RepositoryCalendarioPersonal extends MongoRepository<Reunion,String> {
	
	List<Reunion> findAll();

}
