package ifrs.exercicio1.model;

import java.util.Objects;
import java.util.logging.Logger;

public class Cliente {
    private final String nome;
    private String email;
    private final int idade;
    Logger logger =  Logger.getLogger(Cliente.class.getName());
    public String getNome() {
        return nome;
    }

    public Cliente(String n, String e, int i) {
        this.nome = n;
        this.email = e;
        this.idade = i;
    }

    public boolean valida() {
        if (nome == null || email == null) {
            logger.log(null, "Dados inválidos");
            return false;
        }
        if (nome.isEmpty()) {
            logger.log(null, "Nome vazio");
        }
        if (idade < 0 || idade > 200) {
            logger.log(null, "Idade estranha");
        }
        return true;
    }

    public String getEmail() {
        if (email == null) {
            email = "";
        }
        return email.trim();
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Cliente c) {
            return Objects.equals(this.email, c.email);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 42;
    }

    public void atualiza(){
        //vai ser preenchido depois
    }
}
