# notaFilmes
Desenvolvimento de um sistema de avaliação de filmes para o trabalho da pós graduação.

Esse trabalho é uma representação de uma aplicação que deverá atender aos seguintes pontos:

- Permitir o cadastro de filmes
- Permitir que pessoas avaliem os filmes
- Listar os filmes com a média de avaliações

A entidade filme deve ter um título, sinopse, ano de lançamento, nome do(s) produtor(es), nome do(s) protagonista(s).

Deverá ser implementado a avaliação de cada filme em uma entidade relacionada com a entidade filmes, onde esta entidade deverá conter o nome da pessoa que realizou a avaliação do filme, um comentário opcional e a nota de avaliação do filme, que pode variar de 0 até 5.

O valor médio das avaliações dos filmes deve ser um valor calculado, e este valor não poderá ser armazenado no banco de dados.

O projeto deverá ser implementado utilizando as seguintes tecnologias abordadas em aula:

- Spring Boot
- Spring Data JPA
- PostgreSQL

