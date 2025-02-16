/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhoterminalclass;

import Classes.Diretorio;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author wilson
 */

public class TrabalhoTerminalClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Diretorio dir = new Diretorio();
        Path testando = dir.criarDiretorioTemporarioRaiz("Testando");
        Path novaPasta = dir.criarDiretorio(testando, "Nova pasta");
        dir.criarDiretorio(novaPasta, "Desktop");
        dir.criarDiretorio(novaPasta, "Documento");
        dir.criarDiretorio(novaPasta, "Pasta3");

        System.out.println("CURRENT PASTA");
        dir.listarPasta(testando);
        System.out.println("---------------------------------------------------------------");

        System.out.println("PARENT PASTA TESTE");
        dir.navegarParentPasta(novaPasta);
        System.out.println("---------------------------------------------------------------");


        System.out.println("SUB-PASTAS TESTE");
        Path subPasta = dir.navegarSubPasta(testando, "Nova pasta");
        dir.navegarSubPasta(subPasta, "Desktop");
        dir.navegarSubPasta(novaPasta, "Documento");
        System.out.println("---------------------------------------------------------------");

        int var = 1;
        Scanner tec = new Scanner(System.in);
        while (var == 1) {
            System.out.println("Digite um numero ");
            var = tec.nextInt();
        }
        dir.removerDiretorio(testando);
    }
    
}
