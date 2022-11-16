package com.bitsco.vks.config;

//import org.apache.catalina.Context;
//import org.apache.catalina.connector.Connector;
//import org.apache.tomcat.util.descriptor.web.SecurityCollection;
//import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
//import org.springframework.boot.web.embedded
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedServletConfig {
//    @Bean
//    public EmbeddedServletContainerFactory servletContainerFactory() {
//        return new TomcatEmbeddedServletContainerFactory() {
//
//            @Override
//            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
//                    Tomcat tomcat) {
//                // Ensure that the webapps directory exists
//                new File(tomcat.getServer().getCatalinaBase(), "webapps").mkdirs();
//
//                try {
//                    Context context = tomcat.addWebapp("/foo", "/path/to/foo.war");
//                    // Allow the webapp to load classes from your fat jar
//                    context.setParentClassLoader(getClass().getClassLoader());
//                } catch (ServletException ex) {
//                    throw new IllegalStateException("Failed to add webapp", ex);
//                }
//                return super.getTomcatEmbeddedServletContainer(tomcat);
//            }
//
//        };
//    }
}
