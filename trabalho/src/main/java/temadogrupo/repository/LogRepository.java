package temadogrupo.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogRepository {

    private final String arquivo = "logRepository.txt";

    public void registrarExcecao(Exception e, int maxLinhas) {
        try {

            List<String> linhas = new ArrayList<>();

            LocalDateTime agora = LocalDateTime.now();

            linhas.add(agora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " - " + e.toString());

            StackTraceElement[] elementos = e.getStackTrace();

            for (StackTraceElement item : elementos) {
                linhas.add("Classe: " + item.getClassName() +
                        ", Método: " + item.getMethodName() +
                        ", Arquivo: " + item.getFileName() +
                        ", Linha: " + item.getLineNumber());
            }

            File f = new File(arquivo);

            if (f.exists() && f.length() > 0) {
                try (Scanner sc = new Scanner(f)) {
                    while (sc.hasNextLine()) {
                        linhas.add(sc.nextLine());
                    }
                }
            }

            if (linhas.size() > maxLinhas) {
                linhas = linhas.subList(0, maxLinhas);
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
                for (String l : linhas) {
                    pw.println(l);
                }
            }

        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}