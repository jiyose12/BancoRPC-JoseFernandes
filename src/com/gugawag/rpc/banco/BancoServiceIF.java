package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    Conta adicionarConta(String numero, Double saldo) throws RemoteException;
    List<Conta> listarContas() throws RemoteException;
}
