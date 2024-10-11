package com.example.KitchenSink.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.KitchenSink.entity.Member;
import com.example.KitchenSink.repository.MemberRepository;

@Service
public class MemberRegistrationService {

	@Autowired
	private MemberRepository memberRepository;

	public void register(Member member) {
		memberRepository.save(member);
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Page<Member> findAll(Pageable pageable) {
		return memberRepository.findAll(pageable);
	}

	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public Member findByPhoneNumber(String phoneNumber) {
		return memberRepository.findByPhoneNumber(phoneNumber);
	}

	public boolean deleteByPhoneNumber(String phoneNumber) {
		Member member = memberRepository.findByPhoneNumber(phoneNumber);
		if (member != null) {
			memberRepository.delete(member);
			return true;
		}
		return false;
	}
}
