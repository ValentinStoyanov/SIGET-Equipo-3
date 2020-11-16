package es.uclm.esi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.uclm.esi.model.Reunion;

public interface RepositoryReuniones extends MongoRepository<Reunion,String> {
	
	Reunion save(Reunion reunion);

}
