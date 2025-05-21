package junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConfigServiceTest {
    @Mock
    private RestClient restClient;// Create mocks of dependencies

    @Test
    public void shouldTestFirstExceptionScenario() throws IOException {
        // Create an instance of the class you are testing
        ConfigService configService = new ConfigService(restClient);

        // Create input data for the method you are testing
        String stuff = "stuff";
        String path = "path";
        Map<String, String> additionalParams = Map.of("key", "value");
        Class<String> responseType = String.class;
        // Mock the behavior of the RestClient to throw an SSLHandshakeException
        when(restClient.get(any(), any(), any())).thenThrow(new SSLHandshakeException(""));

        // Call the method you are testing
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            configService.getResponse(stuff, path, additionalParams, responseType);
        });

        // Assert that the exception is of the expected type
        assertEquals("SSL Handshake Exception", exception.getErrorDetails().getBaseError());
    }
    @Test
    public void shouldTestSecondExceptionScenario() throws IOException {
        // You could extract some of the stuff common to both tests into a helper method if you wanted to
        // Create an instance of the class you are testing
        ConfigService configService = new ConfigService(restClient);

        // Create input data for the method you are testing
        String stuff = "stuff";
        String path = "path";
        Map<String, String> additionalParams = Map.of("key", "value");
        Class<String> responseType = String.class;
        // Mock the behavior of the RestClient to throw a SocketTimeoutException
        when(restClient.get(any(), any(), any())).thenThrow(new SocketTimeoutException(""));

        // Call the method you are testing
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            configService.getResponse(stuff, path, additionalParams, responseType);
        });

        // Assert that the exception is of the expected type
        assertEquals("Socket Timeout Exception", exception.getErrorDetails().getBaseError());
    }
    // Repeat this process for any other exceptions you want to test

    @Test
    public void testPositiveFlow() throws IOException {
        // Create an instance of the class you are testing
        ConfigService configService = new ConfigService(restClient);

        // Create input data for the method you are testing
        String stuff = "stuff";
        String path = "path";
        Map<String, String> additionalParams = Map.of("key", "value");
        Class<String> responseType = String.class;

        // Mock the behavior of the RestClient to return a valid response
        when(restClient.get(any(), any(), any())).thenReturn("valid response");

        // Call the method you are testing
        String result = configService.getResponse(stuff, path, additionalParams, responseType);

        // Assert that the result is as expected
        assertEquals("valid response", result);
    }

    //DUMMY CLASSES FOR TESTING
    class ConfigService {
        private RestClient restClient;
        public ConfigService(RestClient restClient) {
            this.restClient = restClient;
        }
        public <T> T getResponse(String stuff, String path, Map<String,String> additionalParams, Class<T> responseType) {
            try {
                return restClient.get(path, additionalParams, responseType);
            } catch (IOException e) {
                if (e instanceof SSLHandshakeException) {
                    throw new ServiceException(new ErrorDetails("SSL Handshake Exception"));
                } else if (e instanceof SocketTimeoutException) {
                    throw new ServiceException(new ErrorDetails("Socket Timeout Exception"));
                } else {
                    throw new ServiceException(new ErrorDetails("No Matching Data Found"));
                }
            }
        }
    }
    class RestClient {
        public <T> T get(String path, Map<String, String> additionalParams, Class<T> responseType) throws IOException{
            return null;
        }
    }
    class ServiceException extends RuntimeException {
        private ErrorDetails error;
        public ServiceException(ErrorDetails error) {
            this.error = error;
        }
        public ErrorDetails getErrorDetails() {
            return error;
        }
    }
    class ErrorDetails {
        private String baseError;
        public ErrorDetails(String baseError) {
            this.baseError = baseError;
        }
        public String getBaseError() {
            return baseError;
        }
    }
}
