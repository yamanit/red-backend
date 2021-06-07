package com.yamanit.red.user.repository;

import com.yamanit.red.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository implements UserRepositoryInterface {
	private static final Map<String, User> USER_MAP = new ConcurrentHashMap<>();

	@Override
	public Optional<User> findByUuid(String uuid) {
		return Optional.ofNullable(USER_MAP.get(uuid));
	}

	@Override
	public String addNewUser() {
		String uuid = UUID.randomUUID().toString();

		USER_MAP.put(uuid, new User(uuid));

		return uuid;
	}
}
