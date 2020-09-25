package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        contas = new ArrayList<>();
        contas.add(new Conta("1", 100));
        contas.add(new Conta("2", 200));
    }

    @Override
    public Conta adicionarConta(String numero, Double saldo) throws RemoteException {
        Conta c = new Conta(numero, saldo);
        contas.add(c);
        return  c;
    }

    @Override
    public double saldo(String numero) throws RemoteException {
        AtomicReference<Double> saldo = new AtomicReference<>((double) 0);
        contas.forEach(c -> {
            if(c.getNumero().equals(numero)) {
                saldo.set(c.getSaldo());
            } else {
                saldo.set((double) 0);
            }
        });
        return saldo.get();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    public List<Conta> listarContas() throws RemoteException{ return contas; }

}
