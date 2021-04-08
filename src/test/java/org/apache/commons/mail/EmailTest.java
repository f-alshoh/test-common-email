package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	
	private static final String [] TEST_EMAILS = {"ab@bc.com",
			"a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};

	private EmailConcrete email;
	
	@Before
	public void  setUpEmailTest() throws Exception{
		email = new EmailConcrete();
	}
	
	@After
	public void  tearDownEmailTest() throws Exception{	
	}
	
	// 1 ) AddBcc(String email)
	@Test
	public void testAddBcc() throws Exception{
		email.addBcc( TEST_EMAILS);
		assertEquals(3, email.getBccAddresses().size());	
	}

	// 2) AddCc(String email)
		@Test
		public void testAddCc() throws Exception{
			email.addCc(TEST_EMAILS);
			assertEquals(3, email.getCcAddresses().size());
			
		}

	
	
	
	
	
}
