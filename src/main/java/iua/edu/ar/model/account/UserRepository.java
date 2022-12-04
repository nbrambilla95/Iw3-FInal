package iua.edu.ar.model.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findFirstByUsernameOrEmail(String username, String email);
	
}
