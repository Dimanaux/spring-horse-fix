# spring-horse-fix

Requirements:
- Java 8 or later
- Maven 3.3 or later

Installation and running:

    mvn clean install
    mvn spring-boot:run

Try it by opening [link](http://localhost/hourse/rest/count?width=10&height=14&start=B1&end=A3) in your browser.

Or Http request format: `GET http://localhost:8080/hourse/rest/count?width=2&height=3&start=A1&end=A3`.

Or simply curl it: `curl http://localhost:8080/hourse/rest/count?width=2&height=3&start=A1&end=A3`.
