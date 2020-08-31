package group.unimeb.market.filter;

import com.google.gson.Gson;
import group.unimeb.market.model.ResponseInfo;
import group.unimeb.market.model.User;
import group.unimeb.market.util.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/signin");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getParameter("email"),
                        request.getParameter("password"))
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        User user = (User) authResult.getPrincipal();

        String role = "";
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();
        }

        String token = JwtTokenUtils.createToken(user.getUsername(), role, false);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("token", token);
        responseData.put("uid", user.getUid());
        responseData.put("email", user.getEmail());
        responseData.put("displayName", user.getDisplayName());

        response.getWriter().write(new Gson().toJson(ResponseInfo.buildSuccess(responseData)));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        int code;
        String msg;

        if (failed == null || failed.getMessage() == null) {
            code = 1001;
            msg = "Incorrect username or password.";
        } else if (failed.getMessage().equalsIgnoreCase("User is disabled")) {
            code = 1002;
            msg = "User disabled.";
        } else if (failed.getMessage().equalsIgnoreCase("Bad credentials")
                || failed.getMessage().equalsIgnoreCase("User not found")) {
            code = 1001;
            msg = "Incorrect username or password.";
        } else {
            code = 1000;
            msg = failed.getMessage();
        }
        response.getWriter().write(new Gson().toJson(ResponseInfo.buildFailure(code, msg)));
    }

}

