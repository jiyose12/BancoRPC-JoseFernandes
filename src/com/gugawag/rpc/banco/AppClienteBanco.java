package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();
        String conta;
        String saldo;

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String contaNumero = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.saldo(contaNumero));
                    break;
                }
                case 2: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.quantidadeContas());
                    break;
                }
                case 3: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("Informe o numero da conta");
                    conta = entrada.next();

                    System.out.println("Informe a quantidade a depositar");
                    saldo = entrada.next();

                    banco.adicionarConta(conta, Double.parseDouble(saldo));
                    break;
                }
                case 4: {
                    //chamada ao método remoto, como se fosse executar localmente
                    List<Conta> contaList = banco.listarContas();
                    contaList.forEach(c -> System.out.println(c));
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\nJosé Raimundo Fernandes Filho\n");
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Adicionar nova conta");
        System.out.println("4 - Listar contas");
        System.out.println("9 - Sair");
    }

}
