package kodlamaio.hrms.core.concretes;

import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MailVerificationService;

@Service
public class MailVerificationManager  implements MailVerificationService {

	@Override
	public void mailVerificationCode() {
		
		System.out.println(" ");
		System.out.println("******************Kullanıcı Doğrulama Sistemi******************");
		Random random = new Random();
		int code = random.nextInt(1000);
		
		String code2 = Integer.toString(code);
				
		System.out.println("Verifying Code : "+ code);
		
		System.out.println("Kayıt doğrulama için size gönderiken doğrulama kodunuz:");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Size gönderilen kodu giriniz:");
		
		String codeinput = scanner.nextLine();
		
		if(code2.equals(codeinput)) {
			
			System.out.println("Code verified and login completed successfully");
		}else {
			System.out.println("The code could not be verified");
			
		}
		
	}

		

}
