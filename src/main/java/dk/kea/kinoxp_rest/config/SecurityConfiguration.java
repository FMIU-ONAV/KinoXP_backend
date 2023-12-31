package dk.kea.kinoxp_rest.config;
import dk.kea.kinoxp_rest.JwtAuthenticationEntryPoint;
import dk.kea.kinoxp_rest.JwtFilter;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration implements WebMvcConfigurer {
    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    private JwtFilter filter;
    private static PasswordEncoder passwordEncoder;
    @Bean
    public static PasswordEncoder passwordEncoder() {
        if(passwordEncoder==null){
            passwordEncoder = new BCryptPasswordEncoder();
        }
        return passwordEncoder;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests(requests -> requests
                        .requestMatchers(new AntPathRequestMatcher("/movie/**", HttpMethod.GET.name())).permitAll()  // Allow only GET requests to /movie
                        .requestMatchers(new AntPathRequestMatcher("/category/**", HttpMethod.GET.name())).permitAll()  // Allow only GET requests to /movie
                        .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()  // Allow all requests to /login
                        .requestMatchers(new AntPathRequestMatcher("/signup")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/seats**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/seats/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/seat/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/seat/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/seat/")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/customer")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/showtime")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/update-showtime")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/showtime/**")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/rating")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/update-showtime/*")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/showtimes/*")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/ticket*")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/ticket**")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/ticket/**")).permitAll()  // Allow all requests to /signup
                        .requestMatchers(new AntPathRequestMatcher("/snacks")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/snacks/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/seat")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/seat/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/ticket/showtime/**")).permitAll()

       .requestMatchers(new AntPathRequestMatcher("/**", HttpMethod.OPTIONS.name())).permitAll()

                        .anyRequest().authenticated()
                )
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }







    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("addCorsMappings called");
        registry.addMapping("/**")  // /** means match any string recursively
                .allowedOriginPatterns("http://localhost:*/", "http://127.0.0.1:*/", "http://kinoxpkea.azurewebsites.net*", "https://delightful-pond-0c24f3603.3.azurestaticapps.net*") //Multiple strings allowed. Wildcard * matches all port numbers.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // decide which methods to allow
                // Allow preflight checks to return successful
                .allowedHeaders("*")
                .allowCredentials(true);
    }


}
