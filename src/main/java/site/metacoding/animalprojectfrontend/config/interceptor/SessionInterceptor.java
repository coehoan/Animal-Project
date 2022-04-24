package site.metacoding.animalprojectfrontend.config.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.animalprojectfrontend.domain.user.User;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();

        User principal = (User) session.getAttribute("principal");

        if (principal == null) {
            throw new RuntimeException("인증되지 않았습니다.");
        } else {
            return true;
        }
    }
}
