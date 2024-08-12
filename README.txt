1.Запустите PostgreSql
2.Настройте подключение к бд в application.properties
3.Запустите проект
4.Перейдите по ссылке http://localhost:8080/swagger-ui/index.html

Для проверки security измените код:
http.authorizeHttpRequests(auth -> auth.requestMatchers("/*").permitAll());
http.authorizeHttpRequests(auth -> auth.requestMatchers("/*/**").authenticated());