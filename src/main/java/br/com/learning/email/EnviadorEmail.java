package br.com.learning.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviadorEmail {

	
	final protected String assuntoMensagem = "Voce foi convidado pela lista VIP";
	final protected String mensagem = "Olá, Voce acaba de ser convidado";
	
	public void enviar(String nome, String emailDestinatario) {
		try {

			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("javatesteapp@gmail.com", "Brasil123"));
			email.setSSLOnConnect(true);

			email.setFrom("javatesteapp@gmail.com");
			email.setSubject(assuntoMensagem);
			email.setMsg(nome + mensagem);
			email.addTo(emailDestinatario);
			email.send();
			
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
}
