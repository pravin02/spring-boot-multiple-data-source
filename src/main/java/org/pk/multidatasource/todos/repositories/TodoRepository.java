package org.pk.multidatasource.todos.repositories;

import org.pk.multidatasource.todos.entities.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
