package com.example.KitchenSink.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.KitchenSink.entity.Member;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
	Member findByEmail(String email);

	Member findByPhoneNumber(String phoneNumber);
}
