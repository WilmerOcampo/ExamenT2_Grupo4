package com.WAEC2GRUPO4.ExamenT2.configuration;
import com.WAEC2GRUPO4.ExamenT2.service.CustomSuccessHandler;
import com.WAEC2GRUPO4.ExamenT2.service.DetalleUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private DetalleUsuarioService detalleUsuarioService;
    private CustomSuccessHandler customSuccessHandler;
    @Bean
    public SecurityFilterChain configSecurity(HttpSecurity httpSecurity)
            throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers("/auth/login",
                                                "/resources/**",
                                                "/static/**",
                                                "/css/**",
                                                "/js/**",
                                                "/seguridad/registro",
                                                "/templates/**")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated()
                ).formLogin(
                        login->
                                login.loginPage("/auth/login")
                                        .loginProcessingUrl("/login")
                                        .usernameParameter("username")
                                        .passwordParameter("password")
                                        .successHandler(customSuccessHandler)
                                        .permitAll()
                ).logout(
                        logout->
                                logout.logoutSuccessUrl("/auth/login")
                                        .invalidateHttpSession(true)
                ).authenticationProvider(authenticationProvider());
        return httpSecurity.build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(detalleUsuarioService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

}

