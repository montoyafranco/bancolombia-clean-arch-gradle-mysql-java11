package co.com.bancolombia.api.utility;

public class BusinessException extends Exception {
    public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}
