package com.hcl.cong.junit1;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

public class AccountDetailsTest {

	static AccountDetails accountDetails;

	// Always run before each test
	@BeforeAll
	static void initAll() {
		System.out.println("@BeforeAll block has been executed");
	}

	@BeforeEach
	void init() {
		accountDetails = new AccountDetails("Anita", 011401533, 114532, 5000.00, "Savings");
		accountDetails.setBalance(5000.00);
		System.out.println("@BeforeEach block has been executed");
		System.out.println("Initial account balance: " + accountDetails.getBalance());
	}

	@Test
	public void depositTest() {
		accountDetails.deposit(500.00);
		System.out.println("@Test block for deposit has been executed");
	}

	@Test
	public void withdrawTest() {
		accountDetails.withdraw(1000.00);
		System.out.println("@Test block for withdraw has been executed");
	}

	// Run after each test
	@AfterEach
	void balance() {
		System.out.println("Account balance : " + accountDetails.getBalance());
	}

	@AfterAll
	static void teardownAll() {
		System.out.println("@AfterAll block has been executed");
	}
}