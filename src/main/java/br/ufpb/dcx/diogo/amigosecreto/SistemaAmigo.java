package br.ufpb.dcx.diogo.amigosecreto;

import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        if (!this.amigos.contains(amigo)) {
            this.amigos.add(amigo);
        }
    }

    public Amigo pesquisaAmigo(String emailAmigo) {
        Amigo amigo = null;
        for (Amigo a : this.amigos) {
            if (a.getEmail().equals(emailAmigo)) {
                amigo = a;
            }
        }
        return amigo;
    }

    public void enviarMensagensParaTodos(String texto, String emailRemetente, boolean ehAnonima) {

    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente,
                                         String emailDestinatario, boolean ehAnonima) {

    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        return new List<Mensagem>;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new List<Mensagem>;
    }

    public void configuraAmigoSecreto(String emailDaPessoa, String emailAmigoSorteado) {

    }

    public void pesquisaAmigoSecreto(String emailDaPessoa) {

    }

}
