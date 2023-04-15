package org.example;


//diyelim bize EdevletService gibi bir yapı geldi.
//herhangi bir firmanın/kurumun bu yapısını adaptor ile
//bunu kendi servisimiz gibi çalıştıracağız.
public class EdevletServiceAdapter implements VerificationService{

    private EdevletService edevletService = new EdevletService();


    @Override
    public boolean CheckIfRealPerson(Customer customer) {
        return edevletService.verify(customer.getName(), customer.getLastName(), customer.getBirthYear(), customer.getNationalId());

    }
}
