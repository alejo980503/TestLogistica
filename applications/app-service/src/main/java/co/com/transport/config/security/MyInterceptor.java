package co.com.transport.config.security;

import co.com.transport.model.exception.TokenException;
import co.com.transport.model.util.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
            String token = request.getHeader("Authorization");
            if (!Strings.isBlank(token) && token.startsWith("Bearer ")) {

                String cutToken = token.substring(7);
                boolean isValidToken = JwtTokenValidator.validateToken(cutToken);

                if (!isValidToken) {

                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token no válido");

                    return false;
                }

                return true;
            } else {
                throw new TokenException(Constants.UNAUTHORIZED, Constants.ERROR_VALIDATE_TOKEN,
                        Constants.TOKEN_INVALID);
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) {

    }
}
