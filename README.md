# urlaubsverwaltung-consumer

This repository demos how to use OpenID Connect (oidc) based on keycloak as a central authorisation server
and consuming http api from a resource server in our case [urlaubsverwaltung api](https://github.com/synyx/urlaubsverwaltung) 

## application

This is the java application consuming the urlaubsverwaltung api - login is based on odic

## openapi-client

This is a generated java client based on the openapi v3 spec of your urlaubsverwaltung.

## Run the application

Configure application.yaml with:
* urlaubsverwaltung instance url
* keycloak realm url
* oidc client / secret

```
./gradlew :application:bootRun

```