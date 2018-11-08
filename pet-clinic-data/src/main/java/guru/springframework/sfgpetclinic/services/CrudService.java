package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
	public T findById(ID iD);

	public T save(T entity);

	public Set<T> findAll();

	public void delete(T entity);

	public void deleteById(ID id);
}
