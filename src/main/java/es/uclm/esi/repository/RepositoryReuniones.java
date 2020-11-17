package es.uclm.esi.repository;
import es.uclm.esi.model.Reunion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryReuniones extends MongoRepository<Reunion,String> {
	Reunion save(Reunion reunion);
	void delete(Reunion reunion);
}
