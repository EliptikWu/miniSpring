package service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import service.LoginService;

import java.util.Optional;

public class LoginServiceImpl implements LoginService {

    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return Optional.ofNullable((String) attr.getRequest().getSession().getAttribute("username"));
    }
}

