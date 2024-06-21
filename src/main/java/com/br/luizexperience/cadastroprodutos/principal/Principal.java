package com.br.luizexperience.cadastroprodutos.principal;

import com.br.luizexperience.cadastroprodutos.model.Produto;

import java.util.*;


public class Principal {
    private Scanner read = new Scanner(System.in);
    private List<Produto> produtos = new ArrayList<>();

    public void exibiMenu() {
        int opcao = 3;
        String nome, descricao, valida;
        double valor = 0;
        boolean disponivel;

        do {
            System.out.println("""
                    ***************************************************
                        Menu de Produtos, digite o opcao que deseja:
                        1 - Cadastrar produto
                        2 - Listar produtos
                        3 - Sair
                    """);

                opcao = read.nextInt();
                switch (opcao) {

                    case 1:

                        System.out.println("Informe o nome do produto:");
                        read.nextLine();
                        nome = read.nextLine();
                        System.out.println("Informe a descricao do produto:");
                        descricao = read.nextLine();
                        try {
                            System.out.println("Informe o valor do produto:");
                        valor = read.nextDouble();
                        } catch (InputMismatchException ex) {
                        System.out.println("Valor informado não condiz com o esperado,tente novamente mais tarde!");
                        System.exit(0);
                        }
                        System.out.println("Informe se o produto está disponivel(S ou N):");
                        valida = read.next();
                        if (valida.equalsIgnoreCase("s") || valida.equalsIgnoreCase("sim")) {
                            disponivel = true;
                        } else if (valida.equalsIgnoreCase("n") || valida.equalsIgnoreCase("nao")) {
                            disponivel = false;
                        } else {
                            System.out.println("Valor informado para disponibilidade não condiz com o esperado," +
                                    " tente novamente mais tarde!");
                            break;
                        }
                        Produto produto = new Produto(nome, descricao, valor, disponivel);
                        produtos.add(produto);
                        System.out.println(produto);;
                        break;
                    case 2:
                        produtos.stream()
                                .sorted(Comparator.comparing(Produto::getValor))
                                .forEach(System.out::println);

                        break;
                }
            }while (opcao != 3) ;
            }
}



