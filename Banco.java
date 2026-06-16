import java.util.Scanner;
 
public class Banco {
 
    static String[] titulares = new String[100];
    static double[] saldos    = new double[100];
    static String[][] extratos = new String[100][200];
    static int[] totalMovimentos = new int[100];
    static int totalContas = 0;
    static Scanner teclado = new Scanner(System.in);
 
    static int buscarConta(String titular) {
        for (int i = 0; i < totalContas; i++)
            if (titulares[i].equalsIgnoreCase(titular)) return i;
        return -1;
    }
 
    static void criarConta() {
        System.out.print("Nome do titular: ");
        String nome = teclado.nextLine();
        if (buscarConta(nome) != -1) {
            System.out.println("Conta já existe!\n");
            return;
        }
        titulares[totalContas] = nome;
        saldos[totalContas]    = 0;
        totalContas++;
        System.out.println("Conta criada com sucesso!\n");
    }
 
    static void depositar() {
        System.out.print("Titular: ");
        int idx = buscarConta(teclado.nextLine());
        if (idx == -1) { System.out.println("Conta não encontrada!\n"); return; }
 
        System.out.print("Valor: R$ ");
        double valor = Double.parseDouble(teclado.nextLine());
        if (valor <= 0) { System.out.println("Valor inválido!\n"); return; }
 
        saldos[idx] += valor;
        extratos[idx][totalMovimentos[idx]++] = "Depósito: R$ " + valor;
        System.out.println("Depósito realizado! Saldo: R$ " + saldos[idx] + "\n");
    }
 
    static void sacar() {
        System.out.print("Titular: ");
        int idx = buscarConta(teclado.nextLine());
        if (idx == -1) { System.out.println("Conta não encontrada!\n"); return; }
 
        System.out.print("Valor: R$ ");
        double valor = Double.parseDouble(teclado.nextLine());
        if (valor <= 0) { System.out.println("Valor inválido!\n"); return; }
        if (valor > saldos[idx]) { System.out.println("Saldo insuficiente!\n"); return; }
 
        saldos[idx] -= valor;
        extratos[idx][totalMovimentos[idx]++] = "Saque:    R$ " + valor;
        System.out.println("Saque realizado! Saldo: R$ " + saldos[idx] + "\n");
    }
 
    static void verSaldo() {
        System.out.print("Titular: ");
        int idx = buscarConta(teclado.nextLine());
        if (idx == -1) { System.out.println("Conta não encontrada!\n"); return; }
        System.out.println("Saldo de " + titulares[idx] + ": R$ " + saldos[idx] + "\n");
    }
 
    static void verExtrato() {
        System.out.print("Titular: ");
        int idx = buscarConta(teclado.nextLine());
        if (idx == -1) { System.out.println("Conta não encontrada!\n"); return; }
 
        System.out.println("--- Extrato de " + titulares[idx] + " ---");
        if (totalMovimentos[idx] == 0) {
            System.out.println("Nenhuma movimentação.");
        } else {
            for (int i = 0; i < totalMovimentos[idx]; i++)
                System.out.println(extratos[idx][i]);
        }
        System.out.println("Saldo atual: R$ " + saldos[idx] + "\n");
    }
 
    public static void main(String[] args) {
        boolean rodando = true;
 
        while (rodando) {
            System.out.println("=== Banco ===");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Ver saldo");
            System.out.println("5. Ver extrato");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
 
            int opcao = Integer.parseInt(teclado.nextLine());
            System.out.println();
 
            switch (opcao) {
                case 1: criarConta(); 
                break;
                case 2: depositar();  
                break;
                case 3: sacar();      
                break;
                case 4: verSaldo();   
                break;
                case 5: verExtrato(); 
                break;
                case 0: rodando = false; System.out.println("Até mais!"); 
                break;
                default: System.out.println("Opção inválida!\n");
            }
        }
        teclado.close();
    }
}