package com.relaciones.servicio.interceptores;

import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

	protected static final Logger LOGGER = LogManager.getLogger(LoadingTimeInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		HandlerMethod controller = ((HandlerMethod) handler);
		
		LOGGER.info("LoadingTimeInterceptor: preHandle() entrando .... " + controller.getMethod().getName());
//		Parameter[] a = controller.getMethod().getParameters();
//		for(Parameter b:a) {
//			System.out.println(b.getName());
//		}
		
		
		
		return true;
	}
}