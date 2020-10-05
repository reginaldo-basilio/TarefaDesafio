# TarefaDesafio
### adicionar biblioteca rs2xml.jar
### necessario junit para os testes
### Ao clicar no botão "Iniciar jogo" é criado um novo jogo onde é habilitado um campo para inserir o placar (pontos) daquele jogo.
### Quando o usuário inserir o placar o programa calcula se este é o menor ou maior resultado e se bateu recorde de menor ou maior resultado, preenchendo assim os campos da tabela.
### Foi usado interface gráfica, conexão com banco mysql através do JDBC, então todos os dados são persistidos no banco.
### Teste unitário ...
## script do banco de dados:
### create database resultados;
### use resultados;


### create table pontuacao (
	
### id int (4) not null auto_increment primary key,
    
### placar int(4),
    
### minTemp int(4),
    
### maxTemp int (4),
    
### recMin int (4),
    
### recMax int (4)

### );
