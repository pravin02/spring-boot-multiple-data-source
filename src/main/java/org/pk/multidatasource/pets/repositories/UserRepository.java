package org.pk.multidatasource.pets.repositories;

import org.pk.multidatasource.pets.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
