package examples.boot.jpaexam.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers(new AntPathRequestMatcher("/**.html"))
                .requestMatchers(new AntPathRequestMatcher("/static/**"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/boards")
                .permitAll()

                .and().authorizeRequests()

                .antMatchers("/").permitAll()
                .antMatchers("/boards/writeform").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/boards").hasRole("USER")
                .antMatchers("/boards/**").permitAll()
                .antMatchers("/members/joinform").permitAll()
                .antMatchers(HttpMethod.POST,"/members").permitAll()
                .antMatchers("/members/welcome").permitAll()
                .antMatchers("/members/login").permitAll()
                .antMatchers("/members/**").hasRole("USER")
                .antMatchers("/api/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().fullyAuthenticated()

                // csrf H2로그인 때문에 개발시에만 추가
                .and().csrf()
                .ignoringAntMatchers("/**")
                // csrf H2로그인 때문에 개발시에만 추가
                .and().headers().frameOptions().disable()

                .and().formLogin()
                .loginPage("/members/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/members/login")

                .and().logout().permitAll();
    }
}
