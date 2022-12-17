package br.edu.infnet.app.tps;

import java.util.Scanner;

import br.edu.infnet.app.auxiliar.Constante;
import br.edu.infnet.app.dominio.Aluno;
import br.edu.infnet.app.dominio.Pessoa;
import br.edu.infnet.app.dominio.Professor;

public class Tp3 {
    private static Pessoa[] pessoas;

    private static void imprimir() {
        for (int i = 0; i < Constante.TAMANHO_LISTA; i++) {
            if (pessoas[i] != null) {
                pessoas[i].imprimir();
            }
        }
    }

    public static void main(String[] args) {
        pessoas = new Pessoa[Constante.TAMANHO_LISTA];
        
        Scanner in = new Scanner(System.in);
        String opcao;
        int pos = 0; 

        do {
            System.out.println("[1] Registrar um novo aluno.");
            System.out.println("[2] Registrar um novo professor.");
            System.out.println("[3] Consultar pessoa.");
            System.out.println("[4] Consultar todos.");
            System.out.println("[5] Sair.");

            System.out.printf("%n" + "Informe a opção desejada: ");
            opcao = in.next();


            switch (opcao) {
                case "1":
                    if (pos < Constante.TAMANHO_LISTA) {
                        Aluno novoAluno = new Aluno();

                        try {
                            in.nextLine(); // fix 
                            System.out.print("Nome do aluno: ");
                            novoAluno.setNome(in.nextLine());
                        } catch (Exception e) {
                            System.out.println("[ERROR] " + e.getMessage());
                            break;
                        }

                        System.out.print("Nota da primeira avaliação: ");
                        novoAluno.setNotaAV1(in.nextFloat());

                        System.out.print("Nota da segunda avaliação: ");
                        novoAluno.setNotaAV2(in.nextFloat());

                        pessoas[pos] = novoAluno;

                        pessoas[pos].imprimir();

                        pos++;
                    } else {
                        System.out.println("Impossível realizar um novo cadastramento!");
                    }
                    break;
                case "2":
                if (pos < Constante.TAMANHO_LISTA) {
                    Professor novoProfessor = new Professor();

                    try {
                        in.nextLine(); // fix
                        System.out.print("Nome do professor: ");
                        novoProfessor.setNome(in.nextLine());
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    
                    System.out.print("Turma: ");
                    novoProfessor.setTurma(in.next());

                    System.out.print("Nome da diciplina: ");
                    novoProfessor.setMateria(in.next()); 

                    System.out.print("Valor salário: ");
                    novoProfessor.setSalario(in.nextFloat());
                    pessoas[pos] = novoProfessor;

                    System.out.print("É estagiário? True ou False: ");
                    novoProfessor.setEstagiario(in.nextBoolean());
                    pessoas[pos] = novoProfessor;

                    pessoas[pos].imprimir();

                    pos++;
                } else {
                    System.out.println("Impossível realizar um novo cadastramento!");
                }
                break;    
                case "3":
                System.out.print("Informe o id do aluno: ");
                    int id = in.nextInt();
                    
                    try {
                        if(id >= 0 && id < pos && pessoas[id].getNome() != null) {
                            pessoas[id].imprimir();
                        } else {
                            System.out.println("O índice ["+id+"] não existe.");
                        }
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;
                case "4": 
                    imprimir();
                    break;
                case "5": 
                    System.out.println("Saída.");
                    break;
                default:
                    System.out.println("O opção ["+opcao+"] não existe.");
                    break;
            }
        } while (!"5".equals(opcao));
        
        System.out.println("Processamento finalizado!");
        in.close();
    }
}