package com.springway.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.springway.observer.Subject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GlobalException implements HandlerExceptionResolver {

    @Autowired
    private Subject subject;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
            @Nullable Object object,
            Exception exception) {
        log.error("Exception info: {}", exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        if (exception instanceof CommonException) {
            final String message = new String(exception.getClass().getName() + " : " + exception.getMessage());
            modelAndView.addObject("message", message);
            modelAndView.setViewName("error");
        } else {
            final String message = new String(exception.getClass().getName() + " : " + exception.getMessage());
            modelAndView.addObject("message", message);
            modelAndView.setViewName("error");
            subject.notifyOperation(message);
        }
        return modelAndView;
    }

}
