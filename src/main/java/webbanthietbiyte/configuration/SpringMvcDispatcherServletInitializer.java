package webbanvali.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;


public class SpringMvcDispatcherServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(final ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = 
          new AnnotationConfigWebApplicationContext();
        
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);
        
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
        container.addFilter("encodingFilter", characterEncodingFilter)
        .addMappingForUrlPatterns(null, false, "/*");
        
        
    }
}
// config c�ch 2
//public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return null;
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		
//		return new Class[] { AppConfig.class };
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}
//
//}
