package org.primefaces.test;

import org.omnifaces.cdi.viewscope.ViewScopeManager;
import org.omnifaces.filter.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class SomeFilter extends HttpFilter {


    @Override
    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, HttpSession httpSession, FilterChain filterChain) throws ServletException, IOException {
        if (ViewScopeManager.isUnloadRequest(httpServletRequest)) {
            System.out.println("Unload request detected");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
