# SalesCore Data Access

Sistema desenvolvido em Java para gerenciamento de vendedores e departamentos utilizando JDBC, MySQL e o padrão DAO (Data Access Object).

O projeto demonstra a construção de uma camada de persistência desacoplada, aplicando boas práticas de desenvolvimento orientado a objetos, acesso a banco de dados relacional e arquitetura em camadas.

---

## Visão Geral

O SalesCore Data Access permite:

- Consultar vendedores por ID
- Listar vendedores por departamento
- Listar todos os vendedores cadastrados
- Inserir novos vendedores
- Atualizar informações existentes
- Remover registros
- Gerenciar departamentos relacionados aos vendedores
- Aplicar o padrão DAO para abstração do acesso aos dados

---

## Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de demonstrar:

- Utilização do JDBC na prática
- Conexão com banco de dados MySQL
- Implementação manual do padrão DAO
- Separação entre regras de negócio e persistência
- Manipulação de ResultSet e PreparedStatement
- Tratamento de exceções de banco de dados
- Aplicação de conceitos de Programação Orientada a Objetos

---

## Arquitetura

O sistema segue uma arquitetura baseada em camadas:

```text
Application
     ↓
DAO Interfaces
     ↓
DAO Implementations
     ↓
JDBC
     ↓
MySQL Database
```

---

## Estrutura do Projeto

```text
src
│
├── application
│   └── Program.java
│
├── db
│   ├── DB.java
│   ├── DbException.java
│   └── DbIntegrityException.java
│
├── model
│   ├── dao
│   │   ├── DaoFactory.java
│   │   ├── SellerDao.java
│   │   ├── DepartmentDao.java
│   │   └── impl
│   │       └── SellerDaoJDBC.java
│   │
│   └── entities
│       ├── Seller.java
│       └── Department.java
```

---

## Modelo de Domínio

### Seller

Representa um vendedor cadastrado no sistema.

| Campo      | Tipo       |
| ---------- | ---------- |
| id         | Integer    |
| name       | String     |
| email      | String     |
| birthDate  | Date       |
| baseSalary | Double     |
| department | Department |

---

### Department

Representa um departamento da empresa.

| Campo | Tipo    |
| ----- | ------- |
| id    | Integer |
| name  | String  |

---

## Tecnologias Utilizadas

- Java
- JDBC
- MySQL
- Eclipse IDE
- Maven (opcional para gerenciamento)
- Git

---

## Padrão DAO

O projeto utiliza o padrão Data Access Object (DAO) para desacoplar a lógica de persistência das regras de negócio.

### Interface

```java
public interface SellerDao {
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
}
```

### Implementação

```java
public class SellerDaoJDBC implements SellerDao {
    ...
}
```

---

## Funcionalidades Demonstradas

### Buscar vendedor por ID

```java
Seller seller = sellerDao.findById(3);
```

---

### Buscar vendedores por departamento

```java
Department department = new Department(2, null);
List<Seller> sellers =
    sellerDao.findByDepartment(department);
```

---

### Listar todos os vendedores

```java
List<Seller> sellers =
    sellerDao.findAll();
```

---

### Inserir novo vendedor

```java
Seller newSeller = new Seller(
    null,
    "Greg",
    "greg@email.com",
    new Date(),
    4000.0,
    department
);

sellerDao.insert(newSeller);
```

---

### Atualizar vendedor

```java
seller.setName("Martha Wayne");
sellerDao.update(seller);
```

---

### Excluir vendedor

```java
sellerDao.deleteById(id);
```

---

## Configuração do Banco de Dados

Arquivo:

```properties
db.properties
```

Exemplo:

```properties
user=root
password=123456
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
```

---

## Configuração do Ambiente

### Pré-requisitos

- Java JDK 17+
- MySQL Server
- Driver JDBC MySQL

---

### Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/SalesCore-Data-Access.git
```

---

### Executar o Projeto

Compile e execute:

```bash
java application.Program
```

ou pela IDE:

```text
Run As → Java Application
```

---

## Tratamento de Exceções

O sistema possui exceções customizadas para operações de banco de dados:

### DbException

Utilizada para erros gerais de acesso ao banco.

### DbIntegrityException

Utilizada para violações de integridade referencial.

---

## Conceitos Aplicados

- JDBC
- CRUD
- DAO Pattern
- Factory Pattern
- Programação Orientada a Objetos
- Relacionamentos entre entidades
- Injeção de dependência via fábrica
- Tratamento de exceções
- Persistência de dados

---

## Diferenciais Técnicos

- Separação clara de responsabilidades
- Baixo acoplamento entre camadas
- Código preparado para expansão
- Fácil substituição da tecnologia de persistência
- Estrutura semelhante a aplicações corporativas

---

## Autor

**Jordão Asato**

LinkedIn:
www.linkedin.com/in/jordao-asato-327063385

---

## Licença

Este projeto está licenciado sob a licença MIT.
