package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Conta extends UnicastRemoteObject {

  private double saldo = 0;
  private String numero;

  public Conta(String numero, double saldo) throws RemoteException {
    this.saldo = saldo;
    this.numero = numero;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo += saldo;
  }

  public String getNumero() {
    return numero;
  }

  public double addSaldo(double s){
    return this.saldo += s;
  }

  @Override
  public String toString() {
    return "Conta{" +
        "saldo=" + saldo +
        ", numero=" + numero +
        '}';
  }
}
