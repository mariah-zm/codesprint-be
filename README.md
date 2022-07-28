# codesprint-be

This is the Backend for a web application built with Spring Boot using Java 18. The web app was built for the 2022 edition of the coding competition [CodeSprint](https://codesprintmalta.edu.mt/) in which I placed [second](https://codesprintmalta.edu.mt/code-spint-2022/) in the Undergraduate category. 

A REST API was implemented on the Backend for FE and BE communication over HTTP. The API is documented using OpenAPI. A PostgreSQL database was used to store quiz and user data. Spring JPA was the library of choice for database connectivity. Spring Security was used to implement SSO with Google and Facebook using OAuth 2.0. Note, however, that the original configurations of the OAuth clients on Google and Facebook have been deleted due to making the repository public.

The competition required participants to build a web application that allows registered teachers to create quizzes for their students. Students are also required to register to access and attempt these quizzes. The task booklet containing the detailed requirements can be found [here](https://codesprintmalta.edu.mt/wp-content/uploads/2022/07/Undergrad_Task_2022.pdf).

The Frontend of the web app can be found in [this repository](https://github.com/mariah-zm/codesprint-spa).
