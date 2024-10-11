package com.example.KitchenSink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.KitchenSink.entity.Member;
import com.example.KitchenSink.service.MemberRegistrationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/members")
public class MemberController {

	@Autowired
	private MemberRegistrationService memberService;

	
	//create the member
	@PostMapping
	public ResponseEntity<?> createMember(@Valid @RequestBody Member member) {
		try {
			memberService.register(member);
			return ResponseEntity.ok().body("Registration successful");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<List<Member>> listAllMembers() {
		List<Member> members = memberService.findAll();
		return ResponseEntity.ok(members);
	}

	@GetMapping("/page")
	public ResponseEntity<Page<Member>> listMembersWithPagination(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Member> members = memberService.findAll(pageable);
		return ResponseEntity.ok(members);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<Member> getMemberByEmail(@PathVariable String email) {
		Member member = memberService.findByEmail(email);
		if (member != null) {
			return ResponseEntity.ok(member);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/phone/{phoneNumber}")
	public ResponseEntity<Member> getMemberByPhone(@PathVariable String phoneNumber) {
		Member member = memberService.findByPhoneNumber(phoneNumber);
		if (member != null) {
			return ResponseEntity.ok(member);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/phone/{phoneNumber}")
	public ResponseEntity<String> deleteMemberByPhone(@PathVariable String phoneNumber) {
		boolean isDeleted = memberService.deleteByPhoneNumber(phoneNumber);
		if (isDeleted) {
			return ResponseEntity.ok("Member deleted successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
