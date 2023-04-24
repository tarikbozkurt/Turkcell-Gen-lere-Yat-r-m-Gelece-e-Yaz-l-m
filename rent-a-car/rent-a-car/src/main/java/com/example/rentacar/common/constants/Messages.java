package com.example.rentacar.common.constants;

public class Messages {
    public static class Car {
        public static final String CAR_NOT_FOUND = "CAR_NOT_FOUND";
        public static final String CAR_ALREADY_EXISTS = "CAR_ALREADY_EXISTS";
        public static final String CAR_NOT_AVAILABLE = "CAR_NOT_AVAILABLE";
        public static final String PLATE_ALREADY_EXISTS = "PLATE_ALREADY_EXISTS";

        public static final String PLATE_NOT_VALID = "PLATE_NUMBER_MUST_MATCH_THE_PATTERN";
    }

    public static class Model{
        public static final String MODEL_NOT_FOUND = "MODEL_NOT_FOUND";
        public static final String MODEL_ALREADY_EXISTS = "MODEL_ALREADY_EXISTS";

    }

    public static class Brand{
        public static final String BRAND_NOT_FOUND = "BRAND_NOT_FOUND";
        public static final String BRAND_ALREADY_EXISTS = "BRAND_ALREADY_EXISTS";

    }

    public static class Maintenance {
        public static final String MAINTENANCE_NOT_FOUND = "MAINTENANCE_NOT_FOUND";
        public static final String CAR_IS_CURRENTLY_UNDER_MAINTENANCE  = "CAR_IS_CURRENTLY_UNDER_MAINTENANCE ";
        public static final String CAR_NOT_REGISTERED_FOR_MAINTENANCE = "CAR_NOT_REGISTERED_FOR_MAINTENANCE";
        public static final String CAR_IS_CURRENTLY_RENTED_AND_CANNOT_BE_SERVICED_FOR_MAINTENANCE ="CAR_IS_CURRENTLY_RENTED_AND_CANNOT_BE_SERVICED_FOR_MAINTENANCE";
    }

    public static class Rental{
        public static final String RENTAL_NOT_FOUND = "RENTAL_NOT_FOUND";
    }

    public static class Payment{
        public static final String PAYMENT_NOT_FOUND = "PAYMENT_NOT_FOUND";
        public static final String CARD_NUMBER_ALREADY_EXISTS = "CARD_NUMBER_ALREADY_EXISTS";
        public static final String CARD_HAS_NOT_ENOUGHT_MONEY = "NOT_HAS_NOT_ENOUGHT_MONEY";
        public static final String NOT_A_VALID_PAYMENT = "NOT_A_VALID_PAYMENT";
        public static final String PAYMENT_FAILED = "PAYMENT_FAILED";
    }

    public static class Invoice{
        public static final String INVOICE_NOT_FOUND = "INVOICE_NOT_FOUND";
    }


}
