package org.iftm.clientapp;

import java.util.List;
import org.iftm.clientapp.entities.Nota;
import org.iftm.clientapp.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientappApplication implements CommandLineRunner {
    
    @Autowired
    private NotaRepository repositorio;

    public static void main(String[] args) {
        SpringApplication.run(ClientappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserindo algumas notas manualmente (opcional, já temos data.sql)
        Nota nota1 = new Nota(null, 7.5f, 6.8f);
        Nota nota2 = new Nota(null, 8.0f, 7.2f);
        Nota nota3 = new Nota(null, 6.5f, 6.0f);
        repositorio.save(nota1);
        repositorio.save(nota2);
        repositorio.save(nota3);

        // Consulta todas as notas
        List<Nota> todasNotas = repositorio.findAll();
        System.out.println("\n=== TODAS AS NOTAS ===");
        for (Nota nota : todasNotas) {
            System.out.println("ID: " + nota.getId() + 
                             ", Valor: " + nota.getValor() + 
                             ", Média Final: " + nota.getMediaFinal());
        }

        // Consulta por ID
        Nota notaBusca = repositorio.findById(1L).orElse(null);
        System.out.println("\n=== NOTA POR ID (1) ===");
        if (notaBusca != null) {
            System.out.println("Valor: " + notaBusca.getValor());
        }

        // Query Methods - Consulta por valor exato
        List<Nota> notasValor7_5 = repositorio.findByValor(7.5f);
        System.out.println("\n=== NOTAS COM VALOR 7.5 ===");
        System.out.println("Quantidade: " + notasValor7_5.size());
        for (Nota nota : notasValor7_5) {
            System.out.println("ID: " + nota.getId() + ", Média: " + nota.getMediaFinal());
        }

        // Query Methods - Consulta por valor maior que
        List<Nota> notasAcima7 = repositorio.findByValorGreaterThan(7.0f);
        System.out.println("\n=== NOTAS COM VALOR > 7 ===");
        System.out.println("Quantidade: " + notasAcima7.size());
        for (Nota nota : notasAcima7) {
            System.out.println("ID: " + nota.getId() + ", Valor: " + nota.getValor());
        }

        // Query Methods - Consulta por média final entre valores
        List<Nota> notasMedia6a7 = repositorio.findByMediaFinalBetween(6.0f, 7.0f);
        System.out.println("\n=== NOTAS COM MÉDIA FINAL ENTRE 6 E 7 ===");
        System.out.println("Quantidade: " + notasMedia6a7.size());
        for (Nota nota : notasMedia6a7) {
            System.out.println("ID: " + nota.getId() + 
                             ", Valor: " + nota.getValor() + 
                             ", Média: " + nota.getMediaFinal());
        }

        // Query Methods - Consulta combinada (valor entre e média maior que)
        System.out.println("\n=== NOTAS COM VALOR ENTRE 6 E 8 E MÉDIA > 6.5 ===");
        List<Nota> notasFiltradas = repositorio.findByValorBetweenAndMediaFinalGreaterThan(6.0f, 8.0f, 6.5f);
        for (Nota nota : notasFiltradas) {
            System.out.println("ID: " + nota.getId() + 
                             ", Valor: " + nota.getValor() + 
                             ", Média: " + nota.getMediaFinal());
        }

        // Atualização de uma nota
        Nota notaParaAtualizar = repositorio.findById(2L).orElse(null);
        if (notaParaAtualizar != null) {
            notaParaAtualizar.setValor(8.5f);
            repositorio.save(notaParaAtualizar);
            System.out.println("\n=== NOTA ATUALIZADA ===");
            System.out.println("ID: 2, Novo valor: " + notaParaAtualizar.getValor());
        }

        // Exclusão de uma nota
        repositorio.deleteById(3L);
        System.out.println("\n=== NOTA ID 3 EXCLUÍDA ===");
        System.out.println("Total de notas após exclusão: " + repositorio.count());
    }
}