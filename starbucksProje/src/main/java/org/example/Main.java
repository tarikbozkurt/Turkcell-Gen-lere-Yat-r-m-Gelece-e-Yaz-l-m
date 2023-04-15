package org.example;

public class Main {
    public static void main(String[] args) {



        CustomerService service = new CustomerService(new EdevletServiceAdapter());
        // mesela dışarıdan bir kullanıcı gelecek
        // biz bu kullanıcıyı Edevlet Service içerisindeki
        // Task gereği statik tanımladığımız hazır listedeki
        // kişiler arasında tüm bilgileri doğru olarak var mı
        //kontrol için yeni customer oluşturuypruz.

        Customer customer1 = new Customer("Tarik", "BOZKURT", 1996, "12345");
        Customer customer2 = new Customer("Tarik", "BOZKURT", 1995, "12345");

        service.add(customer1);
        service.add(customer2);
    }

}