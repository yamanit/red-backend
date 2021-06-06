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
	public User addNewUser() {
		String uuid = UUID.randomUUID().toString();

		User newUser = new User(uuid);

		USER_MAP.put(uuid, newUser);

		return newUser;
	}

	public User getUser(String uuid) {
		return USER_MAP.get(uuid);
	}

	public User save(User user) {
		if (user.getUuid() == null) {
			return addNewUser();
		} else {
			return USER_MAP.get(user.getUuid())
						   .setNickname(user.getNickname());
		}
	}
}
