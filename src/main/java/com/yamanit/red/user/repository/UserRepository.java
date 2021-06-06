package com.yamanit.red.user.repository;

import com.yamanit.red.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
	private static final Map<String, User> USER_MAP = new HashMap<>();

	public Optional<User> findByUuid(String uuid) {
		return Optional.ofNullable(USER_MAP.get(uuid));
	}

	public String addUser() {
		String uuid = UUID.randomUUID().toString();

		USER_MAP.put(uuid, new User(uuid));

		return uuid;
	}
}
