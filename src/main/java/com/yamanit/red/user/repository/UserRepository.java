package com.yamanit.red.user.repository;

import com.yamanit.red.user.model.User;

import java.util.Optional;

public interface UserRepository {
	Optional<User> findByUuid(String uuid);

	User addNewUser();

	User getUser(String uuid);

	User save(User user);
}
