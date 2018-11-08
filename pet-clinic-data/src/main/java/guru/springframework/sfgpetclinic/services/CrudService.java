package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {
	T findById(ID iD);
	T save(T entity);
	Set<T> findAll();
	void delete(T entity);
	void deleteById(ID id);
}
