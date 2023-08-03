package br.ufpb.dcx.diogo.amigosecreto;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (super.ehAnonima()) {
            return "Mensagem para todos. Texto: " + super.getTexto();
        }
        return "Mensagem de " + super.getEmailRemetente() + " para todos. Texto: " + super.getTexto();
    }
}
