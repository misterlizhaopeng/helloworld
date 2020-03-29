package lp.com.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	public void showStr() {
		System.out.println("repository is invoked ........");
	}
}
