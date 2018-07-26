package br.com.watsapp.cursoadroid.whatsapp.Model;


public class Contato {

    private String identificadorUsusario;
    private String nome;
    private String email;

    public Contato() {
    }

    public String getIdentificadorUsusario() {
        return identificadorUsusario;
    }

    public void setIdentificadorUsusario(String identificadorUsusario) {
        this.identificadorUsusario = identificadorUsusario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
