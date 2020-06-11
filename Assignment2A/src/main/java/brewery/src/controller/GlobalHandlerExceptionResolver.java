package brewery.src.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Brendan
 */

@Service
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver{
   
    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp,Object handler, Exception ex){
        return new ModelAndView("/error", "message","UH OH!!!!");
    }

  
}
