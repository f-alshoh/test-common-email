package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	
	private static final String [] TEST_EMAILS = {"ab@bc.com",
			"a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};

	private static final String VALID_EMAIL = "ab@cd.com";
	private static final String TEST_EMAIL = "ab@bc.com";

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
		
		// 4) addReplyTo(String email, String name)
		@Test
		public void testAddReplyTo()throws  EmailException {
			email.addReplyTo(TEST_EMAIL,"");
			assertEquals(1, email.getReplyToAddresses().size());
			
		}

		// 5 ) buildMimeMessage()
		
		@Test
		public void testbuildMimeMessage1()throws Exception{
			
			email.addReplyTo(TEST_EMAIL,"");
			assertEquals(1, email.getReplyToAddresses().size());
			
		}
				
		@Test
		public void testbuildMimeMessage()throws Exception{
			email.setHostName("localhost");
			email.setSmtpPort(1234);
			email.setFrom("a@b.com");
			email.addTo("c@d.com");
			email.setSubject("test mail");
			email.setCharset("ISO-8859-1");
			email.setContent("test content", "test/plain");
			email.addCc("test@abc.com");
			email.addBcc("test2@abc.com");
			email.addHeader("test", "abc");
			email.addReplyTo("sss@b.com");
			email.buildMimeMessage();	
			//assertEquals()
		}
		@Test(expected = EmailException.class)
		public void testbuildMimeMessage2()throws Exception{
			email.setHostName("localhost");
			email.setSmtpPort(1234);
			email.setFrom("a@b.com");
			email.addTo("c@d.com");
			email.setSubject("test mail");
			email.setCharset("ISO-8859-1");
			email.setContent("test content", "test/plain");
			email.addCc("test@abc.com");
			email.addBcc("test2@abc.com");
			email.addHeader("test", "abc");
			email.addReplyTo("sss@b.com");
			email.setPopBeforeSmtp(true, "localhost", "username", "password");
			email.buildMimeMessage();		
		}
		@Test
		public void testbuildMimeMessage3()throws Exception{
			email.setHostName("localhost");
			email.setSmtpPort(1234);
			email.setFrom("a@b.com");
			email.addTo("c@d.com");
			email.setSubject("test mail");
			email.setCharset("ISO-8859-1");
			email.setContent(null, null);
			email.addCc("test@abc.com");
			email.addBcc("test2@abc.com");
			email.addHeader("test", "abc");
			email.addReplyTo("sss@b.com");
			email.buildMimeMessage();
		
		}

		// 6 ) getHostName()
		@Test
		public void testgetHostName() {
			email.setHostName("192.127.0.1");
			String hostname = email.getHostName();
			assertEquals("192.127.0.1",hostname);
		}
		@Test 
		public void testGetSetHostNameWithNull() {
			email.setHostName(null);
			assertEquals(null,email.getHostName());
		}
		@Test
		public void testGetSetHostNameWithSession() {
			Properties properties = new Properties();
			Session session = Session.getDefaultInstance(properties, null);
			properties.put(EmailConstants.MAIL_HOST, "smtp.gmail.com");
			email.setMailSession(session);
			assertEquals("smtp.gmail.com", email.getHostName());
		}
		
		// 7) getMailSession	
		@Test(expected=EmailException.class)
		public void testGetMaillSession() throws Exception {
			email.setHostName("");
			email.getMailSession();
			
		}
		@Test(expected = IllegalArgumentException.class)
		public void testGetMaillSession1() throws Exception {
			
			email.setMailSession(null);
			String session = email.getHostName();
			assertEquals("",session);
			
		}

		// 8) getSentDate()
		@Test
		public void testGetSentDate() {
			Date date=new Date(123);
			email.setSentDate(date);
			assertEquals(date,email.getSentDate());
		}

		
		// 9) getSocketConnectionTimeout()
		@Test
		public void testGetSocketConnectionTimeout() {
			email.setSocketConnectionTimeout(0);
			int socket=email.getSocketConnectionTimeout();
			
			assertEquals(0,socket);
			
			
		}

	
}
