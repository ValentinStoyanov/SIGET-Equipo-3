package es.uclm.esi.repository;
import es.uclm.esi.model.Reunion;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryReuniones extends MongoRepository<Reunion,String> {
	Reunion findFirstByOrderByIdDesc();
	Reunion findById(int _id);
	
	List<Reunion> findByAsistentesIn(String asistentes);
	
	Reunion deleteById(int _id);
	
	Reunion findByDiaAndMesAndAnoAndHora (int dia, int mes, int ano, String hora);
	
}