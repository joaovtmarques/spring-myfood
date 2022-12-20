# MVP - API de delivery de comida.

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

## 👨‍💻 Tecnologias

#### Este projeto foi desenvolvido com as seguintes tecnologias e bibliotecas:

- [Spring](https://spring.io/)
- [Java](https://www.java.com/pt-BR/)
- [PostgreSQL](https://www.postgresql.org/)
- [Lombok](https://projectlombok.org/)
- [Swagger](https://swagger.io/)

<br>

## 📊 Modelo de domínio - Diagrama de classes

<img src="docs/domain-model.jpg">

<br>

## ℹ️ Como rodar o aplicativo

### Pré-requisitos

Para clonar e rodar a aplicação, é necessário ter instalado em sua máquina as ferramentas:
[Git](https://git-scm.com), [Java](https://www.java.com/pt-BR/) e [Maven](https://maven.apache.org/) (opcional).
Além disso, é bom que se tenha um bom editor de código, como o [VSCode](https://code.visualstudio.com/)

### 🎲 Rodando a aplicação

```bash
# Clone este repositório
git clone <https://github.com/joaovtmarques/spring-myfood>

# Acesse a pasta do projeto no terminal
cd spring-myfood

# Compile o projeto
./mvnw compile

# Execute a aplicação
./mvnw spring-boot:run

```