package co.com.bancolombia.api.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class Response {

    public Boolean error;
    public String message;
    public Timestamp timestamp;

    public Object data;

    public Response() {
        error = false;
        message = "";
        data = null;
        timestamp = Timestamp.from(Instant.now());
    }

    public void restart() {
        error = false;
        message = "";
        data = null;
    }

}
