# 🧬CodeADNCharacterGenerator
Welcome to the API Character Generator for CodeADN roleplaying game.

## 📝Usage
Launch the server.
`shell`
```shell 
  java -jar CodeADNCharacterGenerator.jar
```
Launch your browser and look at :
* the application - http://localhost:8080
* the API - http://localhost:8080/swagger-ui.html

## 💻 How to use from zero with command lines
`shell`
```shell
  git clone https://github.com/cymovan/CodeADNCharacterGenerator.git
  cd CodeADNCharacterGenerator/CodeADNCharacterGenerator
  mvn clean install
  java -jar target/CharacterGenerator-0.0.2-SNAPSHOT.jar &
  firefox http://localhost:8080/swagger-ui.html &
```
