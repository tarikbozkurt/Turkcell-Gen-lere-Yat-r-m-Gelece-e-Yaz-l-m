package org.example;

public class CustomerService {

    private VerificationService verificationService;

    public CustomerService(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    public void add(Customer customer){
        if(verificationService.CheckIfRealPerson(customer))
            System.out.println("Doğrulandı");
        else
            System.out.println("Doğrulanamadı");


    }
}
