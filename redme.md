Projeto Leilão
Este projeto é um sistema de leilão que permite o cadastro e gerenciamento de usuários e produtos (imóveis e veículos) em leilões. O sistema é dividido entre um front-end em HTML/CSS e um back-end em Java com Spring Boot.

Estrutura do Front-End (Visual Studio Code)
O front-end é composto por várias páginas HTML, cada uma com uma funcionalidade específica:

login.html: Página para logar o usuário e redirecionar para a página principal.
cadastro.html: Página para o cadastro de novos usuários.
index.html: Página principal do sistema.
register.html: Página para o cadastro de imóveis, veículos, leilões, etc.
bid-history.html: Página que exibe o histórico de lances feitos pelos usuários.
auction-list.html: Página que lista os leilões e produtos disponíveis.
Estrutura do Back-End (Eclipse)
O back-end é implementado utilizando Java e Spring Boot, estruturado da seguinte forma:

Pacotes
com.example.leilao:

LeilaoApplication: Classe principal que inicia a aplicação Spring Boot.
com.example.leilao.config:

CorsConfig: Configuração para habilitar CORS, permitindo que o front-end faça requisições ao back-end.
com.example.leilao.controller:

ClienteController: Controlador responsável pelas operações relacionadas aos clientes.
ImovelController: Controlador para gerenciar operações sobre imóveis.
LanceController: Controlador para gerenciar lances.
LeilaoController: Controlador para gerenciar leilões.
VeiculoController: Controlador para gerenciar veículos.
com.example.leilao.exception: Contém classes para tratar exceções específicas da aplicação.

com.example.leilao.model:

Cliente: Entidade que representa um cliente.
Imovel: Entidade que representa um imóvel.
Lance: Entidade que representa um lance em um leilão.
Leilao: Entidade que representa um leilão.
Veiculo: Entidade que representa um veículo.
com.example.leilao.repository:

ClienteRepository: Interface para operações de persistência relacionadas à entidade Cliente.
ImovelRepository: Interface para operações de persistência relacionadas à entidade Imóvel.
LanceRepository: Interface para operações de persistência relacionadas à entidade Lance.
LeilaoRepository: Interface para operações de persistência relacionadas à entidade Leilão.
VeiculoRepository: Interface para operações de persistência relacionadas à entidade Veículo.
com.example.leilao.service:

ClienteService: Classe de serviço para operações relacionadas ao cliente.
ImovelService: Classe de serviço para operações relacionadas a imóveis.
LanceService: Classe de serviço para operações relacionadas a lances.
LeilaoService: Classe de serviço para operações relacionadas a leilões.
VeiculoService: Classe de serviço para operações relacionadas a veículos.
Tecnologias Utilizadas
Front-End: HTML, CSS, Bootstrap
Back-End: Java, Spring Boot, JPA/Hibernate
Banco de Dados: PostgreSQL
Como Executar o Projeto
Front-End
Navegue até o diretório onde as páginas HTML estão localizadas.
Abra os arquivos HTML em um navegador web.
Back-End
Abra o projeto no Eclipse.
Execute a classe LeilaoApplication como uma aplicação Java.
O back-end estará acessível em http://localhost:8080.
Contribuições
Sinta-se à vontade para contribuir com o projeto, reportando problemas ou sugerindo melhorias!

Licença
Este projeto está licenciado sob a MIT License.