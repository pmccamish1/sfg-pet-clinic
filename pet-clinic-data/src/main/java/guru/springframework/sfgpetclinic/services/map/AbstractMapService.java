package guru.springframework.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import guru.springframework.sfgpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
	protected Map<Long, T> map = new HashMap<>();

	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	public T findById(ID id) {
		return map.get(id);
	}

	public T save(T entity) {
		if (entity != null) {
			if (entity.getId() != null) {
				map.put(entity.getId(), entity);
			} else {
				map.put(getNextId(), entity);
			}
		} else {
			throw new RuntimeException("Can't save a null object");
		}
		return entity;
	}

	public void delete(T entity) {
		map.values().remove(entity);
	}

	public void deleteById(ID id) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(id));
	}

	private Long getNextId() {
		if(map.isEmpty()) {
			return 1L;
		}
		return Collections.max(map.keySet()) + 1;
	}
}
