package Classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author wilson
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class Diretorio {
    private Path pasta;
    private Path sub_pasta;

    //Criar Pasta temporaria no sistema
    public Path criarDiretorioTemporarioRaiz(String diretorio) {
        try {

            pasta = Files.createTempDirectory(diretorio);
            return pasta;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro methodo criarDiretorio dentro da classe Diretorio" + e.getMessage());
        }
        return null;
    }
    
    //listar diretorio
    public String listarPasta(Path diretorio) throws IOException{
        Files.list(diretorio).forEach(System.out::println);
        return null;
    }
    //Criar Diretorios dentro da pasta
    public Path criarDiretorio(Path nome_do_diretorio_atual,String nome_do_diretorio_novo){
        try {
            sub_pasta = nome_do_diretorio_atual.resolve(nome_do_diretorio_novo);
            Files.createDirectory(sub_pasta);
            return sub_pasta;
                        
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro methodo criarDiretorio dentro da classe Diretorio" + e.getMessage());
        }
        return null;
    } 

    //Remove Diretorio recursivamente independente se tem arquivo dentro ou se esta vazio
    public String removerDiretorio(Path pasta){
        try(Stream<Path> walk = Files.walk(pasta)) {
            walk.sorted(Comparator.reverseOrder()).forEach(Diretorio::removerArquivoeDiretorio);
            return ("Remocao efetuada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro methodo RemoverDiretorio dentro da classe Diretorio" + e.getMessage());
        }
        return null;
    }
    public static void removerArquivoeDiretorio(Path pasta){
        try{
            Files.delete(pasta);
        }catch(IOException e){
           JOptionPane.showMessageDialog(null, "Erro methodo RemoverArquivoDiretorio dentro da classe Diretorio" + e.getMessage());
        }
    }
}
