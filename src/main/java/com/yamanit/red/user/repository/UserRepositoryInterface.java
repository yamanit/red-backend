package com.yamanit.red.user.repository;

import com.yamanit.red.user.model.User;

import java.util.Optional;

public interface UserRepositoryInterface {
	Optional<User> findByUuid(String uuid);

	User addNewUser();
}
