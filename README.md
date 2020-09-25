# BancoRPC-JoseFernandes
Testando a chamada de métodos remotamente em java para a disciplina de Sistemas Distribuidos

# Objetivo
Esta prática tem como objetivo mostrar a forma de comunicação entre diferentes processos
utilizando RPC com RMI.
Passos
Primeiro, execute o código que está no link ​gugawag/BancoRPC: RPC em Java​. Para fazer isso:
# Compile as classes: entre na pasta src/com/gugawag/rpc/banco e execute
javac *.java
# Entre na pasta ​src​ e execute, numa aba do shell: ​java
com.gugawag.rpc.banco.AppBanco
# Em outra aba, também dentro da pasta​ src, ​execute:​ java
com.gugawag.rpc.banco.AppClienteBanco
# Execute a app através dos itens de Menu
# Ao final das execuções acima, apague todos os arquivos .class gerados
1. Altere o código do exemplo ​gugawag/BancoRPC: RPC em Java​ e acrescente um novo método,
que pode ser:
 Cadastro de nova conta
 Pesquisa de conta
 Remoção de conta
2. Desenvolva a classe ​Conta​, com número (String) e saldo (double), e uma lista de Contas
(List<Conta>) no servidor. Crie o método adicionarConta, na interface do servidor, e implemente
no servidor tal método, bem como no lado do cliente;
3. Altere a classe AppBanco para, quando mostrar o menu, mostre também seu nome completo
4. Rode o servidor numa máquina, e o cliente em outra (Se possível. Se não, rode na mesma
máquina. Altere a chamada do lookup do cliente para conter a url da máquina remota):
Registry registry = LocateRegistry.​getRegistry​(​"10.0.1.4"​, ​1099​)​;
Para que o servidor não devolva um endereço de loopback que seja inalcançável, suba o servidor
com parâmetro VM:
-Djava.rmi.server.hostname=10.0.1.4 (por exemplo)
