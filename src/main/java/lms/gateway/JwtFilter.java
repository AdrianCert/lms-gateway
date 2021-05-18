package lms.gateway;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import static org.springframework.util.StringUtils.hasText;

@Component
public class JwtFilter extends GenericFilterBean {

    @Autowired
    private JwtProvider jwtProvider;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = extractAuthToken(httpServletRequest);

        if( token != null) {
            Integer xCurrentUser = jwtProvider.getLoginFromToken(token);
            HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(httpServletRequest);
            requestWrapper.addHeader("X-Current-User", xCurrentUser.toString());
            filterChain.doFilter(requestWrapper, servletResponse);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
    

    public String extractAuthToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}
