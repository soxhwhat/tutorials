package com.baeldung.annotations.service;

import com.baeldung.annotations.service.abstracts.AbstractAuthenticationService;
import com.baeldung.annotations.service.interfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication {
    /**
     * 不建议将@Service注解放在抽象接口或者抽象类上，如果实现类或者子类不添加注解将会出现NoSuchBeanDefinitionException异常。
     * 也就是该spring注解不会生效
     *
     * 最终，我们发现唯一可行的方法是将@Service放在我们的实现类上，使它们可以自动检测。Spring的组件扫描不会拾取类，除非它们被单独注释，即使它们是从另一个@Service注释接口或抽象类派生的。
     * 此外，Spring的文档还指出，在实现类上使用@Service允许组件扫描自动检测它们。
     */
    @Autowired
    private AuthenticationService inMemoryAuthService;

    @Autowired
    private AbstractAuthenticationService ldapAuthService;

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}