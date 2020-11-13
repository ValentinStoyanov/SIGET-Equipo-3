package es.uclm.esi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.uclm.esi.model.Reunion;

public interface RepositoryCalendarioPersonal extends MongoRepository<Reunion,String> {
	
	Reunion findById(int _id);

}
