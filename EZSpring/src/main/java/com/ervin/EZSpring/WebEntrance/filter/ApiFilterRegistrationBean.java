package com.ervin.EZSpring.WebEntrance.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Order(20)
@Component
public class ApiFilterRegistrationBean extends FilterRegistrationBean<Filter> {
    @PostConstruct
    public void init() {
        setFilter(new ApiFilter());
        List<String> lis = new ArrayList<>();
        lis.add("/api/*");
        setUrlPatterns(lis);
    }

    class ApiFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setHeader("X-Api-Version", "1.0");
            chain.doFilter(request, response);
        }
    }
}

