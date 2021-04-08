package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	
	private static final String [] TEST_EMAILS = {"ab@bc.com",
			"a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};

	private static final String VALID_EMAIL = "ab@cd.com";

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
		
	// 3) addHeader (String name, String value)
		@Test
		public void testAddHeader() throws Exception {
			email.addHeader(VALID_EMAIL,VALID_EMAIL);
			assertEquals(1,email.headers.size());
			
		}
		@Test(expected = IllegalArgumentException.class)
		public void testAddHeaderEmpty()  throws Exception {
			email.addHeader("", VALID_EMAIL);
			assertEquals(null,email.headers.size());
			
		}
		@Test(expected = IllegalArgumentException.class)
		public void testAddHeaderEmpty2()  throws Exception {
			email.addHeader(VALID_EMAIL, "");
			assertEquals(null,email.headers.size());
			
		}
	 
		@Test 
		public void addHeaderTestValid(){
		email.addHeader("abcde@abc.com", "one"); 
		
		}
		
		
		
	
	
	
	
	
}
