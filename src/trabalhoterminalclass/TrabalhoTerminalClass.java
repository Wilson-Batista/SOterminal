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
        Path pasta = dir.criarDiretorioTemporarioRaiz("Testando");
        Path pasta2 = dir.criarDiretorio(pasta, "Nova pasta");
        dir.criarDiretorio(pasta2, "Desktop");
        dir.criarDiretorio(pasta2, "Documento");
        dir.criarDiretorio(pasta2, "Pasta3");
        dir.listarPasta(pasta);
        int var = 1;
        Scanner tec = new Scanner(System.in);
        while (var == 1) {
            System.out.println("Digite um numero ");
            var = tec.nextInt();
        }
        dir.removerDiretorio(pasta);
    }
    
}
