package br.com.gerenciamento.main;

import br.com.gerenciamento.model.Produto;
import br.com.gerenciamento.repository.ProdutoRepository;

import java.text.NumberFormat;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProdutoRepository repo =new ProdutoRepository();


        while ( true){
            try {//O "guardachuva":Tente executaar o cod abaixo

                System.out.println("\n---GESTÃO DE PRODUTOS 21---");
                System.out.println("1. NOVO | 2. LISTAR |3. DELETAR | 0 SAIR");

                String opcao = sc.nextLine();
                //USa o parametro Matching e Sitching do java 21

                switch (opcao) {
                    case "1" -> {
                        System.out.println("nome: ");
                        String nome = sc.nextLine();
                        System.out.println("Preço: ");
                        // se digitar "carro " aqui o catch lá em baixo segira o erro
                        double preco = Double.parseDouble(sc.nextLine());
                        repo.salvar(new Produto(repo.listarTodos().size() + 1, nome, preco));

                    }
                    case "2" -> {
                        if (repo.listarTodos().isEmpty()) {
                            System.out.println("Nenhum produto cadastrado.");
                        } else {
                            repo.listarTodos().forEach(System.out::println);
                        }
                    }
                    case "3" -> {
                        System.out.print("ID para deletar: ");
                        int id = Integer.parseInt(sc.nextLine());
                        repo.deletar(id);
                        System.out.println("Comando de Remoção enviado");
                    }

                    case "0" -> {
                        System.out.println("Encerrando o Sistema...");
                        System.exit(0);
                    }
                    default -> System.out.println("Opção invalida!");
                }
            }catch (NumberFormatException e ) {

                System.err.println("ERRO:Você deve digitar um valor numerico valido");
            } catch (Exception e){
                        System.err.println("Ocorreu um erro inesperado"+ e.getMessage());
                    }
            }
        }
    }

