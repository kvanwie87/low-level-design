package junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class AbstractServiceTest {
    // THIS IS THE CLASS I AM TESTING JUST HERE FOR QUICK REFERENCE
    class AbstractService {
        private final ConfigService configService;
        private final AuthService authService;
        public AbstractService(ConfigService configService, AuthService authService) {
            this.configService = configService;
            this.authService = authService;
        }
        public <T> T invoke(RequestDTO request, Class <T> responseType) {
            String authToken = authService.getAccessToken().getAccessToken(); // This would need to be mocked
            String path = request.getPath1();
            Map<String, String> additionalParams = new HashMap<>();
            additionalParams.put("token", authToken);
            LoginDTO loginDTO = configService.getResponse(request.getStuff1()+request.getStuff2(), request.getPath1(), additionalParams, LoginDTO.class);
            if(Objects.isNull(loginDTO.getUserInfo())) {
                throw new RuntimeException("User info is null");
            }
            String sessionKey = loginDTO.getUserInfo().getSessionKey();

            return configService.getResponse(request.getStuff1()+request.getStuff2(), request.getPath1() + sessionKey, additionalParams, responseType);
        }
    }
    // START OF CLASSES I AM NOT TESTING FOR REFERENCE, THEIR CODE DOESNT EVEN MATTER BECAUSE THEY WILL BE MOCKED
    class ConfigService {
        public <T> T getResponse(String stuff, String path, Map<String,String> additionalParams, Class<T> responseType) {
            return null;
        }
        public LoginDTO getResponse(String stuff, String path, Map<String, String> additionalParams) { return null; }
    }
    class AuthService {
        public AccessToken getAccessToken() {
            return null;
        }
    }
    class RequestDTO {
        private String path1;
        private String stuff1;
        private String stuff2;
        public String getPath1() {
            return path1;
        }
        public void setPath1(String path1) {
            this.path1 = path1;
        }
        public String getStuff1() {
            return stuff1;
        }
        public void setStuff1(String stuff1) {
            this.stuff1 = stuff1;
        }
        public String getStuff2() {
            return stuff2;
        }
        public void setStuff2(String stuff2) {
            this.stuff2 = stuff2;
        }
    }
    class LoginDTO {
        private UserInfo userInfo;
        public UserInfo getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }
    }
    class UserInfo {
        private String sessionKey;
        public String getSessionKey() {
            return sessionKey;
        }

        public void setSessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
        }
    }
    class AccessToken {
        private String token;
        public String getAccessToken() {
            return token;
        }
        public void setAccessToken(String token) {
            this.token = token;
        }
    }
    class SomeValidRequestType {

    }
    // END OF CLASSES I AM NOT TESTING


    // START OF ACTUAL JUNIT TEST

    // Make mocks of AbstractService dependencies
    @Mock ConfigService configService;
    @Mock AuthService authService;

    @Test
    public void shouldGetResponse() {
        // Create instance of AbstractService with mocked dependencies
        AbstractService abstractService = new AbstractService(configService, authService);

        // Data for mocks (Stuff like POJOs that can just store simple data be dummy objects instead of mocks)
        SomeValidRequestType someValidRequestTypeInstance = new SomeValidRequestType();
        LoginDTO loginDTO = new LoginDTO();
        UserInfo userInfo = new UserInfo();
        userInfo.setSessionKey("dummySessionKey");
        loginDTO.setUserInfo(userInfo);
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken("dummyAccessToken");

        // Config mocks
        when(authService.getAccessToken()).thenReturn(accessToken);
        when(configService.getResponse(any(), any(), any(), eq(LoginDTO.class))).thenReturn(loginDTO); // Mock of first call to configService
        when(configService.getResponse(any(), any(), any(), eq(SomeValidRequestType.class))).thenReturn(someValidRequestTypeInstance); // Mock of second call to configService

        //Create input data
        RequestDTO request = new RequestDTO();
        request.setPath1("dummyPath");
        request.setStuff1("dummyStuff1");
        request.setStuff2("dummyStuff2");

        // Call the method you are testing
        SomeValidRequestType response = abstractService.invoke(request, SomeValidRequestType.class);

        // Verify the output
        assertEquals(someValidRequestTypeInstance, response); // Confirming the response is what we told the mock to return
        
        // Can verify the mocks were called with the expected arguments
        verify(configService).getResponse(eq(request.getStuff1() + request.getStuff2()), eq(request.getPath1()), any(), eq(LoginDTO.class)); // Verifying the first call to configService
        verify(configService).getResponse(eq(request.getStuff1() + request.getStuff2()), eq(request.getPath1() + userInfo.getSessionKey()), any(), eq(SomeValidRequestType.class)); // Verifying the second call to configService

        // Can use argument captors to verify the arguments passed to the mocks
        ArgumentCaptor<Map<String, String>> captor = ArgumentCaptor.forClass(Map.class);
        verify(configService).getResponse(eq(request.getStuff1() + request.getStuff2()), eq(request.getPath1()), captor.capture(), eq(LoginDTO.class)); // Verifying the first call to configService
        Map<String, String> capturedMap = captor.getValue();
        assertEquals("dummyAccessToken", capturedMap.get("token")); // Verifying the token was added to the map

    }

    @Test
    public void shouldThrowExceptionWhenUserInfoIsNull() {
        // Create instance of AbstractService with mocked dependencies
        AbstractService abstractService = new AbstractService(configService, authService);

        // Data for mocks (Stuff like POJOs that can just store simple data be dummy objects instead of mocks)
        LoginDTO loginDTO = new LoginDTO(); // No userInfo set, simulating the null case
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken("dummyAccessToken");

        // Config mocks
        when(authService.getAccessToken()).thenReturn(accessToken);
        when(configService.getResponse(any(), any(), any(), eq(LoginDTO.class))).thenReturn(loginDTO); // Mock of first call to configService

        //Create input data
        RequestDTO request = new RequestDTO();

        // Call the method you are testing and verify it throws the expected exception
        assertThrows(RuntimeException.class, () -> {
            abstractService.invoke(request, SomeValidRequestType.class);
        });
    }
}
