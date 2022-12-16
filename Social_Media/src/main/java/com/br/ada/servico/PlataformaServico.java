package com.br.ada.servico;

import com.br.ada.modelo.Usuario;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.br.ada.repository.PlataformaRepository.*;
import static com.br.ada.servico.UsuarioServico.exibirOpcoesDePerfil;

public class PlataformaServico {
    static Logger logger
            = Logger.getLogger(
            PlataformaServico.class.getName());
    static Scanner input = new Scanner(System.in);

    public static void obterTipoPesquisa(Usuario usuario) {
        String menu =  "\n" + "1 - Pesquisar Posts" +
                "\n" + "2 - Pesquisar Usuários" +
                "\n" + "3 - Voltar "
                + "\n";

        System.out.println(menu);

        direcionarPesquisa(input.nextLine(), usuario);
    }


    private static void direcionarPesquisa(String opcao, Usuario usuario) {
        switch (opcao) {
            case "1":
                System.out.println("Digite sua pesquisa:");
                System.out.println(pesquisarPost(input.nextLine()));
                exibirOpcoesDePerfil(usuario);
                break;
            case "2":
                System.out.println("Digite sua pesquisa:");
                System.out.println(pesquisarUsuario(input.nextLine()));
                exibirOpcoesDePerfil(usuario);
                break;
            case "3":
                exibirOpcoesDePerfil(usuario);
                break;
            default:
                logger.log(Level.WARNING, "Opção inválida, insira uma opção válida!" + '\n');
                exibirOpcoesDePerfil(usuario);
                break;
        }
    }

    public static void obterLike(Usuario usuario) {
        System.out.println("Gostaria de interagir com um post?");
        String menu =  "\n" + "1 - SIM" +
                "\n" + "2 - NÃO" + "\n";

        System.out.println(menu);
        System.out.println("Digite a opção desejada:");
        obterAcaoPost(input.nextLine(), usuario);

    }
    public static void acoesPost(String opcao, Usuario usuario, String id){
        System.out.println("Você gostaria de:");
        String menu =  "\n" + "1 - Curtir" +
                "\n" + "2 - Comentar" +
                "\n" + "3 - Adicionar aos Favoritos ";
        System.out.println(menu);
        System.out.println();
        System.out.println("Insira a opção desejada:");
        direcionarAcaoPost(input.nextLine(), usuario, id);

    }

    public static void obterRemoverFavoritos( Usuario usuario){
        System.out.println("Você gostaria de remover um post dos favoritos?:");
        String menu =  "\n" + "1 - SIM" +
                "\n" + "2 - NÃO";

        System.out.println(menu);
        System.out.println();
        System.out.println("Insira a opção desejada:");
        switch(input.nextLine()){
            case "1":
                System.out.println("Insira o ID do post que deseja remover:");
                removerPostDosFavoritos(input.nextLine(), usuario);
                break;
            case "2":
                exibirOpcoesDePerfil(usuario);
                break;
            default:
                logger.log(Level.WARNING, "Opção inválida, insira uma opção válida!" + '\n');
                exibirOpcoesDePerfil(usuario);
                break;
        }


    }
    public static void obterAcaoPost(String opcao, Usuario usuario) {
        switch (opcao) {
            case "1":
                System.out.println("Digite o ID do Post");
                acoesPost(opcao, usuario, input.nextLine());
            case "2":
                exibirOpcoesDePerfil(usuario);
            default:
                logger.log(Level.WARNING, "Opção inválida, insira uma opção válida!" + '\n');
                verFeed(usuario);
                break;
        }
    }
    public static void direcionarAcaoPost(String opcao, Usuario usuario, String id){
        switch (opcao) {
            case "1":
                curtirPost(id, usuario);
                break;
            case "2":
                System.out.println("comentários ainda não estão funcionando");
                verFeed(usuario);
                break;
            case "3":
                adicionarPostAosFavoritos(id, usuario);
                break;
            default:
                logger.log(Level.WARNING, "Opção inválida, insira uma opção válida!" + '\n');
                verFeed(usuario);
                break;
        }
    }
}
