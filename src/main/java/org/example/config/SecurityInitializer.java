package org.example.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(2) //С помощью этого класса регистрируется класс DelegatingFilterProxy, чтобы
// применить компонент springSecurityFilterChain прежде, чем зарегистрировать любой
// другой фильтр. Ниже приведена реализация данного класса, которая выглядит пустой,
// поскольку в данном случае никакой специальной ее настройки не предполагается.
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
