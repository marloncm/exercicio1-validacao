package ifrs.exercicio1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Pedido {
    private final List<String> itens = new ArrayList<>();
    private double valorTotal;
    private String status = "NOVO";
    private static final String STATUSPROCESSAR = "PROCESSANDO";


Logger logger = Logger.getLogger(Pedido.class.getName());
    public void adicionarItem(String nome, double preco){
        if (nome == null || nome.isEmpty()) {
            logger.log(null, "Item sem nome");
        }
        itens.add(nome);
        valorTotal += preco;
        if (valorTotal > 1000) { logger.log(null, "Pedido grande!"); }
    }

    public String resumo(){
        String s = "Pedido: ";
        StringBuilder builder = new StringBuilder();
        for (String iten : itens) {
            builder.append(s);
            builder.append(iten);
            builder.append(", ");

        }
        return builder.toString();
    }

    public void processar(int tipo){
        if ("NOVO".equals(status)) {
            logger.log(null, "Processando pedido novo...");
        }
        if (STATUSPROCESSAR.equals(status)) {
            logger.log(null, "Ainda processando...");
        }

        switch (tipo) {
            case 1: logger.log(null, "Tipo 1"); break;
            case 2: logger.log(null, "Tipo 2"); break;
            default: logger.log(null, "default"); break;
        }

        try {
            if (valorTotal < 0) throw new IllegalStateException("valor negativo?");
        } catch (Exception e) {
            logger.log(null);
        } finally {
            if (itens.isEmpty()) { logger.log(null, "vazio"); }
        }
    }

    public void fecharPedido(boolean notificarCliente){
        if (!STATUSPROCESSAR.equals(status)) { logger.log(null, "Estado inválido"); }
        status = "FECHADO";
        if (notificarCliente) {
            logger.log(null, "Notificando cliente...");
        }
    }
}
