package ifrs.exercicio1.service;


import ifrs.exercicio1.model.Pedido;

import java.util.logging.Logger;

public class PedidoService {
Logger logger = Logger.getLogger(PedidoService.class.getName());
    public synchronized boolean processaOuNao(Pedido p, int t){
        if (p == null) return false;
        boolean ok = true;

        try {
            while(ok){
                wait(20);
                ok = t > 10;
            }
        } catch (InterruptedException e) {
            logger.log(null, "Processamento interrompido");
            Thread.currentThread().interrupt();

        }

        if (!ok) {
            return false;
        }

        logger.log(null, "Processando pedido no serviço...");
        p.fecharPedido(true);
        return true;
    }

    public String buscaStatus(){
        return null;
    }
}
