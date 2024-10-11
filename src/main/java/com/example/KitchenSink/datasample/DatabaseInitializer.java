package com.example.KitchenSink.datasample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.KitchenSink.entity.Member;
import com.example.KitchenSink.repository.MemberRepository;

@Component
public class DatabaseInitializer {

	@Autowired
	private MemberRepository memberRepository;

	@Bean
	CommandLineRunner initDatabase() {
		return args -> {
			memberRepository.save(new Member("Sumant", "sumant@globallogic.com", "9498897458"));
		};
	}
}